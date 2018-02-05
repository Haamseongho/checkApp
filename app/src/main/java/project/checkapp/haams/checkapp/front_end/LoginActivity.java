package project.checkapp.haams.checkapp.front_end;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import project.checkapp.haams.checkapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGenLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {
        btnGenLogin = (Button) findViewById(R.id.btn_login_general);
        btnGenLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_general:
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();
                break;
        }
    }
}
