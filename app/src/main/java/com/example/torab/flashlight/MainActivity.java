package com.example.torab.flashlight;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private Camera camera;
    Camera.Parameters params;
    private boolean isLightOn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            camera = Camera.open();
            final Button btn = (Button) findViewById(R.id.buttonId);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isLightOn) {

                        params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                        camera.setParameters(params);
                        camera.stopPreview();
                        isLightOn = false;
                        btn.setBackgroundResource(R.drawable.on);
                    } else {
                        params = camera.getParameters();
                        params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(params);
                        camera.stopPreview();
                        isLightOn = true;
                        btn.setBackgroundResource(R.drawable.off);
                    }
                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(this,""+e,Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
