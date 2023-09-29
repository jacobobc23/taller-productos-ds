package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import exceptions.ProductCategoryException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Category;
import org.mariadb.jdbc.Connection;
import singleton.Singleton;

/**
 *
 * @author Jacobo-bc
 */
public class CategoriesManagementController {

    private final Connection con;

    public CategoriesManagementController() {
        con = Singleton.getINSTANCE().getConnection();
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

            String query = "SELECT id, nombreCategoria FROM categorias WHERE nombreCategoria = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String categoryName = rs.getString("nombreCategoria");

                Category category = new Category(id, categoryName);

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

    public void updateCategory(int id, String name) throws SQLException {
        try {
            PreparedStatement ps;

            String query = "UPDATE categorias SET nombreCategoria = ? WHERE id = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            throw new SQLException();
        }
    }

    public void deleteCategory(int id) {
        try {
            PreparedStatement ps;

            String query = "DELETE FROM categorias WHERE id = ? AND NOT EXISTS (SELECT 1 FROM productos WHERE id_categoria = ?)";

            ps = con.prepareStatement(query);
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
