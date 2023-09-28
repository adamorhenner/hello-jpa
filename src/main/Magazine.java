package main;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Magazine {
    @Id
    @GeneratedValue
    private Long id;
    private String isbn;
    private String title;
    private Double price;
    private Integer copiesSold;

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Company publisher;

    @ManyToOne
    private Article coverArticle;

    @OneToMany
    private List<Article> articles = new ArrayList<>();

    public Magazine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(Integer copiesSold) {
        this.copiesSold = copiesSold;
    }

    public Article getCoverArticle() {
        return coverArticle;
    }

    public void setCoverArticle(Article coverArticle) {
        this.coverArticle = coverArticle;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
