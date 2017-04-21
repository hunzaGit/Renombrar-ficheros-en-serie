package Negocio.ServiciosAplicacion;

import java.io.File;

import Negocio.TransferParametros;
import Presentacion.VentanaPrincipal;

public abstract class Renombrador {

	
	protected String calidad;
	protected String idioma;
	protected String separador_palabras_final;
	protected File directorio;
	
	protected String extension;

	protected boolean renombrarFichero(File fichero, String nombre_nuevo) {
		File parent = fichero.getParentFile();

		boolean flag = fichero.renameTo(new File(parent, nombre_nuevo));

		return flag;
	}
	
	public abstract void cambiarNombresFicheros(TransferParametros param) ;


	public abstract String extraerNombreDeFichero(TransferParametros parametros, int numero) ;

	public void setParametros(TransferParametros param){
		this.directorio = param.getDirectorio();

		this.calidad = param.getCalidad();
		this.idioma = param.getIdioma();
		this.separador_palabras_final = param.getSeparadorFinal();
				
		this.extension = param.getExtension();
	}
	
	
}
