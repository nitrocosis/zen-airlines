package com.srgiovine.zenairlines.model;

public final class FlightDescription {

    public final long flightNumber;
    public final String departure;
    public final String departureCity;
    public final String departureState;
    public final String departureTime;
    public final String arrival;
    public final String arrivalCity;
    public final String arrivalState;
    public final String arrivalTime;

    private FlightDescription(long flightNumber, String departure, String departureCity, String departureState, String departureTime, String arrival, String arrivalCity, String arrivalState, String arrivalTime) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.departureCity = departureCity;
        this.departureState = departureState;
        this.departureTime = departureTime;
        this.arrival = arrival;
        this.arrivalCity = arrivalCity;
        this.arrivalState = arrivalState;
        this.arrivalTime = arrivalTime;
    }

    public static class Builder {

        private long flightNumber;
        private String departure;
        private String departureCity;
        private String departureState;
        private String departureTime;
        private String arrival;
        private String arrivalCity;
        private String arrivalState;
        private String arrivalTime;

        public Builder setFlightNumber(long flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public Builder setDeparture(String departure) {
            this.departure = departure;
            return this;
        }

        public Builder setDepartureCity(String departureCity) {
            this.departureCity = departureCity;
            return this;
        }

        public Builder setDepartureState(String departureState) {
            this.departureState = departureState;
            return this;
        }

        public Builder setDepartureTime(String departureTime) {
            this.departureTime = departureTime;
            return this;
        }

        public Builder setArrival(String arrival) {
            this.arrival = arrival;
            return this;
        }

        public Builder setArrivalCity(String arrivalCity) {
            this.arrivalCity = arrivalCity;
            return this;
        }

        public Builder setArrivalState(String arrivalState) {
            this.arrivalState = arrivalState;
            return this;
        }

        public Builder setArrivalTime(String arrivalTime) {
            this.arrivalTime = arrivalTime;
            return this;
        }

        public FlightDescription createFlightDescription() {
            return new FlightDescription(flightNumber, departure, departureCity, departureState,
                    departureTime, arrival, arrivalCity, arrivalState, arrivalTime);
        }
    }

}
