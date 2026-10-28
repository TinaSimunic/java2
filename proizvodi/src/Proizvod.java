public class Proizvod {

    private static int brojac = 0;

    private final String sifra;
    private String naziv;
    private double cijena;
    private int kolicina;

    public Proizvod(String naziv, double cijena, int kolicina) {
        provjeriNaziv(naziv);
        provjeriCijenu(cijena);
        provjeriKolicinu(kolicina);

        this.naziv = naziv.trim();
        this.cijena = cijena;
        this.kolicina = kolicina;

        brojac++;
        this.sifra = String.format("P%03d", brojac);
    }

    public Proizvod(String naziv, double cijena) {
        this(naziv, cijena, 0);
    }


    private static void provjeriNaziv(String naziv) {
        if (naziv == null || naziv.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Naziv ne smije biti null, prazan ni sastavljen samo od razmaka.");
        }
    }

    private static void provjeriCijenu(double cijena) {
        if (Double.isNaN(cijena) || cijena < 0) {
            throw new IllegalArgumentException(
                "Cijena ne smije biti negativna (zadano: " + cijena + ").");
        }
    }

    private static void provjeriKolicinu(int kolicina) {
        if (kolicina < 0) {
            throw new IllegalArgumentException(
                "Količina ne smije biti negativna (zadano: " + kolicina + ").");
        }
    }


    public String getSifra() {
        return sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        provjeriNaziv(naziv);
        this.naziv = naziv.trim();
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        provjeriCijenu(cijena);
        this.cijena = cijena;
    }

    public int getKolicina() {
        return kolicina;
    }


    public void dodaj(int kolicina) {
        if (kolicina <= 0) {
            throw new IllegalArgumentException(
                "Količina za dodavanje mora biti veća od nule (zadano: " + kolicina + ").");
        }
        this.kolicina += kolicina;
    }

    public void prodaj(int kolicina) {
        if (kolicina <= 0) {
            throw new IllegalArgumentException(
                "Količina za prodaju mora biti veća od nule (zadano: " + kolicina + ").");
        }
        if (kolicina > this.kolicina) {
            throw new IllegalArgumentException(
                "Nedovoljno na skladištu: traženo " + kolicina
                + ", dostupno " + this.kolicina + ".");
        }
        this.kolicina -= kolicina;
    }


    public double ukupnaVrijednost() {
        return cijena * kolicina;
    }

    public double ukupnaVrijednost(double popust) {
        if (Double.isNaN(popust) || popust < 0 || popust > 100) {
            throw new IllegalArgumentException(
                "Popust mora biti između 0 i 100 posto (zadano: " + popust + ").");
        }
        return ukupnaVrijednost() * (1 - popust / 100.0);
    }

    public static int getBrojProizvoda() {
        return brojac;
    }

    public String opis() {
        return String.format(java.util.Locale.US, "%s | %s | %.2f EUR | %d kom.",
                sifra, naziv, cijena, kolicina);
    }
}