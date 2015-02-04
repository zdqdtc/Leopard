package com.cat.leopard.test;

import java.sql.SQLException;

import junit.framework.Assert;
import android.test.AndroidTestCase;

import com.cat.leopard.bean.User;
import com.cat.leopard.dao.UserDao;

public class MyTest extends AndroidTestCase {
    @SuppressWarnings("unused")
    private static final String Tag = "MyTest";

    public void testSave() throws Throwable {
        int i = 4 + 8;
        Assert.assertEquals(12, i);
        
        
        
    }

    public void testSomethingElse() throws Throwable {
        Assert.assertTrue(1 + 1 == 12);
    }
    
    
    public void testOrm() throws SQLException
    {
        User u = new User();
        u.setName("张鸿洋");
        new UserDao(getContext()).add(u);
        
    }
}
