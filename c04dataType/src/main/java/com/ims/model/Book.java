package com.ims.model;

import java.sql.Blob;
import java.util.Date;

/**
 * 基本数据类型映射
 */
public class Book {

    private int id;  //->int
    private String bookName; // 图书名称 ->varchar（255）
    private int pageNums; // 图书页数 ->int
    private float price; // 图书价格  ->float
    private boolean specialPrice; // 是否是特价   ->tinyint
    private Date publishDate; // 发布日期   ->datetime
    private String author; // 作者    ->varchar（255）
    private String introduction; // 简介  ->varchar（255）
    private Blob bookPic; // 图书图片   ->longblob

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(boolean specialPrice) {
        this.specialPrice = specialPrice;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Blob getBookPic() {
        return bookPic;
    }

    public void setBookPic(Blob bookPic) {
        this.bookPic = bookPic;
    }

    public int getPageNums() {
        return pageNums;
    }

    public void setPageNums(int pageNums) {
        this.pageNums = pageNums;
    }

}
