package com.group9.kurbani_cattle_hut_management_system.Joy;

public class Owner {
    private String ownerID;
    private String ownerName;
    private String ownerNID;
    private String ownerAddress;
    private String ownerPhone;

    public Owner(String ownerID, String ownerName, String ownerNID, String ownerAddress, String ownerPhone) {
        this.ownerID = ownerID;
        this.ownerName = ownerName;
        this.ownerNID = ownerNID;
        this.ownerAddress = ownerAddress;
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerNID() {
        return ownerNID;
    }

    public void setOwnerNID(String ownerNID) {
        this.ownerNID = ownerNID;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerID='" + ownerID + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerNID='" + ownerNID + '\'' +
                ", ownerAddress='" + ownerAddress + '\'' +
                ", ownerPhone='" + ownerPhone + '\'' +
                '}';
    }
}
