package com.vo.binh.pomo;

import java.util.Date;
import java.util.UUID;

public class Task {
    private UUID mId;
    private String mTaskTitle;
    private Date mTaskDate;
    private boolean mCompleted;

    public Task() {
        mId = UUID.randomUUID();
        mTaskDate = new Date();
    }

    public boolean isCompleted() {
        return mCompleted;
    }

    public void setCompleted(boolean completed) {
        mCompleted = completed;
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

    public void setTaskDate(Date date) {
        mTaskDate = date;
    }

    public Date getTaskDate() {
        return mTaskDate;
    }
}
