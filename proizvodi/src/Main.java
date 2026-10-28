public class Main {

    public static void main(String[] args) {
        System.out.println("=== Stvaranje proizvoda ===");
        Proizvod p1 = new Proizvod("  Mlijeko 1L  ", 1.20, 50);
        Proizvod p2 = new Proizvod("Čaj od kamilice", 3.50, 12);
        Proizvod p3 = new Proizvod("Kruh", 0.95);
        Proizvod p4 = new Proizvod("Jabuke 1kg", 1.99);

        System.out.println(p1.opis());
        System.out.println(p2.opis());
        System.out.println(p3.opis());
        System.out.println(p4.opis());
        System.out.println("Broj stvorenih proizvoda: " + Proizvod.getBrojProizvoda());

        System.out.println("\n=== Dopuštene promjene ===");
        p3.setCijena(0.95);
        p3.setNaziv("  Kruh bijeli  ");
        p3.dodaj(30);
        p2.prodaj(5);
        p1.prodaj(10);
        System.out.println(p1.opis());
        System.out.println(p2.opis());
        System.out.println(p3.opis());

        System.out.println("\n=== Ukupna vrijednost ===");
        System.out.printf("%s: %.2f EUR%n", p2.getNaziv(), p2.ukupnaVrijednost());
        System.out.printf("%s uz 10%% popusta: %.2f EUR%n",
                p2.getNaziv(), p2.ukupnaVrijednost(10));

        System.out.println("\n=== Getteri ===");
        System.out.println("Šifra: " + p1.getSifra());
        System.out.println("Naziv: " + p1.getNaziv());
        System.out.println("Cijena: " + p1.getCijena());
        System.out.println("Količina: " + p1.getKolicina());

        System.out.println("\n=== Pokušaji neispravnih vrijednosti ===");
        try {
            p1.prodaj(1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Odbijeno: " + e.getMessage());
        }
        try {
            p1.setCijena(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Odbijeno: " + e.getMessage());
        }
        try {
            p1.setNaziv("    ");
        } catch (IllegalArgumentException e) {
            System.out.println("Odbijeno: " + e.getMessage());
        }
        try {
            new Proizvod(null, 2.0, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Odbijeno: " + e.getMessage());
        }
        try {
            new Proizvod("Sir", 4.0, -3);
        } catch (IllegalArgumentException e) {
            System.out.println("Odbijeno: " + e.getMessage());
        }
        try {
            p2.dodaj(-2);
        } catch (IllegalArgumentException e) {
            System.out.println("Odbijeno: " + e.getMessage());
        }

        System.out.println("\nBroj stvorenih proizvoda na kraju: "
                + Proizvod.getBrojProizvoda());
    }
}