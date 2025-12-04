package com.group9.kurbani_cattle_hut_management_system.tanvir.seller;

import java.io.Serializable;

public class BuyingOffer implements Serializable {
    private int animalId;
    private String buyerName;
    private String buyerPhone;
    private float offeredPrice;

    public BuyingOffer(int animalId, String buyerName, String buyerPhone, float offeredPrice) {
        this.animalId = animalId;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
        this.offeredPrice = offeredPrice;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public float getOfferedPrice() {
        return offeredPrice;
    }

    public void setOfferedPrice(float offeredPrice) {
        this.offeredPrice = offeredPrice;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }
}
