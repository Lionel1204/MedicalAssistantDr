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
import com.gma.medicalassistantdr.adapter.PtMgmtItemAdapter;
import com.gma.medicalassistantdr.model.PtItem;
import com.gma.medicalassistantdr.utils.MedConst;

import java.util.ArrayList;
import java.util.List;

public class PtManagementActivity extends AppCompatActivity implements PtMgmtItemAdapter.PtMgmtItemClickListener{

    private String TAG = "PtManagementActivity";

    @Override
    protected void onStart() {
        super.onStart();
        RecyclerView recyclerView = findViewById(R.id.pt_mgmt_recyclerview);//获取对象
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//设置布局管理器，这里选择用竖直的列表
        List<PtItem> list = new ArrayList<>();

        PtItem di1 = new PtItem("张三", "P001", "13512341234", "D001", null);
        list.add(di1);
        PtItem di2 = new PtItem("李四", "P002", "13623452345", "D001", null);
        list.add(di2);
        PtItem di3 = new PtItem("王五", "P003", "13734563456", "D002", null);
        list.add(di3);
        PtItem di4 = new PtItem("赵六", "P004", "13845674567", "D002", null);
        list.add(di4);

        PtMgmtItemAdapter itemAdapter = new PtMgmtItemAdapter(list, this);//添加适配器，这里适配器刚刚装入了数据
        itemAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(itemAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.pt_menu_add:
                Log.i(TAG, "Add");
                Intent addIntent = new Intent(MedConst.INTENT_ACTION_ADD_PT);
                startActivityForResult(addIntent, MedConst.ADD_PT_REQUEST_CODE);
                break;
            case R.id.pt_menu_del:
                Log.i(TAG, "Del");
                Toast.makeText(this, R.string.main_demo_disable, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pt_management, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt_management);
    }

    @Override
    public void onItemClick(View view, int position) {
        TextView nameView = view.findViewById(R.id.txtview_pt_name);
        String ptName = nameView.getText().toString();
        Log.i(TAG, "Item Id: " + ptName + " position: " + position);
        Intent detailsIntent = new Intent(MedConst.INTENT_ACTION_PT_DETAILS);
        detailsIntent.putExtra("PT_NAME", ptName);
        startActivityForResult(detailsIntent, MedConst.PT_DETAILS_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MedConst.ADD_PT_REQUEST_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    Log.i(TAG, "Add a new Patient");
                    break;
                case RESULT_CANCELED:
                    Log.i(TAG, "Cancel to add a Patient");
                    break;
            }
        }
    }
}
