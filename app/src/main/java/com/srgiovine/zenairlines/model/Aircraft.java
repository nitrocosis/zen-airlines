package com.srgiovine.zenairlines.model;

public final class Aircraft {

    public final String vin;
    public final long flightNumber;
    public final String model;
    public final long crewCapacity;
    public final String fuelRange;
    public final long firstClass;
    public final long businessClass;
    public final long economyClass;

    private Aircraft(String vin, long flightNumber, String model, long crewCapacity, String fuelRange,
                    long firstClass, long businessClass, long economyClass) {
        this.vin = vin;
        this.flightNumber = flightNumber;
        this.model = model;
        this.crewCapacity = crewCapacity;
        this.fuelRange = fuelRange;
        this.firstClass = firstClass;
        this.businessClass = businessClass;
        this.economyClass = economyClass;
    }

    public static class Builder {

        private String vin;
        private long flightNumber;
        private String model;
        private long crewCapacity;
        private String fuelRange;
        private long firstClass;
        private long businessClass;
        private long economyClass;

        public Builder setVin(String vin) {
            this.vin = vin;
            return this;
        }

        public Builder setFlightNumber(long flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setCrewCapacity(long crewCapacity) {
            this.crewCapacity = crewCapacity;
            return this;
        }

        public Builder setFuelRange(String fuelRange) {
            this.fuelRange = fuelRange;
            return this;
        }

        public Builder setFirstClass(long firstClass) {
            this.firstClass = firstClass;
            return this;
        }

        public Builder setBusinessClass(long businessClass) {
            this.businessClass = businessClass;
            return this;
        }

        public Builder setEconomyClass(long economyClass) {
            this.economyClass = economyClass;
            return this;
        }

        public Aircraft createAircraft() {
            return new Aircraft(vin, flightNumber, model, crewCapacity, fuelRange, firstClass, businessClass, economyClass);
        }
    }
}
