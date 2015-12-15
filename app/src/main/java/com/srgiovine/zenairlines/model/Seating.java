package com.srgiovine.zenairlines.model;

public final class Seating {

    public final long customerId;
    public final long flightNumber;
    public final String seatNumber;
    public final long cost;
    public final String seatClass;

    private Seating(long customerId, long flightNumber, String seatNumber, long cost, String seatClass) {
        this.customerId = customerId;
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.cost = cost;
        this.seatClass = seatClass;
    }

    public static class Builder {

        private long customerId;
        private long flightNumber;
        private String seatNumber;
        private long cost;
        private String seatClass;

        public Builder setCustomerId(long customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setFlightNumber(long flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public Builder setSeatNumber(String seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        public Builder setCost(long cost) {
            this.cost = cost;
            return this;
        }

        public Builder setSeatClass(String seatClass) {
            this.seatClass = seatClass;
            return this;
        }

        public Seating createSeating() {
            return new Seating(customerId, flightNumber, seatNumber, cost, seatClass);
        }
    }
}
