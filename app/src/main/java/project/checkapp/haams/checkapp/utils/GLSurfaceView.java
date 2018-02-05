package project.checkapp.haams.checkapp.utils;

import android.content.Context;
import android.view.MotionEvent;

import project.checkapp.haams.checkapp.utils.utils_adapters.GLSRenderer;

/**
 * Created by haams on 2018-02-05.
 */

public class GLSurfaceView extends android.opengl.GLSurfaceView{
    private GLSRenderer glsRenderer;
    private boolean mDetached = false;
    private GLThread mGLThread;

    public GLSurfaceView(Context context) {
        super(context);
        glsRenderer = new GLSRenderer();
    }

    public boolean onTouchEvent(final MotionEvent e){
        queueEvent(new Runnable() {
            @Override
            public void run() {
                glsRenderer.setColor(e.getX() / getWidth() , e.getY() / getHeight() , 1.0f);

                requestRender();
            }
        });
        return true;
    }

   /* @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mGLThread = new GLThread();

        if(mDetached && (glsRenderer != null)){

            if(renderMode != RENDERMODE_CONTINUOUSLY){
                mGLThread.setRenderMode(renderMode);
            }
            mGLThread.start();
        }
        mDetached = false;
    }
*/
    static class GLThread extends Thread {
        @Override
        public void run() {
            super.run();

        }

    }

  /*  @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if()
    }*/
}
