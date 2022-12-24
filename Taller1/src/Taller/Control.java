package Taller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Control {
	
	public Control() {}
	
	public static String numeroRomano(){
		int romano = 0;
		String cadena = JOptionPane.showInputDialog("INGRESE NUMERO ROMANO A EVALUAR");
		if(String.valueOf(cadena).equalsIgnoreCase("IIII") ) {
			JOptionPane.showMessageDialog(null, "ERROR LA ENTRADA NO ES VALIDA");
		}else {
		Map<Character,Integer> romanM = getRomanMap();
		for(int i = 0; i < cadena.length()-1 ;i++ ) {
			
			int valorRomano = romanM.get(cadena.charAt(i)); 
			if(valorRomano < romanM.get(cadena.charAt(i+1))) {
				romano -= valorRomano;
			}else {
				romano += valorRomano;
			}
		}
		romano = romano + romanM.get(cadena.charAt(cadena.length()-1));
		JOptionPane.showMessageDialog(null, "el numero romano " + cadena + " en decimal es " + romano);
		}
		return "";
	}
	public static Map<Character,Integer> getRomanMap() {
		Map<Character,Integer> roman = new HashMap<Character,Integer>();
		roman.put('I', 1);
		roman.put('V', 5);
		roman.put('X', 10);
		roman.put('L', 50);
		roman.put('C', 100);
		roman.put('D', 500);
		roman.put('M', 1000);
		return roman;
	}
	
	public static int factoresPrimos(){
		int factor = 2;
		int aux = 2;
		int count = 0;
		int num = Integer.parseInt(JOptionPane.showInputDialog("INGRESE UN NUMERO PARA EVALUAR"));
		String cadena = "LOS FACTORES PRIMOS DE"+ num 
				+ "\nEXPRESADOS EN POTENCIAS SON = ";
		do {
			if (num % factor == 0) {
				if (aux == factor) {
					count++;
				}
				num = num / factor;
				if(num == 1) {
					if(count > 0) {
						cadena += factor + "^" + count;
						
						
					}
				}
			} else {
				factor++;
				aux = factor;
				if(count > 0) {
					cadena += factor-1 + "^" + count + " x ";
					
					
				}
				count = 0;
			}
				
		} while (num!=1);
		JOptionPane.showMessageDialog(null,cadena);
		return 0;
	}
	
	public static String borrarEspacios(){
		String cadena = JOptionPane.showInputDialog("INGRESE CADENA DE CARACTERES");
		String espacio = " ";
		String palabra2 = "";
		 	for(int i=0; i < cadena.length(); i++) {
		 		if(!String.valueOf(cadena.charAt(i)).equalsIgnoreCase(espacio)  ) {
		 		palabra2 = palabra2 + cadena.charAt(i);
		 			}	
		 		}
		 	JOptionPane.showMessageDialog(null, palabra2);
		return "";
	}
	
	public static String numeroEgolatra(){
		String cadena = JOptionPane.showInputDialog("INGRESE UN NUMERO PARA EVALUAR");
		double num = Double.parseDouble(cadena);
		double contador = 0;
		for(int i = 0;i < cadena.length();i++ ) {
	
			char num1 = cadena.charAt(i);
			double num2 = Character.getNumericValue(num1);
			contador = contador + Math.pow(num2, cadena.length());
			
		}
		if(num == contador) {
			JOptionPane.showMessageDialog(null, "EL NUMERO " + cadena + " ES EGOLATRA" );
		}else{
			JOptionPane.showMessageDialog(null, "EL NUMERO " + cadena + " NO ES EGOLATRA" );
		}	
		return "";
	}
	
	public static String numeroMagico(){
		int mag = Integer.parseInt(JOptionPane.showInputDialog("INGRESE UN NUMERO PARA EVALUAR"));
		String numMag = String.valueOf(mag);
		String[] listaOrdenadaDescendente = new String[numMag.length()];
		String[] listaOrdenadaAscendente = new String[numMag.length()];
		
		for (int i = 0; i < numMag.length(); i++) {
			listaOrdenadaDescendente[i] = String.valueOf(numMag.charAt(i));
			listaOrdenadaAscendente[i] = String.valueOf(numMag.charAt(i));
		}
		
		
		String tmp = "";
		for (int i = 0; i < numMag.length(); i++) {
			for (int j = (i+1); j < numMag.length(); j++) {
				if(Integer.parseInt(listaOrdenadaAscendente[j]) < Integer.parseInt(listaOrdenadaAscendente[i])) {
					tmp = listaOrdenadaAscendente[i];
					listaOrdenadaAscendente[i] = listaOrdenadaAscendente[j];
					listaOrdenadaAscendente[j] = tmp;
				}
			}
		}
		tmp = "";
		for (int i = 0; i < numMag.length(); i++) {
			for (int j = (i+1); j < numMag.length(); j++) {
				if(Integer.parseInt(listaOrdenadaDescendente[j]) > Integer.parseInt(listaOrdenadaDescendente[i])) {
					tmp = listaOrdenadaDescendente[i];
					listaOrdenadaDescendente[i] = listaOrdenadaDescendente[j];
					listaOrdenadaDescendente[j] = tmp;
				}
			}
		}
		String numAscendente = "";
		String numDescendente = "";
		for (int i = 0; i < listaOrdenadaAscendente.length; i++) {
			numAscendente = numAscendente + listaOrdenadaAscendente[i];
			numDescendente = numDescendente + listaOrdenadaDescendente[i];
		}
		int numAsc = Integer.parseInt(numAscendente);
		int numDes = Integer.parseInt(numDescendente);
		int diferencia = numDes - numAsc;
		if(diferencia == mag) {
			JOptionPane.showMessageDialog(null,mag + " es un número mágico porque " + numDes + " - " + numAsc + " = " + diferencia );
			
		}else {
			JOptionPane.showMessageDialog(null,mag + " no es un número mágico porque " + numDes + " - " + numAsc + " = " + diferencia );
			
		}
		return "";
	}
	
	public static String fechas(){
		String fecha = JOptionPane.showInputDialog("INGRESE FECHA CON EL SIGUIENTE FORMATO(dd/MM/yyyy)");
		boolean validar = true;
		String year = fecha.substring(6,10);
		String month ="";
		String day = fecha.substring(0,2);
		validar = validarFecha(fecha);
		if(validar == true) {
		if(Integer.parseInt(fecha.substring(4,5)) == 1) {
			month += "Enero";
		}else if(Integer.parseInt(fecha.substring(4,5)) == 2) {
			month += "Febrero";
		}else if(Integer.parseInt(fecha.substring(4,5)) == 3) {
			month += "Marzo";
		}else if(Integer.parseInt(fecha.substring(4,5)) == 4) {
			month += "Abril";
		}else if(Integer.parseInt(fecha.substring(4,5)) == 5) {
			month += "Mayo";
		}else if(Integer.parseInt(fecha.substring(4,5)) == 6) {
			month += "Junio";
		}else if(Integer.parseInt(fecha.substring(4,5)) == 7) {
			month += "Julio";
		}else if(Integer.parseInt(fecha.substring(4,5)) == 8) {
			month += "Agosto";
		}else if(Integer.parseInt(fecha.substring(4,5)) == 9) {
			month += "Septiembre";
		}else if(Integer.parseInt(fecha.substring(3,5)) == 10) {
			month += "Octubre";
		}else if(Integer.parseInt(fecha.substring(3,5)) == 11) {
			month += "Noviembre";
		}else {
			month += "Diciembre";
		}
		JOptionPane.showMessageDialog(null,"LA FECHA INGRESADA ES " + day + " de " + month + " de " + year);
		}else {
			JOptionPane.showMessageDialog(null,"LA FECHA INGRESADA NO ES VALIDA");
		}

	
		return "";
	}
	public static boolean validarFecha (String fecha) {
		try{
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			formato.setLenient(false);
			formato.parse(fecha);
			
		}catch(Exception e) {
			return false;
		}
		return true;
	}
}
