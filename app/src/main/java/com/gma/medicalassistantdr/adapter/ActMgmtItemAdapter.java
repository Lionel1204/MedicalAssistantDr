package com.gma.medicalassistantdr.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gma.medicalassistantdr.R;
import com.gma.medicalassistantdr.model.ActItem;

import java.util.List;

public class ActMgmtItemAdapter extends RecyclerView.Adapter<ActMgmtItemAdapter.ActMgmtItemViewHolder> implements View.OnClickListener {
    private List<ActItem> list;//存放数据
    private Context context;
    private ActMgmtItemClickListener mItemClickListener;

    public ActMgmtItemAdapter(List<ActItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ActMgmtItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem_act_mgmt, parent, false);
        ActMgmtItemViewHolder holder = new ActMgmtItemViewHolder(view);
        return holder;
    }

    //在这里可以获得每个子项里面的控件的实例，比如这里的TextView,子项本身的实例是itemView，
    // 在这里对获取对象进行操作
    //holder.itemView是子项视图的实例，holder.textView是子项内控件的实例
    //position是点击位置
    @Override
    public void onBindViewHolder(ActMgmtItemViewHolder holder, final int position) {
        //设置textView显示内容为list里的对应项
        holder.tvActName.setText(list.get(position).getActName());


        if (mItemClickListener != null) {
            holder.itemView.setTag(position);
            holder.itemView.setOnClickListener(this);
        }

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

    public void setOnItemClickListener(ActMgmtItemClickListener listener){
        this.mItemClickListener = listener;
    }

    public interface ActMgmtItemClickListener {
        void onItemClick(View view, int position);
    }

    //这里定义的是子项的类，不要在这里直接对获取对象进行操作
    public class ActMgmtItemViewHolder extends RecyclerView.ViewHolder {

        private TextView tvActName;

        public ActMgmtItemViewHolder(View itemView) {
            super(itemView);
            tvActName = itemView.findViewById(R.id.textview_act_mgmt_act_name);
        }
    }

    /*之下的方法都是为了方便操作，并不是必须的*/

    //在指定位置插入，原位置的向后移动一格
    public boolean addItem(int position, ActItem ai) {
        if (position < list.size() && position >= 0) {
            list.add(position, ai);
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
