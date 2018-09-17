package com.gma.medicalassistantdr.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gma.medicalassistantdr.R;

public class AddPtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pt);
    }

    void onBtnClick(View v){
        String msg = getResources().getString(R.string.main_demo_disable);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        switch(v.getId()){
            case R.id.btn_add_pt_ok:
                setResult(RESULT_OK);
                break;
            case R.id.btn_add_pt_cancel:
                setResult(RESULT_CANCELED);
                break;
            default:
                break;
        }
        finish();
    }
}
