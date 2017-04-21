package Negocio;

import java.io.File;

import Presentacion.VentanaPrincipal;

public class TransferParametros {

	
	private int num_nombre_serie;
	private String indicadorFinal;
	private String calidad;
	private String idioma;
	private String separadorPalabras;
	private File directorio;
	private String separadorFinal;
	
	private String nombre_serie;
	private String num_Temporada;
	
	private String extension;

	public TransferParametros(int num_nombre_serie, String indicadorFinal, String calidad,
			String idioma, String separadorPalabras, File directorio, String separadorFinal, String extension) {
		
		this.num_nombre_serie = num_nombre_serie;
		this.indicadorFinal = indicadorFinal;
		this.calidad = calidad;
		this.idioma = idioma;
		
		this.separadorPalabras = separadorPalabras;
	 
		this.directorio = directorio;
		
		this.separadorFinal = separadorFinal;
		
		this.extension = extension;
		
	}

	public TransferParametros(File directorio, String calidad, String idioma,
			String separadorFinal, String nombre_serie, String num_Temporada, String extension) {

		this.calidad = calidad;
		this.idioma = idioma;	 
		this.directorio = directorio;
		this.separadorFinal = separadorFinal;
		
		this.nombre_serie =nombre_serie;
		this.num_Temporada = num_Temporada;
		
		this.extension = extension;
	
	}

	/**
	 * @return the num_nombre_serie
	 */
	public int getNum_nombre_serie() {
		return num_nombre_serie;
	}

	/**
	 * @param num_nombre_serie the num_nombre_serie to set
	 */
	public void setNum_nombre_serie(int num_nombre_serie) {
		this.num_nombre_serie = num_nombre_serie;
	}

	/**
	 * @return the indicadorFinal
	 */
	public String getIndicadorFinal() {
		return indicadorFinal;
	}

	/**
	 * @param indicadorFinal the indicadorFinal to set
	 */
	public void setIndicadorFinal(String indicadorFinal) {
		this.indicadorFinal = indicadorFinal;
	}

	/**
	 * @return the calidad
	 */
	public String getCalidad() {
		return calidad;
	}

	/**
	 * @param calidad the calidad to set
	 */
	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	/**
	 * @return the idioma
	 */
	public String getIdioma() {
		return idioma;
	}

	/**
	 * @param idioma the idioma to set
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	/**
	 * @return the separadorPalabras
	 */
	public String getSeparadorPalabras() {
		return separadorPalabras;
	}

	/**
	 * @param separadorPalabras the separadorPalabras to set
	 */
	public void setSeparadorPalabras(String separadorPalabras) {
		this.separadorPalabras = separadorPalabras;
	}

	public File getDirectorio() {
		return directorio;
	}

	public void setDirectorio(File directorio) {
		this.directorio = directorio;
	}

	public String getSeparadorFinal() {
		return separadorFinal;
	}

	public void setSeparadorFinal(String separadorFinal) {
		this.separadorFinal = separadorFinal;
	}

	/**
	 * @return the nombre_serie
	 */
	public String getNombre_serie() {
		return nombre_serie;
	}

	/**
	 * @param nombre_serie the nombre_serie to set
	 */
	public void setNombre_serie(String nombre_serie) {
		this.nombre_serie = nombre_serie;
	}

	/**
	 * @return the num_Temporada
	 */
	public String getNum_Temporada() {
		return num_Temporada;
	}

	/**
	 * @param num_Temporada the num_Temporada to set
	 */
	public void setNum_Temporada(String num_Temporada) {
		this.num_Temporada = num_Temporada;
	}

	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

}
