package project.checkapp.haams.checkapp.front_end;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;
import java.util.Random;

import project.checkapp.haams.checkapp.R;
import project.checkapp.haams.checkapp.utils.GLSurfaceView;
import project.checkapp.haams.checkapp.utils.utils_adapters.GLSRenderer;

public class UserStateActivity extends Activity {

    private GLSurfaceView glView; // GLSurfaceView >> 3D 작업
    private GLSRenderer glsRenderer;
    private Random rnd = new Random();
    // Call back >> 액티비티 시작할 때 >> View 초기화
    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_Translucent_NoTitleBar);

        // 퍼미션
        initTedPermission();


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        glView = new GLSurfaceView(this);           // Allocate a GLSurfaceView
        glView.setRenderer(new GLSRenderer(this)); // Use a custom renderer
        glView.getAlpha();

        this.setContentView(glView);                // This activity sets to GLSurfaceView
    }

    private void initTedPermission() {
        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(UserStateActivity.this, "권한이 제공되었습니다.", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(UserStateActivity.this, "권한이 없습니다.", Toast.LENGTH_LONG).show();
            }
        };

        TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("퍼미션 거절 시 앱 사용 불가")
                .setPermissions(Manifest.permission.WRITE_SETTINGS).check();
    }

    @Override
    protected void onPause() {
        super.onPause();
        glView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        glView.onResume();
        android.provider.Settings.System.putInt(this.getContentResolver()
       , Settings.System.SCREEN_BRIGHTNESS,rnd.nextInt(256));
    }

}
