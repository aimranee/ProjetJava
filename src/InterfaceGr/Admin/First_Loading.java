package InterfaceGr.Admin;

import javax.swing.JFrame;

public class First_Loading extends javax.swing.JFrame {

  
    public First_Loading() {
        initComponents();
        this.setLocationRelativeTo(null);
         this.setResizable(false);
    }

    private void initComponents() {

        pp = new javax.swing.JPanel();
        tele = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ppp = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pp.setBackground(new java.awt.Color(255, 255, 255));
        pp.setForeground(new java.awt.Color(0, 102, 205));

        tele.setBackground(new java.awt.Color(255, 255, 255));
        tele.setForeground(new java.awt.Color(0, 102, 205));

        jLabel1.setFont(new java.awt.Font("Doppio One", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 235));
        jLabel1.setText("bienvenue dans l'espace admin");

        jLabel3.setForeground(new java.awt.Color(0, 102, 204));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setText("téléchargement");

        ppp.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ppp.setForeground(new java.awt.Color(0, 51, 255));

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ppLayout = new javax.swing.GroupLayout(pp);
        pp.setLayout(ppLayout);
        ppLayout.setHorizontalGroup(
            ppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tele, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ppLayout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ppLayout.createSequentialGroup()
                .addGroup(ppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ppLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel4)
                        .addGap(65, 65, 65)
                        .addComponent(ppp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ppLayout.createSequentialGroup()
                        .addGap(499, 499, 499)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ppLayout.setVerticalGroup(
            ppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ppLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(ppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(ppp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(tele, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       First_Loading telech = new First_Loading();
       telech.setLocationRelativeTo(telech); 
       telech.setVisible(true);
       try{
           for(int i=0;i<= 100;i++){
               Thread.sleep(40);
               telech.tele.setValue(i);
               telech.ppp.setText(Integer.valueOf(i)+" % ");
           }
       }catch(Exception e){
           System.out.println("error dans loading !!");
       }
       Login login = new Login();
       login.setVisible(true);
       login.setBounds(300, 90, 500, 600);
       login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       login.setResizable(false);
       telech.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pp;
    private javax.swing.JLabel ppp;
    private javax.swing.JProgressBar tele;
    // End of variables declaration//GEN-END:variables
}
