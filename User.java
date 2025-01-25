package com.busreservation.model;

public class User {
    private int userId;
    private String userName;
    private String contactNumber;

    public User(String userName, String contactNumber) {
    }

    public User(int userId, String userName, String contactNumber) {
        this.userId = userId;
        this.userName = userName;
        this.contactNumber = contactNumber;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", contactNumber=" + contactNumber + "]";
    }
}
