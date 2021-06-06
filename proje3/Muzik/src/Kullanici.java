
public class Kullanici {
    private int id;
    private String ad;
    private String email;
    private String sifre;
    private String abonelik_tur;
    private String ulke;

    public Kullanici(int id, String ad, String email, String sifre, String abonelik_tur, String ulke) {
        this.id= id;
        this.ad = ad;
        this.email = email;
        this.sifre = sifre;
        this.abonelik_tur = abonelik_tur;
        this.ulke = ulke;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getAbonelik_tur() {
        return abonelik_tur;
    }

    public void setAbonelik_tur(String abonelik_tur) {
        this.abonelik_tur = abonelik_tur;
    }

    public String getUlke() {
        return ulke;
    }

    public void setUlke(String ulke) {
        this.ulke = ulke;
    }
    
}
