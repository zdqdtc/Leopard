package com.cat.leopard.dao;

import java.sql.SQLException;

import android.content.Context;

import com.cat.leopard.bean.User;
import com.j256.ormlite.dao.Dao;

public class UserDao extends BaseDao {
    private Dao<User, Integer> userDaoOpe;

    @SuppressWarnings("unchecked")
    public UserDao(Context context) {
        super(context);
        try {
            userDaoOpe = helper.getDao(User.class);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 增加一个用户
     * 
     * @param user
     * @throws SQLException
     */
    public void add(User user) {
        try {
            userDaoOpe.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
