package com.icanandroid.teachingandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TodoListActivity extends Activity implements AdapterView.OnItemClickListener {

    private static final String KEY_ITEMS = "key.items";

    private ListView mTodoList;
    private TodoAdapter mTodoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_list);

        mTodoList = (ListView) findViewById(R.id.list);
        View footer = View.inflate(this, R.layout.panel_list_footer, null);
        footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newItemIntent = new Intent(TodoListActivity.this, CreateItemActivity.class);
                startActivityForResult(newItemIntent, CreateItemActivity.REQUEST_CODE);
            }
        });

        mTodoList.addFooterView(footer);
        mTodoAdapter = new TodoAdapter(Glide.with(this));
        mTodoList.setAdapter(mTodoAdapter);
        mTodoList.setOnItemClickListener(this);

        if (savedInstanceState != null) {
            ArrayList<TodoItem> todoItems = (ArrayList<TodoItem>) savedInstanceState.getSerializable(KEY_ITEMS);
            mTodoAdapter.appendAll(todoItems);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TodoItem clickedItem = (TodoItem) mTodoAdapter.getItem(position);
        clickedItem.complete();
        ((CheckBox) view.findViewById(R.id.checkbox)).setChecked(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            String itemText = data.getStringExtra(CreateItemActivity.EXTRA_ITEM);
            String corgi = data.getStringExtra(CreateItemActivity.EXTRA_CORGI);
            mTodoAdapter.appendItem(new TodoItem(itemText, corgi, false));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY_ITEMS, mTodoAdapter.getContents());
    }
}
