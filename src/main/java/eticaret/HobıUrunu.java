package eticaret;

public class HobıUrunu extends Urun {
    private String tur;

    public HobıUrunu(String ad, double fiyat, String tur) {
        super(ad, fiyat);
        this.tur = tur;
    }

    @Override
    public String getKategori() {
        return "Hobı Urunu";
    }

    @Override
    public String toString() {
        return super.toString() + " | Tur: " + tur;
    }
}
