package Presentacion.Controlador;

import Negocio.FactoriaRenombrador;
import Negocio.Renombrador;
import Negocio.TransferParametros;




public class Controlador {
	
	
	private static Controlador uniqueInstance;

	public static Controlador getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Controlador();
		}
		return uniqueInstance;
	}


	public Object action(int evento, int tipo,  Object datos) {
		
		
		switch (evento) {
		
			case EventoGUI.EXTRAER_NOMBRE_FICHERO:{
				return FactoriaRenombrador.getInstance().crearRenombrador(tipo).extraerNombreDeFichero((TransferParametros) datos, 01);
				
			}
			
			
			case EventoGUI.CAMBIAR_NOMBRE_FICHERO:
				FactoriaRenombrador.getInstance().crearRenombrador(tipo).cambiarNombresFicheros((TransferParametros) datos);
				
			default:
				break;
		}
		return datos;
	}
}