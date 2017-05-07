package noleggio;

public class DataErrorException extends Exception {
	
	String msg;

	public DataErrorException (String s){
		
			this.msg = s;
	}
	
	public String toString() {
		
		return "Le date inserite non sono valide";
	}

}
