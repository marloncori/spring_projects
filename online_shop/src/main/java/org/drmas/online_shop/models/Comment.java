package org.drmas.online_shop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Lob
    @Column(length = 1000000)
    private String message;

    private String addedBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date addedAt;

    @JsonBackReference(value = "product")
    @ManyToOne
    private Product product;

    public Comment(){ super();}

    public Comment(String title, String message, String addedBy,
                   Date addedAt, Product product){

        this.title = title;
        this.message = message;
        this.addedBy = addedBy;
        this.addedAt = addedAt;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public Product getProduct() {
        return product;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
