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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ArrayAdapter<String> adapter;
	private static final String TAG = "Transition";
	ArrayList<String> arrlst ;
	ListView listView ;
	
	@Override	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView= (ListView) findViewById(R.id.listView1);
		
		
		arrlst = new ArrayList<String>();		
		// ArrayAdapter used to format the arraylist to the listview
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, arrlst);		
		listView.setAdapter(adapter);
		
		Button button=(Button) findViewById(R.id.button1);
		
		// when the add button is clicked the text in the Edit Text is added to the list
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG,"add?");
				
				// get text from EditText
				String input=((EditText) findViewById(R.id.editText1)).getText().toString();
				
				if (input.length()>0){
					// adds the text to the adapter which puts it in the list		
					adapter.add(input);	
					
					// sets the input text back to nothing
					((EditText) findViewById(R.id.editText1)).setText("");
				}
			}
		});
		
		// when an item is clicked, displays a toast notification
		listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                    long id) {                
            	// can call any function to act on item list
                String item = ((TextView) view).getText().toString();  
                
                // toast that displays list string
                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
                
            }
        });
		
		// longClick- built in function
		// this one deletes the long clicked item from list
		listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
		    @Override
		    public boolean onItemLongClick(AdapterView<?> parent, View view, int pos, long id) {
                
		    	String item = ((TextView) view).getText().toString();                
                // removes list element
                adapter.remove(item);
                
                // Notification of which element removed
                Toast.makeText(getBaseContext(), "removed "+item, Toast.LENGTH_LONG).show();
		    	return true;
		    }
		});

		
		
	}
	



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
