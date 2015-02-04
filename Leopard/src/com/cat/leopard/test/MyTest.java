package com.cat.leopard.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import android.test.AndroidTestCase;
import com.cat.external.log.Log;
import com.cat.leopard.bean.Article;
import com.cat.leopard.bean.User;
import com.cat.leopard.dao.ArticleDao;
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

    public void testOrm() throws SQLException {
        User u = new User();
        u.setName("张鸿洋");
        new UserDao(getContext()).add(u);
        Article article = new Article();
        article.setTitle("ORMLite的使用");
        article.setUser(u);
        new ArticleDao(getContext()).add(article);
    }

    public void testGetUserById() {
        User user = new UserDao(getContext()).get(1);
        if (user.getArticles() != null)
            for (Article article : user.getArticles()) {
                //                Log.e(article.getTitle());
                android.util.Log.e("s", article.getTitle());
            }
    }

    public void testListAdd() {
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 1000; i++) {
            User u = new User();
            u.setId(i);
            u.setName("张鸿洋");
            users.add(u);
        }
        new UserDao(getContext()).addList(users);
    }

    public void testGetAllList() {
        List<User> users = new UserDao(getContext()).getList();
        Log.e("a", users.size() + "");
    }
}
