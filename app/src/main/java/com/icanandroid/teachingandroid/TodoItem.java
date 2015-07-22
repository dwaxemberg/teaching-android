package com.icanandroid.teachingandroid;

import java.io.Serializable;

public class TodoItem implements Serializable {

    private String mName;
    private String mCorgiUrl;
    private boolean mDone;

    TodoItem(String name, String corgiUrl, boolean done) {
        mName = name;
        mCorgiUrl = corgiUrl;
        mDone = done;
    }

    public String getName() {
        return mName;
    }

    public String getCorgiUrl() {
        return mCorgiUrl;
    }

    public boolean isDone() {
        return mDone;
    }

    public void complete() {
        mDone = true;
    }
}
