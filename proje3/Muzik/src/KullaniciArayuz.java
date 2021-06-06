
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author teyfi
 */
public class KullaniciArayuz extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model_tum_sarkilar = new DefaultTableModel();
    DefaultTableModel model_top10_tur = new DefaultTableModel();
    DefaultTableModel model_top_10_ulke = new DefaultTableModel();
    DefaultTableModel model_tablo_kullanici = new DefaultTableModel();
    DefaultTableModel model_tablo_sarki_takip_edilen = new DefaultTableModel();
    DefaultTableModel model_tablo_takip_edilen = new DefaultTableModel();

    ArrayList<Kullanici> kullanicilar = new ArrayList<>();
    ArrayList<Kullanici> kullanicilar_pre = new ArrayList<>();

    ArrayList<Sarki> sarkilar = new ArrayList<>();

    Islemler islemler = new Islemler();
    private int secili_sarki_id;
    private int secili_sarki_id_takip;
    private int kullanici_id;
    private String liste_turu_kullanici;
    private String liste_turu_top_10;
    private int secili_kullanici_id;
    private String secili_kullanici_tur;
    private int secili_kullanici_id_takip=0;
    private String secili_kullanici_tur_takip;
    ArrayList<Sarki> sarkilar_tum = new ArrayList<>();
    ArrayList<Sarki> sarkilar_top10_tur = new ArrayList<>();
    ArrayList<Sarki> sarkilar_takip=new ArrayList<>();

    /**
     * Creates new form KullaniciArayuz
     */
    public KullaniciArayuz() {
        initComponents();

    }

    public KullaniciArayuz(int kullanici_id) {

        initComponents();
        this.kullanici_id = kullanici_id;
        this.setResizable(false);
        this.setSize(1400, 800);

        panel_kullanici.setSize(1400, 800);
        panel_kullanici.setFocusable(true);
        panel_kullanici.setVisible(true);

        panel_takip.setSize(1400, 800);
        panel_takip.setFocusable(false);
        panel_takip.setVisible(false);

        model = (DefaultTableModel) tablo_kullanıcı.getModel();
        model_tum_sarkilar = (DefaultTableModel) tablo_tum_sarkilar.getModel();
        model_top10_tur = (DefaultTableModel) tablo_top10_tur.getModel();

        model_tablo_kullanici = (DefaultTableModel) tablo_kullanici.getModel();
        model_tablo_sarki_takip_edilen = (DefaultTableModel) tablo_sarki_takip_edilen.getModel();
        model_tablo_takip_edilen = (DefaultTableModel) tablo_kullanici_takip_edilen.getModel();
        kullaniciGoruntule(kullanici_id);
        sarkiGoruntuleTum();
        kullaniciGoruntule();

    }

    public void sarkiGoruntuleTum() {
        model_tum_sarkilar.setRowCount(0);
        sarkilar_tum = islemler.sarkiListe();
        if (sarkilar_tum != null) {
            for (Sarki sarki : sarkilar_tum) {
                Object[] eklenecek = {sarki.getSarki_adi(), sarki.getSanatci_adi(), sarki.getAlbum_adi(), sarki.getSure(), sarki.getDinlenme_sayisi(), sarki.getTur_adi()};
                model_tum_sarkilar.addRow(eklenecek);
            }
        }
    }
    public void sarkiGoruntuleTakip(String liste_tur){
        model_tablo_sarki_takip_edilen.setRowCount(0);
        sarkilar_takip=islemler.sarkiListe(secili_kullanici_id_takip,liste_tur);
        if(sarkilar_takip!=null){
            for (Sarki sarki : sarkilar_takip) {
                Object[] eklenecek = {sarki.getSarki_adi(), sarki.getSanatci_adi(), sarki.getAlbum_adi(), sarki.getSure(), sarki.getDinlenme_sayisi(), sarki.getTur_adi()};
                model_tablo_sarki_takip_edilen.addRow(eklenecek);
            }
        }
    }
    public void sarkiGoruntule(String liste_tur) {
        model.setRowCount(0);
        LabelListeTur.setText("");
        LabelListeTur.setText("KULLANICI " + liste_tur);
        sarkilar = islemler.sarkiListe(kullanici_id, liste_tur);
        if (sarkilar != null) {
            for (Sarki sarki : sarkilar) {
                Object[] eklenecek = {sarki.getSarki_adi(), sarki.getSanatci_adi(), sarki.getAlbum_adi(), sarki.getSure(), sarki.getDinlenme_sayisi(), sarki.getTur_adi()};
                model.addRow(eklenecek);
            }
        }
    }

    public void sarkiGoruntuleUlke(String ulke) {
        model_top10_tur.setRowCount(0);
        Label_top10_tur.setText("");
        Label_top10_tur.setText(ulke + " Top 10");
        sarkilar_top10_tur = islemler.sarkiListeUlke(ulke);
        if (sarkilar_top10_tur != null) {
            for (Sarki sarki : sarkilar_top10_tur) {
                Object[] eklenecek = {sarki.getSarki_adi(), sarki.getSanatci_adi(), sarki.getAlbum_adi(), sarki.getSure(), sarki.getDinlenme_sayisi(), sarki.getTur_adi()};
                model_top10_tur.addRow(eklenecek);
            }
        }
    }

    public void kullaniciGoruntule() {
        model_tablo_kullanici.setRowCount(0);
        kullanicilar = islemler.kullaniciGetir();
        if (kullanicilar != null) {
            for (Kullanici kullanici : kullanicilar) {
                Object[] eklenecek = {kullanici.getAd(), kullanici.getEmail(), kullanici.getAbonelik_tur(), kullanici.getUlke()};
                model_tablo_kullanici.addRow(eklenecek);
            }
        }

    }

    public void kullaniciGoruntule(int kullanici_id) {
        model_tablo_takip_edilen.setRowCount(0);
        kullanicilar_pre = islemler.kullaniciGetir(kullanici_id);
        if (kullanicilar_pre != null) {
            for (Kullanici kullanici : kullanicilar_pre) {
                Object[] eklenecek = {kullanici.getAd(), kullanici.getEmail(), kullanici.getAbonelik_tur(), kullanici.getUlke()};
                model_tablo_takip_edilen.addRow(eklenecek);
            }
        }
    }

    public void takipEt() {
        mesaj_panel_takip.setText("");
        if (secili_kullanici_tur.equals("nor")) {
            mesaj_panel_takip.setText("");
            mesaj_panel_takip.setText("Sadece Premium Kullanıcılar Takip Edilebilir");
        } else if (kullanici_id == secili_kullanici_id) {
            mesaj_panel_takip.setText("");
            mesaj_panel_takip.setText("Kullanıcı Kendini Takip Edemez");
        } else {
            String mesaj = islemler.takipEt(kullanici_id, secili_kullanici_id);
            mesaj_panel_takip.setText("");
            mesaj_panel_takip.setText(mesaj);
            kullaniciGoruntule(kullanici_id);
        }
    }

    public void sarkiGoruntuleTop10Genel() {
        model_top10_tur.setRowCount(0);
        Label_top10_tur.setText("");
        Label_top10_tur.setText("Genel Top 10");
        sarkilar_top10_tur = islemler.sarkiListeTop10Genel();
        if (sarkilar_top10_tur != null) {
            for (Sarki sarki : sarkilar_top10_tur) {
                Object[] eklenecek = {sarki.getSarki_adi(), sarki.getSanatci_adi(), sarki.getAlbum_adi(), sarki.getSure(), sarki.getDinlenme_sayisi(), sarki.getTur_adi()};
                model_top10_tur.addRow(eklenecek);
            }
        }
    }

    public void sarkiGoruntuleTur(String liste_tur) {
        model_top10_tur.setRowCount(0);
        Label_top10_tur.setText("");
        Label_top10_tur.setText(liste_tur + " Top 10");
        sarkilar_top10_tur = islemler.sarkiListe(liste_tur);
        if (sarkilar_top10_tur != null) {
            for (Sarki sarki : sarkilar_top10_tur) {
                Object[] eklenecek = {sarki.getSarki_adi(), sarki.getSanatci_adi(), sarki.getAlbum_adi(), sarki.getSure(), sarki.getDinlenme_sayisi(), sarki.getTur_adi()};
                model_top10_tur.addRow(eklenecek);
            }
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

        panel_kullanici = new javax.swing.JPanel();
        LabelTumSarkilar = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablo_kullanıcı = new javax.swing.JTable();
        Label_top10_tur = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablo_top10_tur = new javax.swing.JTable();
        buton_top_10_genel = new javax.swing.JButton();
        buton_pop_top10 = new javax.swing.JButton();
        buton_jazz_top10 = new javax.swing.JButton();
        buton_klasik_top10 = new javax.swing.JButton();
        buton_top_10_tr = new javax.swing.JButton();
        buton_top_10_abd = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablo_tum_sarkilar = new javax.swing.JTable();
        button_jazz = new javax.swing.JButton();
        button_pop = new javax.swing.JButton();
        buton_oynat = new javax.swing.JButton();
        button_klasik = new javax.swing.JButton();
        sarki_ekle = new javax.swing.JButton();
        sarki_kaldir = new javax.swing.JButton();
        LabelListeTur = new javax.swing.JLabel();
        buton_takip_panel = new javax.swing.JButton();
        panel_takip = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablo_kullanici = new javax.swing.JTable();
        buton_takip = new javax.swing.JButton();
        buton_ekle_takip = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablo_sarki_takip_edilen = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablo_kullanici_takip_edilen = new javax.swing.JTable();
        mesaj_panel_takip = new javax.swing.JLabel();
        buton_pop_takip = new javax.swing.JButton();
        buton_jazz_takip = new javax.swing.JButton();
        buton_klasik_takip = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buton_takipten_cik = new javax.swing.JButton();
        onceki_menu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_kullanici.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelTumSarkilar.setText("Tüm Şarkılar");
        panel_kullanici.add(LabelTumSarkilar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, 22));

        tablo_kullanıcı.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sarki", "Sanatci", "Album", "Sure", "Dinlenme", "Tür"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablo_kullanıcı.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablo_kullanıcıMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablo_kullanıcı);
        if (tablo_kullanıcı.getColumnModel().getColumnCount() > 0) {
            tablo_kullanıcı.getColumnModel().getColumn(0).setResizable(false);
            tablo_kullanıcı.getColumnModel().getColumn(1).setResizable(false);
            tablo_kullanıcı.getColumnModel().getColumn(2).setResizable(false);
            tablo_kullanıcı.getColumnModel().getColumn(3).setResizable(false);
            tablo_kullanıcı.getColumnModel().getColumn(4).setResizable(false);
            tablo_kullanıcı.getColumnModel().getColumn(5).setResizable(false);
        }

        panel_kullanici.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 440, 434, 308));
        panel_kullanici.add(Label_top10_tur, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 30, 85, 26));

        tablo_top10_tur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sarki", "Sanatci", "Album", "Sure", "Dinlenme", "Tur"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablo_top10_tur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablo_top10_turMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablo_top10_tur);
        if (tablo_top10_tur.getColumnModel().getColumnCount() > 0) {
            tablo_top10_tur.getColumnModel().getColumn(0).setResizable(false);
            tablo_top10_tur.getColumnModel().getColumn(1).setResizable(false);
            tablo_top10_tur.getColumnModel().getColumn(2).setResizable(false);
            tablo_top10_tur.getColumnModel().getColumn(3).setResizable(false);
            tablo_top10_tur.getColumnModel().getColumn(4).setResizable(false);
            tablo_top10_tur.getColumnModel().getColumn(5).setResizable(false);
        }

        panel_kullanici.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 490, 250));

        buton_top_10_genel.setText("Genel Top 10");
        buton_top_10_genel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_top_10_genelActionPerformed(evt);
            }
        });
        panel_kullanici.add(buton_top_10_genel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 60, 109, 34));

        buton_pop_top10.setText("Pop Top 10");
        buton_pop_top10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_pop_top10ActionPerformed(evt);
            }
        });
        panel_kullanici.add(buton_pop_top10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 110, 109, 33));

        buton_jazz_top10.setText("Jazz Top 10");
        buton_jazz_top10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_jazz_top10ActionPerformed(evt);
            }
        });
        panel_kullanici.add(buton_jazz_top10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 160, 109, 32));

        buton_klasik_top10.setText("Klasik Top 10");
        buton_klasik_top10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_klasik_top10ActionPerformed(evt);
            }
        });
        panel_kullanici.add(buton_klasik_top10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 210, 109, 32));

        buton_top_10_tr.setText("TR Top 10");
        buton_top_10_tr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_top_10_trActionPerformed(evt);
            }
        });
        panel_kullanici.add(buton_top_10_tr, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 310, 110, -1));

        buton_top_10_abd.setText("ABD Top 10");
        buton_top_10_abd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_top_10_abdActionPerformed(evt);
            }
        });
        panel_kullanici.add(buton_top_10_abd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 260, 109, -1));

        tablo_tum_sarkilar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sarki", "Sanatci", "Album", "Sure", "Dinlenme", "Tur"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablo_tum_sarkilar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablo_tum_sarkilarMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablo_tum_sarkilar);
        if (tablo_tum_sarkilar.getColumnModel().getColumnCount() > 0) {
            tablo_tum_sarkilar.getColumnModel().getColumn(0).setResizable(false);
            tablo_tum_sarkilar.getColumnModel().getColumn(1).setResizable(false);
            tablo_tum_sarkilar.getColumnModel().getColumn(2).setResizable(false);
            tablo_tum_sarkilar.getColumnModel().getColumn(3).setResizable(false);
            tablo_tum_sarkilar.getColumnModel().getColumn(4).setResizable(false);
            tablo_tum_sarkilar.getColumnModel().getColumn(5).setResizable(false);
        }

        panel_kullanici.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 480, 260));

        button_jazz.setText("Jazz");
        button_jazz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_jazzActionPerformed(evt);
            }
        });
        panel_kullanici.add(button_jazz, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 580, 93, 43));

        button_pop.setText("Pop");
        button_pop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_popActionPerformed(evt);
            }
        });
        panel_kullanici.add(button_pop, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, 93, 43));

        buton_oynat.setText("OYNAT");
        buton_oynat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_oynatActionPerformed(evt);
            }
        });
        panel_kullanici.add(buton_oynat, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, 133, 41));

        button_klasik.setText("Klasik");
        button_klasik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_klasikActionPerformed(evt);
            }
        });
        panel_kullanici.add(button_klasik, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 640, 93, 43));

        sarki_ekle.setText("Seçili Şarkıyı Ekle");
        sarki_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sarki_ekleActionPerformed(evt);
            }
        });
        panel_kullanici.add(sarki_ekle, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, 123, 43));

        sarki_kaldir.setText("Kaldır");
        sarki_kaldir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sarki_kaldirActionPerformed(evt);
            }
        });
        panel_kullanici.add(sarki_kaldir, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 700, 93, 44));
        panel_kullanici.add(LabelListeTur, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 400, 171, 30));

        buton_takip_panel.setText("Takip Sayfası");
        buton_takip_panel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_takip_panelActionPerformed(evt);
            }
        });
        panel_kullanici.add(buton_takip_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 170, 60));

        panel_takip.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablo_kullanici.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ad", "Email", "Abonelik Tür", "Ülke"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablo_kullanici.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablo_kullaniciMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablo_kullanici);
        if (tablo_kullanici.getColumnModel().getColumnCount() > 0) {
            tablo_kullanici.getColumnModel().getColumn(0).setResizable(false);
            tablo_kullanici.getColumnModel().getColumn(1).setResizable(false);
            tablo_kullanici.getColumnModel().getColumn(2).setResizable(false);
            tablo_kullanici.getColumnModel().getColumn(3).setResizable(false);
        }

        panel_takip.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 510, 250));

        buton_takip.setText("Takip Et");
        buton_takip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_takipActionPerformed(evt);
            }
        });
        panel_takip.add(buton_takip, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 180, 70));

        buton_ekle_takip.setText("Ekle");
        buton_ekle_takip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_ekle_takipActionPerformed(evt);
            }
        });
        panel_takip.add(buton_ekle_takip, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 270, 180, 80));

        tablo_sarki_takip_edilen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sarki", "Sanatci", "Album", "Sure", "Dinlenme", "Tür"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablo_sarki_takip_edilen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablo_sarki_takip_edilenMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablo_sarki_takip_edilen);
        if (tablo_sarki_takip_edilen.getColumnModel().getColumnCount() > 0) {
            tablo_sarki_takip_edilen.getColumnModel().getColumn(0).setResizable(false);
            tablo_sarki_takip_edilen.getColumnModel().getColumn(1).setResizable(false);
            tablo_sarki_takip_edilen.getColumnModel().getColumn(2).setResizable(false);
            tablo_sarki_takip_edilen.getColumnModel().getColumn(3).setResizable(false);
            tablo_sarki_takip_edilen.getColumnModel().getColumn(4).setResizable(false);
            tablo_sarki_takip_edilen.getColumnModel().getColumn(5).setResizable(false);
        }

        panel_takip.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 480, 310));

        tablo_kullanici_takip_edilen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ad", "Email", "Abonelik Tür", "Ülke"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablo_kullanici_takip_edilen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablo_kullanici_takip_edilenMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tablo_kullanici_takip_edilen);
        if (tablo_kullanici_takip_edilen.getColumnModel().getColumnCount() > 0) {
            tablo_kullanici_takip_edilen.getColumnModel().getColumn(0).setResizable(false);
            tablo_kullanici_takip_edilen.getColumnModel().getColumn(1).setResizable(false);
            tablo_kullanici_takip_edilen.getColumnModel().getColumn(2).setResizable(false);
            tablo_kullanici_takip_edilen.getColumnModel().getColumn(3).setResizable(false);
        }

        panel_takip.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 510, 250));

        mesaj_panel_takip.setForeground(new java.awt.Color(255, 51, 51));
        panel_takip.add(mesaj_panel_takip, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 240, 50));

        buton_pop_takip.setText("Pop");
        buton_pop_takip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_pop_takipActionPerformed(evt);
            }
        });
        panel_takip.add(buton_pop_takip, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 50, 110, 50));

        buton_jazz_takip.setText("jazz");
        buton_jazz_takip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_jazz_takipActionPerformed(evt);
            }
        });
        panel_takip.add(buton_jazz_takip, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 120, 110, 40));

        buton_klasik_takip.setText("klasik");
        buton_klasik_takip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_klasik_takipActionPerformed(evt);
            }
        });
        panel_takip.add(buton_klasik_takip, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 180, 110, 40));

        jLabel1.setText("KULLANICILAR");
        panel_takip.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 80, 30));

        jLabel2.setText("TAKİP EDİLEN KULLANICILAR");
        panel_takip.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 404, 240, 20));

        buton_takipten_cik.setText("Takipten Çık");
        buton_takipten_cik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_takipten_cikActionPerformed(evt);
            }
        });
        panel_takip.add(buton_takipten_cik, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 200, 80));

        onceki_menu.setText("ONCEKİ MENU");
        onceki_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onceki_menuActionPerformed(evt);
            }
        });
        panel_takip.add(onceki_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 580, 210, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_kullanici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 348, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_takip, javax.swing.GroupLayout.PREFERRED_SIZE, 1400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 282, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_kullanici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 180, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_takip, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 128, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_popActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_popActionPerformed
        LabelListeTur.setText("");
        LabelListeTur.setText(" KULLANICI POP");
        sarkiGoruntule("pop");
        liste_turu_kullanici = "pop";

    }//GEN-LAST:event_button_popActionPerformed

    private void button_jazzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_jazzActionPerformed
        LabelListeTur.setText("");
        LabelListeTur.setText("KULLANICI JAZZ");
        sarkiGoruntule("jazz");
        liste_turu_kullanici = "jazz";
    }//GEN-LAST:event_button_jazzActionPerformed

    private void button_klasikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_klasikActionPerformed
        LabelListeTur.setText("");
        LabelListeTur.setText("KULLANICI KLASIK");
        sarkiGoruntule("klasik");
        liste_turu_kullanici = "klasik";
    }//GEN-LAST:event_button_klasikActionPerformed

    private void tablo_kullanıcıMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablo_kullanıcıMouseClicked
        int selectRow = tablo_kullanıcı.getSelectedRow();
        String sarki_tablo = tablo_kullanıcı.getValueAt(selectRow, 0).toString();
        String sanatci_tablo = tablo_kullanıcı.getValueAt(selectRow, 1).toString();
        for (Sarki sarki : sarkilar) {
            if (sarki.getSarki_adi().equals(sarki_tablo) && sarki.getSanatci_adi().equals(sanatci_tablo)) {
                secili_sarki_id = sarki.getId();

            }
        }
    }//GEN-LAST:event_tablo_kullanıcıMouseClicked

    private void sarki_kaldirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sarki_kaldirActionPerformed
        String tur = islemler.sarkiKaldir(kullanici_id, secili_sarki_id);
        sarkiGoruntule(tur);
    }//GEN-LAST:event_sarki_kaldirActionPerformed

    private void sarki_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sarki_ekleActionPerformed
        islemler.sarkiEkle(kullanici_id, secili_sarki_id);
        sarkiGoruntuleTum();
        String tur = islemler.seciliSarkiTur(secili_sarki_id);
        sarkiGoruntule(tur);
    }//GEN-LAST:event_sarki_ekleActionPerformed

    private void tablo_tum_sarkilarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablo_tum_sarkilarMouseClicked
        int selectRow = tablo_tum_sarkilar.getSelectedRow();
        String sarki_tablo = tablo_tum_sarkilar.getValueAt(selectRow, 0).toString();
        String sanatci_tablo = tablo_tum_sarkilar.getValueAt(selectRow, 1).toString();
        for (Sarki sarki : sarkilar_tum) {
            if (sarki.getSarki_adi().equals(sarki_tablo) && sarki.getSanatci_adi().equals(sanatci_tablo)) {
                secili_sarki_id = sarki.getId();
            }
        }
    }//GEN-LAST:event_tablo_tum_sarkilarMouseClicked

    public void sarkiOynat() {
        islemler.sarkiOynat(secili_sarki_id);
        sarkiGoruntuleTum();
        if (liste_turu_top_10 != null) {
            if (!liste_turu_top_10.equals("")) {
                if (liste_turu_top_10.equals("genel")) {
                    sarkiGoruntuleTop10Genel();
                } else if (liste_turu_top_10.equals("ABD")) {
                    sarkiGoruntuleUlke(liste_turu_top_10);
                } else if (liste_turu_top_10.equals("Türkiye")) {
                    sarkiGoruntuleUlke(liste_turu_top_10);
                } else {
                    sarkiGoruntuleTur(liste_turu_top_10);
                }
            }
        }
        if (!liste_turu_kullanici.equals("")) {
            sarkiGoruntule(liste_turu_kullanici);
        }
    }
    public void takipCik(){
        if(secili_kullanici_id_takip!=0){
            islemler.takipCik(kullanici_id,secili_kullanici_id_takip);
            kullaniciGoruntule(kullanici_id);
        }
    }
    //***************************************
    //***************TOP 10 LAR**************
    //***************************************

    private void buton_pop_top10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_pop_top10ActionPerformed
        Label_top10_tur.setText("");
        Label_top10_tur.setText(" TOP 10 POP");
        sarkiGoruntuleTur("pop");
        liste_turu_top_10 = "pop";
    }//GEN-LAST:event_buton_pop_top10ActionPerformed

    private void buton_jazz_top10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_jazz_top10ActionPerformed
        Label_top10_tur.setText("");
        Label_top10_tur.setText(" TOP 10 -JAZZ");
        sarkiGoruntuleTur("jazz");
        liste_turu_top_10 = "jazz";
    }//GEN-LAST:event_buton_jazz_top10ActionPerformed

    private void buton_klasik_top10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_klasik_top10ActionPerformed
        Label_top10_tur.setText("");
        Label_top10_tur.setText(" TOP 10 KLASİK");
        sarkiGoruntuleTur("klasik");
        liste_turu_top_10 = "klasik";
    }//GEN-LAST:event_buton_klasik_top10ActionPerformed

    private void tablo_top10_turMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablo_top10_turMouseClicked
        int selectRow = tablo_top10_tur.getSelectedRow();
        String sarki_tablo = tablo_top10_tur.getValueAt(selectRow, 0).toString();
        String sanatci_tablo = tablo_top10_tur.getValueAt(selectRow, 1).toString();
        for (Sarki sarki : sarkilar_top10_tur) {
            if (sarki.getSarki_adi().equals(sarki_tablo) && sarki.getSanatci_adi().equals(sanatci_tablo)) {
                secili_sarki_id = sarki.getId();
            }
        }
    }//GEN-LAST:event_tablo_top10_turMouseClicked

    private void buton_top_10_trActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_top_10_trActionPerformed
        Label_top10_tur.setText("");
        Label_top10_tur.setText(" TOP 10 TR");
        sarkiGoruntuleUlke("Türkiye");
        liste_turu_top_10 = "Türkiye";
    }//GEN-LAST:event_buton_top_10_trActionPerformed

    private void buton_top_10_genelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_top_10_genelActionPerformed
        Label_top10_tur.setText("");
        Label_top10_tur.setText(" TOP 10 GENEL");
        sarkiGoruntuleTop10Genel();
        liste_turu_top_10 = "genel";
    }//GEN-LAST:event_buton_top_10_genelActionPerformed

    private void buton_top_10_abdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_top_10_abdActionPerformed
        Label_top10_tur.setText("");
        Label_top10_tur.setText(" TOP 10 ABD");
        sarkiGoruntuleUlke("ABD");
        liste_turu_top_10 = "ABD";
    }//GEN-LAST:event_buton_top_10_abdActionPerformed

    private void buton_oynatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_oynatActionPerformed
        sarkiOynat();
    }//GEN-LAST:event_buton_oynatActionPerformed

    private void buton_takip_panelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_takip_panelActionPerformed
        panel_kullanici.setFocusable(false);
        panel_kullanici.setVisible(false);

        panel_takip.setVisible(true);
        panel_takip.setFocusable(true);
    }//GEN-LAST:event_buton_takip_panelActionPerformed

    private void tablo_kullaniciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablo_kullaniciMouseClicked
        int selectRow = tablo_kullanici.getSelectedRow();
        String email = tablo_kullanici.getValueAt(selectRow, 1).toString();
        for (Kullanici kullanici : kullanicilar) {
            if (kullanici.getEmail().equals(email)) {
                secili_kullanici_id = kullanici.getId();
                secili_kullanici_tur = kullanici.getAbonelik_tur();
            }
        }
    }//GEN-LAST:event_tablo_kullaniciMouseClicked

    private void buton_takipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_takipActionPerformed
        takipEt();
    }//GEN-LAST:event_buton_takipActionPerformed

    private void buton_pop_takipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_pop_takipActionPerformed
        sarkiGoruntuleTakip("pop");
    }//GEN-LAST:event_buton_pop_takipActionPerformed

    private void tablo_kullanici_takip_edilenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablo_kullanici_takip_edilenMouseClicked
        int selectRow = tablo_kullanici_takip_edilen.getSelectedRow();
        String email = tablo_kullanici_takip_edilen.getValueAt(selectRow, 1).toString();
        for (Kullanici kullanici : kullanicilar_pre) {
            if (kullanici.getEmail().equals(email)) {
                secili_kullanici_id_takip = kullanici.getId();
                secili_kullanici_tur_takip = kullanici.getAbonelik_tur();
            }
        }
    }//GEN-LAST:event_tablo_kullanici_takip_edilenMouseClicked

    private void buton_jazz_takipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_jazz_takipActionPerformed
        sarkiGoruntuleTakip("jazz");
    }//GEN-LAST:event_buton_jazz_takipActionPerformed

    private void buton_klasik_takipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_klasik_takipActionPerformed
        sarkiGoruntuleTakip("klasik");
    }//GEN-LAST:event_buton_klasik_takipActionPerformed

    private void buton_takipten_cikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_takipten_cikActionPerformed
        takipCik();
    }//GEN-LAST:event_buton_takipten_cikActionPerformed

    private void onceki_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onceki_menuActionPerformed
        panel_takip.setFocusable(false);
        panel_takip.setVisible(false);
        
        panel_kullanici.setVisible(true);
        panel_kullanici.setVisible(true);
    }//GEN-LAST:event_onceki_menuActionPerformed

    private void buton_ekle_takipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_ekle_takipActionPerformed
        islemler.sarkiEkle(kullanici_id,secili_sarki_id_takip);     
    }//GEN-LAST:event_buton_ekle_takipActionPerformed

    private void tablo_sarki_takip_edilenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablo_sarki_takip_edilenMouseClicked
        int selectRow = tablo_sarki_takip_edilen.getSelectedRow();
        String sarki_tablo = tablo_sarki_takip_edilen.getValueAt(selectRow, 0).toString();
        String sanatci_tablo = tablo_sarki_takip_edilen.getValueAt(selectRow, 1).toString();
        for (Sarki sarki : sarkilar_takip) {
            if (sarki.getSarki_adi().equals(sarki_tablo) && sarki.getSanatci_adi().equals(sanatci_tablo)) {
                secili_sarki_id_takip = sarki.getId();
            }
        }
    }//GEN-LAST:event_tablo_sarki_takip_edilenMouseClicked
    //***************************************
    //***************TOP 10 LAR**************
    //***************************************

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
            java.util.logging.Logger.getLogger(KullaniciArayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KullaniciArayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KullaniciArayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KullaniciArayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KullaniciArayuz().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelListeTur;
    private javax.swing.JLabel LabelTumSarkilar;
    private javax.swing.JLabel Label_top10_tur;
    private javax.swing.JButton buton_ekle_takip;
    private javax.swing.JButton buton_jazz_takip;
    private javax.swing.JButton buton_jazz_top10;
    private javax.swing.JButton buton_klasik_takip;
    private javax.swing.JButton buton_klasik_top10;
    private javax.swing.JButton buton_oynat;
    private javax.swing.JButton buton_pop_takip;
    private javax.swing.JButton buton_pop_top10;
    private javax.swing.JButton buton_takip;
    private javax.swing.JButton buton_takip_panel;
    private javax.swing.JButton buton_takipten_cik;
    private javax.swing.JButton buton_top_10_abd;
    private javax.swing.JButton buton_top_10_genel;
    private javax.swing.JButton buton_top_10_tr;
    private javax.swing.JButton button_jazz;
    private javax.swing.JButton button_klasik;
    private javax.swing.JButton button_pop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel mesaj_panel_takip;
    private javax.swing.JButton onceki_menu;
    private javax.swing.JPanel panel_kullanici;
    private javax.swing.JPanel panel_takip;
    private javax.swing.JButton sarki_ekle;
    private javax.swing.JButton sarki_kaldir;
    private javax.swing.JTable tablo_kullanici;
    private javax.swing.JTable tablo_kullanici_takip_edilen;
    private javax.swing.JTable tablo_kullanıcı;
    private javax.swing.JTable tablo_sarki_takip_edilen;
    private javax.swing.JTable tablo_top10_tur;
    private javax.swing.JTable tablo_tum_sarkilar;
    // End of variables declaration//GEN-END:variables
}
