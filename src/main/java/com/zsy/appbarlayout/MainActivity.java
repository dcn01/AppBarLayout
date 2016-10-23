package com.zsy.appbarlayout;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/*
 * 文件名:     MainActivity
 * 创建者:     阿钟
 * 创建时间:   2016/10/23 9:23
 * 描述:       高仿稀土掘金
 */
public class MainActivity extends AppCompatActivity {

    private List<String> list;
    //顶部标签
    private String[] title = {"首页", "Android", "产品", "设计", "工具资源", "ios"};
    //底部导航图片资源
    private int[] image = {R.drawable.home, R.drawable.explore, R.drawable.notifications, R.drawable.profile};

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.bar);
        toolbar.setTitle("高仿稀土倔金");
        //为页面设置标题栏
        setSupportActionBar(toolbar);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recy);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        //设置tabLayout模式
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        TabLayout tabLayoutTwo = (TabLayout) findViewById(R.id.tab_layout_two);
        tabLayoutTwo.setTabMode(TabLayout.MODE_FIXED);
        //添加recyclerView的数据
        initData();
        //设置tabLayout标题
        for (String aTitle : title) {
            tabLayout.addTab(tabLayout.newTab().setText(aTitle));
        }
        //自定义的tab布局
        for (int anImage : image) {
            View view = getLayoutInflater().inflate(R.layout.tab, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv);
            imageView.setImageResource(anImage);
            //添加标签
            tabLayoutTwo.addTab(tabLayoutTwo.newTab().setCustomView(view));
        }
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        MyAdapter adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                new AlertDialog.Builder(MainActivity.this).
                        setMessage("博客地址:\nhttp://blog.csdn.net/a_zhon/article/details/52549271").show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add("阿钟程序员" + i);
        }
    }
}
