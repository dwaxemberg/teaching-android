package com.icanandroid.teachingandroid;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
            convertView = View.inflate(parent.getContext(), R.layout.panel_list_item, null);
            convertView.setTag(new TodoItemViewHolder(
                    (TextView) convertView.findViewById(R.id.item_text),
                    (CheckBox) convertView.findViewById(R.id.checkbox)));
        }

        TodoItemViewHolder viewHolder = (TodoItemViewHolder) convertView.getTag();
        TodoItem item = mTodoItems.get(position);
        viewHolder.mItem.setText(item.getName());
        viewHolder.mCheckbox.setChecked(item.isDone());

        return convertView;
    }

    public void appendItem(TodoItem newItem) {
        mTodoItems.add(newItem);
        notifyDataSetChanged();
    }

    public void appendAll(List<TodoItem> newItems) {
        mTodoItems.addAll(newItems);
        notifyDataSetChanged();
    }

    public ArrayList<TodoItem> getContents() {
        return mTodoItems;
    }

    private static class TodoItemViewHolder {

        private TextView mItem;
        private CheckBox mCheckbox;

        private TodoItemViewHolder(TextView item, CheckBox checkbox) {
            mItem = item;
            mCheckbox = checkbox;

            mCheckbox.setFocusable(false);
        }

        private void bind(TodoItem todoItem) {
            mItem.setText(todoItem.getName());
            mCheckbox.setChecked(todoItem.isDone());
        }
    }
}
