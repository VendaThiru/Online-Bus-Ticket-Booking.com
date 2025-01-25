package com.busreservation.model;

public class Booking {
    private int bookingId;
    private int userId;
    private int busId;
    private int seatsBooked;
    private String bookingDate;

    public Booking() {
    }

    public Booking(int bookingId, int userId, int busId, int seatsBooked, String bookingDate) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.busId = busId;
        this.seatsBooked = seatsBooked;
        this.bookingDate = bookingDate;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(int seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", busId=" + busId + ", seatsBooked=" + seatsBooked + ", bookingDate=" + bookingDate + "]";
    }
}
