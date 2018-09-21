package com.gma.medicalassistantdr.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gma.medicalassistantdr.R;
import com.gma.medicalassistantdr.adapter.PayMgmtItemAdapter;
import com.gma.medicalassistantdr.adapter.PtMgmtItemAdapter;
import com.gma.medicalassistantdr.model.PayItem;
import com.gma.medicalassistantdr.model.PtItem;
import com.gma.medicalassistantdr.utils.MedConst;

import java.util.ArrayList;
import java.util.List;

public class PaymentManagementActivity extends AppCompatActivity implements PayMgmtItemAdapter.PayMgmtItemClickListener {

    private String TAG = "PaymentManagementActivity";

    @Override
    protected void onStart() {
        super.onStart();

        RecyclerView recyclerView = findViewById(R.id.pay_mgmt_recyclerview);//获取对象
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//设置布局管理器，这里选择用竖直的列表
        String payName = getResources().getString(R.string.payment_mgmt_pay);
        List<PayItem> list = new ArrayList<>();


        for (int i=1; i<5; i++) {
            PayItem pi = new PayItem(payName+i);
            list.add(pi);
        }

        PayMgmtItemAdapter itemAdapter = new PayMgmtItemAdapter(list, this);//添加适配器，这里适配器刚刚装入了数据
        itemAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_management);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pay_management, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.pay_menu_add:
                Log.i(TAG, "Add");
                Intent addIntent = new Intent(MedConst.INTENT_ACTION_ADD_PAYMENT);
                startActivityForResult(addIntent, MedConst.ADD_PAYMENT_REQUEST_CODE);
                break;
            case R.id.pay_menu_del:
                Log.i(TAG, "Del");
                Toast.makeText(this, R.string.main_demo_disable, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(View view, int position) {
        TextView nameView = view.findViewById(R.id.textview_pay_mgmt_pay_name);
        String payName = nameView.getText().toString();
        Log.i(TAG, "Item Id: " + payName + " position: " + position);
        Intent detailsIntent = new Intent(MedConst.INTENT_ACTION_PAYMENT_DETAILS);
        detailsIntent.putExtra("PAY_NAME", payName);
        startActivityForResult(detailsIntent, MedConst.PAYMENT_DETAILS_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MedConst.PAYMENT_DETAILS_REQUEST_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    Log.i(TAG, "pay details ok");
                    break;
                case RESULT_CANCELED:
                    Log.i(TAG, "pay details cancel");
                    break;
            }
        } else if (requestCode == MedConst.ADD_PAYMENT_REQUEST_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    Log.i(TAG, "add pay ok");
                    break;
                case RESULT_CANCELED:
                    Log.i(TAG, "add pay cancel");
                    break;
            }
        }
    }
}
