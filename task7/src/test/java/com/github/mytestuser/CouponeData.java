package com.github.mytestuser;

public class CouponeData {
    private final String couponeName;
    private final String validDate;
    private final String numberCoupons;

    public CouponeData(String couponeName, String validDate, String numberCoupons) {
        this.couponeName = couponeName;
        this.validDate = validDate;
        this.numberCoupons = numberCoupons;
    }

    public String getCouponeName() {
        return couponeName;
    }

    public String getValidDate() {
        return validDate;
    }

    public String getNumberCoupons() {
        return numberCoupons;
    }
}
