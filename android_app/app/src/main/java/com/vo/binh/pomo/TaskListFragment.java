package com.vo.binh.pomo;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * TaskListFragment controller to display a list of tasks to the user
 * by using a Recycler View's Adapter
 * Adapter:
 *  - create ViewHolders to host a View
 *  - bind Task's data to the model layer
 */
public class TaskListFragment extends Fragment {
    private RecyclerView mTaskRecyclerView;
    private TaskAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        mTaskRecyclerView = (RecyclerView) view.findViewById(R.id.task_recycler_view);
        mTaskRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        TaskLab taskLab = TaskLab.get(getActivity());
        List<Task> tasks = taskLab.getTasks();

        mAdapter = new TaskAdapter(tasks);
        mTaskRecyclerView.setAdapter(mAdapter);
    }

    private class TaskHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Task mTask;

        private TextView mTaskTitleTextView;
        private TextView mDateTextView;
        private ImageView mCompletedImageView;

        public TaskHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_taskcard, parent, false));

            itemView.setOnClickListener(this); // 
            mTaskTitleTextView = (TextView) itemView.findViewById(R.id.task_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.task_date);
            mCompletedImageView = (ImageView) itemView.findViewById(R.id.task_completed);
        }

        public void bind(Task task) {
            mTask = task;
            mTaskTitleTextView.setText(mTask.getTaskTitle());
            mDateTextView.setText(new SimpleDateFormat("E MMMM dd, yyyy").format(mTask.getTaskDate()));
            mCompletedImageView.setVisibility(task.isCompleted() ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onClick(View view) { // When user clicks a task item, it will start a new activity from the Task List Fragment
            // Toast.makeText(getActivity(), mTask.getTaskTitle() + " clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), TaskActivity.class);
            startActivity(intent);
        }
    }


    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {
        private List<Task> mTasks;

        public TaskAdapter(List<Task> tasks) {
            mTasks = tasks;
        }


        @Override
        public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new TaskHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
            Task task = mTasks.get(position);
            holder.bind(task);
        }


        @Override
        public int getItemCount() {
            return mTasks.size();
        }
    }
}
