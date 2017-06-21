package com.example.juexingzhe.sideviewpager;

/**
 * Created by juexingzhe on 2017/6/20.
 */

public class SideBean {

    private int imageRes;
    private String mainTitle;
    private String subTitle;
    private String btnTitle;

    public SideBean(int imageRes){
        this(imageRes, "", "", "");
    }

    public SideBean(int imageRes, String mainTitle, String subTitle){
        this(imageRes, mainTitle, subTitle, "");
    }

    public SideBean(int imageRes, String mainTitle, String subTitle, String btnTitle) {
        this.imageRes = imageRes;
        this.mainTitle = mainTitle;
        this.subTitle = subTitle;
        this.btnTitle = btnTitle;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getBtnTitle() {
        return btnTitle;
    }

    public void setBtnTitle(String btnTitle) {
        this.btnTitle = btnTitle;
    }
}
