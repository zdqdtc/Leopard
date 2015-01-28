package com.cat.external.util;

import android.os.AsyncTask;
import com.google.gson.Gson;
import com.nongfu.customer.cache.CachedObject;
import com.nongfu.customer.cache.DiskCache;
import com.nongfu.customer.cache.GetCallback;
import com.nongfu.customer.cache.PutCallback;
import com.nongfu.customer.cache.SoftCachedObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class CacheManager {
    private final static int              CACHE_RUSH_SECONDS = 60 * 2;

    private static CacheManager           ourInstance;

    private DiskCache                     diskCache;

    private HashMap<String, CachedObject> runtimeCache;

    public static CacheManager getInstance(DiskCache diskCache) {
        if (ourInstance == null) {
            ourInstance = new CacheManager(diskCache);
        }
        return ourInstance;
    }

    private CacheManager(DiskCache diskCache) {
        this.diskCache = diskCache;
        runtimeCache = new HashMap<String, CachedObject>();
    }

    public boolean exists(String key) {
        boolean result = false;
        try {
            result = diskCache.contains(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Object get(String key, Class<?> objectClass, Type objectType) {
        Object result = null;
        CachedObject runtimeCachedObject = runtimeCache.get(key);
        if (runtimeCachedObject != null && !runtimeCachedObject.isExpired()) {
            result = new Gson().fromJson(runtimeCachedObject.getPayload(), objectType);
        } else if (runtimeCachedObject != null && runtimeCachedObject.isSoftExpired()) {
            result = new SoftCachedObject<Object>(new Gson().fromJson(runtimeCachedObject.getPayload(), objectType));
        } else {
            try {
                String json = diskCache.getValue(key);
                if (json != null) {
                    CachedObject cachedObject = new Gson().fromJson(json, CachedObject.class);
                    if (!cachedObject.isExpired()) {
                        runtimeCache.put(key, cachedObject);
                        result = new Gson().fromJson(cachedObject.getPayload(), objectType);
                    } else {
                        if (cachedObject.isSoftExpired()) {
                            result = new SoftCachedObject<Object>(new Gson().fromJson(cachedObject.getPayload(), objectType));
                        }
                        // To avoid cache rushing, we insert the value back in the cache with a longer expiry
                        // Presumably, whoever received this expiration result will have inserted a fresh value by now
                        putAsync(key, new Gson().fromJson(cachedObject.getPayload(), objectType), CACHE_RUSH_SECONDS, false, new PutCallback() {
                            @Override
                            public void onSuccess() {}

                            @Override
                            public void onFailure(Exception e) {}
                        });
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                // Do nothing, return null
            }
        }
        return result;
    }

    public void getAsync(String key, Class<?> objectClass, Type objectType, GetCallback<Object> getCallback) {
        new GetAsyncTask(key, objectClass, objectType, getCallback).execute();
    }

    public boolean unset(String key) {
        return put(key, null, -1, false);
    }

    public void unsetAsync(String key, PutCallback putCallback) {
        putAsync(key, null, -1, false, putCallback);
    }

    public boolean put(String key, Object object) {
        return put(key, object, -1, false);
    }

    public boolean put(String key, Object object, int expiryTimeSeconds, boolean allowSoftExpiry) {
        boolean result = false;
        try {
            String payloadJson = new Gson().toJson(object);
            CachedObject cachedObject = new CachedObject(payloadJson, expiryTimeSeconds, allowSoftExpiry);
            String json = new Gson().toJson(cachedObject);
            runtimeCache.put(key, cachedObject);
            diskCache.setKeyValue(key, json);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            // Do nothing, return false
        }
        return result;
    }

    public void putAsync(String key, Object object, PutCallback putCallback) {
        putAsync(key, object, -1, false, putCallback);
    }

    public void putAsync(String key, Object object, int expiryTimeSeconds, boolean allowSoftExpiry, PutCallback putCallback) {
        new PutAsyncTask(key, object, expiryTimeSeconds, allowSoftExpiry, putCallback).execute();
    }

    public void clear() throws IOException {
        runtimeCache.clear();
        diskCache.clearCache();
    }

    public enum ExpiryTimes {
        ONE_SECOND(1), ONE_MINUTE(60), ONE_HOUR(60 * 60), ONE_DAY(60 * 60 * 24), ONE_WEEK(60 * 60 * 24 * 7), ONE_MONTH(60 * 60 * 24 * 30), ONE_YEAR(
                60 * 60 * 24 * 365);
        private final int seconds;

        ExpiryTimes(int seconds) {
            this.seconds = seconds;
        }

        public int asSeconds() {
            return seconds;
        }
    }

    private class GetAsyncTask extends AsyncTask<Void, Void, Object> {
        private final String              key;

        private final GetCallback<Object> callback;

        private final Type                objectType;

        @SuppressWarnings("unused")
        private final Class<?>            objectClass;

        private Exception                 e;

        private GetAsyncTask(String key, Class<?> objectClass, Type objectType, GetCallback<Object> callback) {
            this.callback = callback;
            this.key = key;
            this.objectType = objectType;
            this.objectClass = objectClass;
        }

        @Override
        protected Object doInBackground(Void... voids) {
            Object result = null;
            CachedObject runtimeCachedObject = runtimeCache.get(key);
            if (runtimeCachedObject != null && !runtimeCachedObject.isExpired()) {
                result = new Gson().fromJson(runtimeCachedObject.getPayload(), objectType);
            } else if (runtimeCachedObject != null && runtimeCachedObject.isSoftExpired()) {
                result = new SoftCachedObject<Object>(new Gson().fromJson(runtimeCachedObject.getPayload(), objectType));
            } else {
                try {
                    String json = diskCache.getValue(key);
                    if (json != null) {
                        CachedObject cachedObject = new Gson().fromJson(json, CachedObject.class);
                        if (!cachedObject.isExpired()) {
                            result = new Gson().fromJson(cachedObject.getPayload(), objectType);
                            runtimeCache.put(key, cachedObject);
                        } else {
                            if (cachedObject.isSoftExpired()) {
                                result = new SoftCachedObject<Object>(new Gson().fromJson(cachedObject.getPayload(), objectType));
                            }
                            // To avoid cache rushing, we insert the value back in the cache with a longer expiry
                            // Presumably, whoever received this expiration result will have inserted a fresh value by now
                            putAsync(key, new Gson().fromJson(cachedObject.getPayload(), objectType), CACHE_RUSH_SECONDS, false, new PutCallback() {
                                @Override
                                public void onSuccess() {}

                                @Override
                                public void onFailure(Exception e) {}
                            });
                        }
                    }
                } catch (Exception e) {
                    this.e = e;
                }
            }
            return result;
        }

        @Override
        protected void onPostExecute(Object object) {
            if (callback != null) {
                if (e == null) {
                    callback.onSuccess(object);
                } else {
                    callback.onFailure(e);
                }
            }
        }
    }

    private class PutAsyncTask extends AsyncTask<Void, Void, Void> {
        private final PutCallback callback;

        private final String      key;

        private final Object      payload;

        private final int         expiryTimeSeconds;

        private final boolean     allowSoftExpiry;

        private Exception         e;

        private PutAsyncTask(String key, Object payload, int expiryTimeSeconds, boolean allowSoftExpiry, PutCallback callback) {
            this.key = key;
            this.callback = callback;
            this.payload = payload;
            this.expiryTimeSeconds = expiryTimeSeconds;
            this.allowSoftExpiry = allowSoftExpiry;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String payloadJson = new Gson().toJson(payload);
                CachedObject cachedObject = new CachedObject(payloadJson, expiryTimeSeconds, allowSoftExpiry);
                String json = new Gson().toJson(cachedObject);
                runtimeCache.put(key, cachedObject);
                diskCache.setKeyValue(key, json);
            } catch (Exception e) {
                this.e = e;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (callback != null) {
                if (e == null) {
                    callback.onSuccess();
                } else {
                    callback.onFailure(e);
                }
            }
        }
    }
}
