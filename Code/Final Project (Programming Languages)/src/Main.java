import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {
    // Variables for Main class
    String table;
    String cashier;
    DefaultTableModel dtm;
    
    // Constructor of Main class
    public Main() {
        initComponents();
        // Call setTableSize() to set the column size of the jTable
        setTableSize();
    }
    
    // Constructor with parameters of Main class
    public Main(String username){
        initComponents();
        // Call setTableSize() to set the column size of the jTable
        setTableSize();
        // Get username from Login class
        this.cashier = username;
        cashier_label.setText(username);
    }
    
    // Function for get the total price from the bill
    public int getSum(){
        int rowcount = table_bill.getRowCount();
        int sum = 0;
        for(int i = 0; i < rowcount; i++){
            sum = sum + Integer.parseInt(table_bill.getValueAt(i, 4).toString());
        }
        return sum;
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
        // Using DefaultTableModel class to 
        DefaultTableModel dtm = new DefaultTableModel(null, column); 
        // SQL syntax for get data from database table
        String sql = "SELECT * FROM %s";
        sql = String.format(sql, table);
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
        } catch (SQLException ex){
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
        photo = new javax.swing.JLabel();
        panel_menu = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        table1_button = new javax.swing.JButton();
        table3_button = new javax.swing.JButton();
        table4_button = new javax.swing.JButton();
        table5_button = new javax.swing.JButton();
        table2_button = new javax.swing.JButton();
        table7_button = new javax.swing.JButton();
        table6_button = new javax.swing.JButton();
        table11_button = new javax.swing.JButton();
        table10_button = new javax.swing.JButton();
        table8_button = new javax.swing.JButton();
        table9_button = new javax.swing.JButton();
        table_panel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        table_panel1 = new javax.swing.JLabel();
        table_panel3 = new javax.swing.JLabel();
        table_panel4 = new javax.swing.JLabel();
        table_panel5 = new javax.swing.JLabel();
        fusilli_button = new javax.swing.JButton();
        spaghetti2_button = new javax.swing.JButton();
        friedrice_button = new javax.swing.JButton();
        spaghetti1_button = new javax.swing.JButton();
        sirloin_button = new javax.swing.JButton();
        wedges_button = new javax.swing.JButton();
        fries_button = new javax.swing.JButton();
        chickenwings1_button = new javax.swing.JButton();
        chickenwings2_button = new javax.swing.JButton();
        cupcake_button = new javax.swing.JButton();
        pudding_button = new javax.swing.JButton();
        cheesecake_button = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        table_panel2 = new javax.swing.JLabel();
        table_panel6 = new javax.swing.JLabel();
        table_panel7 = new javax.swing.JLabel();
        table_panel8 = new javax.swing.JLabel();
        milkshake1_button = new javax.swing.JButton();
        milkshake2_button = new javax.swing.JButton();
        milkshake3_button = new javax.swing.JButton();
        cookiescream_button = new javax.swing.JButton();
        juice1_button = new javax.swing.JButton();
        juice2_button = new javax.swing.JButton();
        juice3_button = new javax.swing.JButton();
        juice4_button = new javax.swing.JButton();
        cappuccino_button = new javax.swing.JButton();
        latte_button = new javax.swing.JButton();
        moccaccino_button = new javax.swing.JButton();
        espresso_button = new javax.swing.JButton();
        panel_bill = new javax.swing.JPanel();
        cashier_label = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_bill = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        table_label = new javax.swing.JLabel();
        panel_menu2 = new javax.swing.JPanel();
        pay_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        clear_button = new javax.swing.JButton();
        refresh_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1035, 720));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photo.jpg"))); // NOI18N
        jPanel1.add(photo);
        photo.setBounds(20, 20, 360, 150);

        panel_menu.setBackground(new java.awt.Color(0, 0, 0));
        panel_menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        panel_menu.setLayout(null);

        jPanel3.setLayout(null);

        table1_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        table1_button.setText("Table 1");
        table1_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table1_buttonActionPerformed(evt);
            }
        });
        jPanel3.add(table1_button);
        table1_button.setBounds(20, 110, 100, 70);

        table3_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        table3_button.setText("Table 3");
        table3_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table3_buttonActionPerformed(evt);
            }
        });
        jPanel3.add(table3_button);
        table3_button.setBounds(20, 290, 100, 70);

        table4_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        table4_button.setText("Table 4");
        table4_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table4_buttonActionPerformed(evt);
            }
        });
        jPanel3.add(table4_button);
        table4_button.setBounds(140, 110, 100, 70);

        table5_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        table5_button.setText("Table 5");
        table5_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table5_buttonActionPerformed(evt);
            }
        });
        jPanel3.add(table5_button);
        table5_button.setBounds(150, 420, 290, 70);

        table2_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        table2_button.setText("Table 2");
        table2_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table2_buttonActionPerformed(evt);
            }
        });
        jPanel3.add(table2_button);
        table2_button.setBounds(20, 200, 100, 70);

        table7_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        table7_button.setText("Table 7");
        table7_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table7_buttonActionPerformed(evt);
            }
        });
        jPanel3.add(table7_button);
        table7_button.setBounds(460, 110, 100, 70);

        table6_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        table6_button.setText("Table 6");
        table6_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table6_buttonActionPerformed(evt);
            }
        });
        jPanel3.add(table6_button);
        table6_button.setBounds(340, 110, 100, 70);

        table11_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        table11_button.setText("Table 11");
        table11_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table11_buttonActionPerformed(evt);
            }
        });
        jPanel3.add(table11_button);
        table11_button.setBounds(460, 290, 100, 70);

        table10_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        table10_button.setText("Table 10");
        table10_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table10_buttonActionPerformed(evt);
            }
        });
        jPanel3.add(table10_button);
        table10_button.setBounds(340, 290, 100, 70);

        table8_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        table8_button.setText("Table 8");
        table8_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table8_buttonActionPerformed(evt);
            }
        });
        jPanel3.add(table8_button);
        table8_button.setBounds(340, 200, 100, 70);

        table9_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        table9_button.setText("Table 9");
        table9_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table9_buttonActionPerformed(evt);
            }
        });
        jPanel3.add(table9_button);
        table9_button.setBounds(460, 200, 100, 70);

        table_panel.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        table_panel.setText("1st Floor Table");
        jPanel3.add(table_panel);
        table_panel.setBounds(200, 20, 220, 50);

        jTabbedPane1.addTab("Table", jPanel3);

        jPanel4.setLayout(null);

        table_panel1.setFont(new java.awt.Font("Gadugi", 3, 16)); // NOI18N
        table_panel1.setText("Staters");
        jPanel4.add(table_panel1);
        table_panel1.setBounds(10, 220, 150, 30);

        table_panel3.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        table_panel3.setText("Food Menu");
        jPanel4.add(table_panel3);
        table_panel3.setBounds(220, 20, 220, 50);

        table_panel4.setFont(new java.awt.Font("Gadugi", 3, 16)); // NOI18N
        table_panel4.setText("Main Dish");
        jPanel4.add(table_panel4);
        table_panel4.setBounds(10, 80, 150, 30);

        table_panel5.setFont(new java.awt.Font("Gadugi", 3, 16)); // NOI18N
        table_panel5.setText("Dessert");
        jPanel4.add(table_panel5);
        table_panel5.setBounds(10, 380, 150, 30);

        fusilli_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        fusilli_button.setText("Fusilli Cheese");
        fusilli_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fusilli_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(fusilli_button);
        fusilli_button.setBounds(400, 120, 160, 40);

        spaghetti2_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        spaghetti2_button.setText("Spaghetti Aglio");
        spaghetti2_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spaghetti2_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(spaghetti2_button);
        spaghetti2_button.setBounds(210, 120, 160, 40);

        friedrice_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        friedrice_button.setText("Fried Rice");
        friedrice_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friedrice_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(friedrice_button);
        friedrice_button.setBounds(210, 170, 160, 40);

        spaghetti1_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        spaghetti1_button.setText("Spaghetti Carbonara");
        spaghetti1_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spaghetti1_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(spaghetti1_button);
        spaghetti1_button.setBounds(20, 120, 159, 40);

        sirloin_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        sirloin_button.setText("Sirloin Steak");
        sirloin_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sirloin_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(sirloin_button);
        sirloin_button.setBounds(20, 170, 160, 40);

        wedges_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        wedges_button.setText("Potato Wedges");
        wedges_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wedges_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(wedges_button);
        wedges_button.setBounds(20, 310, 160, 40);

        fries_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        fries_button.setText("French Fries");
        fries_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fries_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(fries_button);
        fries_button.setBounds(20, 260, 160, 40);

        chickenwings1_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        chickenwings1_button.setText("BBQ Chicken Wings");
        chickenwings1_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chickenwings1_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(chickenwings1_button);
        chickenwings1_button.setBounds(210, 260, 160, 40);

        chickenwings2_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        chickenwings2_button.setText("Bufallo Chicken W.");
        chickenwings2_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chickenwings2_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(chickenwings2_button);
        chickenwings2_button.setBounds(400, 260, 160, 40);

        cupcake_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        cupcake_button.setText("Vanilla Cupcake");
        cupcake_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cupcake_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(cupcake_button);
        cupcake_button.setBounds(210, 420, 160, 40);

        pudding_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        pudding_button.setText("Pudding Nutella");
        pudding_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pudding_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(pudding_button);
        pudding_button.setBounds(400, 420, 160, 40);

        cheesecake_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        cheesecake_button.setText("Cheese Cake");
        cheesecake_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cheesecake_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(cheesecake_button);
        cheesecake_button.setBounds(20, 420, 160, 40);

        jTabbedPane1.addTab("Food", jPanel4);

        jPanel2.setLayout(null);

        table_panel2.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        table_panel2.setText("Beverages Menu");
        jPanel2.add(table_panel2);
        table_panel2.setBounds(200, 20, 220, 50);

        table_panel6.setFont(new java.awt.Font("Gadugi", 3, 16)); // NOI18N
        table_panel6.setText("Milkshake");
        jPanel2.add(table_panel6);
        table_panel6.setBounds(10, 80, 150, 30);

        table_panel7.setFont(new java.awt.Font("Gadugi", 3, 16)); // NOI18N
        table_panel7.setText("Juice");
        jPanel2.add(table_panel7);
        table_panel7.setBounds(10, 220, 150, 30);

        table_panel8.setFont(new java.awt.Font("Gadugi", 3, 16)); // NOI18N
        table_panel8.setText("Coffee");
        jPanel2.add(table_panel8);
        table_panel8.setBounds(10, 380, 150, 30);

        milkshake1_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        milkshake1_button.setText("Vanilla Milkshake");
        milkshake1_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                milkshake1_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(milkshake1_button);
        milkshake1_button.setBounds(20, 120, 160, 40);

        milkshake2_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        milkshake2_button.setText("Chocolate Milkshake");
        milkshake2_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                milkshake2_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(milkshake2_button);
        milkshake2_button.setBounds(210, 120, 160, 40);

        milkshake3_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        milkshake3_button.setText("Strawberry Milkshake");
        milkshake3_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                milkshake3_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(milkshake3_button);
        milkshake3_button.setBounds(390, 120, 170, 40);

        cookiescream_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        cookiescream_button.setText("Cookies & Cream");
        cookiescream_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cookiescream_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(cookiescream_button);
        cookiescream_button.setBounds(20, 170, 160, 40);

        juice1_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        juice1_button.setText("Orange Juice");
        juice1_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juice1_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(juice1_button);
        juice1_button.setBounds(20, 260, 160, 40);

        juice2_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        juice2_button.setText("Watermelon Juice");
        juice2_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juice2_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(juice2_button);
        juice2_button.setBounds(210, 260, 160, 40);

        juice3_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        juice3_button.setText("Avocado Juice");
        juice3_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juice3_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(juice3_button);
        juice3_button.setBounds(390, 260, 170, 40);

        juice4_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        juice4_button.setText("Mango Juice");
        juice4_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juice4_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(juice4_button);
        juice4_button.setBounds(20, 310, 160, 40);

        cappuccino_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        cappuccino_button.setText("Cappuccino");
        cappuccino_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cappuccino_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(cappuccino_button);
        cappuccino_button.setBounds(20, 420, 160, 40);

        latte_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        latte_button.setText("Latte");
        latte_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                latte_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(latte_button);
        latte_button.setBounds(210, 420, 160, 40);

        moccaccino_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        moccaccino_button.setText("Moccaccino");
        moccaccino_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moccaccino_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(moccaccino_button);
        moccaccino_button.setBounds(390, 420, 170, 40);

        espresso_button.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        espresso_button.setText("Espresso");
        espresso_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                espresso_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(espresso_button);
        espresso_button.setBounds(20, 470, 160, 40);

        jTabbedPane1.addTab("Beverages", jPanel2);

        panel_menu.add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 10, 580, 560);

        jPanel1.add(panel_menu);
        panel_menu.setBounds(410, 30, 600, 580);

        panel_bill.setBackground(new java.awt.Color(0, 0, 0));
        panel_bill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        panel_bill.setLayout(null);

        cashier_label.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        cashier_label.setForeground(new java.awt.Color(255, 255, 255));
        panel_bill.add(cashier_label);
        cashier_label.setBounds(220, 10, 80, 30);

        jLabel7.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cashier");
        panel_bill.add(jLabel7);
        jLabel7.setBounds(160, 10, 80, 30);

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
        jScrollPane1.setViewportView(table_bill);

        jScrollPane2.setViewportView(jScrollPane1);

        panel_bill.add(jScrollPane2);
        jScrollPane2.setBounds(10, 50, 370, 450);

        jLabel8.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Table");
        panel_bill.add(jLabel8);
        jLabel8.setBounds(10, 10, 40, 30);

        table_label.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        table_label.setForeground(new java.awt.Color(255, 255, 255));
        panel_bill.add(table_label);
        table_label.setBounds(50, 10, 80, 30);

        jPanel1.add(panel_bill);
        panel_bill.setBounds(10, 170, 390, 510);

        panel_menu2.setBackground(new java.awt.Color(0, 0, 0));
        panel_menu2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        panel_menu2.setLayout(null);

        pay_button.setBackground(new java.awt.Color(255, 255, 255));
        pay_button.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        pay_button.setText("Pay");
        pay_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_buttonActionPerformed(evt);
            }
        });
        panel_menu2.add(pay_button);
        pay_button.setBounds(30, 10, 130, 40);

        delete_button.setBackground(new java.awt.Color(255, 255, 255));
        delete_button.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        delete_button.setText("Delete");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });
        panel_menu2.add(delete_button);
        delete_button.setBounds(170, 10, 130, 40);

        clear_button.setBackground(new java.awt.Color(255, 255, 255));
        clear_button.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        clear_button.setText("Clear");
        clear_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_buttonActionPerformed(evt);
            }
        });
        panel_menu2.add(clear_button);
        clear_button.setBounds(310, 10, 130, 40);

        refresh_button.setBackground(new java.awt.Color(255, 255, 255));
        refresh_button.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        refresh_button.setText("Refresh");
        refresh_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_buttonActionPerformed(evt);
            }
        });
        panel_menu2.add(refresh_button);
        refresh_button.setBounds(450, 10, 130, 40);

        jPanel1.add(panel_menu2);
        panel_menu2.setBounds(410, 620, 600, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -10, 1020, 690);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void pay_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_buttonActionPerformed
         try{
            // Make pay object from Pay class
            Pay pay = new Pay(getSum(), table_label.getText(), table, this); 
            // Open Pay jFrame
            pay.setVisible(true);
            if(getSum() == 0){
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Please select table first!", "Failed", JOptionPane.WARNING_MESSAGE);               
            }
        // Exception or error handling
        } catch(NullPointerException e){
            // Printing error message through windows
            JOptionPane.showMessageDialog(this, "Please select table first!", "Failed", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pay_buttonActionPerformed

    private void table1_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_table1_buttonActionPerformed
        // Set table number to jTextField
        table_label.setText("1");
        // Set table name for database SQL syntax
        table = "tb_table1";
        // Call readData() function to refresh the jTable
        readData();
    }//GEN-LAST:event_table1_buttonActionPerformed

    private void table6_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_table6_buttonActionPerformed
        // Set table number to jTextField
        table_label.setText("6");
        // Set table name for database SQL syntax
        table = "tb_table6";
        // Call readData() function to refresh the jTable
        readData();
    }//GEN-LAST:event_table6_buttonActionPerformed

    private void fusilli_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fusilli_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Fusilli Cheese", "Food", 22000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 22000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_fusilli_buttonActionPerformed

    private void spaghetti2_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spaghetti2_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Spaghetti Aglio Olio", "Food", 31000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 31000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_spaghetti2_buttonActionPerformed

    private void friedrice_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friedrice_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Fried Rice", "Food", 28000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 28000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_friedrice_buttonActionPerformed

    private void spaghetti1_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spaghetti1_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Spaghetti Carbonara", "Food", 30000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 30000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_spaghetti1_buttonActionPerformed

    private void sirloin_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sirloin_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Sirloin Steak", "Food", 50000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 50000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_sirloin_buttonActionPerformed

    private void wedges_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wedges_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Potato Wedges", "Food", 14000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 14000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_wedges_buttonActionPerformed

    private void fries_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fries_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("French Fries", "Food", 12000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 12000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_fries_buttonActionPerformed

    private void chickenwings1_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chickenwings1_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("BBQ Chicken Wings", "Food", 23000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 23000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_chickenwings1_buttonActionPerformed

    private void chickenwings2_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chickenwings2_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Bufallo Chicken Wings", "Food", 25000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 25000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_chickenwings2_buttonActionPerformed

    private void cupcake_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cupcake_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Vanilla Cupcake", "Food", 10000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 10000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_cupcake_buttonActionPerformed

    private void pudding_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pudding_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Pudding Nutella", "Food", 17000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 17000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_pudding_buttonActionPerformed

    private void cheesecake_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cheesecake_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Cheese Cake", "Food", 17000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 17000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_cheesecake_buttonActionPerformed

    private void milkshake1_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_milkshake1_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Vanilla Milkshake", "Beverages", 15000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 15000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_milkshake1_buttonActionPerformed

    private void milkshake2_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_milkshake2_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Chocolate Milkshake", "Beverages", 15000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 15000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_milkshake2_buttonActionPerformed

    private void milkshake3_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_milkshake3_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Strawberry Milkshake", "Beverages", 15000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 15000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_milkshake3_buttonActionPerformed

    private void cookiescream_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cookiescream_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Cookies and Cream", "Beverages", 16000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 16000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_cookiescream_buttonActionPerformed

    private void juice1_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juice1_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Orange Juice", "Beverages", 12000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 12000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_juice1_buttonActionPerformed

    private void juice2_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juice2_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Watermelon Juice", "Beverages", 12000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 12000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_juice2_buttonActionPerformed

    private void juice3_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juice3_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Avocado Juice", "Beverages", 14000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 14000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_juice3_buttonActionPerformed

    private void juice4_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juice4_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Mango Juice", "Beverages", 12000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 12000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_juice4_buttonActionPerformed

    private void cappuccino_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cappuccino_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Cappuccino", "Beverages", 20000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 20000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_cappuccino_buttonActionPerformed

    private void latte_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_latte_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Latte", "Beverages", 18000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 18000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_latte_buttonActionPerformed

    private void moccaccino_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moccaccino_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Moccaccino", "Beverages", 19000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 19000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_moccaccino_buttonActionPerformed

    private void espresso_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_espresso_buttonActionPerformed
        // Make object temp and set data for new items
        Items temp = new Items("Espresso", "Beverages", 15000);
        // Add item to database
        int status_add = Database.addItem(table, temp);
        switch (status_add) {
            case 1:
                // Call readData() function to refresh the jTable
                readData();
                break;
            case 2:
                // Set price for the item
                temp.price = 15000;
                // Add qty + 1 if the button clicked twice and so on
                int status_qty = Database.addQty(table, temp);
                if(status_qty == 1){
                    // Call readData() function to refresh the jTable
                    readData();
                }
                else{
                    // Printing error message through windows
                    JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                }   
                break;
            default:
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be added!", "Failed", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_espresso_buttonActionPerformed

    private void table2_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_table2_buttonActionPerformed
        // Set table number to jTextField
        table_label.setText("2");
        // Set table name for database SQL syntax
        table = "tb_table2";
        // Call readData() function to refresh the jTable
        readData();
    }//GEN-LAST:event_table2_buttonActionPerformed

    private void table3_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_table3_buttonActionPerformed
        // Set table number to jTextField
        table_label.setText("3");
        // Set table name for database SQL syntax
        table = "tb_table3";
        // Call readData() function to refresh the jTable
        readData();
    }//GEN-LAST:event_table3_buttonActionPerformed

    private void table4_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_table4_buttonActionPerformed
        // Set table number to jTextField
        table_label.setText("4");
        // Set table name for database SQL syntax
        table = "tb_table4";
        // Call readData() function to refresh the jTable
        readData();
    }//GEN-LAST:event_table4_buttonActionPerformed

    private void table5_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_table5_buttonActionPerformed
        // Set table number to jTextField
        table_label.setText("5");
        // Set table name for database SQL syntax
        table = "tb_table5";
        // Call readData() function to refresh the jTable
        readData();
    }//GEN-LAST:event_table5_buttonActionPerformed

    private void table7_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_table7_buttonActionPerformed
        // Set table number to jTextField
        table_label.setText("7");
        // Set table name for database SQL syntax
        table = "tb_table7";
        // Call readData() function to refresh the jTable
        readData();
    }//GEN-LAST:event_table7_buttonActionPerformed

    private void table8_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_table8_buttonActionPerformed
        // Set table number to jTextField
        table_label.setText("8");
        // Set table name for database SQL syntax
        table = "tb_table8";
        // Call readData() function to refresh the jTable
        readData();
    }//GEN-LAST:event_table8_buttonActionPerformed

    private void table9_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_table9_buttonActionPerformed
        // Set table number to jTextField
        table_label.setText("9");
        // Set table name for database SQL syntax
        table = "tb_table9";
        // Call readData() function to refresh the jTable
        readData();
    }//GEN-LAST:event_table9_buttonActionPerformed

    private void table11_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_table11_buttonActionPerformed
        // Set table number to jTextField
        table_label.setText("11");
        // Set table name for database SQL syntax
        table = "tb_table11";
        // Call readData() function to refresh the jTable
        readData();
    }//GEN-LAST:event_table11_buttonActionPerformed

    private void table10_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_table10_buttonActionPerformed
        // Set table number to jTextField
        table_label.setText("10");
        // Set table name for database SQL syntax
        table = "tb_table10";
        // Call readData() function to refresh the jTable
        readData();
    }//GEN-LAST:event_table10_buttonActionPerformed

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        // Get the selected row and store it to row variable
        int row = table_bill.getSelectedRow();
        // If the row is selected (!-1)
        if (row != -1){
            // Get the data of first column in jTable
            String items = table_bill.getValueAt(row, 0).toString();
            // SQL syntax to delete the selected row by item name
            String sql = "DELETE FROM %s WHERE items = '" + items + "'";
            sql = String.format(sql, table);
            int status = Database.execute(sql);
            if(status == 1){
                // Printing success message through windows
                JOptionPane.showMessageDialog(this, "Items deleted!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Call readData() function to refresh the jTable
                readData();
            } else{
                // Printing error message through windows
                JOptionPane.showMessageDialog(this, "Items failed to be deleted!", "Failed", JOptionPane.WARNING_MESSAGE);
            }
        } else{
            // Printing error message through windows
            JOptionPane.showMessageDialog(this, "Please select row first!", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_delete_buttonActionPerformed

    private void refresh_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_buttonActionPerformed
        try{
            // Call readData() function to refresh the jTable
            readData();
        // Exception or error handling
        } catch (Exception e){
            // Printing error message through windows
            JOptionPane.showMessageDialog(this, "Please select table first!", "Failed", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_refresh_buttonActionPerformed

    private void clear_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_buttonActionPerformed
        // Execute SQL syntax to delete all data in a table
        int status = Database.deleteAll(table);
        if(status == 1){
            // Call readData() function to refresh the jTable
            readData();
        }
        else{
            // Printing error message through windows
            JOptionPane.showMessageDialog(this, "All items failed to be deleted!", "Failed", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_clear_buttonActionPerformed

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cappuccino_button;
    private javax.swing.JLabel cashier_label;
    private javax.swing.JButton cheesecake_button;
    private javax.swing.JButton chickenwings1_button;
    private javax.swing.JButton chickenwings2_button;
    private javax.swing.JButton clear_button;
    private javax.swing.JButton cookiescream_button;
    private javax.swing.JButton cupcake_button;
    private javax.swing.JButton delete_button;
    private javax.swing.JButton espresso_button;
    private javax.swing.JButton friedrice_button;
    private javax.swing.JButton fries_button;
    private javax.swing.JButton fusilli_button;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton juice1_button;
    private javax.swing.JButton juice2_button;
    private javax.swing.JButton juice3_button;
    private javax.swing.JButton juice4_button;
    private javax.swing.JButton latte_button;
    private javax.swing.JButton milkshake1_button;
    private javax.swing.JButton milkshake2_button;
    private javax.swing.JButton milkshake3_button;
    private javax.swing.JButton moccaccino_button;
    private javax.swing.JPanel panel_bill;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JPanel panel_menu2;
    private javax.swing.JButton pay_button;
    private javax.swing.JLabel photo;
    private javax.swing.JButton pudding_button;
    private javax.swing.JButton refresh_button;
    private javax.swing.JButton sirloin_button;
    private javax.swing.JButton spaghetti1_button;
    private javax.swing.JButton spaghetti2_button;
    private javax.swing.JButton table10_button;
    private javax.swing.JButton table11_button;
    private javax.swing.JButton table1_button;
    private javax.swing.JButton table2_button;
    private javax.swing.JButton table3_button;
    private javax.swing.JButton table4_button;
    private javax.swing.JButton table5_button;
    private javax.swing.JButton table6_button;
    private javax.swing.JButton table7_button;
    private javax.swing.JButton table8_button;
    private javax.swing.JButton table9_button;
    private javax.swing.JTable table_bill;
    private javax.swing.JLabel table_label;
    private javax.swing.JLabel table_panel;
    private javax.swing.JLabel table_panel1;
    private javax.swing.JLabel table_panel2;
    private javax.swing.JLabel table_panel3;
    private javax.swing.JLabel table_panel4;
    private javax.swing.JLabel table_panel5;
    private javax.swing.JLabel table_panel6;
    private javax.swing.JLabel table_panel7;
    private javax.swing.JLabel table_panel8;
    private javax.swing.JButton wedges_button;
    // End of variables declaration//GEN-END:variables
}
