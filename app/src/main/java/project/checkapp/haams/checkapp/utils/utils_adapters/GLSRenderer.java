package project.checkapp.haams.checkapp.utils.utils_adapters;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import java.util.Random;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import project.checkapp.haams.checkapp.front_end.shapes.Cube;
import project.checkapp.haams.checkapp.front_end.shapes.Pyramid;

/**
 * Created by haams on 2018-02-05.
 */

public class GLSRenderer implements GLSurfaceView.Renderer {

    public float mRed;
    public float mGreen;
    public float mBlue;
    private Context context;
    private Pyramid pyramid; // 피라미드 3D
    Random r = new Random();
    private float angleTriangle = 0.0f;
    private float angleQuad = 0.0f;
    private static float anglePyramid = 0; // Rotational angle in degree for Pyramid
    private static float speedPyramid = 2.5f; // Rotaional speed for Pyramid;
    private Cube cube;
    private static float angleCube = 0;
    private static float speedCube = 5.0f;   // Rotational speed for cube (NEW)

    public GLSRenderer(Context context) {
        this.context = context;
        pyramid = new Pyramid();
        cube = new Cube();
    }

    public GLSRenderer() {
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(r.nextFloat(), r.nextFloat(), r.nextFloat(), r.nextFloat());
        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);    // The type of depth testing to do
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);  // nice perspective view
        gl.glShadeModel(GL10.GL_SMOOTH);   // Enable smooth shading of color
        gl.glDisable(GL10.GL_DITHER);      // Disable dithering for better performance
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        if (height == 0) height = 1; // 높이가 0으로 되는걸 방지
        float aspect = (float) width / height;
        gl.glViewport(0, 0, width, height);

        gl.glMatrixMode(GL10.GL_PROJECTION); // projection matrix 선택
        gl.glLoadIdentity(); // projection matrix  Reset
        GLU.gluPerspective(gl, 45, aspect, 0.1f, 100.f);

        gl.glMatrixMode(GL10.GL_MODELVIEW); // model-view matrix select
        gl.glLoadIdentity(); // reset

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClearColor(mRed, mGreen, mBlue, 1.0f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        // You OpenGL|ES rendering code here
        gl.glLoadIdentity();                 // Reset model-view matrix ( NEW )
        gl.glTranslatef(-1.5f, 0.0f, -6.0f); // Translate left and into the screen ( NEW )
        gl.glRotatef(angleTriangle, 0.0f, 1.0f, 0.0f); // Rotate the triangle about the y-axis (NEW)
        //triangle.draw(gl);                   // Draw triangle
        gl.glRotatef(anglePyramid, 0.1f, 1.0f, -0.1f); // Rotate (NEW)
        pyramid.draw(gl);
        gl.glLoadIdentity();                 // Reset the mode-view matrix (NEW)
        gl.glTranslatef(1.5f, 0.0f, -6.0f);  // Translate right and into the screen (NEW)
        gl.glRotatef(angleQuad, 1.0f, 0.0f, 0.0f); // Rotate the square about the x-axis (NEW)
//quad.draw(gl);                       // Draw quad
        gl.glScalef(0.8f, 0.8f, 0.8f);      // Scale down (NEW)
        gl.glRotatef(angleCube, 1.0f, 1.0f, 1.0f); // rotate about the axis (1,1,1) (NEW)
        cube.draw(gl);


        anglePyramid += speedPyramid;
        angleCube += speedCube;

    }

    public void setColor(float r, float g, float b) {
        mRed = r;
        mGreen = g;
        mBlue = b;
    }

}
