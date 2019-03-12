package com.vo.binh.pomo;



import android.support.v4.app.Fragment;
import android.widget.CalendarView;

public class TaskActivity extends SingleFragmentActivity {

    private static final String TAG = "TaskActivity";
    private CalendarView mCalendarView;


    @Override
    protected Fragment createFragment() {
        return new TaskFragment();
    }


}
