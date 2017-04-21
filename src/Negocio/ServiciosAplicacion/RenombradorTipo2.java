package Negocio.ServiciosAplicacion;
import java.io.File;

import Negocio.TransferParametros;

public class RenombradorTipo2 extends Renombrador {

	private String nombre_serie;
	private String num_Temporada;

	/**
	 * 
	 */
	public RenombradorTipo2() {
		super();
	}

	@Override
	public void cambiarNombresFicheros(TransferParametros param) {
		setParametros(param);
		int numCap = 1;

		File[] ficheros = directorio.listFiles();
		System.out.println("----------------------------------");
		System.out.println("Directorio: " + directorio.getName());
		System.out.println("Número ficheros: " + ficheros.length);

		String[] nombre_ficheros = directorio.list();
		for (String nom : nombre_ficheros)
			System.out.println(" - " + nom);

		System.out.println("-----------------------------------------");
		System.out.println();
		System.out.println();

		if (nombre_ficheros == null)
			System.out.println("No hay ficheros en el directorio especificado");
		else {
			for (File fichero : ficheros) {

				String extension = fichero.getName().substring(
						fichero.getName().lastIndexOf(".") + 1);

				if (extension.equalsIgnoreCase(super.extension)) {

					// Nombre
					System.out.println("Procesando fichero: "
							+ fichero.getName());

					String nombre_final_fichero = extraerNombreDeFichero(param,numCap);
					numCap++;
					
					// Renombrando fichero
					System.out.println("Renombrando Fichero...****");

					
					
					if (!renombrarFichero(fichero, nombre_final_fichero)) {
						System.out.println("Error intentando cambiar el nombre de fichero");
					} else {
						System.out.println("nombre cambiado!");
					}

					System.out.println("-------------------------");
				}
			}

		}

	}

	public String extraerNombreDeFichero(TransferParametros param, int numero) {
		setParametros(param);
		System.out.println("DIRECTORIOOOOO:  " + directorio.getName());
		System.out.println("directorio.listFiles()[0]: " + directorio.listFiles()[0]);
		return extraerNombreDeFichero(directorio.listFiles()[0], numero);
	}

	private String extraerNombreDeFichero(File fichero, int numero) {

		boolean fin = false;

		String extension = fichero.getName().substring(
				fichero.getName().lastIndexOf(".") + 1);
		// System.out.println("Ext: " + extension);

		String nombreFinal = "";
		// Nombre de la serie
		nombreFinal = nombre_serie;

		nombreFinal = nombreFinal + " " + separador_palabras_final + " ";

		// Temporada y capitulo
		if (numero >= 0 && numero <= 9) {
			nombreFinal = nombreFinal + num_Temporada + "x0" + numero + " "
					+ separador_palabras_final + " ";
			;
		} else {
			nombreFinal = nombreFinal + num_Temporada + "x" + numero + " "
					+ separador_palabras_final + " ";
			;
		}

		nombreFinal = nombreFinal + "[" + idioma + " " + calidad + "]."
				+ super.extension;

		// System.out.println("Nombre final: " + nombreFinal);

		return nombreFinal;

	}

	@Override
	public void setParametros(TransferParametros param) {

		super.setParametros(param);
		this.nombre_serie = param.getNombre_serie();
		this.num_Temporada = param.getNum_Temporada();

	}

}
