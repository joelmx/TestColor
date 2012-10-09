package com.joelgil.testcolor;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Colours extends Activity {
	
	private Button startButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colours);
        
        startButton = (Button)findViewById(R.id.startButton);
        
        startButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(Colours.this, Game.class);
				startActivity(i);
			}
		});
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_colours, menu);
//        return true;
//    }

}
