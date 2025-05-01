package eticaret;

public abstract class Urun implements Kargolanabilir, Indırılebılır {
    protected String ad;
    protected double fiyat;

    public Urun(String ad, double fiyat) {
        this.ad = ad;
        this.fiyat = fiyat;
    }

    public abstract String getKategori();

    public String getAd() {
        return ad;
    }

    public double getFiyat() {
        return fiyat;
    }

    @Override
    public void kargoyaVer(String adres) {
        System.out.println(ad + " ürünü şu adrese gönderildi: " + adres);
    }

    @Override
    public void indirimUygula(double oran) {
        fiyat -= fiyat * oran / 100;
    }

    @Override
    public String toString() {
        return getKategori() + ": " + ad + " | Fiyat: " + fiyat + "₺";
    }
}

