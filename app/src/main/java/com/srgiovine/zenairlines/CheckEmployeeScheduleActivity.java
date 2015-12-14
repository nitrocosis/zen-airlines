package com.srgiovine.zenairlines;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Allows employees to check their schedules.
 */
public class CheckEmployeeScheduleActivity extends ZenAirlinesActivity {

    private static final String[] SCHEDULES_LIST = {
            "1140,2015-12-09,2.15 Hrs",
            "1160,2015-12-10,2 Hrs",
    };

    private SchedulesAdapter schedulesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_employee_schedule);

        schedulesAdapter = new SchedulesAdapter();

        RecyclerView schedules = (RecyclerView) findViewById(R.id.schedules);
        schedules.setHasFixedSize(true);
        schedules.setLayoutManager(new LinearLayoutManager(this));
        schedules.setAdapter(schedulesAdapter);
    }

    public void onCheckScheduleButtonClicked(View view) {
        schedulesAdapter.updateSchedulesList(Arrays.asList(SCHEDULES_LIST));
    }

    private static class SchedulesAdapter extends RecyclerView.Adapter<SchedulesViewHolder> {

        private final List<String> schedulesList = new ArrayList<>();

        private void updateSchedulesList(List<String> updatedSchedulesList) {
            schedulesList.clear();
            schedulesList.addAll(updatedSchedulesList);
            notifyDataSetChanged();
        }

        @Override
        public SchedulesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_employee_schedule, parent, false);
            return new SchedulesViewHolder(view);
        }

        @Override
        public void onBindViewHolder(SchedulesViewHolder holder, int position) {
            String[] scheduleItem = schedulesList.get(position).split(",");

            String color = position % 2 == 0 ? "#ffffff" : "#efefef";
            holder.itemView.setBackgroundColor(Color.parseColor(color));
            holder.flightNumber.setText(scheduleItem[0]);
            holder.date.setText(scheduleItem[1]);
            holder.shiftLength.setText(scheduleItem[2]);
        }

        @Override
        public int getItemCount() {
            return schedulesList.size();
        }

    }

    private static class SchedulesViewHolder extends RecyclerView.ViewHolder {

        private View itemView;
        private TextView flightNumber;
        private TextView date;
        private TextView shiftLength;

        public SchedulesViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            flightNumber = (TextView) itemView.findViewById(R.id.flight_number);
            date = (TextView) itemView.findViewById(R.id.date);
            shiftLength = (TextView) itemView.findViewById(R.id.shift_length);
        }

    }

}
