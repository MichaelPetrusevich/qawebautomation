package com.github.mytestuser;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class CreateCoupon extends TestBase {

    @Test
    public void createCouponTest() {
        gotoPanelCoupons();
        createCoupon(new CouponeData("abyrwalg", "2020-01-01", "333"));
        Assert.assertEquals("Success",messageCreateCoupon);
    }

    @Test
    public void findCouponTest() {
        gotoPanelCoupons();
        getCoupon("abyrwalg");
        Assert.assertEquals("abyrwalg",valueNameCoupone);
    }
}