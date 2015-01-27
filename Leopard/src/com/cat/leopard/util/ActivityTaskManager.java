/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      ActivityTaskManager.java
 * 类名:        ActivityTaskManager
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.leopard.util;

/**
 * 类名:		ActivityTaskManager
 * 描述:		activity 管理类
 * @author 	diqingzhu
 *
 */


import java.util.HashMap;

import java.util.Set;

import android.app.Activity;


public class ActivityTaskManager {

    private static ActivityTaskManager activityTaskManager = null;
    private HashMap<String, Activity> activityMap = null;

    private ActivityTaskManager() {
        activityMap = new HashMap<String, Activity>();
    }

    /**
     * 返回activity管理器的唯一实例对象。
     * 
     * @return
     */
    public static synchronized ActivityTaskManager getInstance() {
        if (activityTaskManager == null) {
            activityTaskManager = new ActivityTaskManager();
        }
        return activityTaskManager;
    }

    /**
     * 将一个activity添加到管理器。
     * 
     * @param activity
     */
    public Activity putActivity(String name, Activity activity) {
        return activityMap.put(name, activity);
    }

    /**
     * 得到保存在管理器中的Activity对象。
     * 
     * @param name
     * @return
     */
    public Activity getActivity(String name) {
        return activityMap.get(name);
    }

    /**
     * 返回管理器的Activity是否为空。
     * 
     * @return 当且当管理器中的Activity对象为空时返回true，否则返回false。
     */
    public boolean isEmpty() {
        return activityMap.isEmpty();
    }

    /**
     * 返回管理器中Activity对象的个数。
     * 
     * @return 管理器中Activity对象的个数。
     */
    public int size() {
        return activityMap.size();
    }

    /**
     * 返回管理器中是否包含指定的名字。
     * 
     * @param name
     *            要查找的名字。
     * @return 当且仅当包含指定的名字时返回true, 否则返回false。
     */
    public boolean containsName(String name) {
        return activityMap.containsKey(name);
    }

    /**
     * 返回管理器中是否包含指定的Activity。
     * 
     * @param activity
     *            要查找的Activity。
     * @return 当且仅当包含指定的Activity对象时返回true, 否则返回false。
     */
    public boolean containsActivity(Activity activity) {
        return activityMap.containsValue(activity);
    }

    /**
     * 关闭所有活动的Activity。
     */
    public void closeAllActivity() {
        Set<String> activityNames = activityMap.keySet();
        for (String string : activityNames) {
            finisActivity(activityMap.get(string));
        }
        activityMap.clear();
    }

    /**
     * 关闭所有活动的Activity除了指定的一个之外。
     * 
     * @param nameSpecified
     *            指定的不关闭的Activity对象的名字。
     */
    public void closeAllActivityExceptOne(String nameSpecified) {
        Set<String> activityNames = activityMap.keySet();
        Activity activitySpecified = activityMap.get(nameSpecified);
        for (String name : activityNames) {
            if (name.equals(nameSpecified)) {
                continue;
            }
            finisActivity(activityMap.get(name));
        }
        activityMap.clear();
        activityMap.put(nameSpecified, activitySpecified);
    }

    /**
     * 移除Activity对象,如果它未结束则结束它。
     * 
     * @param name
     *            Activity对象的名字。
     */
    public void removeActivity(String name) {
        Activity activity = activityMap.remove(name);
        finisActivity(activity);
    }

    private final void finisActivity(Activity activity) {
        if (activity != null) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
