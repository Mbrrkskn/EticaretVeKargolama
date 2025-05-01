package eticaret;

import java.util.*;

public class Sıparıs {
    private Musterı musteri;
    private List<Urun> urunler = new ArrayList<>();
    private KargoDurumu kargoDurumu = KargoDurumu.HAZIRLANIYOR;

    public Sıparıs(Musterı musteri) {
        this.musteri = musteri;
    }

    public void urunEkle(Urun urun) {
        urunler.add(urun);
    }

    public void indirimUygula(double oran) {
        for (Urun urun : urunler) {
            urun.indirimUygula(oran);
        }
    }

    public void kargoyaVer() {
        System.out.println("\nSıparıs kargoya verılıyor...");
        for (Urun urun : urunler) {
            urun.kargoyaVer(musteri.getAdres());
        }
        kargoDurumuGuncelle(KargoDurumu.YOLDA);
    }

    public void kargoDurumuGuncelle(KargoDurumu yeniDurum) {
        this.kargoDurumu = yeniDurum;
        System.out.println("Kargo durumu guncellendı: " + yeniDurum);
    }

    public void siparisOzet() {
        System.out.println("\n--- Sıparıs Ozetı ---");
        System.out.println("Musterı: " + musteri.getAd());
        for (Urun urun : urunler) {
            System.out.println(urun);
        }
        System.out.println("Kargo Durumu: " + kargoDurumu);
    }
}

