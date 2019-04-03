package xyz.pozhu.demo.ui.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import bean.HomeBean;
import xyz.pozhu.demo.R;
import xyz.pozhu.demo.singleclick.SingleClickActivity;

public class HomePageListAdapter extends RecyclerView.Adapter<HomePageListAdapter.ViewHolder> {
    private Context mContext;
    private List<HomeBean> datas;

    public HomePageListAdapter() {
        if (datas == null)
            datas = new ArrayList<>();

    }

    public void addDatas(List<HomeBean> beans) {
        if (beans != null && !beans.isEmpty()) {
            datas.addAll(beans);
            notifyDataSetChanged();
        }
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_home_page, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(datas.get(position).getTitle());
        final int type = datas.get(position).getType();

        Class clazz = null;
        switch (type) {
            case HomeBean.SINGLE_CLICK:
                clazz = SingleClickActivity.class;
                break;
        }

        final Class finalClazz = clazz;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalClazz == null) return;
                Intent intent = new Intent(mContext, finalClazz);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
