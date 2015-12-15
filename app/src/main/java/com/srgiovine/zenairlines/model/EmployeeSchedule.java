package com.srgiovine.zenairlines.model;

public final class EmployeeSchedule {

    public final long scheduleId;
    public final long employeeId;
    public final long flightNumber;
    public final String date;
    public final String shiftLength;

    private EmployeeSchedule(long scheduleId, long employeeId, long flightNumber, String date, String shiftLength) {
        this.scheduleId = scheduleId;
        this.employeeId = employeeId;
        this.flightNumber = flightNumber;
        this.date = date;
        this.shiftLength = shiftLength;
    }

    public static class Builder {

        private long scheduleId;
        private long employeeId;
        private long flightNumber;
        private String date;
        private String shiftLength;

        public Builder setScheduleId(long scheduleId) {
            this.scheduleId = scheduleId;
            return this;
        }

        public Builder setEmployeeId(long employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setFlightNumber(long flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setShiftLength(String shiftLength) {
            this.shiftLength = shiftLength;
            return this;
        }

        public EmployeeSchedule createEmployeeSchedule() {
            return new EmployeeSchedule(scheduleId, employeeId, flightNumber, date, shiftLength);
        }
    }
}
