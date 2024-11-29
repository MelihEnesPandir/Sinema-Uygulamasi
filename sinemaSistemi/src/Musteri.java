public class Musteri {
    private int id;
    private String ad;
    private String email;
    private String telno;

    // Yapıcı metod (constructor) ID dahil olmak üzere 4 parametre kabul eder
    public Musteri(int id, String ad, String email, String telno) {
        this.id = id;
        this.ad = ad;
        this.email = email;
        this.telno = telno;
    }

    // Getter ve Setter metodları
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

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    // Müşteri bilgilerini yazdırmak için bir metod
    public void bilgiGoster() {
        System.out.println("Müşteri ID: " + id);
        System.out.println("Müşteri Adı: " + ad);
        System.out.println("Müşteri Email: " + email);
        System.out.println("Müşteri Telefon Numarası: " + telno);  // Telefon numarası bilgisi eklenmiş
    }
}
