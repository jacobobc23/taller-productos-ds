package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Category;
import model.Product;
import org.mariadb.jdbc.Connection;
import db.DBConnection;

/**
 *
 * @author jacobobc
 */
public class ProductsController {

    private final Connection con;

    public ProductsController() {
        con = DBConnection.getINSTANCE().getConnection();
    }

    public ArrayList<Product> listAllProducts() {
        ArrayList<Product> products = new ArrayList<>();

        String sql = "SELECT p.code, p.name, p.distributor, p.price, p.category_id,"
                + " c.name AS category_name FROM products p JOIN categories c ON p.category_id = c.id";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                String distributor = rs.getString("distributor");
                double price = rs.getDouble("price");
                int categoryId = rs.getInt("category_id");
                String categoryName = rs.getString("category_name");

                Category category = new Category(categoryId, categoryName);

                Product product = new Product(code, name, distributor, category, price);
                products.add(product);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return products;
    }

    public ArrayList<Category> listAllCategories() {
        ArrayList<Category> categories = new ArrayList<>();

        String sql = "SELECT * FROM categories";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String categoryName = rs.getString("name");

                Category category = new Category(id, categoryName);
                categories.add(category);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return categories;
    }

    public Product selectProduct(String code) {
        String sql = "SELECT p.code, p.name, p.distributor, p.price, p.category_id,"
                + " c.name AS category_name FROM products p JOIN categories c ON p.category_id = c.id WHERE p.code = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String distributor = rs.getString("distributor");
                double price = rs.getDouble("price");
                int categoryId = rs.getInt("category_id");
                String categoryName = rs.getString("category_name");

                Category category = new Category(categoryId, categoryName);

                return new Product(code, name, distributor, category, price);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    public ArrayList<Product> listProductsByCategory(int categoryId) {
        ArrayList<Product> products = new ArrayList<>();

        String sql = "SELECT p.code, p.name, p.distributor, p.price, c.name AS category_name"
                + " FROM products p JOIN categories c ON p.category_id = c.id WHERE p.category_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                String distributor = rs.getString("distributor");
                double price = rs.getDouble("price");
                String categoryName = rs.getString("category_name");

                Category category = new Category(categoryId, categoryName);
                Product product = new Product(code, name, distributor, category, price);
                products.add(product);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return products;
    }

    public void addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO products (code, name, distributor, price, category_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDistributor());
            ps.setDouble(4, product.getPrice());
            ps.setInt(5, product.getCategory().getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
            throw new SQLException();
        }
    }

    public boolean updateProduct(Product product) {
        String sql = "UPDATE products SET price = ? WHERE code = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, product.getPrice());
            ps.setString(2, product.getCode());

            int rowsUpdated = ps.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return false;
        }
    }

    public boolean deleteProduct(String code) {
        String sql = "DELETE FROM products WHERE code = ?";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, code);
            int rowDeleted = ps.executeUpdate();

            return rowDeleted > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return false;
        }
    }
}
