package com.gxy.entity;

import java.util.Date;

public class Cart {
    private int bookId;

    private String bookName;

    private String bookImg;

    private int bookPrice;

    private int bookDdprice;

    private int bookCount;

    private Date bookCreateDate;

    
    public Cart() {
		super();
	}

	public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookDdprice() {
        return bookDdprice;
    }

    public void setBookDdprice(int bookDdprice) {
        this.bookDdprice = bookDdprice;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public Date getBookCreateDate() {
        return bookCreateDate;
    }

    public void setBookCreateDate(Date bookCreateDate) {
        this.bookCreateDate = bookCreateDate;
    }

	@Override
	public String toString() {
		return "Cart [bookId=" + bookId + ", bookName=" + bookName + ", bookImg=" + bookImg + ", bookPrice=" + bookPrice
				+ ", bookDdprice=" + bookDdprice + ", bookCount=" + bookCount + ", bookCreateDate=" + bookCreateDate
				+ "]";
	}
}