import java.util.*;

public class SinemaUygulamasi {

    private static List<Salon> salonlar = new ArrayList<>();
    private static List<Musteri> musteriler = new ArrayList<>();
    private static int musteriIdCounter = 100; // Başlangıç ID'si 100'den başlar

    public static void main(String[] args) {
        // Filmleri oluşturuyoruz
        Film film1 = new Film("Titanic", 195, "Romantik");
        Film film2 = new Film("Avatar", 162, "Bilim Kurgu");
        Film film3 = new Film("The Dark Knight", 152, "Aksiyon");
        Film film4 = new Film("Inception", 148, "Bilim Kurgu");
        Film film5 = new Film("Forrest Gump", 142, "Dram");
        Film film6 = new Film("Interstellar", 169, "Bilim Kurgu");
        Film film7 = new Film("The Godfather", 175, "Suç");
        Film film8 = new Film("The Matrix", 136, "Bilim Kurgu");
        Film film9 = new Film("The Shawshank Redemption", 142, "Dram");
        Film film10 = new Film("Pulp Fiction", 154, "Suç");

        // Salonları oluşturuyoruz
        Salon salon1 = new Salon(1, "Salon 1");
        Salon salon2 = new Salon(2, "Salon 2");
        Salon salon3 = new Salon(3, "Salon 3");
        Salon salon4 = new Salon(4, "Salon 4");
        Salon salon5 = new Salon(5, "Salon 5");

        // Film ve saatleri ekliyoruz
        salon1.filmEkle(film1, Arrays.asList("12:00", "16:00", "20:00"));
        salon1.filmEkle(film2, Arrays.asList("10:00", "14:00", "18:00"));

        salon2.filmEkle(film3, Arrays.asList("12:00", "16:00", "20:00"));
        salon2.filmEkle(film4, Arrays.asList("10:00", "14:00", "18:00"));

        salon3.filmEkle(film5, Arrays.asList("12:00", "16:00", "20:00"));
        salon3.filmEkle(film6, Arrays.asList("10:00", "14:00", "18:00"));

        salon4.filmEkle(film7, Arrays.asList("13:00", "17:00", "21:00"));
        salon4.filmEkle(film8, Arrays.asList("11:00", "15:00", "19:00"));

        salon5.filmEkle(film9, Arrays.asList("13:00", "17:00", "21:00"));
        salon5.filmEkle(film10, Arrays.asList("11:00", "15:00", "19:00"));

        // Salonları listeye ekliyoruz
        salonlar.add(salon1);
        salonlar.add(salon2);
        salonlar.add(salon3);
        salonlar.add(salon4);
        salonlar.add(salon5);

        // Kullanıcı etkileşimi başlatılıyor
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Yeni Müşteri Ekle");
            System.out.println("2. Salonları ve Gösterim Bilgilerini Görüntüle");
            System.out.println("3. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); // buffer temizleme

            switch (secim) {
                case 1:
                    // Müşteri ekleme
                    System.out.print("Müşteri Adı: ");
                    String ad = scanner.nextLine();
                    System.out.print("Müşteri Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Müşteri Telefon Numarası: ");
                    String telno = scanner.nextLine();
                    Musteri yeniMusteri = new Musteri(musteriIdCounter++, ad, email, telno);

                    // Salonlar ve gösterim bilgilerini bir kez göster
                    System.out.println("Mevcut salonlar ve gösterim bilgileri:");
                    for (Salon salon : salonlar) {
                        salon.bilgiGoster();  // Salon bilgilerini yazdır
                        System.out.println();
                    }

                    // Kullanıcıdan salon ID'si alınacak
                    System.out.print("Hangi salona kaydolmak istersiniz? (Salon ID): ");
                    int salonId = scanner.nextInt();
                    scanner.nextLine(); // buffer temizleme

                    // Seçilen salonu bul
                    Salon secilenSalon = salonlar.stream()
                            .filter(salon -> salon.getId() == salonId)
                            .findFirst()
                            .orElse(null);

                    if (secilenSalon != null) {
                        System.out.println("Bu salonda gösterilen filmler:");
                        int filmIndex = 1;
                        for (Film film : secilenSalon.getFilmVeSaatler().keySet()) {
                            System.out.println(filmIndex + ". " + film.getName());
                            filmIndex++;
                        }

                        // Kullanıcı film seçimi yapacak
                        System.out.print("Hangi filmi izlemek istersiniz? (Numara): ");
                        int filmSecim = scanner.nextInt();
                        scanner.nextLine(); // buffer temizleme

                        // Film seçimi
                        Film secilenFilm = (Film) secilenSalon.getFilmVeSaatler().keySet().toArray()[filmSecim - 1];

                        System.out.print("Seçilen film için saatleri gösteriyorum: ");
                        List<String> saatler = secilenSalon.getFilmVeSaatler().get(secilenFilm);
                        System.out.println(saatler);
                        System.out.print("Hangi saati tercih ediyorsunuz?  (1, 2, 3): ");
                        String saatSecimi = scanner.nextLine();

                        // Müşteri kaydı yapılıyor
                        secilenSalon.kayitOl(yeniMusteri);
                    } else {
                        System.out.println("Geçersiz salon ID.");
                    }
                    break;

                case 2:
                    // Salonlar ve film bilgileri
                    for (Salon salon : salonlar) {
                        salon.bilgiGoster();
                        System.out.println();
                    }
                    break;

                case 3:
                    // Çıkış
                    System.out.println("Çıkış yapılıyor...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Geçersiz seçim, tekrar deneyin.");
            }
        }
    }

    public static List<Salon> getSalonlar() {
        return salonlar;
    }
}
