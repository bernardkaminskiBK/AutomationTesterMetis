package banka;

import java.util.ArrayList;

public class Banka {
    private ArrayList<BankovyUcet> bankoveUcty;

    public Banka() {
        bankoveUcty = new ArrayList<>();
    }

    public void zalozUcet(BankovyUcet ucet) {
        bankoveUcty.add(ucet);
    }

    public void zmazUcet(int cisloUctu) {
        BankovyUcet ucet = vyhladaj(cisloUctu);

        if (ucet != null) {
            bankoveUcty.remove(ucet);
        }
    }

    public int getPocetUctov() {
        return bankoveUcty.size();
    }

    public int getPocetUctovSoZostatkomVyssimAko(double prinajmensom) {
        int pocetUctov = 0;

        for (BankovyUcet ucet : bankoveUcty) {
            if (ucet.getAktualnyZostatok() > prinajmensom) {
                pocetUctov++;
            }
        }

        return pocetUctov;
    }

    public double getCelkovyZostatok() {
        double celkovyZostatok = 0;

        for (BankovyUcet ucet : bankoveUcty) {
            celkovyZostatok = celkovyZostatok + ucet.getAktualnyZostatok();
        }

        return celkovyZostatok;
    }

    private BankovyUcet vyhladaj(int cisloUctu) {
        for (BankovyUcet ucet : bankoveUcty) {
            if (ucet.getCisloUctu() == cisloUctu) {
                return ucet;
            }
        }
        return null;
    }
}
