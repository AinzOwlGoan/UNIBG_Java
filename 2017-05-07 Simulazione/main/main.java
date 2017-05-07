package main;

import prog.utili.*;
import prog.io.*;
import automobili.*;
import noleggio.*;

public class main extends stampa {

	public static void main(String[] args) throws DataErrorException, TargaErrorException {

		AutoEconomica ae = new AutoEconomica("AB124CD", new Data(8, 12, 2015));
		AutoLusso al = new AutoLusso("AB143FD", new Data(12, 12, 2010));

		int[] control = new int[3];
		int checkTarga;
		Sequenza<Noleggio> n = new Sequenza<Noleggio>();
		int index = 0, check = 0;
		boolean secure = false;

		checkTarga = ControllaTarga(ae);
		if (checkTarga == 0)
			System.out.println("Targa sbagliata");
		else {

			Noleggio n1 = new Noleggio(generaID(), ae, new Data(7, 05, 2017), new Data(8, 05, 2017));

			Noleggio n2 = new Noleggio(generaID(), ae, new Data(8, 05, 2017), new Data(10, 05, 2017));

			/////////////////////////////////////
			check = n1.NoleggioGiornaliero();
			control[0] = check;
			secure = print(check, n1, n, control, index);
			if (secure == true)
				index++;
			//////////////////////////////////
			check = n2.NoleggioMediaDurata();
			control[1] = check;
			secure = print(check, n2, n, control, index);
			if (secure == true)
				index++;
			///////////////////////////////

		}

		checkTarga = ControllaTarga(al);
		if (checkTarga == 0)
			System.out.println("Targa sbagliata");
		else {
			Noleggio n3 = new Noleggio(generaID(), al, new Data(9, 05, 2017), new Data(15, 05, 2017), "1234");

			// n3.setTessera("");
			// System.out.print(n1.getID() + "\n" + n2.getID() + "\n" +
			// n3.getID() + "\n");

			if ((n3.getTessera() != null) && (n3.getTessera() != "")) {

				check = n3.NoleggioAbituale();
				control[2] = check;
				// System.out.print(checkAbituale);
			}
			print(check, n3, n, control, index);
		}

		StampaTabella(n, control);
		///////////////////
		
		autolibera("AB124CD",n,new Data(8,5,2017), new Data(11,12,2017));
		autolibera("AD133DC",n,new Data(15,12,2017), new Data(15,01,2018));
		
	}


}
