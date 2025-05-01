package eticaret;

public class Takı extends Urun {
    private String malzeme;

    public Takı(String ad, double fiyat, String malzeme) {
        super(ad, fiyat);
        this.malzeme = malzeme;
    }

    @Override
    public String getKategori() {
        return "Takı";
    }

    @Override
    public String toString() {
        return super.toString() + " | Malzeme: " + malzeme;
    }
}
