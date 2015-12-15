package com.srgiovine.zenairlines;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.srgiovine.zenairlines.data.ZenDB;
import com.srgiovine.zenairlines.model.EmployeeSchedule;

import java.util.ArrayList;
import java.util.List;

/**
 * Allows employees to check their schedules.
 */
public class CheckEmployeeScheduleActivity extends ZenAirlinesActivity {

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
        if (!validateEditTexts(R.id.employee_id)) {
            return;
        }

        getZenDB().selectEmployeeSchedulesAsync(getEditTextValue(R.id.employee_id, String.class),
                new ZenDB.Callback<List<EmployeeSchedule>>() {
                    @Override
                    public void success(List<EmployeeSchedule> employeeSchedules) {
                        schedulesAdapter.updateSchedulesList(employeeSchedules);
                    }

                    @Override
                    public void failed() {
                        showAlertDialog("Failed", "Employee schedule not found!");
                    }
                });
    }

    private static class SchedulesAdapter extends RecyclerView.Adapter<SchedulesViewHolder> {

        private final List<EmployeeSchedule> schedulesList = new ArrayList<>();

        private void updateSchedulesList(List<EmployeeSchedule> updatedSchedulesList) {
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
            EmployeeSchedule scheduleItem = schedulesList.get(position);

            String color = position % 2 == 0 ? "#ffffff" : "#efefef";
            holder.itemView.setBackgroundColor(Color.parseColor(color));
            holder.flightNumber.setText(String.valueOf(scheduleItem.flightNumber));
            holder.date.setText(scheduleItem.date);
            holder.shiftLength.setText(scheduleItem.shiftLength);
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
