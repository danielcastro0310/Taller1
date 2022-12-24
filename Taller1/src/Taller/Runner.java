package Taller;

import javax.swing.JOptionPane;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Control control = new Control();
		byte option;
		int intentos = 0;
		int cont = 0;
		while(intentos < 3)
		try {
			do {
		option = Byte.parseByte(JOptionPane.showInputDialog(null, "             OPCIONES\n"
				+ "------------------------------------\n"
				+ "1.Numero Romano\n"
				+ "2.Factores Primos\n"
				+ "3.Borrar Espacios\n"
				+ "4.Numeros Egolatras\n"
				+ "5.Numero Magico\n"
				+ "6.Fechas\n"
				+ "7.Salir"));
		switch(option){
		case 1:
			Control.numeroRomano();
			break;
		case 2:
			Control.factoresPrimos();
			break;
		case 3:
			Control.borrarEspacios();
			break;
		case 4:
			Control.numeroEgolatra();
			break;
		case 5:
			Control.numeroMagico();
			break;
		case 6:
			Control.fechas();
			break;
		case 7:
			JOptionPane.showMessageDialog(null,"            ----------------------\n"
					+ "             !! GOODBYE !! \n"
					+ "            ----------------------");
			System.exit(1);
			break;
		default :
			JOptionPane.showMessageDialog(null,"ERROR OPCION INCORRECTA");
			break;
		}
			}while(option !=7);
		}catch(Exception e) {
			cont++;
			intentos++;
			if(cont <= 2) {
			JOptionPane.showMessageDialog(null, "                              ERROR \n"
					+ "  ------------------------------------------------------\n"
					+ "     NUMERO DE INTENTOS REALIZADOS \n" + intentos + " RECUERDE QUE SOLO PUEDE REALIZAR 3");
			}else {
				JOptionPane.showMessageDialog(null, "HA AGOTADO SU NUMERO DE INTENTOS\n"
						+ "    TOTAL DE INTENTOS REALIZADOS " + intentos);
			}
		}

	}

}
