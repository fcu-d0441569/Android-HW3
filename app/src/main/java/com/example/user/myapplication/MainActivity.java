package com.example.user.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(listen);
        Intent intent = getIntent();
        String name = intent.getStringExtra(intentActivity.KEY_NAME);
        if(name != null){
            Toast.makeText(this,"Hello "+name,Toast.LENGTH_LONG)
                    .show();
        }
    }
    private View.OnClickListener listen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, intentActivity.class);
            startActivity(intent);
        }
    };
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.action_settings:
                break;
            case R.id.action_web:
                Uri uri = Uri.parse("https://www.google.com/");
                Intent intent = new Intent();
                intent.setAction(intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
                break;
        }
        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }
}

