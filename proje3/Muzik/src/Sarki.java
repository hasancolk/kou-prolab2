
public class Sarki {
    private int id;
    
    private String sarki_adi;
    
    private int tarih;
    private String ad;
    private String sanatci_adi;
    private int sanatci_id;
    
    private int album_id;
    private String album_adi;
    
    private int tur_id;
    private String tur_adi;
    
    private int sanatciId;
    private String sanatciAd;
    private int turId;
    private String turAd;
    private int albumId;
    private String albumAd;
    private int dinlenme;
    private float sure;
    
    
    private int dinlenme_sayisi;
    
    public Sarki(int id,String sarki_adi,String sanatci_adi,String album_adi,float sure,int dinlenme_sayisi){
        this.id=id;
        this.sarki_adi=sarki_adi;
        this.sanatci_adi=sanatci_adi;
        this.album_adi=album_adi;
        this.sure=sure;
        this.dinlenme_sayisi=dinlenme_sayisi;
    }
    public Sarki(int id,String sarki_adi,String sanatci_adi,String album_adi,float sure,int dinlenme_sayisi,String tur_adi){
        this.id=id;
        this.sarki_adi=sarki_adi;
        this.sanatci_adi=sanatci_adi;
        this.album_adi=album_adi;
        this.sure=sure;
        this.dinlenme_sayisi=dinlenme_sayisi;
        this.tur_adi=tur_adi;
    }
    
    public Sarki(int id, String ad, int tarih, String sanatciAd, String turAd, String albumAd, int dinlenme, float sure) {
        this.id = id;
        this.ad = ad;
        this.tarih = tarih;
        this.sanatciAd = sanatciAd;
        this.turAd = turAd;
        this.albumAd = albumAd;
        this.dinlenme = dinlenme;
        this.sure = sure;
    }

    public String getTur_adi() {
        return tur_adi;
    }

    public void setTur_adi(String tur_adi) {
        this.tur_adi = tur_adi;
    }

    public Sarki(int id, String sarki_adi, int tarih, String sanatci_adi, int sanatci_id, int album_id, String album_adi, int tur_id, String tur_adi, float sure, int dinlenme_sayisi) {
        this.id = id;
        this.sarki_adi = sarki_adi;
        this.tarih = tarih;
        this.sanatci_adi = sanatci_adi;
        this.sanatci_id = sanatci_id;
        this.album_id = album_id;
        this.album_adi = album_adi;
        this.tur_id = tur_id;
        this.tur_adi = tur_adi;
        this.sure = sure;
        this.dinlenme_sayisi = dinlenme_sayisi;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSarki_adi() {
        return sarki_adi;
    }

    public void setSarki_adi(String sarki_adi) {
        this.sarki_adi = sarki_adi;
    }

    public String getSanatci_adi() {
        return sanatci_adi;
    }

    public void setSanatci_adi(String sanatci_adi) {
        this.sanatci_adi = sanatci_adi;
    }

    public String getAlbum_adi() {
        return album_adi;
    }

    public void setAlbum_adi(String album_adi) {
        this.album_adi = album_adi;
    }

    public float getSure() {
        return sure;
    }

    public void setSure(float sure) {
        this.sure = sure;
    }

    public int getDinlenme_sayisi() {
        return dinlenme_sayisi;
    }

    public void setDinlenme_sayisi(int dinlenme_sayisi) {
        this.dinlenme_sayisi = dinlenme_sayisi;
    }
    
    

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getTarih() {
        return tarih;
    }

    public void setTarih(int tarih) {
        this.tarih = tarih;
    }

    public int getSanatciId() {
        return sanatciId;
    }

    public void setSanatciId(int sanatciId) {
        this.sanatciId = sanatciId;
    }

    public String getSanatciAd() {
        return sanatciAd;
    }

    public void setSanatciAd(String sanatciAd) {
        this.sanatciAd = sanatciAd;
    }

    public int getTurId() {
        return turId;
    }

    public void setTurId(int turId) {
        this.turId = turId;
    }

    public String getTurAd() {
        return turAd;
    }

    public void setTurAd(String turAd) {
        this.turAd = turAd;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumAd() {
        return albumAd;
    }

    public void setAlbumAd(String albumAd) {
        this.albumAd = albumAd;
    }

    public int getDinlenme() {
        return dinlenme;
    }

    public void setDinlenme(int dinlenme) {
        this.dinlenme = dinlenme;
    }

    
    
}
