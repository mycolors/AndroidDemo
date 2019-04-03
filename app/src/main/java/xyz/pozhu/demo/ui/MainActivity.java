package xyz.pozhu.demo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.HomeBean;
import xyz.pozhu.demo.PzLog;
import xyz.pozhu.demo.R;
import xyz.pozhu.demo.ui.adapter.HomePageListAdapter;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private HomePageListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        PzLog.e("test", new Exception("test"));
        PzLog.w("test");
        PzLog.i("test");
        PzLog.d("test");
        PzLog.v("test");
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler_view);
        mAdapter = new HomePageListAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        List<HomeBean> homeBeans = new ArrayList<>();
        homeBeans.add(new HomeBean(HomeBean.SINGLE_CLICK, "单点功能"));
        mAdapter.addDatas(homeBeans);
    }

}
