package com.icanandroid.teachingandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TodoListActivity extends Activity implements AdapterView.OnItemClickListener {

    private ListView mTodoList;
    private TodoAdapter mTodoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_list);

        mTodoList = (ListView) findViewById(R.id.list);
        View footer = View.inflate(this, R.layout.panel_list_footer, mTodoList);
        footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newItemIntent = new Intent(TodoListActivity.this, CreateItemActivity.class);
                startActivityForResult(newItemIntent, CreateItemActivity.REQUEST_CODE);
            }
        });

        mTodoList.addFooterView(footer);
        mTodoAdapter = new TodoAdapter();
        mTodoList.setAdapter(mTodoAdapter);
        mTodoList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TodoItem clickedItem = (TodoItem) mTodoAdapter.getItem(position);
        clickedItem.complete();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            String itemText = data.getStringExtra(CreateItemActivity.EXTRA_ITEM);
            mTodoAdapter.appendItem(new TodoItem(itemText, false));
        }
    }
}
