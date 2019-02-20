package com.example.secondTutorialSBEntity.Model;

import javax.persistence.*;

/**

 1

 */
@Entity // if you did not give spesific name jpa gets class name to give table name
public class Product {

    @Id
    @SequenceGenerator(name = "product_id", sequenceName = "product_SQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id")
    private Integer id;

    //@Column(name = "name", nullable = false) --> given a spesific name
    private String name;

    private String category;

    private String description;

    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
