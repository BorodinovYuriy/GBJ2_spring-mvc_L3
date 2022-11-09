package ru.adt.springmvc.models;

public class Product {

    private int id;

    private String title;
    private int cost;
    public Product(){}
    public Product(int id,String title, int cost) {
        this.id = id;
        this.cost = cost;
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getFormatId() {
        return Integer.toString(getId()) + ").  ";
    }
    public String getFormatCost() {
        return ("- " + Integer.toString(getCost()) + "$.");
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }

}
