package gui_Panel;

import javax.swing.*;

import customEntities.Custom_JLabel;

public class Logo extends javax.swing.JPanel {
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom_JLabel lbl_Profile;
    // End of variables declaration//GEN-END:variables
    public Logo() {
        initComponents();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_Profile = new Custom_JLabel();

        lbl_Profile.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lbl_Profile.setForeground(new java.awt.Color(30, 30, 30));
        lbl_Profile.setBuffered_Image("src/main/images/view_image/Logo.png"); // NOI18N
        lbl_Profile.resizeImage(50, 50);
        lbl_Profile.setText(" Rising Star");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbl_Profile, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Profile, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
}
