package com.group9.kurbani_cattle_hut_management_system.Joy;

public class Tent {
    private String tentID;
    private int occupiedSloats;
    private int totalCapacity;
    private int freeSlots;
    private String direction;
    private String status;

    public Tent(String tentID, int occupiedSloats, int totalCapacity, int freeSlots, String direction, String status) {
        this.tentID = tentID;
        this.occupiedSloats = occupiedSloats;
        this.totalCapacity = totalCapacity;
        this.freeSlots = freeSlots;
        this.direction = direction;
        this.status = status;
    }

    public String getTentID() {
        return tentID;
    }

    public void setTentID(String tentID) {
        this.tentID = tentID;
    }

    public int getOccupiedSloats() {
        return occupiedSloats;
    }

    public void setOccupiedSloats(int occupiedSloats) {
        this.occupiedSloats = occupiedSloats;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public int getFreeSlots() {
        return freeSlots;
    }

    public void setFreeSlots(int freeSlots) {
        this.freeSlots = freeSlots;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tent{" +
                "tentID='" + tentID + '\'' +
                ", occupiedSloats=" + occupiedSloats +
                ", totalCapacity=" + totalCapacity +
                ", freeSlots=" + freeSlots +
                ", direction='" + direction + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
