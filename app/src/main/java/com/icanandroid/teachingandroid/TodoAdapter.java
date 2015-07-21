package com.icanandroid.teachingandroid;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class TodoAdapter extends BaseAdapter {

    private ArrayList<TodoItem> mTodoItems;

    public TodoAdapter() {
        mTodoItems = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mTodoItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mTodoItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.panel_list_item, parent);
            convertView.setTag(new TodoItemViewHolder(
                    (TextView) convertView.findViewById(R.id.item_text),
                    (ImageButton) convertView.findViewById(R.id.checkbox)));
        }

        TodoItemViewHolder viewHolder = (TodoItemViewHolder) convertView.getTag();
        viewHolder.bind((TodoItem) getItem(position));

        return convertView;
    }

    public void appendItem(TodoItem newItem) {
        mTodoItems.add(newItem);
        notifyDataSetChanged();
    }

    private static class TodoItemViewHolder {

        private TextView mItem;
        private ImageButton mCheckbox;

        private TodoItemViewHolder(TextView item, ImageButton checkbox) {
            mItem = item;
            mCheckbox = checkbox;
        }

        private void bind(TodoItem todoItem) {
            mItem.setText(todoItem.getName());
            mCheckbox.setSelected(todoItem.isDone());
        }
    }
}
