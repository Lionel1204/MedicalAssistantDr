package com.gma.medicalassistantdr.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gma.medicalassistantdr.R;

public class AddPayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pay);
    }

    public void onBtnClick(View view) {
        String msg = getResources().getString(R.string.main_demo_disable);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        switch(view.getId()){
            case R.id.btn_add_pay_ok:
                setResult(RESULT_OK);
                break;
            case R.id.btn_add_pay_cancel:
                setResult(RESULT_CANCELED);
                break;
            default:
                break;
        }
        finish();
    }

}
