package com.icanandroid.teachingandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mNameText;
    private Button mSubmitButton;
    private TextView mHelloLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);
        mNameText = (EditText) findViewById(R.id.name_box);
        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mHelloLabel = (TextView) findViewById(R.id.hello_text);

        mSubmitButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View button) {
                String name = mNameText.getText().toString();
                // TODO: Do some input validation here
                mHelloLabel.setText("Hello, " + name + "!");
            }
        });
    }

    @Override
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
