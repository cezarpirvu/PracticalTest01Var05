package ro.pub.cs.systems.pdsd.practicaltest01var05;

import ro.pub.cs.systems.pdsd.practicaltest01var05.PracticalTest01Var05MainActivity.MyListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest02Var05SecondaryActivity extends Activity {
	
	
	int numar=0;;
	protected class MyListener implements View.OnClickListener {
		
		TextView text = (TextView)findViewById(R.id.directions_count);
		@Override
		public void onClick(View view) {
			if (view.getId() == R.id.register) {
				numar++;
				String value = Integer.toString(numar);
				text.setText(value);
				setResult(RESULT_OK);
				finish();
			}
			if (view.getId() == R.id.cancel) {
				setResult(RESULT_CANCELED);
				finish();
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test02_var05_secondary);
		
		
		TextView number_directions = (TextView)findViewById(R.id.directions_count);
		
		TextView show_directions = (TextView)findViewById(R.id.show_directions);
		Intent intent = getIntent();
		if (intent != null) {
			number_directions.setText(String.valueOf(intent.getIntExtra("register", 0)));
			String value = intent.getStringExtra("rezultat");
			if (value != null) {
				show_directions.setText(value);
			} else {
				show_directions.setText("");
			}
		} else {
			show_directions.setText("");
		}
		
		
		 MyListener ml = new MyListener();
	     Button register = (Button)findViewById(R.id.register);
	     Button cancel = (Button)findViewById(R.id.cancel);
	        
	     register.setOnClickListener(ml);
	     cancel.setOnClickListener(ml);
	     
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.practical_test02_var05_secondary, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
