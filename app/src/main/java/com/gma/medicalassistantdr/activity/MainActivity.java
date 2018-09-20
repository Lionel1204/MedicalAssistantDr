package com.gma.medicalassistantdr.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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

    public void onBtnClick(View view) {
        String action = "";
        int requestCode = -1;
        switch (view.getId()) {
            case R.id.btn_main_message:
                action = MedConst.INTENT_ACTION_MESSAGE;
                requestCode = MedConst.MESSAGE_REQUEST_CODE;
                break;
            case R.id.btn_main_dr_mgmt:
                action = MedConst.INTENT_ACTION_DR_MANAGEMENT;
                requestCode = MedConst.DR_MANAGEMENT_REQUEST_CODE;
                break;
            case R.id.btn_main_pt_mgmt:
                action = MedConst.INTENT_ACTION_PT_MANAGEMENT;
                requestCode = MedConst.PT_MANAGEMENT_REQUEST_CODE;
                break;
            case R.id.btn_main_payment_mgmt:
                action = MedConst.INTENT_ACTION_PAYMENT_MANAGEMENT;
                requestCode = MedConst.PAYMENT_MANAGEMENT_REQUEST_CODE;
                break;
            case R.id.btn_main_activity_mgmt:
                action = MedConst.INTENT_ACTION_ACTIVITY_MANAGEMENT;
                requestCode = MedConst.ACTIVITY_MANAGEMENT_REQUEST_CODE;
                break;
            case R.id.btn_main_profile:
                action = MedConst.INTENT_ACTION_PROFILE;
                requestCode = MedConst.PROFILE_REQUEST_CODE;
                break;
            default:
                return;
        }

        Intent intent = new Intent(action);
        startActivityForResult(intent, requestCode);
    }
}
