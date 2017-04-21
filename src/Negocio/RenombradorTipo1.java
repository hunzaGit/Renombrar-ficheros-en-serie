package Negocio;

import java.io.File;

import javax.swing.JTextField;

public class RenombradorTipo1 extends Renombrador {

	private int num_nombre_serie;
	private String fin_nombre;
	private String separador_palabras;
	private String sepapador_palabras_final;

	public void cambiarNombresFicheros(TransferParametros param) {

		setParametros(param);
		boolean fin = false;

		// serie_3x45_nombre_capitulo_1080p
		// File dir = new
		// File("C:\\Users\\Rodrigo de Miguel\\Desktop\\Nueva carpeta");
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

				if (extension.equalsIgnoreCase(extension)) {
					// Nombre
					System.out.println("Procesando fichero: "
							+ fichero.getName());

					String nombre_final_fichero = extraerNombreDeFichero(
							fichero, -1);

					// Renombrando fichero
					System.out.println("Renombrando Fichero...****");

					if (!renombrarFichero(fichero, nombre_final_fichero)) {
						System.out
								.println("Error intentando cambiar el nombre de fichero");
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

		return extraerNombreDeFichero(param.getDirectorio().listFiles()[0],
				numero);
	}

	private String extraerNombreDeFichero(File fichero, int numero) {
		boolean fin = false;

		String extension = fichero.getName().substring(
				fichero.getName().lastIndexOf(".") + 1);
		// System.out.println("Ext: " + extension);

		String[] palabras_nombre = fichero.getName().split(separador_palabras);
		String nombreFinal = "";

		// Creando nombre
		for (int i = 0; i < palabras_nombre.length && !fin; i++) {

			// nombre serie
			while (i < num_nombre_serie) {
				nombreFinal = nombreFinal + palabras_nombre[i] + " ";
				i++;
			}
			nombreFinal = nombreFinal + sepapador_palabras_final + " ";
			// Capitulo
			nombreFinal = nombreFinal + palabras_nombre[i];
			i++;

			nombreFinal = nombreFinal + " " + sepapador_palabras_final + " ";

			// Nombre del Capitulo
			while (i < palabras_nombre.length && !fin) {

				try {
					// Si la palabra es mas grande que la plabra de fin
					if (palabras_nombre[i].length() >= fin_nombre.length()) {
						while (!palabras_nombre[i].substring(0,
								fin_nombre.length()).equalsIgnoreCase(
								fin_nombre)) {
							nombreFinal = nombreFinal + palabras_nombre[i];
							nombreFinal = nombreFinal + " ";

							i++;
						}
						fin = true;
					} else {
						nombreFinal = nombreFinal + palabras_nombre[i];
						nombreFinal = nombreFinal + " ";

						i++;

					}

				} catch (StringIndexOutOfBoundsException e) {

					nombreFinal = nombreFinal + palabras_nombre[i];
					nombreFinal = nombreFinal + " ";

					i++;

				}
			}

		}

		nombreFinal = nombreFinal + "[" + idioma + " " + calidad + "]."
				+ extension;

		// System.out.println("Nombre final: " + nombreFinal);

		return nombreFinal;

	}

	@Override
	public void setParametros(TransferParametros param) {
		super.setParametros(param);
		this.num_nombre_serie = param.getNum_nombre_serie();
		this.fin_nombre = param.getIndicadorFinal();

		this.separador_palabras = param.getSeparadorPalabras();
	}

}
