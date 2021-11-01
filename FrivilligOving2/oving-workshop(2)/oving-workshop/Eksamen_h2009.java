
/* PC - konfliktkommentar skal n� v�re l�st


Eksamen_h2009.java  GS 2009-11-16

Forste kommentar fra PC

*/
// Første kommentar fra Epleproduktet på en annen linje
// Andre kommentar fra PC

import static javax.swing.JOptionPane.*;

// b
// Andre kommentar fra Epleproduktet
class Spor {
    String navn;
    String artist;
    double lengde; // Ny kommentar oppgis i minutter

    public Spor(String navn, String artist, double lengde) {
        this.navn = navn;
        this.artist = artist;
        this.lengde = lengde;
    }

    /* Her manger noen get/set - metoder */

    public String getNavn() {
        return navn;
    }

    public void setNavn(String nyVerdi) {
        navn = nyVerdi;
    }

    public String toString() {
        // her mangler det noe
    }

    // c
    public boolean equals(Object obj) {
        /* to spor er like dersom de har samme artist, navn og lengde */
		// her mangler det noe
    }
}

// d Du skal lage to konstruktører og en toString()-metode:
class Album {
    private String navn;
    private SporLF[] spilleliste;
    private int antSpor;
    private final int MAKS_LENGDE = 60;

    public Album(String navn, SporLF[] spilleliste) {
        this.navn = navn;
        this.spilleliste = new SporLF[spilleliste.length];
        for (int i = 0; i < spilleliste.length; i++) {
            this.spilleliste[i] = spilleliste[i];
        }
        antSpor = spilleliste.length;
    }

    // konstrukt�r som oppretter en tom Spor-tabell (spilleliste)
    public Album(String navn, int maksAntSpor) {
        // fyll in det som mangler
    }

    // e)	Lag en Album-metode som returnerer den totale lengden p� spilletiden. Merk du kan anta at 1 minutt er lik 100 sekunder .
    public double getSpilleTid() {

        double totTid = 0;
        for (int i = 0; i < antSpor; i++) {
            // her mangler det noe
        }
        return totTid;
    }

    /* f)	Lag en Album-metode som skal pr�ve � registrere et nytt spor. Nytt spor skal ikke registreres
          dersom spor er registrert fra f�r, eller dersom den totale spilletid p� albumet overstiger 60 minutter,
          eller n�r det ikke er plass i tabellen til flere spor. */
    public boolean regNyttSpor(SporLF nyttSpor) {
        if (antSpor >= spilleliste.length) {
            return false;
        } else {
            if (sjekkSpor(nyttSpor)) { // spor allerede registrert
                return false;
            } else if (getSpilleTid() + nyttSpor.getLengde() > MAKS_LENGDE) {
                return false;
            } else {
                // her mangler det noe
            }
        }
    }

    private boolean sjekkSpor(SporLF t) {
        for (int i = 0; i < antSpor; i++) {
            if (spilleliste[i].equals(t)) return true;
        }
        return false;
    }

    // g)	Lag en Album-metode   public Spor[]finnSpor(String artist) som returnerer alle spor som synges av en gitt artist.
    public SporLF[] finnSporArtist(String artist) {
        SporLF[] kopi = new SporLF[antSpor];
        int kopiCount = 0;
        for (int i = 0; i < antSpor; i++) {
            if (spilleliste[i].getArtist().equals(artist)) {
                kopi[kopiCount] = new SporLF(spilleliste[i].getNavn(), spilleliste[i].getArtist(), spilleliste[i].getLengde());
                kopiCount++;
            }
        }

        if (kopiCount == 0) {
            return null;
        } else if (kopiCount < antSpor) {
            SporLF[] tmp = new SporLF[kopiCount];
            for (int i = 0; i < kopiCount; i++) {
                tmp[i] = kopi[i];
            }
            return tmp;
        } else {
            return kopi;
        }
    }

    // toString()-metoden skal returnere albumnavn og en liste over alle spor
    public String toString() {
        // her mangler det noe
    }
}

// i
class Eksamen_h2009 {
    public static void main(String[] args) {
        final int REG_ALBUM = 0;
        final int REG_SPOR = 1;
        final int INFO = 2;
        final int SOK_ARTIST = 3;
        final int AVSLUTT = 4;

        String[] muligheter = {"Registrer Album", "Registrer nytt spor", "Info om Album", "S�k etter sanger av artist", "Avslutt"};

        //Album album = null;
        SporLF[] liste = {new SporLF("Beat It", "Michael Jackson", 5.33), new SporLF("Billie Jean", "Michael Jackson", 6.11), new SporLF("Thriller", "Michael Jackson", 8.33), new SporLF("This is it", "Michael Jackson", 4.23)};
        AlbumLF album = new AlbumLF("Thriller", liste);

        int valg = showOptionDialog(null, "Velg operasjon", "HiST Musikk Katalogisering", 0, 0, null, muligheter, muligheter[0]);

        while (valg != AVSLUTT) {
            switch (valg) {
                case REG_ALBUM:
                    String navn = showInputDialog("Navn p� Album: ");
                    int maks = Integer.parseInt(showInputDialog("Maks antall spor; "));
                    if (album == null) album = new AlbumLF(navn, maks);
                    else {
                        if (showConfirmDialog(null, "Album allerede reg. sikker p� at du vil opprette nytt=") == YES_OPTION) {
                            album = new AlbumLF(navn, maks);
                        }
                    }
                    break;
                case REG_SPOR:
                    String tittel = showInputDialog("Tittel: ");
                    String artist = showInputDialog("Artist: ");
                    double lengde = Double.parseDouble(showInputDialog("Lengde p� spor(mm.ss); "));

                    SporLF nyttSpor = new SporLF(tittel, artist, lengde);
                    if (album.regNyttSpor(nyttSpor)) {
                        showMessageDialog(null, "Spor registrert");
                    } else {
                        showMessageDialog(null, "Ikke plass p� Album.");
                    }
                    break;
                case INFO:
                    showMessageDialog(null, album);
                    break;

                case SOK_ARTIST:
                    artist = showInputDialog("Artist du �nsker � s�ke etter: ");
                    SporLF[] spor = album.finnSporArtist(artist);
                    String res = "L�ter av " + artist + ":\n";
                    if (spor != null) {
                        for (SporLF s : spor) {
                            res += s + "\n";
                        }
                    } else res += "Ingen l�ter registrert";

                    showMessageDialog(null, res);
                    break;
                case OVERRASKELSE:
                    showMessageDialog(null, "O V E R R A S K E L S E !");
                    break;
                default:
                    break;
            }
        }
        valg = showOptionDialog(null, "Velg operasjon", "HiST Musikk Katalogisering", 0, 0, null, muligheter, muligheter[0]);
    }
}
