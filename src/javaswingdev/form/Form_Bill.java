package javaswingdev.form;
import javaswingdev.main.Dashboard;
import javaswingdev.main.*;
import javaswingdev.swing.table.BillEventAction;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.*;

public class Form_Bill extends javax.swing.JPanel {

    /**
     * Creates new form Form_Shift
     */
    private DefaultTableModel model;
    private TableRowSorter<TableModel> rowSorter;
    
    public Form_Bill() {
        initComponents();
        table.fixTable(jScrollPane1);
        initTable();
        SortFilter();
    }
    
    private Bill showUpdateForm(Bill bill){
        Billing billForm = new Billing(Dashboard.getFrames()[0], true);
        billForm.setOk(true);
        System.out.println(bill.getTotalCost());
        billForm.setBill(bill);
        billForm.showBillInfo(bill);
        return billForm.getBill();
    }
    
    private void initTable() {
     billEventAction = new BillEventAction() {
         @Override
         public void delete(Bill bill) {
//             System.out.println(product);
             Message msg=new Message();
             if(msg.showMessage("Delete Bill?")){
                 Dashboard.store.deleteBill(bill.getBillId());
                 model =(DefaultTableModel) table.getModel();
                 model.removeRow(table.getSelectedRow());
                 msg.showDialog("Delete Product Id " + bill.getBillId()+" Successfully!","red");
             }else {
                    System.out.println("User click Cancel");
                }
         }

         @Override
         public void update(Bill bill) {
             Bill b = showUpdateForm(bill);
             System.out.println(bill.getOrderList().get(0).getProduct().getProductName());
             if(b != null){
//               update table row
                 model =(DefaultTableModel) table.getModel();
                model.setValueAt(b.getBillId(),table.getSelectedRow() , 0);
                model.setValueAt(b.getDate(),table.getSelectedRow() , 1);
                model.setValueAt(b.getStaff().getName(),table.getSelectedRow() , 2);
                model.setValueAt(b.getTotalCost(),table.getSelectedRow() , 3);
             }
             
         }
     };

     table.fixTable(jScrollPane1);
     for(Bill b: Dashboard.store.getBillList()){
         table.addRow(b.toRowTable(billEventAction));
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
        searchField = new swing.TextFieldAnimation();
        addBillBtn = new javaswingdev.swing.Button();

        setBackground(new java.awt.Color(243, 243, 243));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#I", "Date", "Staff", "Total", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(25);
            table.getColumnModel().getColumn(3).setResizable(false);
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

        searchField.setForeground(new java.awt.Color(153, 153, 153));
        searchField.setAnimationColor(new java.awt.Color(87, 97, 174));
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFieldFocusGained(evt);
            }
        });

        addBillBtn.setBackground(new java.awt.Color(87, 97, 174));
        addBillBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBillBtn.setText("ADD ");
        addBillBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBillBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addBillBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBillBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBillBtnActionPerformed(java.awt.event.ActionEvent evt) {        
        Billing billForm = new Billing(Dashboard.getFrames()[0], true);
        billForm.setVisible(true);
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
    
    private void searchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusGained
        String text = searchField.getText();
       if (text.trim().length() == 0) {
            rowSorter.setRowFilter(null);
       } else {
             rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
       }  
    }//GEN-LAST:event_searchFieldFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaswingdev.swing.Button addBillBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javaswingdev.swing.RoundPanel roundPanel1;
    private swing.TextFieldAnimation searchField;
    private javaswingdev.swing.table.Table table;
    // End of variables declaration//GEN-END:variables

    private BillEventAction billEventAction;
}
