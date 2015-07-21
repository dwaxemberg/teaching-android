package com.icanandroid.teachingandroid;

public class TodoItem {
    private String mName;
    private boolean mDone;

    TodoItem(String name, boolean done) {
        mName = name;
        mDone = done;
    }

    public String getName() {
        return mName;
    }

    public boolean isDone() {
        return mDone;
    }

    public void complete() {
        mDone = true;
    }
}
