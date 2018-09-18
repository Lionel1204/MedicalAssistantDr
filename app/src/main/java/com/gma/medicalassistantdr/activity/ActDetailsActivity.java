package com.gma.medicalassistantdr.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gma.medicalassistantdr.R;

public class ActDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_details);
        Intent intent = getIntent();
        String payName = intent.getStringExtra("ACT_NAME");

        TextView titleTextView = findViewById(R.id.textview_act_details_title);

        titleTextView.setText(payName);

        TextView detailsTextView = findViewById(R.id.textview_act_details_details);
        String details = "时间：2018年10月21日 - 10月23日 15:30-17:30\r\n\r\n 地址：中心会议室\r\n\r\n 内容：中医心血管讲座以及康复锻炼的讲解\r\n\r\n 主讲：广州中医药大学";
        detailsTextView.setText(details);
    }

    void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_act_details_edit:
                Toast.makeText(this, R.string.main_demo_disable, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_act_details_del:
                Toast.makeText(this, R.string.main_demo_disable, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
