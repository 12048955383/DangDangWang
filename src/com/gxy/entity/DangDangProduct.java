package com.gxy.entity;

import java.util.Date;

public class DangDangProduct {
    //主键
    private int ddProductId;

    //图书名称
    private String ddProductName;

    //作者
    private String ddProductAuthor;

    //图片路径
    private String ddProductImg;

    //出版社
    private String ddProductPress;

    //出版时间
    private String ddProductPresstime;

    //版本号
    private String ddProductEdition;

    //印刷时间
    private String ddProductPrinttime;

    //印刷数量
    private int ddProductPrintcount;

    //ISBN
    private String ddProductIsbn;

    //总字数
    private String ddProductWordcount;

    //总页数
    private String ddProductPagecount;

    //页面规格
    private String ddProductFormat;

    //纸张
    private String ddProductPaper;

    //包装
    private String ddProductPack;

    //定价
    private int ddProductPrice;

    //当当价
    private int ddProductDdprice;

    //图书销量
    private int ddProductCount;

    //上架时间
    private Date ddProductAddtime;

    //推荐评语
    private String ddProductRecommend;

    //图书简介
    private String ddProductBrief;

    //作者简介
    private String ddProductAuthorbrief;

    //目录
    private String ddProductDirectory;

    //视频推荐
    private String ddProductMediacomment;

    //图书标记
    private String ddProductExcerpt;

    //图书分类，分类2外键
    private int ddCategory2Id;

    //时间戳
    private Date ddProductCreateDate;

    
    public DangDangProduct() {
		super();
	}

	public int getDdProductId() {
        return ddProductId;
    }

    public void setDdProductId(int ddProductId) {
        this.ddProductId = ddProductId;
    }

    public String getDdProductName() {
        return ddProductName;
    }

    public void setDdProductName(String ddProductName) {
        this.ddProductName = ddProductName;
    }

    public String getDdProductAuthor() {
        return ddProductAuthor;
    }

    public void setDdProductAuthor(String ddProductAuthor) {
        this.ddProductAuthor = ddProductAuthor;
    }

    public String getDdProductImg() {
        return ddProductImg;
    }

    public void setDdProductImg(String ddProductImg) {
        this.ddProductImg = ddProductImg;
    }

    public String getDdProductPress() {
        return ddProductPress;
    }

    public void setDdProductPress(String ddProductPress) {
        this.ddProductPress = ddProductPress;
    }

    public String getDdProductPresstime() {
        return ddProductPresstime;
    }

    public void setDdProductPresstime(String ddProductPresstime) {
        this.ddProductPresstime = ddProductPresstime;
    }

    public String getDdProductEdition() {
        return ddProductEdition;
    }

    public void setDdProductEdition(String ddProductEdition) {
        this.ddProductEdition = ddProductEdition;
    }

    public String getDdProductPrinttime() {
        return ddProductPrinttime;
    }

    public void setDdProductPrinttime(String ddProductPrinttime) {
        this.ddProductPrinttime = ddProductPrinttime;
    }

    public int getDdProductPrintcount() {
        return ddProductPrintcount;
    }

    public void setDdProductPrintcount(int ddProductPrintcount) {
        this.ddProductPrintcount = ddProductPrintcount;
    }

    public String getDdProductIsbn() {
        return ddProductIsbn;
    }

    public void setDdProductIsbn(String ddProductIsbn) {
        this.ddProductIsbn = ddProductIsbn;
    }

    public String getDdProductWordcount() {
        return ddProductWordcount;
    }

    public void setDdProductWordcount(String ddProductWordcount) {
        this.ddProductWordcount = ddProductWordcount;
    }

    public String getDdProductPagecount() {
        return ddProductPagecount;
    }

    public void setDdProductPagecount(String ddProductPagecount) {
        this.ddProductPagecount = ddProductPagecount;
    }

    public String getDdProductFormat() {
        return ddProductFormat;
    }

    public void setDdProductFormat(String ddProductFormat) {
        this.ddProductFormat = ddProductFormat;
    }

    public String getDdProductPaper() {
        return ddProductPaper;
    }

    public void setDdProductPaper(String ddProductPaper) {
        this.ddProductPaper = ddProductPaper;
    }

