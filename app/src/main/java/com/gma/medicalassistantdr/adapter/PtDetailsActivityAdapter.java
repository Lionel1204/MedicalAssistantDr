package com.gma.medicalassistantdr.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.gma.medicalassistantdr.R;
import com.gma.medicalassistantdr.model.PtActivityItem;

import java.util.List;

public class PtDetailsActivityAdapter extends RecyclerView.Adapter<PtDetailsActivityAdapter.PtDetailsActivityViewHolder> implements View.OnClickListener {
    private List<PtActivityItem> list;//存放数据
    private Context context;
    private PtDetailsActivityClickListener mItemClickListener;

    public PtDetailsActivityAdapter(List<PtActivityItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public PtDetailsActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem_pt_details_activity, parent, false);
        PtDetailsActivityViewHolder holder = new PtDetailsActivityViewHolder(view);
        return holder;
    }

    //在这里可以获得每个子项里面的控件的实例，比如这里的TextView,子项本身的实例是itemView，
    // 在这里对获取对象进行操作
    //holder.itemView是子项视图的实例，holder.textView是子项内控件的实例
    //position是点击位置
    @Override
    public void onBindViewHolder(PtDetailsActivityViewHolder holder, final int position) {
        //设置textView显示内容为list里的对应项
        holder.tvActivityName.setText(list.get(position).getActivityName());


        if (mItemClickListener != null) {
            holder.itemView.setTag(position);
            holder.itemView.setOnClickListener(this);
        }
        /*
        //子项的点击事件监听
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "查看患者信息", Toast.LENGTH_SHORT).show();
            }
        });*/

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
            mItemClickListener.onPtDetailsActivityItemClick(v, position);
        }
    }

    public void setOnPtDetailsActivityItemClickListener(PtDetailsActivityClickListener listener){
        this.mItemClickListener = listener;
    }

    public interface PtDetailsActivityClickListener {
        void onPtDetailsActivityItemClick(View view,int position);
    }

    //这里定义的是子项的类，不要在这里直接对获取对象进行操作
    public class PtDetailsActivityViewHolder extends RecyclerView.ViewHolder {

        private TextView tvActivityName;
        private ImageButton btnDetails;

        public PtDetailsActivityViewHolder(View itemView) {
            super(itemView);
            tvActivityName = itemView.findViewById(R.id.txtview_pt_details_listitem_activity_name);
            btnDetails = itemView.findViewById(R.id.imgbtn_pt_details_listitem_activity_details);
        }
    }

    /*之下的方法都是为了方便操作，并不是必须的*/

    //在指定位置插入，原位置的向后移动一格
    public boolean addItem(int position, PtActivityItem pi) {
        if (position < list.size() && position >= 0) {
            list.add(position, pi);
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