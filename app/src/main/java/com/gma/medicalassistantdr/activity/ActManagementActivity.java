package com.gma.medicalassistantdr.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gma.medicalassistantdr.R;
import com.gma.medicalassistantdr.adapter.ActMgmtItemAdapter;
import com.gma.medicalassistantdr.adapter.PayMgmtItemAdapter;
import com.gma.medicalassistantdr.model.ActItem;
import com.gma.medicalassistantdr.model.PayItem;
import com.gma.medicalassistantdr.utils.MedConst;

import java.util.ArrayList;
import java.util.List;

public class ActManagementActivity extends AppCompatActivity implements ActMgmtItemAdapter.ActMgmtItemClickListener {

    private String TAG = "ActManagementActivity";

    @Override
    protected void onStart() {
        super.onStart();
        RecyclerView recyclerView = findViewById(R.id.act_mgmt_recyclerview);//获取对象
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//设置布局管理器，这里选择用竖直的列表
        String actName = getResources().getString(R.string.act_mgmt_activity);
        List<ActItem> list = new ArrayList<>();


        for (int i=1; i<5; i++) {
            ActItem ai = new ActItem(actName+i);
            list.add(ai);
        }

        ActMgmtItemAdapter itemAdapter = new ActMgmtItemAdapter(list, this);//添加适配器，这里适配器刚刚装入了数据
        itemAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(itemAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_management);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.act_management, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.act_menu_add:
                Log.i(TAG, "Add");
                Intent addIntent = new Intent(MedConst.INTENT_ACTION_ADD_ACTIVITY);
                startActivityForResult(addIntent, MedConst.ADD_ACTIVITY_REQUEST_CODE);
                break;
            case R.id.act_menu_del:
                Log.i(TAG, "Del");
                Toast.makeText(this, R.string.main_demo_disable, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MedConst.ACTIVITY_DETAILS_REQUEST_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    Log.i(TAG, "act details ok");
                    break;
                case RESULT_CANCELED:
                    Log.i(TAG, "act details cancel");
                    break;
            }
        } else if (requestCode == MedConst.ADD_ACTIVITY_REQUEST_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    Log.i(TAG, "add act ok");
                    break;
                case RESULT_CANCELED:
                    Log.i(TAG, "add act cancel");
                    break;
            }
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        TextView nameView = view.findViewById(R.id.textview_act_mgmt_act_name);
        String actName = nameView.getText().toString();
        Log.i(TAG, "Item Id: " + actName + " position: " + position);
        Intent detailsIntent = new Intent(MedConst.INTENT_ACTION_ACTIVITY_DETAILS);
        detailsIntent.putExtra("ACT_NAME", actName);
        startActivityForResult(detailsIntent, MedConst.ACTIVITY_DETAILS_REQUEST_CODE);
    }
}
