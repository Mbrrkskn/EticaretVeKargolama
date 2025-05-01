package eticaret;

        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Müşteri bilgisi
        System.out.print("Musterı adı: ");
        String ad = scanner.nextLine();

        System.out.print("Teslımat adresı: ");
        String adres = scanner.nextLine();

        Musterı musteri = new Musterı(ad, adres);
        Sıparıs siparis = new Sıparıs(musteri);

        //System.out.println("\nUrun eklemeye baslayalım!");

        while (true) {
            System.out.println("\nUrun kategorısı secın:");
            System.out.println("1 - Kıyafet");
            System.out.println("2 - Ayakkabı");
            System.out.println("3 - Takı");
            System.out.println("4 - Hobı Urunu");
            System.out.println("0 - Bıtır");

            int secim;
            try {
                System.out.print("Secımınız: ");
                secim = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Uyarı: Lutfen gecerlı bır rakam gırın (0-4)!");
                continue;
            }

            if (secim == 0) {
                System.out.println("Urun ekleme sona erdı.");
                break;
            }
            if (secim < 1 || secim > 4) {
                System.out.println("Uyarı: Hatalı secım! Lutfen 1-4 arasında bır rakam gırın.");
                continue;
            }

            System.out.print("Urun adı: ");
            String urunAdi = scanner.nextLine();

            double fiyat;
            try {
                System.out.print("Fıyat: ");
                fiyat = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Uyarı: Gecersız fıyat gırdınız!");
                continue;
            }

            Urun urun = null;

            switch (secim) {
                case 1 -> {
                    System.out.print("Beden (S/M/L): ");
                    String beden = scanner.nextLine();
                    urun = new Kıyafet(urunAdi, fiyat, beden);
                }
                case 2 -> {
                    System.out.print("Numara (örn: 37): ");
                    int numara;
                    try {
                        numara = Integer.parseInt(scanner.nextLine());
                        urun = new Ayakkabı(urunAdi, fiyat, numara);
                    } catch (NumberFormatException e) {
                        System.out.println("Uyarı: Gecersız numara!");
                    }
                }
                case 3 -> {
                    System.out.print("Malzeme (örn: Altın, Gumus): ");
                    String malzeme = scanner.nextLine();
                    urun = new Takı(urunAdi, fiyat, malzeme);
                }
                case 4 -> {
                    System.out.print("Hobı Turu (örn: Puzzle, Drone): ");
                    String tur = scanner.nextLine();
                    urun = new HobıUrunu(urunAdi, fiyat, tur);
                }
                default -> System.out.println("Gecersız secım.");
            }

            if (urun != null) {
                siparis.urunEkle(urun);
                System.out.println("Urun eklendı: " + urun.getAd());
            } else {
                System.out.println("Uyari: Urun olusturulamadi, tekrar deneyin.");
            }
        }

        // Sipariş özeti
        siparis.siparisOzet();

        // İndirim uygulama
        System.out.print("\nIndırım oranı gırınız (%): ");
        try {
            double indirim = Double.parseDouble(scanner.nextLine());
            siparis.indirimUygula(indirim);
            System.out.println("%" + indirim + " ındırım uygulandı!");
        }catch (NumberFormatException e) {
            System.out.println("Uyarı: Indırım uygulanamadı, gecersız oran.");
        }

        // Güncel sipariş özeti
        siparis.siparisOzet();

        // Kargo işlemleri
        System.out.println("\nKargo surecı baslatılıyor...");
        siparis.kargoyaVer();
        siparis.kargoDurumuGuncelle(KargoDurumu.TESLIM_EDILDI);

        siparis.siparisOzet();

        scanner.close();
    }
}

