package com.example.retaininstancetest.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.retaininstancetest.R;

public class RetainFragment extends Fragment {

	private static final String EXTRA_NUMBER = "com.example.retaininstancetest.fragment.EXTRA_NUMBER";

	private int mNumber;
	private View mLogin;
	private View mPassword;
	private View ImageView;

	public static RetainFragment newInstance(final int number) {
		final RetainFragment fragment = new RetainFragment();
		final Bundle args = new Bundle(1);
		args.putInt(EXTRA_NUMBER, number);
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public void onAttach(final Activity activity) {
		super.onAttach(activity);
		Log.d("Test", "Fragment onAttach");
	}

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		Log.d("Test", "Fragment onCreate");

		final Bundle args = getArguments();
		mNumber = args.getInt(EXTRA_NUMBER);
	}

	@Override
	public View onCreateView(final LayoutInflater inflater,
			final ViewGroup container, final Bundle savedInstanceState) {
		Log.d("Test", "This: " + this);
		Log.d("Test", "Fragment onCreateView");
		final View view = inflater.inflate(R.layout.fragment_retain, container,
				false);

		mLogin = view.findViewById(R.id.login);
		mPassword = view.findViewById(R.id.password);
		ImageView = view.findViewById(R.id.img);

		final TextView name = (TextView) view.findViewById(R.id.fragment_name);
		name.setText("Fragment #" + mNumber);

		return view;
	}

	@Override
	public void onActivityCreated(final Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d("Test", "Fragment onActivityCreated");
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.d("Test", "Fragment onStart");
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.d("Test", "Fragment onResume");
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.d("Test", "Fragment onStop");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.d("Test", "Fragment onStop");
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Log.d("Test", "Fragment onDestroyView");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("Test", "Fragment onDestroy");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		Log.d("Test", "Fragment onDetach");
	}

	@Override
	public String toString() {
		return "Fragment " + mNumber;
	}
}
