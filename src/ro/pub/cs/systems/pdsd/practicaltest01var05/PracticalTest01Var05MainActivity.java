package ro.pub.cs.systems.pdsd.practicaltest01var05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class PracticalTest01Var05MainActivity extends Activity {

	int cont1= 0;
	int request=-1;
	protected class MyListener implements View.OnClickListener {
		
		
		@Override
		public void onClick(View view) {
			TextView out = (TextView)findViewById(R.id.textView1);
			String output = out.getText().toString();
			if (!output.isEmpty()){
				output+=", ";
			}
			
			if (view instanceof Button) {
				if (view.getId() == R.id.north) {
					Button north = (Button)findViewById(R.id.north);
					String value = north.getText().toString();
					output+=value;
					
				}
				if (view.getId() == R.id.west) {
					Button west = (Button)findViewById(R.id.west);
					String value = west.getText().toString();
					output+=value;
				}
				if (view.getId() == R.id.east) {
					Button east = (Button)findViewById(R.id.east);
					String value = east.getText().toString();
					output+=value;
				}
				if (view.getId() == R.id.south) {
					Button south = (Button)findViewById(R.id.south);
					String value = south.getText().toString();
					output+=value;
				}
				
				out.setText(output);
				
				
				if (view.getId() == R.id.navigate) {
					Intent intent = new Intent("ro.pub.cs.systems.pdsd.practicaltest01var05.PracticalTest02Var05SecondaryActivity");
					String value = out.getText().toString();
					TextView text = (TextView)findViewById(R.id.textView1);
		  			text.setText("");
					intent.putExtra("rezultat", value);
					intent.putExtra("register", cont1);
					startActivityForResult(intent, request);
				}
				
			}
		}
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);
        
        MyListener ml = new MyListener();
        Button north = (Button)findViewById(R.id.north);
        Button south = (Button)findViewById(R.id.south);
        Button west = (Button)findViewById(R.id.west);
        Button east = (Button)findViewById(R.id.east);
        Button navigate = (Button)findViewById(R.id.navigate);
        
        north.setOnClickListener(ml);
        south.setOnClickListener(ml);
        west.setOnClickListener(ml);
        east.setOnClickListener(ml);
        navigate.setOnClickListener(ml);
        
      //salvare
        TextView text = (TextView)findViewById(R.id.textView1);
      	if (savedInstanceState != null) {
      		String value = savedInstanceState.getString("text");
      		if (value != null) {
      			text.setText(value);
      		} else {
      			text.setText("");
      		}
      	} else {
      		text.setText("");
      	}
  
    }


  //salvare context
  	@Override
  	protected void onSaveInstanceState(Bundle savedInstanceState) {
  		super.onSaveInstanceState(savedInstanceState);
  		
  		TextView text = (TextView)findViewById(R.id.textView1);
  		savedInstanceState.putString("text", text.getText().toString());
  		savedInstanceState.putInt("register", cont1);
  		
  	};
  	
  //returneaza result code
  	@Override
  	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
  		Toast.makeText(this, "The activity returned with result "+resultCode, Toast.LENGTH_LONG).show();
  		
  		if (requestCode == request) {
  			if (resultCode == RESULT_OK){
  			cont1++;
  			}
  		}
  	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_var05_main, menu);
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
