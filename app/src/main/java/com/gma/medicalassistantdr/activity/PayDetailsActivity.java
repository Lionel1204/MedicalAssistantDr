package com.gma.medicalassistantdr.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gma.medicalassistantdr.R;

public class PayDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_details);
        Intent intent = getIntent();
        String payName = intent.getStringExtra("PAY_NAME");

        TextView titleTextView = findViewById(R.id.textview_pay_details_title);

        titleTextView.setText(payName);

        TextView detailsTextView = findViewById(R.id.textview_pay_details_details);
        String details = String.format("心脏养护关爱%s\r\n\r\n 套餐介绍：时刻关爱您的心脏健康，祝您早日康复，套餐为期120天\r\n\r\n 价格：128元", payName);
        detailsTextView.setText(details);
    }

    void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pay_details_edit:
                Toast.makeText(this, R.string.main_demo_disable, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_pay_details_del:
                Toast.makeText(this, R.string.main_demo_disable, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

}
