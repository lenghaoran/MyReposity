/**
 * @Title: Book.java 
 * @Package com.clps.sms.utils.poiUtils.model 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Leng Haoran   
 * @date 2017年8月14日 下午10:35:48 
 * @version V1.0  
 */
package com.clps.sms.utils.poi.model;

/**
 * @ClassName: Book 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Leng Haoran
 * @date 2017年8月14日 下午10:35:48 
 *  
 */
public class Book {
	private int bookId;  
    private String name;  
    private String author;  
    private float price;  
    private String isbn;  
    private String pubName;  
    private byte[] preface;
    
    public Book()  
    {  
    }  
  
    public Book(int bookId, String name, String author, float price,  
            String isbn, String pubName, byte[] preface)  
    {  
        this.bookId = bookId;  
        this.name = name;  
        this.author = author;  
        this.price = price;  
        this.isbn = isbn;  
        this.pubName = pubName;  
        this.preface = preface;  
    }

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPubName() {
		return pubName;
	}

	public void setPubName(String pubName) {
		this.pubName = pubName;
	}

	public byte[] getPreface() {
		return preface;
	}

	public void setPreface(byte[] preface) {
		this.preface = preface;
	} 
    
}
