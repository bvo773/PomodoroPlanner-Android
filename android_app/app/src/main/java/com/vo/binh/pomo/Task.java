package com.vo.binh.pomo;

import java.util.Date;
import java.util.UUID;

public class Task {
   private UUID mId;
   private String mTaskTitle;
   private Date mTaskDate;

    public boolean isDone() {
        return mDone;
    }

    public void setDone(boolean done) {
        mDone = done;
    }

    private boolean mDone;

    public String getTaskTitle() {
        return mTaskTitle;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public void setTaskTitle(String taskTitle) {
        mTaskTitle = taskTitle;
    }

    public Date getTaskDate() {
        return mTaskDate;
    }
}
