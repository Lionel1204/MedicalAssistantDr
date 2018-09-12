package com.gma.medicalassistantdr.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.gma.medicalassistantdr.R;
import com.gma.medicalassistantdr.utils.MedConst;

public class MainActivity extends AppCompatActivity {

    private boolean mLogged = false;
    private String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mLogged = true;
        if (!mLogged) {
            Intent loginIntent = new Intent(MedConst.INTENT_ACTION_LOGIN);
            loginIntent.putExtra("key", "test");
            int requestCode = MedConst.LOGIN_REQUEST_CODE;
            startActivityForResult(loginIntent, requestCode);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case MedConst.LOGIN_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    String result = data.getExtras().getString("result");
                    mLogged = result.equals("OK");
                    Log.i(TAG, result);
                }
                break;
            default:
                break;
        }
    }
}
