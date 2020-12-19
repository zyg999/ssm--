package org.zyg.domain;

import javax.validation.constraints.NotBlank;

public class Book {
    private int id;
    @NotBlank(message = "图书名不允许为空")
    private String title;
    @NotBlank(message = "作者名不允许为空")
    private String author;
    private Double price;
    public Book() {

    }

    public Book(int id, @NotBlank(message = "图书名不允许为空") String title, @NotBlank(message = "图书名不允许为空") String author, Double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
