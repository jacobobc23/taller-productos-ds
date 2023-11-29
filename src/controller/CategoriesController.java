package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import exceptions.ProductCategoryException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Category;
import org.mariadb.jdbc.Connection;
import db.DBConnection;

/**
 *
 * @author jacobobc
 */
public class CategoriesController {

    private final Connection con;

    public CategoriesController() {
        con = DBConnection.getINSTANCE().getConnection();
    }

    public ArrayList<Category> listAllCategories() {
        ArrayList<Category> categories = new ArrayList<>();

        String sql = "SELECT * FROM categories";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                Category category = new Category(id, name);
                categories.add(category);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return categories;
    }

    public Category selectCategory(String name) {
        String sql = "SELECT * FROM categories WHERE name = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");

                return new Category(id, name);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    public void insertCategory(Category category) throws SQLException {
        String sql = "INSERT INTO categories (id, name) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, category.getId());
            ps.setString(2, category.getName());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            throw new SQLException();
        }
    }

    public void updateCategory(int id, String name) throws SQLException {
        String sql = "UPDATE categories SET name = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            throw new SQLException();
        }
    }

    public void deleteCategory(int id) {
        String sql = "DELETE FROM categories WHERE id = ? AND NOT EXISTS (SELECT 1 FROM products WHERE category_id = ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setInt(2, id);

            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted == 0) {
                throw new ProductCategoryException();
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
}
