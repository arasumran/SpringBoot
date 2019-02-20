package com.umran.springtutor.springApi;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@JsonRootName(value ="cycle")
//@XmlRootElement
public class CycleDecs {

    private int id;
    private String model;
    private String name;
    private String Category;
    private String Type;
    private int CreatedYear;

    public CycleDecs() {
    }

    public CycleDecs(int id, String model, String name, String category, String type, int createdYear) {
        this.id = id;
        this.model = model;
        this.name = name;
        Category = category;
        Type = type;
        this.CreatedYear = createdYear;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getCreatedYear() {
        return CreatedYear;
    }

    public void setCreatedYear(int createdYear) {
        CreatedYear = createdYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
