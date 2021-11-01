/*

Eksamen_h2009.java  GS 2009-11-16

*/

import static javax.swing.JOptionPane.*;
// b
class SporLF {
	String navn;
	String artist;
	double lengde;

	public SporLF(String navn, String artist, double lengde){
		this.navn = navn;
		this.artist = artist;
		this.lengde = lengde;
	}

	public String getNavn(){return navn; }
	public void setNavn(String nyVerdi){ navn = nyVerdi;}

	public String getArtist(){return artist;}
	public void setArtist(String nyVerdi){ artist = nyVerdi;}

	public double getLengde(){ return lengde;}
	public void setLengde(double nyVerdi){ lengde = nyVerdi;}

	public String toString(){
		return navn + " " + artist + " " + lengde;
	}

// c
	public boolean equals(Object obj){
		if (obj instanceof SporLF){
			SporLF t = (SporLF) obj;
			if (t == this) return true;
			else{
				if(this.navn.equals(t.getNavn()) && this.artist.equals(t.getArtist())){
					return true;
				}
			}
		}
		return false;
	}
}

// d
class AlbumLF {
	private String navn;
	private SporLF[] spilleliste;
	private int antSpor;
	private final int MAKS_LENGDE = 60;

	public AlbumLF(String navn, SporLF[] spilleliste){
		this.navn = navn;
		this.spilleliste = new SporLF[spilleliste.length];
		for(int i=0; i<spilleliste.length; i++){
			this.spilleliste[i] = spilleliste[i];
		}
		antSpor = spilleliste.length;
	}

	public AlbumLF(String navn, int maksAntSpor){
		this.navn = navn;
		spilleliste = new SporLF[maksAntSpor];
		antSpor = 0;
	}

	// e
	public double getSpilleTid(){
		double totTid = 0;
		for(int i=0; i<antSpor; i++){
			totTid += spilleliste[i].getLengde();
		}
		return totTid;
	}

	// f
	public boolean regNyttSpor (SporLF nyttSpor){
		if (antSpor >= spilleliste.length){
			return false;
		}else{
			if(sjekkSpor(nyttSpor)){ // spor allerede registrert
				return false;
			} else if (getSpilleTid() + nyttSpor.getLengde() > MAKS_LENGDE){
				return false;
			}else{
				spilleliste[antSpor] = new SporLF(nyttSpor.getNavn(), nyttSpor.getArtist(), nyttSpor.getLengde());
				antSpor++;
				return true;
			}
		}
	}

	private boolean sjekkSpor(SporLF t){
		for(int i=0; i<antSpor; i++){
			if (spilleliste[i].equals(t)) return true;
		}
		return false;
	}

	// g
	public SporLF[] finnSporArtist(String artist){
		SporLF[] kopi = new SporLF[antSpor];
		int kopiCount = 0;
		for(int i=0; i<antSpor; i++){
			if(spilleliste[i].getArtist().equals(artist)){
				kopi[kopiCount] = new SporLF(spilleliste[i].getNavn(), spilleliste[i].getArtist(), spilleliste[i].getLengde());
				kopiCount++;
			}
		}

		if( kopiCount == 0){
			return null;
		}
		else if (kopiCount < antSpor){
			SporLF[] tmp = new SporLF[kopiCount];
			for(int i=0; i<kopiCount; i++){
				tmp[i] = kopi[i];
			}
			return tmp;
		}else{
			return kopi;
		}
	}

	public String toString(){
		String res = navn + "\n";
		for(int i=0; i<antSpor; i++){
			res += spilleliste[i] + "\n";
		}
		return res;
	}
}

// i
class Eksamen_h2009_losningsforslag{
	public static void main (String[] args){
		final int REG_ALBUM = 0;
		final int REG_SPOR = 1;
		final int INFO = 2;
		final int SOK_ARTIST = 3;
		final int AVSLUTT = 4;

		String[] muligheter = {"Registrer Album", "Registrer nytt spor", "Info om Album", "S�k etter sanger av artist", "Avslutt"};

		//Album album = null;
		SporLF[] liste = {new SporLF("Beat It", "Michael Jackson", 5.33), new SporLF("Billie Jean", "Michael Jackson", 6.11),new SporLF("Thriller", "Michael Jackson", 8.33),new SporLF("This is it", "Michael Jackson", 4.23)};
		AlbumLF album = new AlbumLF("Thriller", liste);

		int valg = showOptionDialog(null, "Velg operasjon", "HiST Musikk Katalogisering", 0, 0, null, muligheter, muligheter[0]);

		while (valg != AVSLUTT){
			if (valg == REG_ALBUM){
				String navn = showInputDialog("Navn p� Album: " );
				int maks = Integer.parseInt(showInputDialog("Maks antall spor; "));
				if (album == null) album = new AlbumLF(navn, maks);
				else {
					if (showConfirmDialog(null, "Album allerede reg. sikker p� at du vil opprette nytt=" ) == YES_OPTION){
						album = new AlbumLF(navn, maks);
					}
				}
			}else if(valg == REG_SPOR){
				String tittel = showInputDialog("Tittel: " );
				String artist = showInputDialog("Artist: " );
				double lengde = Double.parseDouble(showInputDialog("Lengde p� spor(mm.ss); "));

				SporLF nyttSpor = new SporLF(tittel, artist, lengde);
				if (album.regNyttSpor(nyttSpor)) {
					showMessageDialog(null, "Spor registrert");
				}else{
					showMessageDialog(null, "Ikke plass p� Album.");
				}

			}else if(valg == INFO){
				showMessageDialog(null, album);

			}else if(valg == SOK_ARTIST){
				String artist = showInputDialog("Artist du �nsker � s�ke etter: ");
				SporLF[] spor = album.finnSporArtist(artist);
				String res = "L�ter av " + artist + ":\n";
				if (spor != null){
					for(SporLF s: spor){
						res += s + "\n";
					}
				} else res += "Ingen l�ter registrert";

				showMessageDialog(null, res);
			}
			valg = showOptionDialog(null, "Velg operasjon", "HiST Musikk Katalogisering", 0, 0, null, muligheter, muligheter[0]);
		}
	}
}