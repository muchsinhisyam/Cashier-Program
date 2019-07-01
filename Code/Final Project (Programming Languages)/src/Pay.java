import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Pay extends javax.swing.JFrame {
    // ParentController
    Main parentController;
    // Variables for Pay class
    String table_no, table_database;
    
    // Constructor for Pay class
    public Pay() {
        initComponents();
        // Call setTableSize() to set the column size of the jTable
        setTableSize();
    }
    
    // Constructor with parameters for Pay class
    public Pay(int total_price, String table_no, String table_database, Main temp){
        initComponents();
        // Store table number from Main class to Pay class
        this.table_no = table_no;
        // Set table number to table_label
        table_label.setText(table_no);
        // Set total price to total_label
        total_label.setText(String.valueOf(total_price));
        // Store table data from Main class to Pay class
        this.table_database = table_database;
        this.parentController = temp;
        // Call readData() function to refresh the jTable
        readData();
    }
    
    // Function for set the column size of the jTable
    public void setTableSize(){
        table_bill.getColumnModel().getColumn(0).setPreferredWidth(80);
        table_bill.getColumnModel().getColumn(1).setPreferredWidth(20);
        table_bill.getColumnModel().getColumn(2).setPreferredWidth(10);
        table_bill.getColumnModel().getColumn(3).setPreferredWidth(20);
        table_bill.getColumnModel().getColumn(4).setPreferredWidth(30);
    }
    
    // Function for read data from database
    public void readData(){
        String column[] = {"Items","Type","Qty","Price","Total Price"};
        DefaultTableModel dtm = new DefaultTableModel(null, column); 
        // SQL syntax for get data from database
        String sql = "SELECT * FROM %s";
        sql = String.format(sql, table_database);
        ResultSet rs = Database.executeQuery(sql); 
        try {
            while(rs.next()){
                // Get data from table column by index starts from no 1
                String items = rs.getString(1);
                String type = rs.getString(2);
                String qty = rs.getString(3);
                String price = rs.getString(4);
                String total_price = rs.getString(5);
                String data[] = {items,type,qty,price,total_price};
                // Adding the data to dtm variable
                dtm.addRow(data);
            }
        // Exception or error handling
        }catch (SQLException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        table_bill.setModel(dtm);
        // Call setTableSize() to set the column size of the jTable
        setTableSize();
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pay_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cancel_button = new javax.swing.JButton();
        pay_button1 = new javax.swing.JButton();
        total_label = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pay_text = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        change_label = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        paid_label = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        table_label = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_bill = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(805, 525));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(490, 242));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photo.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 20, 280, 130);

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel5.setLayout(null);

        pay_button.setBackground(new java.awt.Color(255, 255, 255));
        pay_button.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        pay_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cash.png"))); // NOI18N
        pay_button.setText("Pay with Cash");
        pay_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_buttonActionPerformed(evt);
            }
        });
        jPanel5.add(pay_button);
        pay_button.setBounds(150, 360, 220, 40);

        jLabel3.setFont(new java.awt.Font("Garamond", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Rp.");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(60, 30, 90, 60);

        cancel_button.setBackground(new java.awt.Color(255, 255, 255));
        cancel_button.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        cancel_button.setText("Cancel");
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });
        jPanel5.add(cancel_button);
        cancel_button.setBounds(10, 360, 77, 90);

        pay_button1.setBackground(new java.awt.Color(255, 255, 255));
        pay_button1.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        pay_button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/debit.png"))); // NOI18N
        pay_button1.setText("Pay with Debit Card");
        pay_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_button1ActionPerformed(evt);
            }
        });
        jPanel5.add(pay_button1);
        pay_button1.setBounds(150, 410, 220, 40);

        total_label.setFont(new java.awt.Font("Garamond", 1, 48)); // NOI18N
        total_label.setForeground(new java.awt.Color(255, 255, 255));
        total_label.setText("0");
        jPanel5.add(total_label);
        total_label.setBounds(140, 30, 230, 60);

        jLabel4.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cash (IDR)");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(30, 150, 90, 30);

        pay_text.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        pay_text.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pay_text.setText("0");
        pay_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_textActionPerformed(evt);
            }
        });
        jPanel5.add(pay_text);
        pay_text.setBounds(140, 150, 220, 30);

        jLabel2.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Change");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(30, 230, 90, 30);

        change_label.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        change_label.setForeground(new java.awt.Color(255, 255, 255));
        change_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        change_label.setText("0");
        jPanel5.add(change_label);
        change_label.setBounds(140, 230, 220, 30);

        jLabel6.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Paid");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(30, 190, 90, 30);

        paid_label.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        paid_label.setForeground(new java.awt.Color(255, 255, 255));
        paid_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        paid_label.setText("0");
        jPanel5.add(paid_label);
        paid_label.setBounds(140, 190, 220, 30);

        jLabel5.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Table");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(30, 110, 90, 30);

        table_label.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        table_label.setForeground(new java.awt.Color(255, 255, 255));
        table_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        table_label.setText("0");
        jPanel5.add(table_label);
        table_label.setBounds(140, 110, 220, 30);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(400, 20, 380, 460);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel7.setLayout(null);

        table_bill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Items", "Type", "Qty", "Price", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_bill.setEnabled(false);
        jScrollPane1.setViewportView(table_bill);

        jScrollPane2.setViewportView(jScrollPane1);

        jPanel7.add(jScrollPane2);
        jScrollPane2.setBounds(10, 10, 360, 300);

        jPanel1.add(jPanel7);
        jPanel7.setBounds(10, 160, 380, 320);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 790, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        // Hide this window
        this.setVisible(false);
    }//GEN-LAST:event_cancel_buttonActionPerformed

    private void pay_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_buttonActionPerformed
        // Make total variable and store the total price value
        int total = Integer.parseInt(total_label.getText());
        // Make pay variable and store the pay value
        int pay = Integer.parseInt(pay_text.getText());
        // Make change variable
        int change = 0;
        // If total is greater or same than pay, execute payment process
        if(total <= pay){
            change = pay - total;
            // Set change value to change_label, and make it to string
            change_label.setText(String.valueOf(change));
            // Print success message
            JOptionPane.showMessageDialog(this, "Payment Success! \nChange : " + change, "Payment Success", JOptionPane.INFORMATION_MESSAGE);
            // Code for print the bill
            MessageFormat header = new MessageFormat("Bill Report");
            MessageFormat footer = new MessageFormat("Page {0,number,integer}");
            try {
                table_bill.print(JTable.PrintMode.NORMAL, header, footer);
            } catch (PrinterException ex) {
                Logger.getLogger(Pay.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Hide this window
            this.setVisible(false);
            // Execute deleteAll() to delete all data from a table
            Database.deleteAll(table_database);
            // Call readData() function to refresh the jTable
            readData();
            parentController.readData();
        // If total is lower than pay
        } else{
            // Print error message
            JOptionPane.showMessageDialog(this, "Payment Failed, Money not enough!", "Payment Failed", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pay_buttonActionPerformed

    private void pay_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_button1ActionPerformed
        // Make pay variable and store the pay value
        int pay = Integer.parseInt(pay_text.getText());
        // Make total variable and store the total price value
        int total = pay;
        // Make change variable and set the value
        int change = pay - total;
        // Set change value to change_label, and make it to string
        change_label.setText(String.valueOf(change));
        // Print success message
        JOptionPane.showMessageDialog(this, "Payment Success! \nPayment using debit card.", "Payment Success", JOptionPane.INFORMATION_MESSAGE);
        // Code for print the bill
        MessageFormat header = new MessageFormat("Bill Report");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            table_bill.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(Pay.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Hide this window
        this.setVisible(false);
        // Execute deleteAll() to delete all data from a table
        Database.deleteAll(table_database);
        // Call readData() function to refresh the jTable
        readData();
        parentController.readData();
    }//GEN-LAST:event_pay_button1ActionPerformed

    private void pay_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pay_textActionPerformed

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
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pay().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_button;
    private javax.swing.JLabel change_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel paid_label;
    private javax.swing.JButton pay_button;
    private javax.swing.JButton pay_button1;
    private javax.swing.JTextField pay_text;
    private javax.swing.JTable table_bill;
    private javax.swing.JLabel table_label;
    private javax.swing.JLabel total_label;
    // End of variables declaration//GEN-END:variables
}
