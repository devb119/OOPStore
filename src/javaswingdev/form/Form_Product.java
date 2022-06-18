/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaswingdev.form;
import javaswingdev.main.Dashboard;
import javaswingdev.main.*;
import javaswingdev.swing.table.ProductEventAction;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.*;

public class Form_Product extends javax.swing.JPanel {

    private DefaultTableModel model;
    private TableRowSorter<TableModel> rowSorter;
    /**
     * Creates new form Form_Shift
     */
    public Form_Product() {
        initComponents();
        table.fixTable(jScrollPane1);
        initTable();
        
    }
    
    private Product showUpdateForm(Product product){
        if(product.getClass().toString().contains("Shirt")){
            ShirtInfo form = new ShirtInfo(Dashboard.getFrames()[0], true);
            form.setOk(true);
            Shirt shirt = (Shirt)product;
            form.setShirt(shirt);
            form.showInfo(shirt);
            return form.getShirt();
        }else if(product.getClass().toString().contains("Pant")){
            PantInfo form = new PantInfo(Dashboard.getFrames()[0], true);
            form.setOk(true);
            Pant pant = (Pant)product;
            form.showInfo(pant);
//            return form.getShirt();
        }else if(product.getClass().toString().contains("Shoes")){
            ShoesInfo form = new ShoesInfo(Dashboard.getFrames()[0], true);
            form.setOk(true);
            Shoes shoes = (Shoes)product;
            form.showInfo(shoes);
//            return form.getShirt();
        }
        return null;
    }
    
    private void initTable() {
     ProductEventAction productEventAction = new ProductEventAction() {
         @Override
         public void delete(Product product) {
             System.out.println(product);
         }

         @Override
         public void update(Product product) {
             Shirt shirt = (Shirt)showUpdateForm(product);
             if(shirt != null){
                 
                 
                 model =(DefaultTableModel) table.getModel();
                model.setValueAt(shirt.getProductId(),table.getSelectedRow() , 0);
                model.setValueAt(shirt.getProductName(),table.getSelectedRow() , 1);
                model.setValueAt(shirt.getProductPrice(),table.getSelectedRow() , 2);
                model.setValueAt(shirt.getBrand(),table.getSelectedRow() , 3);
                model.setValueAt(shirt.getCategory(),table.getSelectedRow() , 4);
                model.setValueAt(shirt.getDescription(),table.getSelectedRow() , 5);
                model.setValueAt(shirt.getQuantity(),table.getSelectedRow() , 6);
                
             }
         }
     };

     table.fixTable(jScrollPane1);
     for(Product p: Dashboard.store.getProductList()){
         table.addRow(p.toRowTable(productEventAction));
     }
  }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javaswingdev.swing.table.Table();
        textFieldAnimation1 = new swing.TextFieldAnimation();

        setBackground(new java.awt.Color(243, 243, 243));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Name", "Price", "Brand", "Category", "Description", "Quantity", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(25);
        }

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        textFieldAnimation1.setForeground(new java.awt.Color(153, 153, 153));
        textFieldAnimation1.setAnimationColor(new java.awt.Color(87, 97, 174));
        textFieldAnimation1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldAnimation1FocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(textFieldAnimation1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(textFieldAnimation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addProdBtnActionPerformed(java.awt.event.ActionEvent evt) {                                           
   
//        ModelStaff newStaff= new ModelStaff();
//        
//        showUpdateStaff(newStaff);
new ProductInfo(Dashboard.getFrames()[0], true).setVisible(true);
    }
    private void textFieldAnimation1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldAnimation1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldAnimation1FocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javaswingdev.swing.RoundPanel roundPanel1;
    private javaswingdev.swing.table.Table table;
    private swing.TextFieldAnimation textFieldAnimation1;
    // End of variables declaration//GEN-END:variables
}