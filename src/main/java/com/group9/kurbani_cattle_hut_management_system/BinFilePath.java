package com.group9.kurbani_cattle_hut_management_system;

public enum BinFilePath {
    SELLER("bin/seller/seller.bin"),
    ANIMAL("bin/seller/animal.bin"),
    BUYING_OFFER("bin/seller/buying_offer.bin"),
    MEDICAL_RECORD("bin/seller/medical_record.bin");

    private final String filePath;

    BinFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
