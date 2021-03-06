package automobili;


import prog.utili.*;

public abstract class Auto {
	
	protected String targa;
	protected Data immatricolazione;

	//controllo su targa
	//controllo su immatricolazione
	
	protected Auto( String t, Data imm) throws TargaErrorException{
		if(t.length()!=7)
			 throw new TargaErrorException();
		targa = t;
	    immatricolazione = imm;
	    
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public Data getImmatricolazione() {
		return immatricolazione;
	}

	public void setImmatricolazione(Data immatricolazione) {
		this.immatricolazione = immatricolazione;
	}
	
}
