package eticaret;

public class Kıyafet extends Urun {
    private String beden;

    public Kıyafet(String ad, double fiyat, String beden) {
        super(ad, fiyat);
        this.beden = beden;
    }

    @Override
    public String getKategori() {
        return "Kıyafet";
    }

    @Override
    public String toString() {
        return super.toString() + " | Beden: " + beden;
    }
}
