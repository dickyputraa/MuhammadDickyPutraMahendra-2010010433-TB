package GUI;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableColumnModel;

public class Krs extends javax.swing.JFrame {
    public Connection con;
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel model;
    
    public Krs() {
        initComponents();
        tampil_combo();
        tampil_comboid();
        String[] header = {"ID KRS","ID NAMA","ID MAPEL","TANGGAL"};
        model = new DefaultTableModel(header,0);
        tabel.setModel(model);
        tampil();
    }
    
    public void clear (){
        String[] header = {"ID KRS","ID NAMA","ID MAPEL","TANGGAL"};
        model = new DefaultTableModel(header,0);
        tabel.setModel(model);
    }
    
    public void kosongkan(){
        txtid.setText("");
        cbidnama.setSelectedItem("");
        cbid.setSelectedItem("");
        txttanggal.setText("");
        txtid.setEditable(true);
    }
    
    public void tambah(){
        koneksi classKoneksi = new koneksi();
        try {
            con = classKoneksi.getKoneksi();
            st = con.createStatement();
            st.execute("INSERT INTO krs VALUES('"+txtid.getText()+"','"+cbidnama.getSelectedItem()+"','"+cbid.getSelectedItem()+"','"+txttanggal.getText()+"')");
        } catch (SQLException ex){
                System.err.println(ex.getMessage());
        }
        clear();
        tampil();
    }
    
    public void ubah(){
        try{
            st.executeUpdate("UPDATE krs set id_nama='"+cbidnama.getSelectedItem()+"',id_namamapel='"+cbid.getSelectedItem()+"',tanggal='"+txttanggal.getText()+"' WHERE id_krs='"+txtid.getText()+"'");
            JOptionPane.showMessageDialog(null, "Update Data Berhasil","Alert",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update Data Gagal","Alert",JOptionPane.ERROR_MESSAGE);
        }
        kosongkan();
        clear();
        tampil();
    }
    
    public void tampil(){
        koneksi classKoneksi = new koneksi();
        try{
            con = classKoneksi.getKoneksi();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM krs");
            while(rs.next()){
                    String[] row = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
                    model.addRow(row);
            }
            tabel.setModel(model);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void hapus(){
        String id = txtid.getText();
        try{
            st.executeUpdate("DELETE FROM krs WHERE id_krs='"+id+"'");
            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil","Alert",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Hapus Data Gagal","Alert",JOptionPane.ERROR_MESSAGE);
        }
        kosongkan();
        clear();
        tampil();
    }
    
    public void tampil_combo(){
        koneksi classKoneksi = new koneksi();
        try{
            con = classKoneksi.getKoneksi();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM mahasiswa");
            while(rs.next()){
                    cbidnama.addItem(rs.getString("id")+"-"+rs.getString("nama"));
            }
            
            rs.last();
            int jumlahdata = rs.getRow();
            rs.first();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void tampil_comboid(){
        koneksi classKoneksi = new koneksi();
        try{
            con = classKoneksi.getKoneksi();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM matakuliah");
            while(rs.next()){
                    cbid.addItem(rs.getString("id")+"-"+rs.getString("nama"));
            }
            
            rs.last();
            int jumlahdata = rs.getRow();
            rs.first();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
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

        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        cbidnama = new javax.swing.JComboBox<>();
        cbid = new javax.swing.JComboBox<>();
        txttanggal = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btnupdate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel5.setText("Pengisian Data Krs");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("ID NAMA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 60, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("ID MAPEL");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("Tanggal");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 210, -1));

        getContentPane().add(cbidnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 210, -1));

        getContentPane().add(cbid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 210, -1));
        getContentPane().add(txttanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 210, -1));

        btnsave.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 70, -1));

        btndelete.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btndelete.setText("Delete");
        btndelete.setEnabled(false);
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 70, -1));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 620, 130));

        btnupdate.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnupdate.setText("Update");
        btnupdate.setEnabled(false);
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 70, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/80a1faf1ec2f473bec030396a7fdb2e8.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new MenuUtama().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        hapus();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        ubah();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        tambah();
    }//GEN-LAST:event_btnsaveActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int row = tabel.getSelectedRow();
        btnupdate.setEnabled(true);
        btndelete.setEnabled(true);
        txtid.setEditable(false);
        txtid.setText(tabel.getValueAt(row, 0).toString());
        cbidnama.setSelectedItem(tabel.getValueAt(row, 1).toString());
        cbid.setSelectedItem(tabel.getValueAt(row, 2).toString());
        txttanggal.setText(tabel.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tabelMouseClicked

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
            java.util.logging.Logger.getLogger(Krs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Krs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Krs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Krs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Krs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> cbid;
    private javax.swing.JComboBox<String> cbidnama;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txttanggal;
    // End of variables declaration//GEN-END:variables
}
