package com.sjtu.charles.activity;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sjtu.charles.views.SuperSwipeRefreshLayout;

/**
 * Created by zhuyifei on 2016/5/14.
 */
@SuppressLint("NewApi")
public class ListViewActivity extends Activity {

	private SuperSwipeRefreshLayout swipeRefreshLayout;

	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);

		listView = (ListView) findViewById(R.id.list_view);
		listView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, getData()));
		swipeRefreshLayout = (SuperSwipeRefreshLayout) findViewById(R.id.swipe_refresh);
		swipeRefreshLayout
				.setOnPullRefreshListener(new SuperSwipeRefreshLayout.OnPullRefreshListener() {

					@Override
					public void onRefresh() {
						new Handler().postDelayed(new Runnable() {

							@Override
							public void run() {
								swipeRefreshLayout.setRefreshing(false);
							}
						}, 20000);
					}

					@Override
					public void onPullDistance(int distance) {
						System.out.println("debug:distance = " + distance);
						// myAdapter.updateHeaderHeight(distance);
					}

					@Override
					public void onPullEnable(boolean enable) {
					}
				});

	}

	private List<String> getData() {
		List<String> data = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			data.add("item -- " + i);
		}
		return data;
	}

}