    public String getDdProductPack() {
        return ddProductPack;
    }

    public void setDdProductPack(String ddProductPack) {
        this.ddProductPack = ddProductPack;
    }

    public int getDdProductPrice() {
        return ddProductPrice;
    }

    public void setDdProductPrice(int ddProductPrice) {
        this.ddProductPrice = ddProductPrice;
    }

    public int getDdProductDdprice() {
        return ddProductDdprice;
    }

    public void setDdProductDdprice(int ddProductDdprice) {
        this.ddProductDdprice = ddProductDdprice;
    }

    public int getDdProductCount() {
        return ddProductCount;
    }

    public void setDdProductCount(int ddProductCount) {
        this.ddProductCount = ddProductCount;
    }

    public Date getDdProductAddtime() {
        return ddProductAddtime;
    }

    public void setDdProductAddtime(Date ddProductAddtime) {
        this.ddProductAddtime = ddProductAddtime;
    }

    public String getDdProductRecommend() {
        return ddProductRecommend;
    }

    public void setDdProductRecommend(String ddProductRecommend) {
        this.ddProductRecommend = ddProductRecommend;
    }

    public String getDdProductBrief() {
        return ddProductBrief;
    }

    public void setDdProductBrief(String ddProductBrief) {
        this.ddProductBrief = ddProductBrief;
    }

    public String getDdProductAuthorbrief() {
        return ddProductAuthorbrief;
    }

    public void setDdProductAuthorbrief(String ddProductAuthorbrief) {
        this.ddProductAuthorbrief = ddProductAuthorbrief;
    }

    public String getDdProductDirectory() {
        return ddProductDirectory;
    }

    public void setDdProductDirectory(String ddProductDirectory) {
        this.ddProductDirectory = ddProductDirectory;
    }

    public String getDdProductMediacomment() {
        return ddProductMediacomment;
    }

    public void setDdProductMediacomment(String ddProductMediacomment) {
        this.ddProductMediacomment = ddProductMediacomment;
    }

    public String getDdProductExcerpt() {
        return ddProductExcerpt;
    }

    public void setDdProductExcerpt(String ddProductExcerpt) {
        this.ddProductExcerpt = ddProductExcerpt;
    }

    public int getDdCategory2Id() {
        return ddCategory2Id;
    }

    public void setDdCategory2Id(int ddCategory2Id) {
        this.ddCategory2Id = ddCategory2Id;
    }

    public Date getDdProductCreateDate() {
        return ddProductCreateDate;
    }

    public void setDdProductCreateDate(Date ddProductCreateDate) {
        this.ddProductCreateDate = ddProductCreateDate;
    }

	@Override
	public String toString() {
		return "DangDangProduct [ddProductId=" + ddProductId + ", ddProductName=" + ddProductName + ", ddProductAuthor="
				+ ddProductAuthor + ", ddProductImg=" + ddProductImg + ", ddProductPress=" + ddProductPress
				+ ", ddProductPresstime=" + ddProductPresstime + ", ddProductEdition=" + ddProductEdition
				+ ", ddProductPrinttime=" + ddProductPrinttime + ", ddProductPrintcount=" + ddProductPrintcount
				+ ", ddProductIsbn=" + ddProductIsbn + ", ddProductWordcount=" + ddProductWordcount
				+ ", ddProductPagecount=" + ddProductPagecount + ", ddProductFormat=" + ddProductFormat
				+ ", ddProductPaper=" + ddProductPaper + ", ddProductPack=" + ddProductPack + ", ddProductPrice="
				+ ddProductPrice + ", ddProductDdprice=" + ddProductDdprice + ", ddProductCount=" + ddProductCount
				+ ", ddProductAddtime=" + ddProductAddtime + ", ddProductRecommend=" + ddProductRecommend
				+ ", ddProductBrief=" + ddProductBrief + ", ddProductAuthorbrief=" + ddProductAuthorbrief
				+ ", ddProductDirectory=" + ddProductDirectory + ", ddProductMediacomment=" + ddProductMediacomment
				+ ", ddProductExcerpt=" + ddProductExcerpt + ", ddCategory2Id=" + ddCategory2Id
				+ ", ddProductCreateDate=" + ddProductCreateDate + "]";
	}
    
}