/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Class.DBFunction;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author eyubonsai
 */
public class FrmPengeluaran extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmPengeluaran
     */
    public FrmPengeluaran() {
        initComponents();
        awal();
    }
private void awal()
{
     ambil_tabel();
     this.clear();
}

private void clear()
{
    this.jTextField1.setText("");
    this.jTextField2.setText("");
    this.jTextField3.setText("Auto");
    this.csimpan.setText("simpan");
    this.chapus.setEnabled(false);
}

private void isubah()
{
    this.csimpan.setText("ubah");
    this.chapus.setEnabled(true);
}
 private void ambil_tabel()
 {
     DBFunction p=new DBFunction();
  
     p._bindingTable("Select * from pengeluaran", jTable1);
 }
 
 private void tambah()
 {
     DBFunction p=new DBFunction();
     DateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd");
        String tgl=dateFormat.format(this.TxtTgl.getDate()); 
         p.RunSQL("Insert into pengeluaran (`nama_barang`,`tgl`,`total`) values ('"+this.jTextField1.getText()+"','"+tgl+"','"+this.jTextField2.getText()+"')");                  
         JOptionPane.showMessageDialog(null, "Berhasil tambah"); 
         awal();
 }
 
 private void update()
 {
     DBFunction p=new DBFunction();
     
         p.RunSQL("Update pengeluaran SET `nama_barang`='"+this.jTextField1.getText()+"',total='"+this.jTextField2.getText()+"' Where id_keluar='"+this.jTextField3.getText()+"'");
         JOptionPane.showMessageDialog(null, "Berhasil ubah");   
         awal();
 }
 
 private void hapus()
 {
     DBFunction p=new DBFunction();
     
         p.RunSQL("Delete from pengeluaran Where id_keluar='"+this.jTextField3.getText()+"'");         
         JOptionPane.showMessageDialog(null, "Berhasil hapus");   
         awal();
 }

 private void simpan()
 {
     String a=csimpan.getText();
     if("simpan".equals(a))
     {
         this.tambah();
     }else if(("ubah").equals(a))
     {
         this.update();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        TxtTgl = new com.toedter.calendar.JDateChooser();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        csimpan = new javax.swing.JButton();
        chapus = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID Trans");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setText("Tanggal");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel3.setText("TOTAL");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 140, -1));
        getContentPane().add(TxtTgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 160, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 140, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 290, 150));

        jButton1.setText("keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        csimpan.setText("simpan");
        csimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csimpanActionPerformed(evt);
            }
        });
        getContentPane().add(csimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        chapus.setText("hapus");
        chapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chapusActionPerformed(evt);
            }
        });
        getContentPane().add(chapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        jLabel4.setText("Nama Barang");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jTextField3.setEditable(false);
        jTextField3.setText("Auto");
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 140, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        this.isubah();
        int i=this.jTable1.getSelectedRow();
        if(i==-1)
        {
            return;
        }
        java.util.Date tgl1=(java.util.Date) jTable1.getModel().getValueAt(i,2);
        this.jTextField1.setText(String.valueOf(jTable1.getModel().getValueAt(i,3)));
        this.TxtTgl.setDate(tgl1);
        this.jTextField2.setText((String)jTable1.getModel().getValueAt(i,1));
        this.jTextField3.setText((String)jTable1.getModel().getValueAt(i,0));

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void csimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csimpanActionPerformed
        // TODO add your handling code here:
        this.simpan();
    }//GEN-LAST:event_csimpanActionPerformed

    private void chapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chapusActionPerformed
        // TODO add your handling code here:
        this.hapus();
    }//GEN-LAST:event_chapusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser TxtTgl;
    private javax.swing.JButton chapus;
    private javax.swing.JButton csimpan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}