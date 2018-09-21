package com.gma.medicalassistantdr.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import android.widget.Toast;

import com.gma.medicalassistantdr.R;
import com.gma.medicalassistantdr.adapter.DrMgmtItemAdapter;
import com.gma.medicalassistantdr.model.DrItem;
import com.gma.medicalassistantdr.utils.MedConst;

import java.util.ArrayList;
import java.util.List;

public class DrManagementActivity extends AppCompatActivity implements DrMgmtItemAdapter.DrMgmtItemClickListener {

    private String TAG = "DrManagementActivity";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dr_management, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStart() {
        super.onStart();
        RecyclerView recyclerView = findViewById(R.id.dr_mgmt_recyclerview);//获取对象
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//设置布局管理器，这里选择用竖直的列表
        List<DrItem> list = new ArrayList<>();

        BitmapDrawable dr1 = (BitmapDrawable) getDrawable(R.drawable.avatar1);
        Bitmap bm1 = dr1.getBitmap();
        DrItem di1 = new DrItem("张医生", bm1);
        list.add(di1);

        BitmapDrawable dr2 = (BitmapDrawable) getDrawable(R.drawable.avatar2);
        Bitmap bm2 = dr2.getBitmap();
        DrItem di2 = new DrItem("李主任", bm2);
        list.add(di2);

        BitmapDrawable dr3 = (BitmapDrawable) getDrawable(R.drawable.avatar3);
        Bitmap bm3 = dr3.getBitmap();
        DrItem di3 = new DrItem("王医生", bm3);
        list.add(di3);

        BitmapDrawable dr4 = (BitmapDrawable) getDrawable(R.drawable.avatar4);
        Bitmap bm4 = dr4.getBitmap();
        DrItem di4 = new DrItem("赵医生", bm4);
        list.add(di4);

        DrMgmtItemAdapter itemAdapter = new DrMgmtItemAdapter(list, this);//添加适配器，这里适配器刚刚装入了数据
        itemAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MedConst.ADD_DR_REQUEST_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    Log.i(TAG, "Add a new Dr");
                    break;
                case RESULT_CANCELED:
                    Log.i(TAG, "Cancel to add a Dr");
                    break;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.dr_menu_add:
                Log.i(TAG, "Add");
                Intent addIntent = new Intent(MedConst.INTENT_ACTION_ADD_DR);
                startActivityForResult(addIntent, MedConst.ADD_DR_REQUEST_CODE);
                break;
            case R.id.dr_menu_del:
                Log.i(TAG, "Del");
                Toast.makeText(this, R.string.main_demo_disable, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_management);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "修改密码，Demo版不支持", Toast.LENGTH_SHORT).show();
        //This view is the item root layout
        Log.i(TAG, "Item Id: " + view.getId() + " position: " + position);
    }
}
