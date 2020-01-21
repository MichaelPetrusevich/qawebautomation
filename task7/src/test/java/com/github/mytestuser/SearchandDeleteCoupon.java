package com.github.mytestuser;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class SearchandDeleteCoupon extends TestBase {
    @Test
    public void searchCouponTest() {
        gotoPanelCoupons();
        searchCoupon("abyrwalg");
        Assert.assertEquals(1,countRowCoupon);
        log.info("Search coupone");
    }

    @Test
    public void deleteCouponTest() {
        gotoPanelCoupons();
        searchCoupon("abyrwalg");
        deleteCoupon();

        searchCoupon("abyrwalg");
        Assert.assertEquals(0,countRowCoupon);
        log.info("Delete coupone");
    }
}
