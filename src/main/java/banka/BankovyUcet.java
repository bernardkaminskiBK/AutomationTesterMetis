package banka;

public class BankovyUcet {
    private int cisloUctu;
    private double aktualnyZostatok;

    public BankovyUcet(int cisloUctu, double aktualnyZostatok) {
        this.cisloUctu = cisloUctu;
        this.aktualnyZostatok = aktualnyZostatok;
    }

    public BankovyUcet(double aktualnyZostatok) {
        this.aktualnyZostatok = aktualnyZostatok;
    }

    public BankovyUcet() {
        this.aktualnyZostatok = 0;
    }

    public void vloz(double ciastka) {
        aktualnyZostatok += ciastka;
    }

    public void vyber(double ciastka) {
        aktualnyZostatok -= ciastka;
    }

    public int getCisloUctu() {
        return cisloUctu;
    }

    public double getAktualnyZostatok() {
        return aktualnyZostatok;
    }
}
