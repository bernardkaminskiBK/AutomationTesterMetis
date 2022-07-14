package programingFundamentalsFirstTask;

import java.util.Scanner;

public class Statistiky {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Zadaj prvé číslo:");
        double cislo1 = input.nextDouble();

        System.out.println("Zadaj druhé číslo:");
        double cislo2 = input.nextDouble();

        System.out.println(vypocitajStatistiky(cislo1, cislo2));
    }

    public static String vypocitajStatistiky(double cislo1, double cislo2) {
        double sucet = cislo1 + cislo2;
        double sucin = cislo1 * cislo2;
        double rozdiel = cislo1 - cislo2;
        double podiel = cislo1 / cislo2;
        double zvysok = cislo1 % cislo2;

        return "Sucet: " + sucet + "\n" + "Sucin: " + sucin + "\n" + "Rozdiel: " + rozdiel + "\n" + "Podiel: " + podiel + "\n" + "Zvysok: " + zvysok;
    }
}
