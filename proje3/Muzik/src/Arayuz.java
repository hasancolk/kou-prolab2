import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class Arayuz extends javax.swing.JFrame {

    DefaultTableModel model_sanatci;
    DefaultTableModel model_kullanici;
    DefaultTableModel model_album;
    DefaultTableModel model_sarki;
    Islemler islemler = new Islemler();
    int duzenle=0;
    private PreparedStatement preparedStatement=null;
    
    
    public Arayuz() {
        initComponents();
    }
    
    public Arayuz(String ad,String parola){
        
        initComponents();
        
        model_sanatci = (DefaultTableModel) sanatci_tablosu.getModel();
        sanatciGoruntule();
        
        model_kullanici = (DefaultTableModel) kullanici_tablosu.getModel();
        kullaniciGoruntule();
        
        model_album = (DefaultTableModel) album_tablosu.getModel();
        albumGoruntule();
        
        model_sarki = (DefaultTableModel) sarki_tablosu.getModel();
        sarkiGoruntule();
        
        this.setResizable(false);
        this.setSize(1100,650);
        
        admin_panel.setSize(1100,650);
        admin_panel.setFocusable(true);
        admin_panel.setVisible(true);
        islem_panel.setVisible(false);
        mesaj.setVisible(false);
        
    }
    
    public void sanatciGoruntule() { // verileri tabloya getirir.
        
        model_sanatci.setRowCount(0);
        
        ArrayList<Sanatci> sanatcilar = new ArrayList<Sanatci>();
        
        
        sanatcilar = islemler.sanatcilariGetir(); // tum calisanlarin tutuldugu arraylist donderilir.
        
        if (sanatcilar != null ) {
            
            for (Sanatci sanatci : sanatcilar) {
                Object[] eklenecek = {sanatci.getId(),sanatci.getAd(),sanatci.getUlke()};
                
                model_sanatci.addRow(eklenecek);
                
            }
            
        }
           
    }
    
    public void kullaniciGoruntule() { // verileri tabloya getirir.
        
        model_kullanici.setRowCount(0);
        
        ArrayList<Kullanici> kullanicilar = new ArrayList<Kullanici>();
        
        
        kullanicilar = islemler.kullanicilariGetir(); // tum calisanlarin tutuldugu arraylist donderilir.
        
        if (kullanicilar != null ) {
            
            for (Kullanici kullanici : kullanicilar) {
                Object[] eklenecek = {kullanici.getId(),kullanici.getAd(),kullanici.getEmail(),kullanici.getAbonelik_tur(),kullanici.getUlke()};
                
                model_kullanici.addRow(eklenecek);
                
            }
            
        }
           
    }
    
    public void albumGoruntule() { // verileri tabloya getirir.
        
        model_album.setRowCount(0);
        
        ArrayList<Album> albumler = new ArrayList<Album>();
        
        
        albumler = islemler.albumleriGetir(); // tum calisanlarin tutuldugu arraylist donderilir.
        
        if (albumler != null ) {
            
            for (Album album : albumler) {
                Object[] eklenecek = {album.getId(),album.getAd(),album.getSanatciAd(),album.getTarih(),album.getTurAd()};
                
                model_album.addRow(eklenecek);
                
            }
            
        }
           
    }
    
    public void sarkiGoruntule() { // verileri tabloya getirir.
        
        model_sarki.setRowCount(0);
        
        ArrayList<Sarki> sarkilar = new ArrayList<Sarki>();
        
        
        sarkilar = islemler.sarkilariGetir(); // tum calisanlarin tutuldugu arraylist donderilir.
        
        if (sarkilar != null ) {
            
            for (Sarki sarki : sarkilar) {
                Object[] eklenecek = {sarki.getId(),sarki.getAd(),sarki.getSanatciAd(),sarki.getAlbumAd(),sarki.getTurAd(),sarki.getTarih(),sarki.getSure(),sarki.getDinlenme()};
                
                model_sarki.addRow(eklenecek);
                
            }
            
        }
           
    }
    
    public void dinamikAra(DefaultTableModel model,JTable tablo,String ara){
        
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
      
        tablo.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(ara));
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        admin_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sanatci_tablosu = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        kullanici_tablosu = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        album_tablosu = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        sarki_tablosu = new javax.swing.JTable();
        kullanici_duzenle = new javax.swing.JButton();
        album_duzenle = new javax.swing.JButton();
        sarki_duzenle = new javax.swing.JButton();
        sanatci_duzenle = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kullanici_ara = new javax.swing.JTextField();
        sanatci_ara = new javax.swing.JTextField();
        album_ara = new javax.swing.JTextField();
        sarki_ara = new javax.swing.JTextField();
        islem_panel = new javax.swing.JPanel();
        sil = new javax.swing.JButton();
        ekle = new javax.swing.JButton();
        guncelle = new javax.swing.JButton();
        mesaj = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        giris2 = new javax.swing.JTextField();
        giris3 = new javax.swing.JTextField();
        giris4 = new javax.swing.JTextField();
        giris5 = new javax.swing.JTextField();
        giris6 = new javax.swing.JTextField();
        giris7 = new javax.swing.JTextField();
        giris1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1100, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admin_panel.setMinimumSize(new java.awt.Dimension(1100, 650));
        admin_panel.setPreferredSize(new java.awt.Dimension(1100, 650));
        admin_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sanatci_tablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "ad", "ülke"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sanatci_tablosu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sanatci_tablosuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sanatci_tablosu);
        if (sanatci_tablosu.getColumnModel().getColumnCount() > 0) {
            sanatci_tablosu.getColumnModel().getColumn(0).setResizable(false);
            sanatci_tablosu.getColumnModel().getColumn(1).setResizable(false);
            sanatci_tablosu.getColumnModel().getColumn(2).setResizable(false);
        }

        admin_panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 260, 170));

        kullanici_tablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "ad", "email", "abonelik_tur", "ulke"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        kullanici_tablosu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kullanici_tablosuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(kullanici_tablosu);
        if (kullanici_tablosu.getColumnModel().getColumnCount() > 0) {
            kullanici_tablosu.getColumnModel().getColumn(0).setResizable(false);
            kullanici_tablosu.getColumnModel().getColumn(1).setResizable(false);
            kullanici_tablosu.getColumnModel().getColumn(2).setResizable(false);
            kullanici_tablosu.getColumnModel().getColumn(3).setResizable(false);
            kullanici_tablosu.getColumnModel().getColumn(4).setResizable(false);
        }

        admin_panel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 310, 170));

        album_tablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "ad", "sanatçı", "tarih", "tür"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        album_tablosu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                album_tablosuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(album_tablosu);
        if (album_tablosu.getColumnModel().getColumnCount() > 0) {
            album_tablosu.getColumnModel().getColumn(0).setResizable(false);
            album_tablosu.getColumnModel().getColumn(1).setResizable(false);
            album_tablosu.getColumnModel().getColumn(2).setResizable(false);
            album_tablosu.getColumnModel().getColumn(3).setResizable(false);
            album_tablosu.getColumnModel().getColumn(4).setResizable(false);
        }

        admin_panel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 330, 170));

        sarki_tablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "ad", "sanatçı", "albüm", "tür", "tarih", "süre", "izlenme"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sarki_tablosu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sarki_tablosuMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(sarki_tablosu);
        if (sarki_tablosu.getColumnModel().getColumnCount() > 0) {
            sarki_tablosu.getColumnModel().getColumn(0).setResizable(false);
            sarki_tablosu.getColumnModel().getColumn(1).setResizable(false);
            sarki_tablosu.getColumnModel().getColumn(2).setResizable(false);
            sarki_tablosu.getColumnModel().getColumn(3).setResizable(false);
            sarki_tablosu.getColumnModel().getColumn(4).setResizable(false);
            sarki_tablosu.getColumnModel().getColumn(5).setResizable(false);
            sarki_tablosu.getColumnModel().getColumn(6).setResizable(false);
            sarki_tablosu.getColumnModel().getColumn(7).setResizable(false);
        }

        admin_panel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, 450, 170));

        kullanici_duzenle.setText("DUZENLE");
        kullanici_duzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullanici_duzenleActionPerformed(evt);
            }
        });
        admin_panel.add(kullanici_duzenle, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 120, 30));

        album_duzenle.setText("DUZENLE");
        album_duzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                album_duzenleActionPerformed(evt);
            }
        });
        admin_panel.add(album_duzenle, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 580, 120, 30));

        sarki_duzenle.setText("DUZENLE");
        sarki_duzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sarki_duzenleActionPerformed(evt);
            }
        });
        admin_panel.add(sarki_duzenle, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 580, 120, 30));

        sanatci_duzenle.setText("DUZENLE");
        sanatci_duzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sanatci_duzenleActionPerformed(evt);
            }
        });
        admin_panel.add(sanatci_duzenle, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, 120, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("                       ŞARKILAR");
        admin_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 330, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("              KULLANICILAR");
        admin_panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 280, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("     SANATÇILAR");
        admin_panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 170, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("               ALBUMLER");
        admin_panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 250, 20));

        kullanici_ara.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kullanici_araKeyReleased(evt);
            }
        });
        admin_panel.add(kullanici_ara, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 250, -1));

        sanatci_ara.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sanatci_araKeyReleased(evt);
            }
        });
        admin_panel.add(sanatci_ara, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 240, -1));

        album_ara.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                album_araKeyReleased(evt);
            }
        });
        admin_panel.add(album_ara, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 310, -1));

        sarki_ara.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sarki_araKeyReleased(evt);
            }
        });
        admin_panel.add(sarki_ara, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 370, 390, -1));

        islem_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sil.setText("SİL");
        sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silActionPerformed(evt);
            }
        });
        islem_panel.add(sil, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 100, 50));

        ekle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ekle.setText("EKLE");
        ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleActionPerformed(evt);
            }
        });
        islem_panel.add(ekle, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 100, 50));

        guncelle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        guncelle.setText("GUNCELLE");
        guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncelleActionPerformed(evt);
            }
        });
        islem_panel.add(guncelle, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 100, 50));

        mesaj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mesaj.setForeground(new java.awt.Color(0, 51, 204));
        islem_panel.add(mesaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 320, 20));

        label2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 0, 0));
        label2.setText("jLabel1");
        islem_panel.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 230, 30));

        label3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 0, 0));
        label3.setText("jLabel1");
        islem_panel.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 230, 30));

        label4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label4.setForeground(new java.awt.Color(255, 0, 0));
        label4.setText("jLabel1");
        islem_panel.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 230, 30));

        label5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label5.setForeground(new java.awt.Color(255, 0, 0));
        label5.setText("jLabel1");
        islem_panel.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 230, 30));

        label6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label6.setForeground(new java.awt.Color(255, 0, 0));
        label6.setText("jLabel1");
        islem_panel.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 230, 30));

        label7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label7.setForeground(new java.awt.Color(255, 0, 0));
        label7.setText("jLabel1");
        islem_panel.add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 230, 30));

        label1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 0, 0));
        label1.setText("jLabel1");
        islem_panel.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 30));

        giris2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        islem_panel.add(giris2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 320, 30));

        giris3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        islem_panel.add(giris3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 320, 30));

        giris4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        islem_panel.add(giris4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 320, 30));

        giris5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        islem_panel.add(giris5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 320, 30));

        giris6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        islem_panel.add(giris6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 320, 30));

        giris7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        islem_panel.add(giris7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 320, 30));

        giris1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        islem_panel.add(giris1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 320, 30));

        admin_panel.add(islem_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 740, 320));

        getContentPane().add(admin_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kullanici_araKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kullanici_araKeyReleased
        String ara = kullanici_ara.getText();
        
        dinamikAra(model_kullanici,kullanici_tablosu,ara);
    }//GEN-LAST:event_kullanici_araKeyReleased

    private void sanatci_araKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sanatci_araKeyReleased
        String ara = sanatci_ara.getText();
        
        dinamikAra(model_sanatci,sanatci_tablosu,ara);
    }//GEN-LAST:event_sanatci_araKeyReleased

    private void album_araKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_album_araKeyReleased
        String ara = album_ara.getText();
        
        dinamikAra(model_album,album_tablosu,ara);
    }//GEN-LAST:event_album_araKeyReleased

    private void sarki_araKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sarki_araKeyReleased
        String ara = sarki_ara.getText();
        
        dinamikAra(model_sarki,sarki_tablosu,ara);
    }//GEN-LAST:event_sarki_araKeyReleased

    private void kullanici_duzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullanici_duzenleActionPerformed
        islem_panel.setVisible(true);
        labelTemizle();
        duzenle=1;
        
        label1.setText("ad");
        label2.setText("email");
        label3.setText("abonelik_tur");
        label4.setText("ulke");
        
        label5.setVisible(false);
        label6.setVisible(false);
        label7.setVisible(false);
        giris5.setVisible(false);
        giris6.setVisible(false);
        giris7.setVisible(false);
        
        
        
    }//GEN-LAST:event_kullanici_duzenleActionPerformed

    private void sanatci_duzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sanatci_duzenleActionPerformed
        islem_panel.setVisible(true);
        labelTemizle();
        duzenle=2;
        
        label1.setText("ad");
        label2.setText("ulke");
        
        label3.setVisible(false);
        label4.setVisible(false);
        label5.setVisible(false);
        label6.setVisible(false);
        label7.setVisible(false);
        giris3.setVisible(false);
        giris4.setVisible(false);
        giris5.setVisible(false);
        giris5.setVisible(false);
        giris6.setVisible(false);
        giris7.setVisible(false);
    }//GEN-LAST:event_sanatci_duzenleActionPerformed

    private void album_duzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_album_duzenleActionPerformed
        islem_panel.setVisible(true);
        labelTemizle();
        duzenle=3;
        
        label1.setText("ad");
        label2.setText("sanatçı");
        label3.setText("tarih");
        label4.setText("tur");
        
        label5.setVisible(false);
        label6.setVisible(false);
        label7.setVisible(false);
        giris5.setVisible(false);
        giris6.setVisible(false);
        giris7.setVisible(false);
    }//GEN-LAST:event_album_duzenleActionPerformed

    private void sarki_duzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sarki_duzenleActionPerformed
        islem_panel.setVisible(true);
        labelTemizle();
        duzenle=4;
        
        label1.setText("ad");
        label2.setText("sanatçı");
        label3.setText("albüm");
        label4.setText("tür");
        label5.setText("tarih");
        label6.setText("süre");
        label7.setText("izlenme");
        
    }//GEN-LAST:event_sarki_duzenleActionPerformed

    
    private void kullanici_tablosuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kullanici_tablosuMouseClicked
        int selectedrow = kullanici_tablosu.getSelectedRow();
        
        giris1.setText(model_kullanici.getValueAt(selectedrow,1).toString());
        giris2.setText(model_kullanici.getValueAt(selectedrow,2).toString());
        giris3.setText(model_kullanici.getValueAt(selectedrow,3).toString());
        giris4.setText(model_kullanici.getValueAt(selectedrow,4).toString());
    }//GEN-LAST:event_kullanici_tablosuMouseClicked

    private void sanatci_tablosuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sanatci_tablosuMouseClicked
        int selectedrow = sanatci_tablosu.getSelectedRow();
        
        giris1.setText(model_sanatci.getValueAt(selectedrow,1).toString());
        giris2.setText(model_sanatci.getValueAt(selectedrow,2).toString());
    }//GEN-LAST:event_sanatci_tablosuMouseClicked

    private void album_tablosuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_album_tablosuMouseClicked
        int selectedrow = album_tablosu.getSelectedRow();
        String id = model_album.getValueAt(selectedrow,0).toString();
        int id_deger=Integer.parseInt(id);
        
        giris1.setText(model_album.getValueAt(selectedrow,1).toString());
        //giris2.setText(model_album.getValueAt(selectedrow,2).toString());
        giris2.setText(Integer.toString(islemler.albumSanatciIdBul(id_deger)));
        giris3.setText(model_album.getValueAt(selectedrow,3).toString());
        giris4.setText(model_album.getValueAt(selectedrow,4).toString());
    }//GEN-LAST:event_album_tablosuMouseClicked

    private void sarki_tablosuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sarki_tablosuMouseClicked
        int selectedrow = sarki_tablosu.getSelectedRow();
        String id = model_sarki.getValueAt(selectedrow,0).toString();
        int id_deger=Integer.parseInt(id);
        
        giris1.setText(model_sarki.getValueAt(selectedrow,1).toString());
        //giris2.setText(model_sarki.getValueAt(selectedrow,2).toString());
        //giris3.setText(model_sarki.getValueAt(selectedrow,3).toString());
        giris2.setText(Integer.toString(islemler.sarkiSanatciBul(id_deger)));
        giris3.setText(Integer.toString(islemler.sarkiAlbumBul(id_deger)));
        giris4.setText(model_sarki.getValueAt(selectedrow,4).toString());
        giris5.setText(model_sarki.getValueAt(selectedrow,5).toString());
        giris6.setText(model_sarki.getValueAt(selectedrow,6).toString());
        giris7.setText(model_sarki.getValueAt(selectedrow,7).toString());
    }//GEN-LAST:event_sarki_tablosuMouseClicked

    private void guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncelleActionPerformed
        if(duzenle==1)
        {
            String ad = giris1.getText();
            String email = giris2.getText();
            String abonelik_tur = giris3.getText();
            String ulke = giris4.getText();

            int selectedrow = kullanici_tablosu.getSelectedRow();

            if (selectedrow == -1) {

                if (model_kullanici.getRowCount() == 0) {
                    mesaj.setText("Kullanıcı Tablosu şu anda boş. ");
                }
                else {
                    mesaj.setText("Lütfen güncellenecek bir kullanıcı seçiniz.");
                }
            }
            else {

                int id = (int)model_kullanici.getValueAt(selectedrow,0);

                islemler.kullaniciGuncelle(id,ad,email,abonelik_tur,ulke);

                //kullaniciGoruntule();
                sarkiGoruntule();
                sanatciGoruntule();
                kullaniciGoruntule();
                albumGoruntule();

                mesaj.setText("Çalışan başarıyla güncellendi...");
                }
        }
        
        if(duzenle==2)
        {
            String ad = giris1.getText();
            String ulke = giris2.getText();
            

            int selectedrow = sanatci_tablosu.getSelectedRow();

            if (selectedrow == -1) {

                if (model_sanatci.getRowCount() == 0) {
                    mesaj.setText("Sanatçı Tablosu şu anda boş. ");
                }
                else {
                    mesaj.setText("Lütfen güncellenecek bir sanatçı seçiniz.");
                }
            }
            else {

                int id = (int)model_sanatci.getValueAt(selectedrow,0);
                
                islemler.sanatciGuncelle(id,ad,ulke);

                //sanatciGoruntule();
                sarkiGoruntule();
                sanatciGoruntule();
                kullaniciGoruntule();
                albumGoruntule();
                
                mesaj.setText("Çalışan başarıyla güncellendi...");
                }
        }
        
        if(duzenle==3)
        {
            String ad = giris1.getText();
            String sanatci = giris2.getText();
            String tarih = giris3.getText();
            String tur = giris4.getText();

            int selectedrow = album_tablosu.getSelectedRow();

            if (selectedrow == -1) {

                if (model_album.getRowCount() == 0) {
                    mesaj.setText("Album Tablosu şu anda boş. ");
                }
                else {
                    mesaj.setText("Lütfen güncellenecek bir albüm seçiniz.");
                }
            }
            else {

                int id = (int)model_album.getValueAt(selectedrow,0);

                islemler.albumGuncelle(id,ad,sanatci,tarih,tur);

                //albumGoruntule();
                sarkiGoruntule();
                sanatciGoruntule();
                kullaniciGoruntule();
                albumGoruntule();

                mesaj.setText("Album başarıyla güncellendi...");
                }
        }
        
        if(duzenle==4)
        {
            String ad = giris1.getText();
            String sanatciId = giris2.getText();
            String albumId = giris3.getText();
            String tur = giris4.getText();
            String tarih = giris5.getText();
            String sure = giris6.getText();

            int selectedrow = sarki_tablosu.getSelectedRow();

            if (selectedrow == -1) {

                if (model_sarki.getRowCount() == 0) {
                    mesaj.setText("Şarkı Tablosu şu anda boş. ");
                }
                else {
                    mesaj.setText("Lütfen güncellenecek bir şarkı seçiniz.");
                }
            }
            else {

                int id = (int)model_sarki.getValueAt(selectedrow,0);

                islemler.sarkiGuncelle(id,ad,sanatciId,albumId,tur,tarih,sure);

                //sarkiGoruntule();
                sarkiGoruntule();
                sanatciGoruntule();
                kullaniciGoruntule();
                albumGoruntule();

                mesaj.setText("Şarkı başarıyla güncellendi...");
                }
        }
        
    }//GEN-LAST:event_guncelleActionPerformed

    private void ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleActionPerformed
        if(duzenle==1)
        {
            mesaj.setText("");
        
            String ad  =  giris1.getText();
            String email = giris2.getText();
            String abonelik_tur = giris3.getText();
            String ulke = giris4.getText();

            islemler.kullaniciEkle(ad,email,abonelik_tur,ulke);

            //kullaniciGoruntule(); // tablo guncellenir.
            sarkiGoruntule();
            sanatciGoruntule();
            kullaniciGoruntule();
            albumGoruntule();

            mesaj.setText("Yeni Kullanıcı Başarıyla Eklendi...");
        }
        
        if(duzenle==2)
        {
            mesaj.setText("");
        
            String ad  =  giris1.getText();
            String ulke = giris2.getText();

            islemler.sanatciEkle(ad,ulke);

            //sanatciGoruntule(); // tablo guncellenir.
            sarkiGoruntule();
            sanatciGoruntule();
            kullaniciGoruntule();
            albumGoruntule();

            mesaj.setText("Yeni Sanatci Başarıyla Eklendi...");
        }
        
        if(duzenle==3)
        {
            mesaj.setText("");
        
            String ad  =  giris1.getText();
            String sanatciId = giris2.getText();
            String tarih = giris3.getText();
            String tur = giris4.getText();

            islemler.albumEkle(ad,sanatciId,tarih,tur);

            //albumGoruntule(); // tablo guncellenir.
            sarkiGoruntule();
            sanatciGoruntule();
            kullaniciGoruntule();
            albumGoruntule();

            mesaj.setText("Yeni Albüm Başarıyla Eklendi...");
        }
        
        if(duzenle==4)
        {
            mesaj.setText("");
        
            String ad  =  giris1.getText();
            String sanatciId = giris2.getText();
            String albumId = giris3.getText();
            String tur = giris4.getText();
            String tarih = giris5.getText();
            String sure = giris6.getText();

            islemler.sarkiEkle_(ad,sanatciId,albumId,tur,tarih,sure);

            //sarkiGoruntule(); // tablo guncellenir.
            sarkiGoruntule();
            sanatciGoruntule();
            kullaniciGoruntule();
            albumGoruntule();

            mesaj.setText("Yeni Sarki Başarıyla Eklendi...");
        }
        
    }//GEN-LAST:event_ekleActionPerformed

    private void silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silActionPerformed
        if(duzenle==1)
        {
            mesaj.setText("");
       
            int selectedrow = kullanici_tablosu.getSelectedRow();

            if (selectedrow == -1) {
                if (model_kullanici.getRowCount() == 0 ) {
                    mesaj.setText("Kullanıcı tablosu şu anda boş...");
                }
                else {
                    mesaj.setText("Lütfen silinecek bir kullanıcı seçin...");
                }

            }
            else {
                int id = (int)model_kullanici.getValueAt(selectedrow,0);

                islemler.kullaniciSil(id);

                //kullaniciGoruntule();
                sarkiGoruntule();
                sanatciGoruntule();
                kullaniciGoruntule();
                albumGoruntule();

                mesaj.setText("Kullanıcı başarıyla silindi...");

            }
        }
        
        if(duzenle==2)
        {
            mesaj.setText("");
       
            int selectedrow = sanatci_tablosu.getSelectedRow();

            if (selectedrow == -1) {
                if (model_sanatci.getRowCount() == 0 ) {
                    mesaj.setText("Sanatçı tablosu şu anda boş...");
                }
                else {
                    mesaj.setText("Lütfen silinecek bir sanatçı seçin...");
                }

            }
            else {
                int id = (int)model_sanatci.getValueAt(selectedrow,0);

                islemler.sanatciSil(id);

                //sanatciGoruntule();
                sarkiGoruntule();
                sanatciGoruntule();
                kullaniciGoruntule();
                albumGoruntule();

                mesaj.setText("Sanatçı başarıyla silindi...");

            }
        }
        
        if(duzenle==3)
        {
            mesaj.setText("");
       
            int selectedrow = album_tablosu.getSelectedRow();

            if (selectedrow == -1) {
                if (model_album.getRowCount() == 0 ) {
                    mesaj.setText("Albüm tablosu şu anda boş...");
                }
                else {
                    mesaj.setText("Lütfen silinecek bir albüm seçin...");
                }

            }
            else {
                int id = (int)model_album.getValueAt(selectedrow,0);

                islemler.albumSil(id);

                //albumGoruntule();
                sarkiGoruntule();
                sanatciGoruntule();
                kullaniciGoruntule();
                albumGoruntule();

                mesaj.setText("Albüm başarıyla silindi...");

            }
        }
        
        if(duzenle==4)
        {
            mesaj.setText("");
       
            int selectedrow = sarki_tablosu.getSelectedRow();

            if (selectedrow == -1) {
                if (model_sarki.getRowCount() == 0 ) {
                    mesaj.setText("Şarkı tablosu şu anda boş...");
                }
                else {
                    mesaj.setText("Lütfen silinecek bir şarkı seçin...");
                }

            }
            else {
                int id = (int)model_sarki.getValueAt(selectedrow,0);

                islemler.sarkiSil(id);

                //sarkiGoruntule();
                sarkiGoruntule();
                sanatciGoruntule();
                kullaniciGoruntule();
                albumGoruntule();

                mesaj.setText("Şarkı başarıyla silindi...");

            }
        }
        
    }//GEN-LAST:event_silActionPerformed

    public void labelTemizle(){
        label2.setText("");
        label3.setText("");
        label4.setText("");
        label5.setText("");
        label6.setText("");
        label7.setText("");
        label1.setText("");
        label2.setVisible(true);
        label3.setVisible(true);
        label4.setVisible(true);
        label5.setVisible(true);
        label6.setVisible(true);
        label7.setVisible(true);
        label1.setVisible(true);
        giris1.setVisible(true);
        giris2.setVisible(true);
        giris3.setVisible(true);
        giris4.setVisible(true);
        giris5.setVisible(true);
        giris6.setVisible(true);
        giris7.setVisible(true);
    }
    
    
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
            java.util.logging.Logger.getLogger(Arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Arayuz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel admin_panel;
    private javax.swing.JTextField album_ara;
    private javax.swing.JButton album_duzenle;
    private javax.swing.JTable album_tablosu;
    private javax.swing.JButton ekle;
    private javax.swing.JTextField giris1;
    private javax.swing.JTextField giris2;
    private javax.swing.JTextField giris3;
    private javax.swing.JTextField giris4;
    private javax.swing.JTextField giris5;
    private javax.swing.JTextField giris6;
    private javax.swing.JTextField giris7;
    private javax.swing.JButton guncelle;
    private javax.swing.JPanel islem_panel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField kullanici_ara;
    private javax.swing.JButton kullanici_duzenle;
    private javax.swing.JTable kullanici_tablosu;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel mesaj;
    private javax.swing.JTextField sanatci_ara;
    private javax.swing.JButton sanatci_duzenle;
    private javax.swing.JTable sanatci_tablosu;
    private javax.swing.JTextField sarki_ara;
    private javax.swing.JButton sarki_duzenle;
    private javax.swing.JTable sarki_tablosu;
    private javax.swing.JButton sil;
    // End of variables declaration//GEN-END:variables
}
