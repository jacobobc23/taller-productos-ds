package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Category;
import model.Product;
import org.mariadb.jdbc.Connection;
import singleton.Singleton;

/**
 * Esta clase maneja la gestión de los productos, tiene los métodos para listar
 * todos los productos y buscarlos por su código.
 *
 * @author Jacobo-bc
 */
public class ProductsManagementController {

    private final Connection con;

    public ProductsManagementController() {
        con = Singleton.getINSTANCE().getConnection();
    }

    public ArrayList<Product> listProducts() {
        ArrayList<Product> products = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT productos.codigo, productos.nombre, productos.distribuidor, productos.precio, productos.id_categoria,"
                    + " categorias.nombreCategoria FROM productos JOIN categorias ON productos.id_categoria = categorias.id";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String code = rs.getString("codigo");
                String name = rs.getString("nombre");
                String distribuidor = rs.getString("distribuidor");
                double price = rs.getDouble("precio");
                int categoryId = rs.getInt("id_categoria");
                String categoryName = rs.getString("nombreCategoria");

                Category category = new Category(categoryId, categoryName);

                Product product = new Product(code, name, distribuidor, category, price);
                products.add(product);

            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return products;
    }

    /**
     * Devuelve un arrayList con todas las categorias disponibles.
     *
     * @return
     */
    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> categories = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM categorias";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String categoryName = rs.getString("nombreCategoria");
                Category category = new Category(id, categoryName);
                categories.add(category);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return categories;
    }

    /**
     * Devuelve un resultset que coincida con el código del producto
     *
     * @param code El código del producto que se está buscando
     * @return Un resultset que tiene la información del producto buscado. Si el
     * código es vacío, se devuelven todos los productos.
     */
    public Product searchProduct(String code) {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT productos.codigo, productos.nombre, productos.distribuidor, productos.precio, productos.id_categoria,"
                    + " categorias.nombreCategoria FROM productos JOIN categorias ON productos.id_categoria = categorias.id WHERE productos.codigo = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, code);
            rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("nombre");
                String distribuidor = rs.getString("distribuidor");
                double price = rs.getDouble("precio");
                int categoryId = rs.getInt("id_categoria");
                String categoryName = rs.getString("nombreCategoria");

                Category category = new Category(categoryId, categoryName);

                Product product = new Product(code, name, distribuidor, category, price);

                return product;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    public ArrayList<Product> searchProductByCategory(int id) {
        ArrayList<Product> products = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT productos.codigo, productos.nombre, productos.distribuidor, productos.precio, categorias.nombreCategoria"
                    + " FROM productos JOIN categorias ON productos.id_categoria = categorias.id WHERE productos.id_categoria = ?";

            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                String code = rs.getString("codigo");
                String name = rs.getString("nombre");
                String distribuidor = rs.getString("distribuidor");
                double price = rs.getDouble("precio");
                String categoryName = rs.getString("nombreCategoria");

                Category category = new Category(id, categoryName);

                Product product = new Product(code, name, distribuidor, category, price);
                products.add(product);

            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return products;
    }

    /**
     * Agrega un nuevo producto
     *
     * @param product
     * @throws java.sql.SQLException
     */
    public void addProduct(Product product) throws SQLException {
        try {
            PreparedStatement ps;

            String query = "INSERT INTO productos (codigo, nombre, distribuidor, precio, id_categoria) VALUES (?, ?, ?, ?, ?)";

            ps = con.prepareStatement(query);

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

    /**
     * Actualiza un producto de la base de datos.
     *
     * @param product
     * @return true si se editó, false en caso contrario.
     */
    public boolean updateProduct(Product product) {
        try {
            PreparedStatement ps;

            String query = "UPDATE productos SET precio = ? WHERE codigo = ?";

            ps = con.prepareStatement(query);
            ps.setDouble(1, product.getPrice());
            ps.setString(2, product.getCode());

            int rowsUpdated = ps.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return false;
        }
    }

    /**
     * Elimina un producto de la base de datos
     *
     * @param code El código del producto que se desea eliminar
     * @return true si se pudo eliminar, false en caso contrario
     */
    public boolean deleteProduct(String code) {
        try {
            PreparedStatement ps;

            String query = "DELETE FROM productos WHERE codigo = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, code);

            int rowDeleted = ps.executeUpdate();

            return rowDeleted > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return false;
        }
    }
}
