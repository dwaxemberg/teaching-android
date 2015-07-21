package com.icanandroid.teachingandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateItemActivity extends Activity {

    public static int REQUEST_CODE = 123;
    public static String EXTRA_ITEM = "extra.item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_create_item);

        final EditText todoText = (EditText) findViewById(R.id.todo_text);
        final Button submitButton = (Button) findViewById(R.id.submit_button);
        final Button cancelButton = (Button) findViewById(R.id.cancel_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemText = todoText.getText().toString();

                if (TextUtils.isEmpty(itemText)) {
                    Toast.makeText(CreateItemActivity.this, R.string.todo_item_must_have_text,
                            Toast.LENGTH_LONG).show();
                } else {
                    Intent todoIntent = getIntent();
                    todoIntent.putExtra(EXTRA_ITEM, todoText.getText().toString());
                    setResult(RESULT_OK, todoIntent);
                    finish();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED, getIntent());
                finish();
            }
        });
    }
}
