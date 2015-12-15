package com.srgiovine.zenairlines.model;

public final class Employee {

    public final long id;
    public final String firstName;
    public final String lastName;
    public final String ssn;
    public final String jobDescription;
    public final String phoneNumber;
    public final String email;
    public final String address;
    public final String city;
    public final String state;
    public final String zip;

    public Employee(long id, String firstName, String lastName, String ssn, String jobDescription,
                    String phoneNumber, String email, String address, String city, String state, String zip) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.jobDescription = jobDescription;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public static class Builder {

        private long id;
        private String firstName;
        private String lastName;
        private String ssn;
        private String jobDescription;
        private String phoneNumber;
        private String email;
        private String address;
        private String city;
        private String state;
        private String zip;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setSsn(String ssn) {
            this.ssn = ssn;
            return this;
        }

        public Builder setJobDescription(String jobDescription) {
            this.jobDescription = jobDescription;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setZip(String zip) {
            this.zip = zip;
            return this;
        }

        public Employee createEmployee() {
            return new Employee(id, firstName, lastName, ssn, jobDescription, phoneNumber, email,
                    address, city, state, zip);
        }
    }
}
