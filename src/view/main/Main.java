package view.main;

import controller.ProductsManagementController;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Product;

/**
 * Interfaz gráfica principal para la gestión de productos, la cuál contiene
 * métodos para la visualización, búsqueda, actualización y eliminación de
 * productos.
 *
 * @author Jacobo-bc
 */
public class Main extends javax.swing.JFrame {

    private final ProductsManagementController controller;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setTitle("Inicio");
        controller = new ProductsManagementController();
        fillTable();
        setCbxCategory();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDistributor = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtCode = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        btnAddProduct = new javax.swing.JButton();
        btnUpdateProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        btnSearchProduct = new javax.swing.JButton();
        btnShowAllProducts = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        cbxCategory = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CÓDIGO:");

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE:");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DISTRIBUIDOR:");

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CATEGORÍA:");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PRECIO:");

        txtDistributor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDistributorKeyTyped(evt);
            }
        });

        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceKeyTyped(evt);
            }
        });

        btnAddProduct.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnAddProduct.setText("Registrar");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        btnUpdateProduct.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnUpdateProduct.setText("Editar");
        btnUpdateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProductActionPerformed(evt);
            }
        });

        btnDeleteProduct.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnDeleteProduct.setText("Eliminar");
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Distribuidor", "Categoría", "Precio"
            }
        ));
        productsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productsTable);

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CÓDIGO:");

        btnSearchProduct.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnSearchProduct.setText("Buscar");
        btnSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchProductActionPerformed(evt);
            }
        });

        btnShowAllProducts.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnShowAllProducts.setText("Ver todos");
        btnShowAllProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllProductsActionPerformed(evt);
            }
        });

        btnClean.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnClean.setText("Limpiar");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        cbxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        backgroundPanel.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(txtDistributor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(txtName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(txtCode, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(txtPrice, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(btnAddProduct, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(btnUpdateProduct, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(btnDeleteProduct, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(txtFilter, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(btnSearchProduct, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(btnShowAllProducts, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(btnClean, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundPanel.setLayer(cbxCategory, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnUpdateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtCode)
                    .addComponent(txtName)
                    .addComponent(txtDistributor)
                    .addComponent(txtPrice)
                    .addComponent(cbxCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnShowAllProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(126, 126, 126))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearchProduct)
                        .addComponent(btnShowAllProducts)
                        .addComponent(btnClean))
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddProduct)
                    .addComponent(btnUpdateProduct))
                .addGap(44, 44, 44)
                .addComponent(btnDeleteProduct)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Realiza una búsqueda en la bd con el código proporcionado, para así
     * actualizar la tabla y los campos de textos.
     *
     * @param evt
     */
    private void btnSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchProductActionPerformed
        String code = txtFilter.getText().trim();

        try {

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{
                "Código", "Nombre", "Distribuidor", "Categoría", "Precio"
            });

            productsTable.setModel(model);

            ResultSet rs = controller.searchProduct(code);
            ResultSetMetaData rsMd = rs.getMetaData();

            int cantidadColumnas = rsMd.getColumnCount();
            int anchos[] = {40, 100, 100, 100, 20};

            for (int i = 0; i < productsTable.getColumnCount(); i++) {
                productsTable.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {

                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                model.addRow(filas);

                txtCode.setText(rs.getString("codigo"));
                txtName.setText(rs.getString("nombre"));
                txtDistributor.setText(rs.getString("distribuidor"));
                cbxCategory.setSelectedItem((rs.getString("categoria")));
                txtPrice.setText(String.valueOf(rs.getDouble("precio")));

            }

            if (code.isEmpty()) {
                txtCode.setText("");
                txtName.setText("");
                txtDistributor.setText("");
                cbxCategory.setSelectedIndex(0);
                txtPrice.setText("");
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }//GEN-LAST:event_btnSearchProductActionPerformed

    private void btnShowAllProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllProductsActionPerformed
        fillTable();
        cleanFields();
    }//GEN-LAST:event_btnShowAllProductsActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        if (hasEmptyFields()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos");
            return;
        }

        String code = txtCode.getText().trim();
        String name = txtName.getText().trim();
        String distributor = txtDistributor.getText().trim();
        String category = cbxCategory.getSelectedItem().toString();
        double price = Double.parseDouble(txtPrice.getText());

        try {
            Product product = new Product(code, name, distributor, category, price);
            controller.addProduct(product);
            JOptionPane.showMessageDialog(null, "Producto guardado");
            fillTable();
            cleanFields();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar el producto");
        }
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnUpdateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProductActionPerformed
        String code = txtCode.getText().trim();
        String name = txtName.getText().trim();
        String distributor = txtDistributor.getText().trim();
        String category = cbxCategory.getSelectedItem().toString();
        double price = Double.parseDouble(txtPrice.getText());

        Product product = new Product(code, name, distributor, category, price);
        boolean success = controller.updateProduct(product);

        if (success) {
            fillTable();
            cleanFields();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el producto");
        }
    }//GEN-LAST:event_btnUpdateProductActionPerformed

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        String code = txtCode.getText().trim();

        boolean success = controller.deleteProduct(code);

        if (success) {
            fillTable();
            cleanFields();
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto");
        }
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void productsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productsTableMouseClicked
        int seleccion = productsTable.getSelectedRow();

        txtCode.setText(productsTable.getValueAt(seleccion, 0).toString());
        txtName.setText(productsTable.getValueAt(seleccion, 1).toString());
        txtDistributor.setText(productsTable.getValueAt(seleccion, 2).toString());
        cbxCategory.setSelectedItem(String.valueOf(productsTable.getValueAt(seleccion, 3)));
        txtPrice.setText(productsTable.getValueAt(seleccion, 4).toString());
    }//GEN-LAST:event_productsTableMouseClicked

    private void txtDistributorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDistributorKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDistributorKeyTyped

    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPriceKeyTyped

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        cleanTable();
        cleanFields();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void fillTable() {
        try {

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{
                "Código", "Nombre", "Distribuidor", "Categoría", "Precio"
            });

            productsTable.setModel(model);

            ResultSet rs = controller.listProducts();
            ResultSetMetaData rsMd = rs.getMetaData();

            int cantidadColumnas = rsMd.getColumnCount();
            int anchos[] = {40, 100, 100, 100, 20};

            for (int i = 0; i < productsTable.getColumnCount(); i++) {
                productsTable.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                model.addRow(filas);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    /**
     * Reestablece los valores de búsqueda y limpia los campos de texto.
     */
    private void cleanFields() {
        txtCode.setText("");
        txtName.setText("");
        txtDistributor.setText("");
        cbxCategory.setSelectedIndex(0);
        txtPrice.setText("");
        txtFilter.setText("");
    }

    private void cleanTable() {
        DefaultTableModel model = (DefaultTableModel) productsTable.getModel();
        model.setRowCount(0);
    }

    /**
     * Método para verificar si existen campos vacíos.
     *
     * @return true si hay campos sin llenar, false en caso contrario.
     */
    private boolean hasEmptyFields() {
        return (txtCode.getText().isEmpty() || txtName.getText().isEmpty() || txtDistributor.getText().isEmpty()
                || cbxCategory.getSelectedIndex() == 0 || txtPrice.getText().isEmpty());
    }

    private void setCbxCategory() {

        cbxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Zapatos", "Ropa", "Accesorios"
        }));
        cbxCategory.insertItemAt("Seleccione una opción", 0);
        cbxCategory.setSelectedIndex(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane backgroundPanel;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnSearchProduct;
    private javax.swing.JButton btnShowAllProducts;
    private javax.swing.JButton btnUpdateProduct;
    private javax.swing.JComboBox<String> cbxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productsTable;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtDistributor;
    private javax.swing.JTextField txtFilter;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
