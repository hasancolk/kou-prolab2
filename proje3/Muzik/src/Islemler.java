
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Islemler {

    private Connection con = null;//bağlantı objesi

    private Statement statement = null;//sql sorularını çaıştırmak için class
    //içindeki metodlar ile çalıştıracağız

    private PreparedStatement preparedStatement = null;
    private PreparedStatement preparedStatement_2 = null;
    private PreparedStatement preparedStatement2=null;
    private PreparedStatement preparedStatement3=null;

    public Islemler() {
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi + "?useUnicode=true&characterEncoding=utf8";
        //"?useUnicode=true&characterEncoding=utf8" türkçe karakterlerin eklenmesidne hata olmaması için 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("driver bulunamadi...");
        }

        try {
            con = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);
            System.out.println("Baglanti başarılı");
        } catch (SQLException ex) {
            System.out.println("Baglanti Başarısız...");
            //ex.printStackTrace();
        }
    }

    public boolean adminGirisYap(String ad, String parola) {
        String sorgu = "select * from admin where username=? and password=?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, parola);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean kullaniciGirisYap(String email, String sifre) {
        String sorgu = "select * from kullanici where email=? and sifre=?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, sifre);

            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ArrayList<Kullanici> kullaniciGetir() {
        String sorgu = "SELECT * FROM `kullanici` WHERE 1";
        ArrayList<Kullanici> sonuc = new ArrayList<>();
        try {
            preparedStatement = con.prepareStatement(sorgu);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ad = rs.getString("ad");
                String email = rs.getString("email");
                String sifre = rs.getString("sifre");
                String abonelik_tur = rs.getString("abonelik_tur");
                String ulke = rs.getString("ulke");
                sonuc.add(new Kullanici(id, ad, email, sifre, abonelik_tur, ulke));
            }
            return sonuc;
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Kullanici> kullaniciGetir(int kullanici_id) {
        String sorgu = "SELECT * FROM takip_tablo T ,kullanici K WHERE T.takipci=? AND T.takip_edilen=K.id ";
        ArrayList<Kullanici> sonuc = new ArrayList<>();
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, kullanici_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("K.id");
                String ad = rs.getString("K.ad");
                String email = rs.getString("K.email");
                String sifre = rs.getString("K.sifre");
                String abonelik_tur = rs.getString("K.abonelik_tur");
                String ulke = rs.getString("K.ulke");
                sonuc.add(new Kullanici(id, ad, email, sifre, abonelik_tur, ulke));
            }
            return sonuc;
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public String takipEt(int kullanici_id, int takip_edilecek_id) {
        int var = takipEtVarmi(kullanici_id, takip_edilecek_id);
        if (var == 0) {
            String sorgu = "INSERT INTO `takip_tablo`(`takip_edilen`, `takipci`) VALUES (?,?)";
            try {
                preparedStatement = con.prepareStatement(sorgu);
                preparedStatement.setInt(1, takip_edilecek_id);
                preparedStatement.setInt(2, kullanici_id);
                preparedStatement.executeUpdate();
                return "Takip Etme Basarili";
            } catch (SQLException ex) {
                Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
                return "Hata";
            }
        }else if(var!=0){
            return"Kullanıcı zaten Takip Ediliyor";
        }
        return "Hata";
    }

    public int takipEtVarmi(int kullanici_id, int takip_edilecek_id) {
        String sorgu = "SELECT * FROM `takip_tablo` WHERE takip_edilen=? AND takipci=?";
        int var = 0;
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, takip_edilecek_id);
            preparedStatement.setInt(2, kullanici_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                var = rs.getInt("id");
            }
            return var;
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    public void takipCik(int kullanici_id, int secili_kullanici_id_takip){
        String sorgu="DELETE FROM `takip_tablo` WHERE takip_edilen=? AND takipci=?";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1,secili_kullanici_id_takip);
            preparedStatement.setInt(2,kullanici_id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int kullaniciID(String email, String sifre) {
        String sorgu = "select * from kullanici where email=? and sifre=?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, sifre);

            ResultSet rs = preparedStatement.executeQuery();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt("id");
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int kayitKullaniciVarmi(String email) {
        String sorgu = "SELECT * FROM kullanici WHERE email=?";
        int sonuc = 0;
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sonuc = rs.getInt("id");
            }
            return sonuc;
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hata verdi");
            return -1;
        }

    }

    public String kayitKullanici(String ad, String email, String sifre, String abonelik_tur, String ulke) {
        int var = kayitKullaniciVarmi(email);

        if (var == 0) {
            //yoksa

            String sorgu = "INSERT INTO `kullanici`( `ad`, `email`, `sifre`, `abonelik_tur`, `ulke`) VALUES (?,?,?,?,?)";
            try {
                preparedStatement = con.prepareStatement(sorgu);
                preparedStatement.setString(1, ad);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, sifre);
                preparedStatement.setString(4, abonelik_tur);
                preparedStatement.setString(5, ulke);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
                return "Kullanıcı eklenemedi...";
            }
            String sorgu_2 = "INSERT INTO calma_listeleri ( `kullaniciId`, `turId`) VALUES (?, '1'), ( ?, '2'), (?, '3');";
            int kullanici_id = kullaniciID(email, sifre);
            try {
                preparedStatement_2 = con.prepareStatement(sorgu_2);
                preparedStatement_2.setInt(1, kullanici_id);
                preparedStatement_2.setInt(2, kullanici_id);
                preparedStatement_2.setInt(3, kullanici_id);
                preparedStatement_2.executeUpdate();
                return "Kullanici Başarıyla Eklenmiştir...";
            } catch (SQLException ex) {
                Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
                return "Çalma listeleri olusturulamadı";
            }
        } else {
            //varsa
            return "Bu email kayıtlıdır başka bir email ile deneyiniz...";
        }
    }

    public ArrayList<Sarki> sarkiListe(int kullanici_id, String liste_tur) {
        String sorgu = "SELECT * FROM sarki S ,sanatci SN ,album A,tur T "
                + "WHERE T.id=S.tur_id AND S.album_id=A.id AND S.sanatci_id=SN.id AND S.id IN(SELECT sarkiId FROM sarki_ekleme WHERE calmaListesiId IN "
                + "(SELECT id FROM `calma_listeleri` WHERE kullaniciId =? AND turId IN(SELECT id FROM tur WHERE tur=?)))";
        ArrayList<Sarki> sonuc = new ArrayList<>();

        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, kullanici_id);
            preparedStatement.setString(2, liste_tur);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("S.id");
                String sarki_adi = rs.getString("S.ad");
                int tarih = rs.getInt("tarih");
                String sanatci_adi = rs.getString("SN.ad");
                int sanatci_id = rs.getInt("sanatci_id");
                int album_id = rs.getInt("album_id");
                String album_adi = rs.getString("A.ad");
                int tur_id = rs.getInt("tur_id");
                String tur_adi = rs.getString("T.tur");
                float sure = rs.getFloat("S.sure");
                int dinlenme_sayisi = rs.getInt("S.dinleme_sayisi");
                sonuc.add(new Sarki(id, sarki_adi, tarih, sanatci_adi, sanatci_id, album_id, album_adi, tur_id, tur_adi, sure, dinlenme_sayisi));
            }
            return sonuc;
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return sonuc;
        }
    }

    public void sarkiOynat(int sarki_id) {
        String sorgu = "UPDATE `sarki` SET dinleme_sayisi=dinleme_sayisi+1 WHERE id=?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, sarki_id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Sarki> sarkiListeTop10Genel() {
        String sorgu = "SELECT * FROM sarki S ,sanatci SN ,album A ,tur T "
                + " WHERE S.tur_id=T.id AND S.sanatci_id=SN.id AND A.id=S.album_id ORDER BY S.dinleme_sayisi DESC LIMIT 10";
        ArrayList<Sarki> sonuc = new ArrayList<>();

        try {
            preparedStatement = con.prepareStatement(sorgu);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("S.id");
                String sarki_adi = rs.getString("S.ad");
                int tarih = rs.getInt("tarih");
                String sanatci_adi = rs.getString("SN.ad");
                int sanatci_id = rs.getInt("sanatci_id");
                int album_id = rs.getInt("album_id");
                String album_adi = rs.getString("A.ad");
                int tur_id = rs.getInt("tur_id");
                String tur_adi = rs.getString("T.tur");
                float sure = rs.getFloat("S.sure");
                int dinlenme_sayisi = rs.getInt("S.dinleme_sayisi");
                sonuc.add(new Sarki(id, sarki_adi, tarih, sanatci_adi, sanatci_id, album_id, album_adi, tur_id, tur_adi, sure, dinlenme_sayisi));
            }
            return sonuc;
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return sonuc;
        }
    }

    public String sarkiKaldir(int kullanici_id, int sarki_id) {

        String tur = "";
        String sorgu = "DELETE FROM sarki_ekleme WHERE sarki_ekleme.sarkiId=? AND "
                + "sarki_ekleme.calmaListesiId "
                + " IN(SELECT C.id FROM calma_listeleri C,sarki S WHERE C.kullaniciId=? AND S.tur_id=C.turId AND S.id=?)";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, sarki_id);
            preparedStatement.setInt(2, kullanici_id);
            preparedStatement.setInt(3, sarki_id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sorgu2 = "SELECT tur FROM sarki S,tur T WHERE S.id=? AND S.tur_id=T.id";
        try {
            preparedStatement = con.prepareStatement(sorgu2);
            preparedStatement.setInt(1, sarki_id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                tur = rs.getString("tur");
            }
            return tur;

        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return tur;
        }

    }

    public ArrayList<Sarki> sarkiListe() {
        String sorgu = "SELECT * FROM sarki S ,sanatci SN ,album A ,tur T WHERE S.tur_id=T.id AND S.sanatci_id=SN.id AND A.id=S.album_id";
        ArrayList<Sarki> sonuc = new ArrayList<>();

        try {
            preparedStatement = con.prepareStatement(sorgu);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("S.id");
                String sarki_adi = rs.getString("S.ad");
                int tarih = rs.getInt("tarih");
                String sanatci_adi = rs.getString("SN.ad");
                int sanatci_id = rs.getInt("sanatci_id");
                int album_id = rs.getInt("album_id");
                String album_adi = rs.getString("A.ad");
                int tur_id = rs.getInt("tur_id");
                String tur_adi = rs.getString("T.tur");
                float sure = rs.getFloat("S.sure");
                int dinlenme_sayisi = rs.getInt("S.dinleme_sayisi");
                sonuc.add(new Sarki(id, sarki_adi, tarih, sanatci_adi, sanatci_id, album_id, album_adi, tur_id, tur_adi, sure, dinlenme_sayisi));
            }
            return sonuc;
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return sonuc;
        }
    }

    public ArrayList<Sarki> sarkiListe(String liste_tur) {
        String sorgu = "SELECT * FROM sarki S ,sanatci SN ,album A ,tur T "
                + " WHERE S.tur_id=T.id AND S.sanatci_id=SN.id AND A.id=S.album_id AND T.tur=? ORDER BY S.dinleme_sayisi DESC LIMIT 10";
        ArrayList<Sarki> sonuc = new ArrayList<>();

        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, liste_tur);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("S.id");
                String sarki_adi = rs.getString("S.ad");
                int tarih = rs.getInt("tarih");
                String sanatci_adi = rs.getString("SN.ad");
                int sanatci_id = rs.getInt("sanatci_id");
                int album_id = rs.getInt("album_id");
                String album_adi = rs.getString("A.ad");
                int tur_id = rs.getInt("tur_id");
                String tur_adi = rs.getString("T.tur");
                float sure = rs.getFloat("S.sure");
                int dinlenme_sayisi = rs.getInt("S.dinleme_sayisi");
                sonuc.add(new Sarki(id, sarki_adi, tarih, sanatci_adi, sanatci_id, album_id, album_adi, tur_id, tur_adi, sure, dinlenme_sayisi));
            }
            return sonuc;
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return sonuc;
        }
    }

    public ArrayList<Sarki> sarkiListeUlke(String ulke) {
        String sorgu = "SELECT * FROM sarki S ,sanatci SN ,album A,tur T"
                + " WHERE S.tur_id=A.tur_id AND Sn.id=S.sanatci_id AND A.id=S.album_id AND S.tur_id=T.id AND SN.ülke=? "
                + " ORDER BY S.dinleme_sayisi DESC LIMIT 10";

        ArrayList<Sarki> sonuc = new ArrayList<>();

        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, ulke);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("S.id");
                String sarki_adi = rs.getString("S.ad");
                int tarih = rs.getInt("tarih");
                String sanatci_adi = rs.getString("SN.ad");
                int sanatci_id = rs.getInt("sanatci_id");
                int album_id = rs.getInt("album_id");
                String album_adi = rs.getString("A.ad");
                int tur_id = rs.getInt("tur_id");
                String tur_adi = rs.getString("T.tur");
                float sure = rs.getFloat("S.sure");
                int dinlenme_sayisi = rs.getInt("S.dinleme_sayisi");
                sonuc.add(new Sarki(id, sarki_adi, tarih, sanatci_adi, sanatci_id, album_id, album_adi, tur_id, tur_adi, sure, dinlenme_sayisi));
            }
            return sonuc;
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return sonuc;
        }
    }

    public void sarkiEkle(int kullanici_id, int sarki_id) {
        boolean var = sarkiVarmi(kullanici_id, sarki_id);
        int calma_listesi_id = 0;
        String sorgu = "SELECT C.id FROM sarki S ,calma_listeleri C WHERE S.id=? AND S.tur_id=C.turId AND C.kullaniciId=?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, sarki_id);
            preparedStatement.setInt(2, kullanici_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                calma_listesi_id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!var) {

            String sorgu2 = "INSERT INTO `sarki_ekleme` (`calmaListesiId`, `sarkiId`) VALUES (?,?)";
            try {
                preparedStatement_2 = con.prepareStatement(sorgu2);
                preparedStatement_2.setInt(1, calma_listesi_id);
                preparedStatement_2.setInt(2, sarki_id);
                preparedStatement_2.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String seciliSarkiTur(int id) {
        String sorgu = "SELECT T.tur FROM sarki S ,tur T WHERE S.id=? AND T.id=S.tur_id";
        String tur = "";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                tur = rs.getString("tur");
            }
            return tur;
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return tur;
        }

    }

    public boolean sarkiVarmi(int kullanici_id, int sarki_id) {

        String sorgu = "SELECT * FROM sarki S ,calma_listeleri C,sarki_ekleme Se "
                + "WHERE S.id=? AND S.tur_id=C.turId AND C.kullaniciId=? AND S.id=Se.sarkiId AND Se.calmaListesiId=C.id";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, sarki_id);
            preparedStatement.setInt(2, kullanici_id);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public ArrayList<Sanatci> sanatcilariGetir() {
        
        ArrayList<Sanatci> cikti = new ArrayList<Sanatci>();
        
        try {
            statement =  con.createStatement();
            String sorgu =  "Select * From sanatci";
            
            ResultSet rs =  statement.executeQuery(sorgu);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String ad = rs.getString("ad");
                String ulke = rs.getString("ülke");
                
                cikti.add(new Sanatci(id, ad, ulke));
                
            }
            return cikti;
           
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
        
    }
    
    public ArrayList<Kullanici> kullanicilariGetir(){
        
        ArrayList<Kullanici> cikti = new ArrayList<Kullanici>();
        
        try {
            statement = con.createStatement();
            String sorgu = "Select * From kullanici";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String ad = rs.getString("ad");
                String email = rs.getString("email");
                String sifre = rs.getString("sifre");
                String abonelik_tur = rs.getString("abonelik_tur");
                String ulke = rs.getString("ulke");
                
                cikti.add(new Kullanici(id, ad, email , sifre , abonelik_tur , ulke));
            }
            
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ArrayList<Album> albumleriGetir(){
        
        ArrayList<Album> cikti = new ArrayList<Album>();
        
        try {
            statement = con.createStatement();
            String sorgu = "Select * From album A,sanatci S,tur T Where A.sanatci_id=S.id and T.id=A.tur_id";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int id = rs.getInt("A.id");
                String ad = rs.getString("A.ad");
                String sanatciAd = rs.getString("S.ad");
                int tarih = rs.getInt("A.tarih");
                String turAd = rs.getString("T.tur");
                
                cikti.add(new Album(id, ad, sanatciAd , tarih , turAd));
            }
            
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ArrayList<Sarki> sarkilariGetir(){
        
        ArrayList<Sarki> cikti = new ArrayList<Sarki>();
        
        try {
            statement = con.createStatement();
            String sorgu = "select * from sarki,tur T,sanatci,album A where sarki.tur_id=T.id and sarki.sanatci_id=sanatci.id and sarki.album_id=A.id";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int id = rs.getInt("sarki.id");
                String ad = rs.getString("sarki.ad");
                String sanatciAd = rs.getString("sanatci.ad");
                int tarih = rs.getInt("sarki.tarih");
                String turAd = rs.getString("T.tur");
                String albumAd = rs.getString("A.ad");
                int dinlenme = rs.getInt("dinleme_sayisi");
                float sure = rs.getFloat("sure");
                
                cikti.add(new Sarki(id,  ad,  tarih,  sanatciAd,  turAd,  albumAd,  dinlenme,  sure));
            }
            
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public void kullaniciGuncelle(int id,String ad,String email,String abonelik_tur,String ulke){
        String sorgu =  "Update kullanici set ad = ? , email = ? , abonelik_tur = ? , ulke = ? where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1,ad);
            preparedStatement.setString(2,email);
            
            preparedStatement.setString(3,abonelik_tur);
            preparedStatement.setString(4,ulke);
            
            preparedStatement.setInt(5, id);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sanatciGuncelle(int id,String ad,String ulke){
        String sorgu =  "Update sanatci set ad = ? , ülke = ? where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1,ad);
            preparedStatement.setString(2,ulke);
            
            preparedStatement.setInt(3, id);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void albumGuncelle(int id,String ad,String sanatci,String tarih,String tur){
        String sorgu =  "Update album set ad = ? , sanatci_id = ? , tarih = ? , tur_id = ? where id = ?";
        String sorgu3 = "select * from tur where tur=?";
        
        try {
            int turId=0;
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement3 = con.prepareStatement(sorgu3);
            preparedStatement3.setString(1, tur);
            ResultSet rs =  preparedStatement3.executeQuery();
            
            while(rs.next()) {
                turId = rs.getInt("id");
            }
            
            preparedStatement.setString(1,ad);
            preparedStatement.setString(2,sanatci);
            
            preparedStatement.setString(3,tarih);
            preparedStatement.setInt(4,turId);
            
            preparedStatement.setInt(5, id);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sarkiGuncelle(int id,String ad,String sanatciId,String albumId,String tur,String tarih,String sure){
        String sorgu =  "Update sarki set ad = ? , sanatci_id = ? , album_id = ? , tur_id = ? , tarih = ? , sure = ? where id = ?";
        String sorgu2 = "select * from album where id = ?";
        String sorgu3 = "select * from tur where tur=?";
        
        try {
            int turId=0;
            int album_sanatciId=0;
            int album_turId=0;
            
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement2 = con.prepareStatement(sorgu2);
            preparedStatement2.setString(1, albumId);
            ResultSet rs =  preparedStatement2.executeQuery();
            
            while(rs.next()) {
                album_sanatciId = rs.getInt("sanatci_id");
                album_turId = rs.getInt("tur_id");
            }
            
            preparedStatement3 = con.prepareStatement(sorgu3);
            preparedStatement3.setString(1, tur);
            rs =  preparedStatement3.executeQuery();
            
            while(rs.next()) {
                turId = rs.getInt("id");
            }
            
            preparedStatement.setString(1,ad);
            preparedStatement.setString(2,sanatciId);
            preparedStatement.setString(3,albumId);
            preparedStatement.setInt(4,turId);
            preparedStatement.setString(5,tarih);
            preparedStatement.setString(6,sure);
            
            preparedStatement.setInt(7, id);
            
            if(Integer.parseInt(sanatciId)==album_sanatciId && turId==album_turId)
                preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void kullaniciEkle(String ad,String email,String abonelik_tur,String ulke) {
        
        String sorgu = "Insert Into kullanici (ad,email,abonelik_tur,ulke,sifre) VALUES(?,?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, abonelik_tur);
            preparedStatement.setString(4, ulke);
            preparedStatement.setString(5, "1234");
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sanatciEkle(String ad,String ulke) {
        
        String sorgu = "Insert Into sanatci (ad,ülke) VALUES(?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, ulke);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void albumEkle(String ad,String sanatciId,String tarih,String tur) {
        
        String sorgu1 = "Insert Into album (ad,sanatci_id,tarih,tur_id) VALUES(?,?,?,?)";
        //String sorgu2 = "select * from sanatci where ad=?"; // sanatcinin id'si alinir.
        String sorgu3 = "select * from tur where tur=?";
        
        try {
     
            int turId=0;
            
            preparedStatement = con.prepareStatement(sorgu1);
            
            /*preparedStatement2 = con.prepareStatement(sorgu2);
            preparedStatement2.setString(1, sanatci);
            ResultSet rs =  preparedStatement2.executeQuery();
            
            while(rs.next()) {
                sanatciId = rs.getInt("id");
            }*/
            
            preparedStatement3 = con.prepareStatement(sorgu3);
            preparedStatement3.setString(1, tur);
            ResultSet rs =  preparedStatement3.executeQuery();
            
            while(rs.next()) {
                turId = rs.getInt("id");
            }
            
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, sanatciId);
            preparedStatement.setString(3, tarih);
            preparedStatement.setInt(4, turId);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sarkiEkle_(String ad,String sanatciId,String albumId,String tur,String tarih,String sure) {
        
        String sorgu1 = "Insert Into sarki (ad,sanatci_id,album_id,tur_id,tarih,sure,dinleme_sayisi) VALUES(?,?,?,?,?,?,0)";
        String sorgu2 = "select * from album where id = ?";
        String sorgu3 = "select * from tur where tur=?";
        
        try {
     
            int turId=0;
            int album_sanatciId=0;
            int album_turId=0;
            
            preparedStatement = con.prepareStatement(sorgu1);
            
            preparedStatement2 = con.prepareStatement(sorgu2);
            preparedStatement2.setString(1, albumId);
            ResultSet rs =  preparedStatement2.executeQuery();
            
            while(rs.next()) {
                album_sanatciId = rs.getInt("sanatci_id");
                album_turId = rs.getInt("tur_id");
            }
            
            preparedStatement3 = con.prepareStatement(sorgu3);
            preparedStatement3.setString(1, tur);
            rs =  preparedStatement3.executeQuery();
            
            while(rs.next()) {
                turId = rs.getInt("id");
            }
            
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, sanatciId);
            preparedStatement.setString(3, albumId);
            preparedStatement.setInt(4, turId);
            preparedStatement.setString(5, tarih);
            preparedStatement.setString(6, sure);
            
            if(Integer.parseInt(sanatciId)==album_sanatciId && turId==album_turId)
                preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void kullaniciSil(int id) {
        
        String sorgu = "Delete from kullanici where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void sanatciSil(int id) {
        
        String sorgu = "Delete from sanatci where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void albumSil(int id) {
        
        String sorgu = "Delete from album where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void sarkiSil(int id) {
        
        String sorgu = "Delete from sarki where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public int albumSanatciIdBul(int id){
        try {
            String sorgu = "select * from album where album.id=?";
            int sonuc=0;
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            ResultSet rs =  preparedStatement.executeQuery();

                while(rs.next()) {
                    sonuc = rs.getInt("album.sanatci_id");
                }
            
                return sonuc;
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
         
    }
    
    public int sarkiSanatciBul(int id){
        try {
            String sorgu = "select * from sarki where sarki.id=?";
            int sonuc=0;
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            ResultSet rs =  preparedStatement.executeQuery();

                while(rs.next()) {
                    sonuc = rs.getInt("sarki.sanatci_id");
                }
            
                return sonuc;
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
         
    }
    
    public int sarkiAlbumBul(int id){
        try {
            String sorgu = "select * from sarki where sarki.id=?";
            int sonuc=0;
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            ResultSet rs =  preparedStatement.executeQuery();

                while(rs.next()) {
                    sonuc = rs.getInt("sarki.album_id");
                }
            
                return sonuc;
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
         
    }
    
}
