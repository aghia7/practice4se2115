package controllers;

import models.Product;
import repositories.products.IProductRepository;

import java.util.List;

public class ProductController {
    private final IProductRepository productRepo;

    public ProductController(IProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public String getById(int id) {
        Product product = productRepo.get(id);

        if (product == null)
            return "Product with id = " + id + " does not exist!";

        return product.toString();
    }

    public String getAll() {
        List<Product> products = productRepo.getAll();

        if (products.isEmpty())
            return "Product`s list is empty";

        String resp = "";
        for (Product product : products)
            resp += product + "\n";

        return resp;
    }

    public String getAllByCategory(String category) {
        List<Product> products = productRepo.getAllByCategory(category);

        if (products.isEmpty())
            return "Product`s list is empty";

        String resp = "";
        for (Product product : products)
            resp += product + "\n";

        return resp;
    }

    public String create(String name, String category, double price) {
        Product product = Product.builder(name)
                .withCategory(category)
                .withPrice(price).build();

        boolean created = productRepo.create(product);
        if (created)
            return "A new product " + name + " was added!";

        return "A product cannot be created!";
    }

    public String deleteById(int id) {
        Product product = productRepo.delete(id);

        if (product != null) {
            return "A product " + product.getName() + " was removed!";
        }

        return "A product with id = " + id + " does not exist!";
    }
}
