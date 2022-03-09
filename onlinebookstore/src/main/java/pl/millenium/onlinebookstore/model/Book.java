package pl.millenium.onlinebookstore.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tbl_book")
@Getter
@Setter
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;

    private String name;

    private String description;

    @Column(name = "unit_price",  nullable = false)
    private Double unitPrice;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    private boolean active;

    @Column(name = "units_in_stock", nullable = false)
    private int unitsInStock;

    @Column(name = "data_created")
    private Date createdOn;

    @Column(name = "last_updated")
    private Date updatedOn;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private BookCategory bookCategory;
}
