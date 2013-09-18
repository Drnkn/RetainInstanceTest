package com.example.retaininstancetest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.retaininstancetest.fragment.RetainFragment;

public class RetainInstanceActivity extends FragmentActivity {
	private static final int NUM_ITEMS = 10;
	private static final int ADAPTER_COMMON = 0;
	private static final int ADAPTER_STATE = 1;

	private PagerAdapter mAdapter;
	private ViewPager mPager;
	private int mCurrentAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("Test", "Activity onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_retain_instance);
		mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
		mCurrentAdapter = ADAPTER_COMMON;

		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);

		// Watch for button clicks.
		final Button button = (Button) findViewById(R.id.swap_adapters);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (mCurrentAdapter == ADAPTER_COMMON) {
					mAdapter = new MyFragmentStatePagerAdapter(
							getSupportFragmentManager());
					mCurrentAdapter = ADAPTER_STATE;
					button.setText("Set FragmentStatePagerAdapter");					
				} else if (mCurrentAdapter == ADAPTER_STATE) {
					mAdapter = new MyFragmentPagerAdapter(
							getSupportFragmentManager());
					mCurrentAdapter = ADAPTER_COMMON;
					button.setText("Set FragmentPagerAdapter");
				}
				mPager.setAdapter(mAdapter);
			}
		});

	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("Test", "Activity onRestart");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d("Test", "Activity onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d("Test", "Activity onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d("Test", "Activity onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d("Test", "Activity onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("Test", "Activity onDestroy");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.retain_instance, menu);
		return true;
	}

	public static class MyFragmentPagerAdapter extends FragmentPagerAdapter {
		public MyFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public int getCount() {
			return NUM_ITEMS;
		}

		@Override
		public Fragment getItem(int position) {
			return RetainFragment.newInstance(position);
		}
	}

	public static class MyFragmentStatePagerAdapter extends
			FragmentStatePagerAdapter {
		public MyFragmentStatePagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public int getCount() {
			return NUM_ITEMS;
		}

		@Override
		public Fragment getItem(int position) {
			return RetainFragment.newInstance(position);
		}
	}

}
