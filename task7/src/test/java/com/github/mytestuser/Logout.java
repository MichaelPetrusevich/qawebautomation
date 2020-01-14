package com.github.mytestuser;

import org.junit.Assert;
import org.junit.Test;

public class Logout extends TestBase {

    @Test
    public void logoutTest() {
        logout();
        Assert.assertEquals("Login - Open eShop",headingLogout);
    }
}