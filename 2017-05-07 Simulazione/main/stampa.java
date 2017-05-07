package main;

import automobili.Auto;
import automobili.AutoEconomica;
import noleggio.Noleggio;
import prog.utili.*;

public class stampa {

	
	static char[] Alfabeto = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	public static boolean print (int check, Noleggio n, Sequenza<Noleggio> g, int[]control ,int index){
		
		if (check != 0)
		{
			System.out.println("Noleggio Riuscito");
			g.add(n);
			control[index] = check;
			//System.out.print(n.getID()+"aggiunto"+n.getInizio());
			return true;
			
		}
		else
			System.out.println("Noleggio Fallito");
		
		return false;
	}
	
	
	public static String generaID() {
		
		String ID="";
		
		for (int i = 0; i < 10; i++) {
		
			ID += (int)(Math.random()*10);
		}

		return ID;
	}
	public static int ControllaTarga(Auto a){
		
		String targa = a.getTarga();
		targa= targa.toUpperCase();
		System.out.println(targa+"");

		for (int i = 0; i < targa.length(); i++) {
			if (i < 2 || i > 4) {
				if ((targa.charAt(i) == '0') || (targa.charAt(i) == '1') || (targa.charAt(i) == '2')
						|| (targa.charAt(i) == '3') || (targa.charAt(i) == '4') || (targa.charAt(i) == '5')
						|| (targa.charAt(i) == '6') || (targa.charAt(i) == '7') || (targa.charAt(i) == '8')
						|| (targa.charAt(i) == '9')) {

					return 0;
				}
			}else if(i>=2 && i<=4){ 
					for (int h = 0; h < 26; h++) {
						if (targa.charAt(i) == Alfabeto[h])
						{
							//System.out.print(Alfabeto[h]+" "+targa.charAt(i));
							return 0;
						}
					}

				}
		}

		return 1;
	}
	//overload
	public static int ControllaTarga(String targa) {

		
		targa= targa.toUpperCase();
		System.out.println(targa+"");

		for (int i = 0; i < targa.length(); i++) {
			if (i < 2 || i > 4) {
				if ((targa.charAt(i) == '0') || (targa.charAt(i) == '1') || (targa.charAt(i) == '2')
						|| (targa.charAt(i) == '3') || (targa.charAt(i) == '4') || (targa.charAt(i) == '5')
						|| (targa.charAt(i) == '6') || (targa.charAt(i) == '7') || (targa.charAt(i) == '8')
						|| (targa.charAt(i) == '9')) {

					return 0;
				}
			}else if(i>=2 && i<=4){ 
					for (int h = 0; h < 26; h++) {
						if (targa.charAt(i) == Alfabeto[h])
						{
							//System.out.print(Alfabeto[h]+" "+targa.charAt(i));
							return 0;
						}
					}

				}
		}

		return 1;
	}
	/**
	 * 
	 * @return no
	 * @param int[] ,
	 *            Sequenza<Noleggio>
	 */
	public static void StampaTabella(Sequenza<Noleggio> g, int []check){
		int i=0;
		System.out.println("===============================================");
		for(Noleggio n: g){
		System.out.println(n.toString()+"|"+check[i]+"|"+n.getA().getTarga()+"|");
		i++;
		}
		System.out.println("===============================================");
	}

	/**
	 * 
	 * @return no
	 * @param string,
	 *            Sequenza<Noleggio>, Data
	 */

	public static void autolibera(String targa, Sequenza<Noleggio> g, Data in, Data fin) {

		Data i, f;
		int j = ControllaTarga(targa);
		if (j != 0) {
			boolean h = false;
			for (Noleggio n : g) {

				String t = n.getA().getTarga();
				i = n.getInizio();
				f = n.getFine();

				if (targa.equals(t)) {
					if ((in.isMaggiore(i)) || (fin.isMaggiore(i))) {
						h = true;

					}
				}
			}
			if (h == true)
				System.out.println("L'auto che si e' tentato di affittare da: "+in+" a "+fin+" non va bene");
			else
				System.out.println("L'auto che si e' tentato di affittare da:"+in+" a "+fin+" va bene");

			
		}
	}
}
