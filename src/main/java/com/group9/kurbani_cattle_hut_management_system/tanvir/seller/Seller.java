package com.group9.kurbani_cattle_hut_management_system.tanvir.seller;

import java.io.Serializable;

public class Seller implements Serializable {
    private String sellerName;
    private String sellerEmail;
    private String sellerPhone;
    private String hutAddress;
    private String password;
    private String NID;
    private String kycURL;
    private boolean isVerified;

    public Seller(String sellerName, String sellerEmail, String sellerPhone, String hutAddress, String password, String NID, String kycURL) {
        this.sellerName = sellerName;
        this.sellerEmail = sellerEmail;
        this.sellerPhone = sellerPhone;
        this.hutAddress = hutAddress;
        this.password = password;
        this.NID = NID;
        this.kycURL = kycURL;
        this.isVerified = false;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    public String getHutAddress() {
        return hutAddress;
    }

    public void setHutAddress(String hutAddress) {
        this.hutAddress = hutAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNID() {
        return NID;
    }

    public void setNID(String NID) {
        this.NID = NID;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public String getKycURL() {
        return kycURL;
    }

    public void setKycURL(String kycURL) {
        this.kycURL = kycURL;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerName='" + sellerName + '\'' +
                ", sellerEmail='" + sellerEmail + '\'' +
                ", sellerPhone='" + sellerPhone + '\'' +
                ", hutAddress='" + hutAddress + '\'' +
                ", password='" + password + '\'' +
                ", NID='" + NID + '\'' +
                ", kycURL='" + kycURL + '\'' +
                ", isVerified=" + isVerified +
                '}';
    }
}
