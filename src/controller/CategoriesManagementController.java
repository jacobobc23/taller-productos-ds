package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connection.BDConnection;
import exceptions.ProductCategoryException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Category;
import model.Product;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author Jacobo-bc
 */
public class CategoriesManagementController {

    private final BDConnection conn;
    private final Connection con;

    public CategoriesManagementController() {
        conn = new BDConnection();
        con = conn.getConnection();
    }

    public ArrayList<Category> listCategories() {
        ArrayList<Category> categories = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM categorias";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("nombreCategoria");

                Category category = new Category(id, name);
                categories.add(category);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return categories;
    }

    public Category searchCategory(String name) {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM categorias WHERE nombreCategoria = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id = getIdCategoryByName(name);
                Category category = new Category(id, name);

                return category;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    public void addCategory(Category category) throws SQLException {
        try {
            PreparedStatement ps;

            String query = "INSERT INTO categorias (id, nombreCategoria) VALUES (?, ?)";

            ps = con.prepareStatement(query);

            ps.setInt(1, category.getId());
            ps.setString(2, category.getCategoryName());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            throw new SQLException();
        }
    }

    public void updateCategory(Category category) throws SQLException {
        try {
            PreparedStatement ps;

            String query = "UPDATE categorias SET nombreCategoria = ? WHERE id = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, category.getCategoryName());
            ps.setInt(2, category.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            throw new SQLException();
        }
    }

    public void deleteCategory(int id) {
        ArrayList<Product> products = getProducts();
        
        for (Product product : products) {
            if (product.getCategory().getId() == id) {
                throw new ProductCategoryException();
            }
        }
        
        try {
            PreparedStatement ps;

            String query = "DELETE FROM categorias WHERE id = ?";

            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    private int getIdCategoryByName(String name) {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT id FROM categorias WHERE nombreCategoria = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return -1;
    }

    private ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM productos";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String code = rs.getString("codigo");
                String name = rs.getString("nombre");
                String distribuidor = rs.getString("distribuidor");
                double price = rs.getDouble("precio");
                int categoryId = rs.getInt("id_categoria");

                String categoryName = getCategoryNameById(categoryId);
                Category category = new Category(categoryId, categoryName);

                Product product = new Product(code, name, distribuidor, category, price);
                products.add(product);

            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return products;
    }

    private String getCategoryNameById(int categoryId) {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT nombreCategoria FROM categorias WHERE id = ?";

            ps = con.prepareStatement(query);
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("nombreCategoria");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return "Categoría no encontrada";
    }
}
