/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      Image.java
 * 类名:        Image
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.leopard.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * 类名:		Image
 * 描述:		图片类型
 * @author 	diqingzhu
 *
 */
public class Image implements Serializable {
    /**
     * 变量名:		serialVersionUID
     * 描述:			TODO
     * 取值含义:		TODO
     */
    private static final long serialVersionUID = -5399911779933046541L;

    private String            url;

    private int               size;

    private List<Image>       images;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public Image clone() {
        Image image = null;
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo;
        try {
            oo = new ObjectOutputStream(bo);
            oo.writeObject(this);//从流里读出来
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            image = (Image) oi.readObject();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return image;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
