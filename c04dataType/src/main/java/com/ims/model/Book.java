package com.ims.model;

import javafx.scene.image.PixelFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

/**
 * 基本数据类型映射
 */
@Entity
@Table(name = "c04_t_book")
public class Book {

    private int intTest;  //->int
    private long longTest; //->bigint
    private float floattest; // ->float
    private double doubleTest;  // ->float
    private String stringTeat; // ->varchar（255）
    private boolean booleanTest; // ->tinyint
    private Date dateTest; // ->datetime
    private String stringToTextTest; //
    private Blob blobTest; // ->longblob

    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public int getIntTest() {
        return intTest;
    }

    public void setIntTest(int intTest) {
        this.intTest = intTest;
    }

    public long getLongTest() {
        return longTest;
    }

    public void setLongTest(long longTest) {
        this.longTest = longTest;
    }

    public float getFloattest() {
        return floattest;
    }

    public void setFloattest(float floattest) {
        this.floattest = floattest;
    }

    public double getDoubleTest() {
        return doubleTest;
    }

    public void setDoubleTest(double doubleTest) {
        this.doubleTest = doubleTest;
    }

    public String getStringTeat() {
        return stringTeat;
    }

    public void setStringTeat(String stringTeat) {
        this.stringTeat = stringTeat;
    }

    public boolean isBooleanTest() {
        return booleanTest;
    }

    public void setBooleanTest(boolean booleanTest) {
        this.booleanTest = booleanTest;
    }

    public Date getDateTest() {
        return dateTest;
    }

    public void setDateTest(Date dateTest) {
        this.dateTest = dateTest;
    }

    @Column(columnDefinition = "text")
    public String getStringToTextTest() {
        return stringToTextTest;
    }

    public void setStringToTextTest(String stringToTextTest) {
        this.stringToTextTest = stringToTextTest;
    }

    public Blob getBlobTest() {
        return blobTest;
    }

    public void setBlobTest(Blob blobTest) {
        this.blobTest = blobTest;
    }
}
