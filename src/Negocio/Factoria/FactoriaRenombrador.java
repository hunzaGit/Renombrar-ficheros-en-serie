package Negocio.Factoria;

import Negocio.ServiciosAplicacion.Renombrador;
import Negocio.ServiciosAplicacion.RenombradorTipo1;
import Negocio.ServiciosAplicacion.RenombradorTipo2;
import Presentacion.Controlador.TipoRenombrador;

public class FactoriaRenombrador {

	private static FactoriaRenombrador uniqueInstance;

	public static FactoriaRenombrador getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new FactoriaRenombrador();
		}
		return uniqueInstance;

	}

	
	
	public Renombrador crearRenombrador(int tipo) {

		switch (tipo) {
		case TipoRenombrador.NOMBRESERIE_TxCC_NOMBRECAPITULO:
			return new RenombradorTipo1();

			
		case TipoRenombrador.RENOMBRAR_A_MANO:
			return new RenombradorTipo2();
		default:
			break;
		}

		return null;
	}

}
