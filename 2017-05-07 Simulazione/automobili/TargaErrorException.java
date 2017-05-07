package automobili;

public class TargaErrorException extends Exception {
	
	String msg;

	public TargaErrorException (){
		
			
	}
	
	public String toString() {
		
		return "La Targa Inserita non e' valida";
	}

}
