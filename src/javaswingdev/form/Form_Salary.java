/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaswingdev.form;
import java.time.LocalDate;
import javaswingdev.main.Dashboard;
import javaswingdev.main.*;
import javaswingdev.swing.table.ProductEventAction;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.Date;
import model.*;

public class Form_Salary extends javax.swing.JPanel {

    private DefaultTableModel model;
    private TableRowSorter<TableModel> rowSorter;
    /**
     * Creates new form Form_Shift
     */
    public Form_Salary() {
        initComponents();
        table.fixTable(jScrollPane1);
        initTable(LocalDate.now().getMonthValue());
        SortFilter();

    }
    private void initTable(int month) {
     table.fixTable(jScrollPane1);
     for(Staff s: Dashboard.store.getStaffList()){
         table.addRow(s.toRowSalaryTable(month, LocalDate.now().getYear()));
     }
  }
    
    
     private void SortFilter(){
      rowSorter = new TableRowSorter<>(table.getModel());
      table.setRowSorter(rowSorter);
      searchField.getDocument().addDocumentListener(new DocumentListener(){
      @Override 
      public void insertUpdate(DocumentEvent e){
           String text = searchField.getText();
           if(text.trim().length()==0){
               rowSorter.setRowFilter(null);
           }
           else{
               rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
               
           }
       }
      @Override
      public void removeUpdate(DocumentEvent e){
          String text= searchField.getText();
          if(text.trim().length()==0){
              rowSorter.setRowFilter(null);
              
          }else
          {
              rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text));
          }
      }
         @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); 
            }
            
    });
              
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
        searchField = new swing.TextFieldAnimation();
        inputMonth = new javaswingdev.swing.Combobox();

        setBackground(new java.awt.Color(243, 243, 243));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Name", "Rate", "WorkedHour", "Sum"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Float.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(25);
            table.getColumnModel().getColumn(0).setPreferredWidth(25);
            table.getColumnModel().getColumn(0).setMaxWidth(25);
            table.getColumnModel().getColumn(2).setMinWidth(55);
            table.getColumnModel().getColumn(2).setPreferredWidth(55);
            table.getColumnModel().getColumn(2).setMaxWidth(55);
        }

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        searchField.setForeground(new java.awt.Color(153, 153, 153));
        searchField.setAnimationColor(new java.awt.Color(87, 97, 174));
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFieldFocusGained(evt);
            }
        });
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        inputMonth.setMaximumRowCount(12);
        inputMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        inputMonth.setSelectedIndex(-1);
        inputMonth.setLabeText("Select Month");
        inputMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMonthActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(inputMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldFocusGained

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
            String text = searchField.getText();
       if (text.trim().length() == 0) {
            rowSorter.setRowFilter(null);
       } else {
             rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
       }           // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void inputMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMonthActionPerformed
        // TODO add your handling code here:
        System.out.println(Integer.parseInt(inputMonth.getSelectedItem().toString()));
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        initTable(Integer.parseInt(inputMonth.getSelectedItem().toString()));
    }//GEN-LAST:event_inputMonthActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaswingdev.swing.Combobox inputMonth;
    private javax.swing.JScrollPane jScrollPane1;
    private javaswingdev.swing.RoundPanel roundPanel1;
    private swing.TextFieldAnimation searchField;
    private javaswingdev.swing.table.Table table;
    // End of variables declaration//GEN-END:variables
}