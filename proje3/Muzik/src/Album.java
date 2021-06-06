
public class Album {
    
    private int id;
    private String ad;
    private int sanatciId;
    private String sanatciAd;
    private int tarih;
    private int turId;
    private String turAd;

    public Album(int id, String ad, String sanatciAd, int tarih, String turAd) {
        this.id = id;
        this.ad = ad;
        this.sanatciAd = sanatciAd;
        this.tarih = tarih;
        this.turAd = turAd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
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

    public int getTarih() {
        return tarih;
    }

    public void setTarih(int tarih) {
        this.tarih = tarih;
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
    
    
    
    
    
    
}
