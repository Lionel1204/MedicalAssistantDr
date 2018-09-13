package com.gma.medicalassistantdr.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gma.medicalassistantdr.R;
import com.gma.medicalassistantdr.model.DrItem;

import java.util.List;

public class DrMgmtItemAdapter extends RecyclerView.Adapter<DrMgmtItemAdapter.DrMgmtItemViewHolder> implements View.OnClickListener {
    private List<DrItem> list;//存放数据
    private Context context;
    private DrMgmtItemClickListener mItemClickListener;

    public DrMgmtItemAdapter(List<DrItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public DrMgmtItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem_dr_mgmt, parent, false);
        DrMgmtItemViewHolder holder = new DrMgmtItemViewHolder(view);
        return holder;
    }

    //在这里可以获得每个子项里面的控件的实例，比如这里的TextView,子项本身的实例是itemView，
    // 在这里对获取对象进行操作
    //holder.itemView是子项视图的实例，holder.textView是子项内控件的实例
    //position是点击位置
    @Override
    public void onBindViewHolder(DrMgmtItemViewHolder holder, final int position) {
        //设置textView显示内容为list里的对应项
        holder.textView.setText(list.get(position).getItemName());

        //子项的点击事件监听
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "修改密码，Demo版不支持", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //要显示的子项数量
    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        if (v.getTag() != null) {
            int position = (int) v.getTag();
            mItemClickListener.onItemClick(v, position);
        }
    }

    public void setOnItemClickListener(DrMgmtItemClickListener listener){
        this.mItemClickListener = listener;
    }

    public interface DrMgmtItemClickListener {
        void onItemClick(View view,int position);
    }

    //这里定义的是子项的类，不要在这里直接对获取对象进行操作
    public class DrMgmtItemViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView avatar;

        public DrMgmtItemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.dr_mgmt_name_textview);
            avatar = itemView.findViewById(R.id.dr_mgmt_avatar_imgview);
        }
    }

    /*之下的方法都是为了方便操作，并不是必须的*/

    //在指定位置插入，原位置的向后移动一格
    public boolean addItem(int position, DrItem di) {
        if (position < list.size() && position >= 0) {
            list.add(position, di);
            notifyItemInserted(position);
            return true;
        }
        return false;
    }

    //去除指定位置的子项
    public boolean removeItem(int position) {
        if (position < list.size() && position >= 0) {
            list.remove(position);
            notifyItemRemoved(position);
            return true;
        }
        return false;
    }

    //清空显示数据
    public void clearAll() {
        list.clear();
        notifyDataSetChanged();
    }
}
