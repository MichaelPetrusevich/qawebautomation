package com.github.mytestuser;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CreateCoupon.class,
        SearchandDeleteCoupon.class,
        Logout.class
})
public class MySuiteTest extends TestBase {

    @BeforeClass
    public static void suiteSetUp() {
        System.out.println("suiteSetUp");
    }

    @AfterClass
    public static void suiteTearDown() {
        System.out.println("suiteTearDown");
    }

}