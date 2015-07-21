package com.icanandroid.teachingandroid;

import java.io.Serializable;

public class TodoItem implements Serializable {

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
