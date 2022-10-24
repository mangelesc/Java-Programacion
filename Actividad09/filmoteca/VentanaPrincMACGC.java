package macgc_actividad09.filmoteca;

public class VentanaPrincMACGC extends javax.swing.JFrame {

    public VentanaPrincMACGC() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFilmoteca = new javax.swing.JLabel();
        btnMostrarDirec = new javax.swing.JButton();
        btnInsertDirectores = new javax.swing.JButton();
        btnModificarDirectores = new javax.swing.JButton();
        btnEliminarDirectores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFilmoteca.setText("FILMOTECA MACGC");

        btnMostrarDirec.setText("Listar Directores");
        btnMostrarDirec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarDirecActionPerformed(evt);
            }
        });

        btnInsertDirectores.setText("Insertar Directores");
        btnInsertDirectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertDirectoresActionPerformed(evt);
            }
        });

        btnModificarDirectores.setText("Modificar Directores");
        btnModificarDirectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarDirectoresActionPerformed(evt);
            }
        });

        btnEliminarDirectores.setText("Eliminar Directores");
        btnEliminarDirectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDirectoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(lblFilmoteca)
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInsertDirectores, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnModificarDirectores, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                        .addComponent(btnEliminarDirectores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMostrarDirec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblFilmoteca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnInsertDirectores, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMostrarDirec, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnModificarDirectores, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarDirectores, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarDirecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarDirecActionPerformed
        dispose();
        try {
            new MostrarDirector_macgc().setVisible(true);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }//GEN-LAST:event_btnMostrarDirecActionPerformed


    private void btnInsertDirectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertDirectoresActionPerformed
        dispose();
        try {
            new InsertDIrectores_macgc().setVisible(true);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    
    }//GEN-LAST:event_btnInsertDirectoresActionPerformed

    private void btnModificarDirectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarDirectoresActionPerformed
        dispose();
        try {
            new ModificarDirector_macgc().setVisible(true);;
        } catch(Exception e) {
            e.printStackTrace(System.out);
        }
    
    }//GEN-LAST:event_btnModificarDirectoresActionPerformed

    private void btnEliminarDirectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDirectoresActionPerformed
        dispose();
        try {
            new EliminarDirector_macgc().setVisible(true);;
        } catch(Exception e) {
            e.printStackTrace(System.out);
        }
    
    }//GEN-LAST:event_btnEliminarDirectoresActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarDirectores;
    private javax.swing.JButton btnInsertDirectores;
    private javax.swing.JButton btnModificarDirectores;
    private javax.swing.JButton btnMostrarDirec;
    private javax.swing.JLabel lblFilmoteca;
    // End of variables declaration//GEN-END:variables
}
