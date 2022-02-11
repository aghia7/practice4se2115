package repositories.products;

import db.DB;
import models.Product;
import models.User;

import java.sql.*;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final DB db;

    public ProductRepository(DB db) {
        this.db = db;
    }

    @Override
    public Product get(int id) {
        Product product = null;

        try {
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM products WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                product = new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return product;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public boolean create(Product product) {
        return false;
    }

    @Override
    public Product delete(int id) {
        return null;
    }

    @Override
    public List<Product> getAllByCategory(String category) {
        return null;
    }
}
