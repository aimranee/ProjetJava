
package InterfaceGr.Admin;
import javax.swing.JOptionPane;
import ConnectionOracl.Connect;
import InterfaceGr.PageMenu;
import InterfaceGr.Prof.GraphiquesProf;
import java.sql.*;


public class loginForm extends javax.swing.JFrame {

    Connection con = Connect.getCon();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public loginForm() {
        initComponents();
       Connection con = Connect.getCon();
    }

   
    @SuppressWarnings("unchecked")
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtDes = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 2, new java.awt.Color(153, 153, 153)));

        headerPanel.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login Form !");
        
        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Cancel_Icon.png"))); // NOI18N
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel1)
                .addContainerGap(132, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblClose)
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addComponent(lblClose, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(19, 19, 19))
        );
        
        jLabel9.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Designation :");
        
        txtDes.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        txtDes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Prof" }));
        txtDes.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 2, 1, new java.awt.Color(153, 153, 153)));
        txtDes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtDes.setMaximumSize(new java.awt.Dimension(90, 75));
        txtDes.setPreferredSize(new java.awt.Dimension(190, 35));
        

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Username :");

        txtUname.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        txtUname.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(153, 153, 153)));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Password :");

        txtPass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPass.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(153, 153, 153)));

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Forgot");
        
        jLabel6.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 0));
        jLabel6.setText("Password ?");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Log In");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setMaximumSize(new java.awt.Dimension(83, 35));
        jButton1.setMinimumSize(new java.awt.Dimension(83, 35));
        jButton1.setPreferredSize(new java.awt.Dimension(230, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 0));
        jLabel7.setText("Aide");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addComponent(jLabel9)
                            .addComponent(txtPass)
                            .addComponent(jLabel4)
                            .addComponent(txtDes)
                            .addComponent(txtUname)
                            .addComponent(jLabel3)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel7))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
               
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        String uname = txtUname.getText();
        String pass = String.valueOf(txtPass.getPassword());
        if (uname.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Please enter Username");
        } else if (pass.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter Password");
        } else {
            try {
                String sql = "SELECT * FROM admin WHERE UserNamer = ? AND PassWord = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, uname);
                ps.setString(2, pass);
                rs = ps.executeQuery();
                if (rs.next()){
                    String name = rs.getString("UserNamer");
                    String pss = rs.getString("PassWord");
                	String dess = (String)txtDes.getSelectedItem().toString();
                	if(dess == "Admin") {
                		JOptionPane.showMessageDialog(null, "Login admin Successful ");
                		PageMenu pm = new PageMenu();
                		pm.setVisible(true);
                		this.dispose();
                	}else {
                		JOptionPane.showMessageDialog(null, "Login prof Successful");
                		GraphiquesProf pm = new GraphiquesProf();
                		pm.setVisible(true);
                		this.dispose();
                	}
                } else {
                    JOptionPane.showMessageDialog(null, "Username or Password is incorect");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {
        dispose();
    }
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginForm().setVisible(true);
            }
        });
    }
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<String> txtDes;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblClose;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUname;
}
