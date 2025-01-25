//package com.busreservation.model;
//
//public class Bus {
//    private int busId;
//    private String busName;
//    private String source;
//    private String destination;
//    private int totalSeats;
//    private int availableSeats;
//    private String departureDate;
//
//    public Bus(String busName, String source, String destination, int totalSeats, int availableSeats, String departureDate) {
//    }
//
//    public Bus(int busId, String busName, String source, String destination, int totalSeats, int availableSeats, String departureDate) {
//        this.busId = busId;
//        this.busName = busName;
//        this.source = source;
//        this.destination = destination;
//        this.totalSeats = totalSeats;
//        this.availableSeats = availableSeats;
//        this.departureDate = departureDate;
//    }
//
//    // Getters and Setters
//    public int getBusId() {
//        return busId;
//    }
//
//    public void setBusId(int busId) {
//        this.busId = busId;
//    }
//
//    public String getBusName() {
//        return busName;
//    }
//
//    public void setBusName(String busName) {
//        this.busName = busName;
//    }
//
//    public String getSource() {
//        return source;
//    }
//
//    public void setSource(String source) {
//        this.source = source;
//    }
//
//    public String getDestination() {
//        return destination;
//    }
//
//    public void setDestination(String destination) {
//        this.destination = destination;
//    }
//
//    public int getTotalSeats() {
//        return totalSeats;
//    }
//
//    public void setTotalSeats(int totalSeats) {
//        this.totalSeats = totalSeats;
//    }
//
//    public int getAvailableSeats() {
//        return availableSeats;
//    }
//
//    public void setAvailableSeats(int availableSeats) {
//        this.availableSeats = availableSeats;
//    }
//
//    public String getDepartureDate() {
//        return departureDate;
//    }
//
//    public void setDepartureDate(String departureDate) {
//        this.departureDate = departureDate;
//    }
//
//    @Override
//    public String toString() {
//        return "Bus [busId=" + busId + ", busName=" + busName + ", source=" + source + ", destination=" + destination + ", totalSeats=" + totalSeats + ", availableSeats=" + availableSeats + ", departureDate=" + departureDate + "]";
//    }
//}
package com.busreservation.model;

public class Bus {
    private int busId;
    private String busName;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;
    private String departureDate;

    // Default constructor
    public Bus() {
    }

    // Parameterized constructor
    public Bus(String busName, String source, String destination, int totalSeats, int availableSeats, String departureDate) {
        this.busName = busName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.departureDate = departureDate;
    }

    // Getters and Setters
    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public String toString() {
        return "Bus [busId=" + busId + ", busName=" + busName + ", source=" + source +
                ", destination=" + destination + ", totalSeats=" + totalSeats +
                ", availableSeats=" + availableSeats + ", departureDate=" + departureDate + "]";
    }
}
