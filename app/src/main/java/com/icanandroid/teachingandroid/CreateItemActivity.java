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
    public static String EXTRA_CORGI = "extra.corgi_url";

    private static final String[] CORGI_URLS = {
            "https://secure.static.tumblr.com/1687a491d59689834536edd549fea8f9/ctpb9fo/gDsn12kik/tumblr_static_buisnesscorgi.jpg",
            "http://www.shanalogic.com/wordpress/wp-content/uploads2/2015/03/anigif_enhanced-buzz-16494-1377022542-23_preview.gif",
            "http://25.media.tumblr.com/tumblr_lcl1khUpo31qbwakso1_500.jpg",
            "http://www.vh1.com/celebrity/bwe/images/2010/08/CORGI-JUMP.jpg"
    };

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
                    todoIntent.putExtra(EXTRA_CORGI, CORGI_URLS[(int) (Math.random() * CORGI_URLS.length)]);
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
