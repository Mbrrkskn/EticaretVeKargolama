package eticaret;

public class Ayakkabı extends Urun {
    private int numara;

    public Ayakkabı(String ad, double fiyat, int numara) {
        super(ad, fiyat);
        this.numara = numara;
    }

    @Override
    public String getKategori() {
        return "Ayakkabı";
    }

    @Override
    public String toString() {
        return super.toString() + " | Numara: " + numara;
    }
}
