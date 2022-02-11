package models;

public class Product {
    private int id;
    private String name;
    private String category;
    private double price;

    public Product() {}

    public Product(String name, String category, double price) {
        setName(name);
        setCategory(category);
        setPrice(price);
    }

    public Product(int id, String name, String category, double price) {
        this(name, category, price);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + category + " " + price;
    }
}
