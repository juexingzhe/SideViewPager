package com.example.juexingzhe.sideviewpager;

/**
 * Created by juexingzhe on 2017/6/20.
 */

public class SideBean {

    private int imageRes0;
    private String mainTitle0;
    private String subTitle0;
    private String btnTitle0;

    private int imageRes1;
    private String mainTitle1;
    private String subTitle1;
    private String btnTitle1;

    public SideBean(int imageRes0){
        this(imageRes0, "", "", "");
    }

    public SideBean(int imageRes0, String mainTitle0, String subTitle0){
        this(imageRes0, mainTitle0, subTitle0, "");
    }

    public SideBean(int imageRes0, String mainTitle0, String subTitle0, String btnTitle0) {
        this.imageRes0 = imageRes0;
        this.mainTitle0 = mainTitle0;
        this.subTitle0 = subTitle0;
        this.btnTitle0 = btnTitle0;
    }

    public SideBean(int imageRes0, String mainTitle0, String subTitle0, String btnTitle0, int imageRes1, String mainTitle1, String subTitle1, String btnTitle1) {
        this.imageRes0 = imageRes0;
        this.mainTitle0 = mainTitle0;
        this.subTitle0 = subTitle0;
        this.btnTitle0 = btnTitle0;
        this.imageRes1 = imageRes1;
        this.mainTitle1 = mainTitle1;
        this.subTitle1 = subTitle1;
        this.btnTitle1 = btnTitle1;
    }

    public int getImageRes0() {
        return imageRes0;
    }

    public void setImageRes0(int imageRes0) {
        this.imageRes0 = imageRes0;
    }

    public String getMainTitle0() {
        return mainTitle0;
    }

    public void setMainTitle0(String mainTitle0) {
        this.mainTitle0 = mainTitle0;
    }

    public String getSubTitle0() {
        return subTitle0;
    }

    public void setSubTitle0(String subTitle0) {
        this.subTitle0 = subTitle0;
    }

    public String getBtnTitle0() {
        return btnTitle0;
    }

    public void setBtnTitle0(String btnTitle0) {
        this.btnTitle0 = btnTitle0;
    }

    public int getImageRes1() {
        return imageRes1;
    }

    public void setImageRes1(int imageRes1) {
        this.imageRes1 = imageRes1;
    }

    public String getMainTitle1() {
        return mainTitle1;
    }

    public void setMainTitle1(String mainTitle1) {
        this.mainTitle1 = mainTitle1;
    }

    public String getSubTitle1() {
        return subTitle1;
    }

    public void setSubTitle1(String subTitle1) {
        this.subTitle1 = subTitle1;
    }

    public String getBtnTitle1() {
        return btnTitle1;
    }

    public void setBtnTitle1(String btnTitle1) {
        this.btnTitle1 = btnTitle1;
    }
}
