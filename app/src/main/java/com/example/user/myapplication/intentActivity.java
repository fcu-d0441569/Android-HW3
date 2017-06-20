package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class intentActivity extends AppCompatActivity {
    public static final String KEY_NAME = "KEY_NAME";
    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        editText = (EditText) findViewById(R.id.e_name);
        button = (Button)findViewById(R.id.b_back);
        button.setOnClickListener(listener);
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = editText.getText().toString();
            Intent intent = new Intent();
            intent.setClass(intentActivity.this, MainActivity.class);
            intent.putExtra(KEY_NAME, name);
            startActivity(intent);
        }
    };

}
