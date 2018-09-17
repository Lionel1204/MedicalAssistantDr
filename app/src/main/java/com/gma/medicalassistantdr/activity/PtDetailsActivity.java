package com.gma.medicalassistantdr.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gma.medicalassistantdr.R;
import com.gma.medicalassistantdr.adapter.DrMgmtItemAdapter;
import com.gma.medicalassistantdr.adapter.PtDetailsActivityAdapter;
import com.gma.medicalassistantdr.adapter.PtDetailsPurchaseAdapter;
import com.gma.medicalassistantdr.model.DrItem;
import com.gma.medicalassistantdr.model.PtActivityItem;
import com.gma.medicalassistantdr.model.PtPurchaseItem;

import java.util.ArrayList;
import java.util.List;

public class PtDetailsActivity extends AppCompatActivity implements
        PtDetailsPurchaseAdapter.PtDetailsPurchaseClickListener,
        PtDetailsActivityAdapter.PtDetailsActivityClickListener
{

    @Override
    protected void onStart() {
        super.onStart();
        RecyclerView purRecyclerView = findViewById(R.id.recyclerview_pt_details_purchase);//获取对象
        purRecyclerView.setLayoutManager(new LinearLayoutManager(this));//设置布局管理器，这里选择用竖直的列表
        List<PtPurchaseItem> purList = new ArrayList<>();

        PtPurchaseItem ppi = new PtPurchaseItem(getResources().getString(R.string.pt_details_product1), "60%");
        purList.add(ppi);

        PtDetailsPurchaseAdapter purItemAdapter = new PtDetailsPurchaseAdapter(purList, this);//添加适配器，这里适配器刚刚装入了数据
        purItemAdapter.setOnPtDetailsPurchaseItemClickListener(this);
        purRecyclerView.setAdapter(purItemAdapter);

        RecyclerView actRecyclerView = findViewById(R.id.recyclerview_pt_details_activity);//获取对象
        actRecyclerView.setLayoutManager(new LinearLayoutManager(this));//设置布局管理器，这里选择用竖直的列表
        List<PtActivityItem> actList = new ArrayList<>();

        PtActivityItem pai = new PtActivityItem(getResources().getString(R.string.pt_details_activity));
        actList.add(pai);

        PtDetailsActivityAdapter actItemAdapter = new PtDetailsActivityAdapter(actList, this);//添加适配器，这里适配器刚刚装入了数据
        actItemAdapter.setOnPtDetailsActivityItemClickListener(this);
        actRecyclerView.setAdapter(actItemAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt_details);
        Intent intent = getIntent();
        String ptName = intent.getStringExtra("PT_NAME");
        TextView ptTextView = findViewById(R.id.textview_pt_details_pt_name);
        String txt = getResources().getString(R.string.pt_details_pt_name) + ptName;
        ptTextView.setText(txt);
    }

    @Override
    public void onPtDetailsPurchaseItemClick(View view, int position) {

    }

    @Override
    public void onPtDetailsActivityItemClick(View view, int position) {

    }

    void onBtnClick(View v){
        Toast.makeText(this, R.string.main_demo_disable, Toast.LENGTH_SHORT).show();
    }
}
