package gui;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Mysql;

public class EmployeeRegistration extends javax.swing.JFrame {

    private HashMap<String, Integer> GenderMap = new HashMap<>();
    private HashMap<String, Integer> TypeMap = new HashMap<>();

    public EmployeeRegistration() {
        initComponents();
        this.loadTypes();
        this.loadGender();
        this.loadUsers();
    }

    private void loadTypes() {
        try {
            ResultSet types = Mysql.search("SELECT * FROM `employee_type`");
            Vector<String> items = new Vector<>();
            items.add("Select");

            while (types.next()) {
                items.add(types.getString("name"));

                TypeMap.put(types.getString("name"), types.getInt("id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(items);
            cbType.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadGender() {
        try {
            ResultSet genders = Mysql.search("SELECT * FROM `genders`");
            Vector<String> items = new Vector<>();
            items.add("Select");

            while (genders.next()) {
                items.add(genders.getString("name"));

                GenderMap.put(genders.getString("name"), genders.getInt("id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(items);
            cbGender.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadUsers() {
        try {
            String query = "SELECT * FROM `employee` e "
                    + "INNER JOIN employee_type t ON t.id = e.employee_type_id "
                    + "INNER JOIN genders g ON g.id = e.gender_id";
            ResultSet users = Mysql.search(query);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            while (users.next()) {
                Vector<String> row = new Vector<>();
                row.add(users.getString("e.email"));
                row.add(users.getString("e.first_name"));
                row.add(users.getString("e.last_name"));
                row.add(users.getString("e.nic"));
                row.add(users.getString("e.mobile"));
                row.add(users.getString("g.name"));
                row.add(users.getString("e.password"));
                row.add(users.getString("t.name"));
                row.add(users.getString("e.date_of_registered"));

                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Clear() {
        tbEmail.setEnabled(true);

        tbEmail.setText("");
        tbFirstName.setText("");
        tbLastName.setText("");
        tbMobile.setText("");
        tbPassword.setText("");
        tbNIC.setText("");
        cbType.setSelectedIndex(0);
        cbGender.setSelectedIndex(0);

        tbEmail.grabFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tbEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tbFirstName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tbLastName = new javax.swing.JTextField();
        tbNIC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tbMobile = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tbPassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        cbType = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(47, 47, 47));

        jLabel1.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        jLabel1.setText("Email");

        jLabel2.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        jLabel2.setText("First Name");

        jLabel3.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        jLabel3.setText("Last Name");

        jLabel4.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        jLabel4.setText("NIC");

        jLabel5.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        jLabel5.setText("Mobile");

        jLabel6.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        jLabel6.setText("Password");

        jLabel7.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        jLabel7.setText("Type");

        cbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        jLabel8.setText("Gender");

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Create Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tbNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(42, 42, 42)
                                        .addComponent(tbLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(42, 42, 42)
                                        .addComponent(tbFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(tbMobile)
                                                .addComponent(tbPassword)
                                                .addComponent(cbType, 0, 195, Short.MAX_VALUE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tbFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tbLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tbNIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tbMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(47, 47, 47));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email", "First Name", "Last Name", "NIC", "Mobile", "Gender", "Password", "Type", "Registered At"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String email = tbEmail.getText();
        String firstName = tbFirstName.getText();
        String lastName = tbLastName.getText();
        String nic = tbNIC.getText();
        String mobile = tbMobile.getText();
        String password = String.valueOf(tbPassword.getPassword());
        String type = String.valueOf(cbType.getSelectedItem());
        String gender = String.valueOf(cbGender.getSelectedItem());

        Vector<String> v = new Vector<>();
        v.add(email);
        v.add(firstName);
        v.add(lastName);
        v.add(mobile);
        v.add(nic);
        v.add(password);

        boolean isValid = true;
        for (var item : v) {
            if (String.valueOf(item).isEmpty()) {
                isValid = false;
            }
        }

        String EmailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        if (!email.matches(EmailPattern)) {
            JOptionPane.showMessageDialog(this, "Invalid Email Address", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cbType.getSelectedIndex() == 0 || cbGender.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please Select A Value", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isValid) {
            JOptionPane.showMessageDialog(this, "Please Fill All TextFields", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String query1 = "SELECT * FROM `employee` WHERE `email` = '" + email + "' OR `nic` = '" + nic + "' OR `mobile` = '" + mobile + "'";

        try {
            ResultSet employee = Mysql.search(query1);
            if (employee.next()) {
                JOptionPane.showMessageDialog(this, "A Employee Named " + employee.getString("first_name") + " Already Exist With These Details", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }

        type = String.valueOf(TypeMap.get(type));
        gender = String.valueOf(GenderMap.get(gender));

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        String query = "INSERT INTO `employee`(`email`, `first_name`, `last_name`, `nic`, `password`, `mobile`, `date_of_registered`"
                + ", `employee_type_id`, `gender_id`) VALUES('" + email + "', '" + firstName + "', '" + lastName + "', '" + nic + "', '" + mobile + "', "
                + "'" + password + "', '" + date + "', '" + type + "', '" + gender + "')";

        try {
            Mysql.insert(query);
            this.loadUsers();
            this.Clear();
            JOptionPane.showMessageDialog(this, "New User Added", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            return;
        } catch (Exception ex) {
            Logger.getLogger(EmployeeRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "ERROR WHILE ADDING NEW USER", "ERROR", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 1) {
            tbEmail.setEnabled(false);

            int row = jTable1.getSelectedRow();
            String email = String.valueOf(jTable1.getValueAt(row, 0));
            String firstName = String.valueOf(jTable1.getValueAt(row, 1));
            String lastName = String.valueOf(jTable1.getValueAt(row, 2));
            String nic = String.valueOf(jTable1.getValueAt(row, 3));
            String mobile = String.valueOf(jTable1.getValueAt(row, 4));
            String gender = String.valueOf(jTable1.getValueAt(row, 5));
            String password = String.valueOf(jTable1.getValueAt(row, 6));
            String type = String.valueOf(jTable1.getValueAt(row, 7));

            tbEmail.setText(email);
            tbFirstName.setText(firstName);
            tbLastName.setText(lastName);
            tbNIC.setText(nic);
            tbMobile.setText(mobile);
            tbPassword.setText(password);
            cbGender.setSelectedItem(gender);
            cbType.setSelectedItem(type);

        } else if (evt.getClickCount() == 2) {

            int row = jTable1.getSelectedRow();
            String email = String.valueOf(jTable1.getValueAt(row, 0));

            AddressView addressView = new AddressView(this, true, email);
            addressView.setVisible(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String email = tbEmail.getText();
        String firstName = tbFirstName.getText();
        String lastName = tbLastName.getText();
        String nic = tbNIC.getText();
        String mobile = tbMobile.getText();
        String password = String.valueOf(tbPassword.getPassword());
        String type = String.valueOf(cbType.getSelectedItem());
        String gender = String.valueOf(cbGender.getSelectedItem());

        Vector<String> v = new Vector<>();
        v.add(email);
        v.add(firstName);
        v.add(lastName);
        v.add(mobile);
        v.add(nic);
        v.add(password);

        boolean isValid = true;
        for (var item : v) {
            if (String.valueOf(item).isEmpty()) {
                isValid = false;
            }
        }

        String EmailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        if (!email.matches(EmailPattern)) {
            JOptionPane.showMessageDialog(this, "Invalid Email Address", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cbType.getSelectedIndex() == 0 || cbGender.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please Select A Value", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isValid) {
            JOptionPane.showMessageDialog(this, "Please Fill All TextFields", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String query1 = "SELECT * FROM `employee` WHERE `email` <> '" + email + "' AND `mobile` = '" + mobile + "'";
        String query2 = "SELECT * FROM `employee` WHERE `email` <> '" + email + "' AND `mobile` = '" + nic + "'";

        Vector<String> queries = new Vector<>();
        queries.add(query1);
        queries.add(query2);

        try {
            isValid = true;
            for (var query : queries) {
                if (Mysql.search(String.valueOf(query)).next()) {
                    isValid = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!isValid) {
            JOptionPane.showMessageDialog(this, "Employee Already Exist With Given Details", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Vector<String> columns = new Vector<>();
        columns.add("first_name");
        columns.add("last_name");
        columns.add("nic");
        columns.add("mobile");
        columns.add("password");
        columns.add("gender_id");
        columns.add("employee_type_id");

        Vector<String> values = new Vector<>();
        values.add(firstName);
        values.add(lastName);
        values.add(nic);
        values.add(mobile);
        values.add(password);
        values.add(String.valueOf(GenderMap.get(gender)));
        values.add(String.valueOf(TypeMap.get(type)));

        int index = 0;
        for (var column : columns) {
            try {
                String query = "UPDATE `employee` SET `" + column + "` = '" + values.get(index) + "' WHERE `email`='" + email + "'";
                Mysql.update(query);
                index++;
            } catch (Exception ex) {
                Logger.getLogger(EmployeeRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.loadUsers();
        this.Clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatAtomOneDarkIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JComboBox<String> cbType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tbEmail;
    private javax.swing.JTextField tbFirstName;
    private javax.swing.JTextField tbLastName;
    private javax.swing.JTextField tbMobile;
    private javax.swing.JTextField tbNIC;
    private javax.swing.JPasswordField tbPassword;
    // End of variables declaration//GEN-END:variables
}
