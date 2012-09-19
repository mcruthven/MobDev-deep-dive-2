package com.example.listviewex;

import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.Arrays;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Button.*;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ArrayAdapter<String> adapter;
	private static final String TAG = "Transition";
	ArrayList<String> lst ;
	ListView listView ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView= (ListView) findViewById(R.id.listView1);
		lst = new ArrayList<String>();
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, lst);
		listView.setAdapter(adapter);

		Button button=(Button) findViewById(R.id.button1);		
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG,"add?");
				String input=((EditText) findViewById(R.id.editText1)).getText().toString();
				if (input.length()>0){
					adapter.add(input);
					adapter.notifyDataSetChanged();
				}
			}
		});
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
