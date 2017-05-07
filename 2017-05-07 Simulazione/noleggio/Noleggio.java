package noleggio;

import prog.utili.*;
import automobili.*;

public class Noleggio implements Comparable {
	
	protected Auto a;
	protected Data inizio, fine;
	protected String tessera;
	protected String ID;
	
	
	public Noleggio(String ID, Auto aut, Data in, Data fin){
		
		this.ID = ID;
		this.a = aut;
		this.inizio = in;
		this.fine = fin;
	}
	
	public Noleggio(String ID, Auto aut, Data in, Data fin, String carta){
		this.ID = ID;
		this.a = aut;
		this.inizio = in;
		this.fine = fin;
		this.tessera = carta;
	}	
	public String getTessera() {
		return tessera;
	}

	public void setTessera(String tessera) {
		this.tessera = tessera;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	
	public Auto getA() {
		return a;
	}

	public void setA(Auto a) {
		this.a = a;
	}

	public Data getInizio() {
		return inizio;
	}

	public void setInizio(Data inizio) {
		this.inizio = inizio;
	}

	public Data getFine() {
		return fine;
	}

	public void setFine(Data fine) {
		this.fine = fine;
	}

	public int NoleggioGiornaliero() throws DataErrorException {

		Data oggi = new Data();

		if (oggi.isMaggiore(inizio) || oggi.isMaggiore(fine) || inizio.isMaggiore(fine)) {

			throw new DataErrorException("Le Date inserite non sono valide");
		}
		 
		 if ((inizio.quantoManca(fine) == 1) && (a instanceof AutoEconomica)){		
				
			return 50;
		 }
		return 0;
	}
	
	 public int NoleggioMediaDurata() throws DataErrorException{
		
		Data oggi = new Data();
		
		int contagiorni=0;
		
		if (oggi.isMaggiore(inizio) || oggi.isMaggiore(fine)|| inizio.isMaggiore(fine))
			throw new DataErrorException("Le Date inserite non sono valide");

		if(inizio.quantoManca(fine)>1){
			
			if( a.getImmatricolazione().getAnno() >= (oggi.getAnno()-2))

			{
				contagiorni = inizio.quantoManca(fine);

				return 40 + 20 * (contagiorni - 1);
			}
			else
				
				return 0;
		}
		return 0;
	}
	
	public int NoleggioAbituale() throws DataErrorException {

		Data oggi = new Data();
		int ContaGiorni = 0;
		
		if (oggi.isMaggiore(inizio) || oggi.isMaggiore(fine) || inizio.isMaggiore(fine))
			throw new DataErrorException("Le Date inserite non sono valide");

		if (a instanceof AutoLusso) {

			ContaGiorni = inizio.quantoManca(fine);

			return (ContaGiorni * 15);
		}
		return 0;

	}

	public String toString(){
		
		return "|"+getID()+" |"+getInizio()+"|"+getFine()+"|";
	}
	@Override
	public int compareTo(Object o) {
	
		return this.compareTo(o);
	}
	
	
	
}
