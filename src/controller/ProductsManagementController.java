package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.BDConnection;
import model.Product;
import org.mariadb.jdbc.Connection;

/**
 * Esta clase maneja la gestión de los productos, tiene los métodos para listar
 * todos los productos y buscarlos por su código.
 *
 * @author Jacobo-bc
 */
public class ProductsManagementController {

    private final BDConnection conn;
    private final Connection con;

    public ProductsManagementController() {
        conn = new BDConnection();
        con = conn.getConnection();
    }

    /**
     * Devuelve un resultset que contiene todos los productos de la bd
     *
     * @return Un resulset que tiene la información de todos los productos
     */
    public ResultSet listProducts() {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM productos";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            return rs;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    /**
     * Devuelve un resultset que coincida con el código del producto
     *
     * @param code El código del producto que se está buscando
     * @return Un resultset que tiene la información del producto buscado. Si el
     * código es vacío, se devuelven todos los productos.
     */
    public ResultSet searchProduct(String code) {
        String where = "";

        if (!"".equals(code)) {
            where = "WHERE codigo = '" + code + "'";
        }

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM productos " + where;

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            return rs;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    /**
     * Agrega un nuevo producto
     *
     * @param product
     * @return true si se pudo agregar, false en caso contrario
     */
    public boolean addProduct(Product product) {
        try {
            PreparedStatement ps;

            String query = "INSERT INTO productos (codigo, nombre, distribuidor, categoria, precio) VALUES (?, ?, ?, ?, ?)";

            ps = con.prepareStatement(query);

            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDistributor());
            ps.setString(4, product.getCategory());
            ps.setDouble(5, product.getPrice());

            int rowInserted = ps.executeUpdate();

            return rowInserted > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return false;
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

            String query = "UPDATE productos SET nombre = ?, distribuidor = ?, categoria = ?, precio = ? WHERE codigo = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDistributor());
            ps.setString(3, product.getCategory());
            ps.setDouble(4, product.getPrice());
            ps.setString(5, product.getCode());

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
