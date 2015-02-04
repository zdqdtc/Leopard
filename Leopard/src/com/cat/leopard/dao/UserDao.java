package com.cat.leopard.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import com.cat.leopard.bean.User;
import com.j256.ormlite.android.AndroidDatabaseConnection;
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

    public void addList(List<User> list) {
        AndroidDatabaseConnection connection = new AndroidDatabaseConnection(helper.getWritableDatabase(), true);
        try {
            connection.setAutoCommit(false);
            for (User user : list) {
                userDaoOpe.createOrUpdate(user);
            }
            connection.commit(null);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public User get(int id) {
        try {
            return userDaoOpe.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getList() {
        List<User> users = new ArrayList<User>();
        try {
            users = userDaoOpe.queryForAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return users;
    }
}
