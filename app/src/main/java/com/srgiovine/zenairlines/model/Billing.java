package com.srgiovine.zenairlines.model;

public final class Billing {

    public final long transactionNumber;
    public final long flightNumber;
    public final long customerId;
    public final long ticketNumber;

    private Billing(long transactionNumber, long flightNumber, long customerId, long ticketNumber) {
        this.transactionNumber = transactionNumber;
        this.flightNumber = flightNumber;
        this.customerId = customerId;
        this.ticketNumber = ticketNumber;
    }

    public static class Builder {

        private long transactionNumber;
        private long flightNumber;
        private long customerId;
        private long ticketNumber;

        public Builder setTransactionNumber(long transactionNumber) {
            this.transactionNumber = transactionNumber;
            return this;
        }

        public Builder setFlightNumber(long flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public Builder setCustomerId(long customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setTicketNumber(long ticketNumber) {
            this.ticketNumber = ticketNumber;
            return this;
        }

        public Billing createBilling() {
            return new Billing(transactionNumber, flightNumber, customerId, ticketNumber);
        }
    }

}
