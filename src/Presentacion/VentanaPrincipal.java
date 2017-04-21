package Presentacion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import Negocio.RenombradorTipo1;
import Negocio.TransferParametros;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.EventoGUI;
import Presentacion.Controlador.TipoRenombrador;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = 6260339989633298267L;
	private JLabel labelDirectorio;
	private JTextField textFieldDirectorio;
	private JPanel panelDirectorioOpcion;
	private JPanel panelDatos;

	private JLabel labelSeparadorPalabras;
	private JTextField textFieldSeparadorPalabras;
	private JLabel labelTamSerie;
	private JTextField textFieldTamNombreSerie;
	private JLabel labelCalidad;
	private JTextField textFielCalidad;
	private JLabel labelIdioma;
	private JTextField textFieldIdioma;
	private JLabel labelIndicadorFinal;
	private JTextField textFieldIndicadorFinal;

	private int TAM_TEXTFIELDS_STANDAR = 7;
	private JPanel panelNorte;
	private JPanel panelCentral;
	private JTextArea textAreaFicheros;
	private JPanel panelEjemploResultado;
	private JTextArea textAreaEjemplo;
	private JPanel panelBotones;
	private JButton botonIniciar;

	private File directorio;
	private JPanel panelEleccion;
	private JComboBox<String> comboEleccion;
	private JLabel labelNombreSerie;
	private JTextField textFieldNombreSerie;
	private JLabel labelSeparadorFinal;
	private JTextField textFieldSeparadorFinal;
	private JPanel panelDatosComunes;
	private JLabel labelNumTemporada;
	private JTextField textFieldNumTemporada;
	private JButton botonTest;
	private Vector<String> opciones;
	private JLabel labelExtension;
	private JTextField textFieldExtension;

	public VentanaPrincipal() {
		super("Renombrar ficheros");

		create();
		agregarManejadoresDeEventos();

		setLocationRelativeTo(null);
		setResizable(false);
	}

	public void create() {

		// Panel de path
		panelDirectorioOpcion = new JPanel();
		panelDirectorioOpcion.setBorder(BorderFactory
				.createTitledBorder("Directorio"));
		textFieldDirectorio = new JTextField(
				"C:\\Users\\Rodrigo de Miguel\\workspace\\Pruebas", 45);

		/*
		 * JFileChooser chooser = new JFileChooser();
		 * chooser.setCurrentDirectory(new java.io.File("."));
		 * chooser.setDialogTitle("choosertitle");
		 * chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		 * chooser.setAcceptAllFileFilterUsed(false);
		 * 
		 * if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		 * System.out.println("getCurrentDirectory(): " +
		 * chooser.getCurrentDirectory());
		 * System.out.println("getSelectedFile() : " +
		 * chooser.getSelectedFile()); } else {
		 * System.out.println("No Selection "); }
		 * 
		 * 
		 * panelDirectorio.add(chooser);
		 */

		panelDirectorioOpcion.add(textFieldDirectorio, BorderLayout.CENTER);

		panelEleccion = new JPanel();
		panelEleccion.setBorder(BorderFactory
				.createTitledBorder("Tipo de nombre"));

		opciones = new Vector<String>();
		opciones.add("Nombre_serie_[TxCC]_Nombre_capitulo");
		opciones.add("Poner nombre a mano");
		comboEleccion = new JComboBox<String>(opciones);
		panelDirectorioOpcion.add(comboEleccion, BorderLayout.CENTER);

		// Panel de datos necesario
		panelDatos = new JPanel();
		panelDatos.setBorder(BorderFactory.createTitledBorder("Datos"));

		crearComponentesOpcion1();
		crearcomponentesOpcion2();

		añadirComponentes();

		crearPanelDatosComunes();

		// Panel central
		// Panel Ejemplo resultado
		panelEjemploResultado = new JPanel();
		panelEjemploResultado.setBorder(BorderFactory
				.createTitledBorder("Resultado final de nombre fichero"));

		textAreaEjemplo = new JTextArea(1, 50);
		textAreaEjemplo.setBorder(BorderFactory
				.createTitledBorder("Ficheros encontrados"));
		textAreaEjemplo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelEjemploResultado.add(textAreaEjemplo);

		panelEjemploResultado.add(textAreaEjemplo);

		panelNorte = new JPanel(new BorderLayout());
		panelNorte.add(panelDirectorioOpcion, BorderLayout.NORTH);
		panelNorte.add(panelDatosComunes, BorderLayout.CENTER);
		panelNorte.add(panelDatos, BorderLayout.SOUTH);

		panelCentral = new JPanel(new BorderLayout());

		// Text area ficheros
		textAreaFicheros = new JTextArea(20, 50);
		textAreaFicheros.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textAreaFicheros.setEditable(false);
		panelCentral.add(textAreaFicheros);

		panelCentral.add(panelEjemploResultado, BorderLayout.SOUTH);

		// panel sur

		panelBotones = new JPanel();
		panelBotones.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		botonTest = new JButton("Test");
		panelBotones.add(botonTest);

		botonIniciar = new JButton("Iniciar");
		panelBotones.add(botonIniciar);

		// Agregar paneles A la ventana
		this.add(panelNorte, BorderLayout.NORTH);
		this.add(panelCentral, BorderLayout.CENTER);
		this.add(panelBotones, BorderLayout.SOUTH);

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);

		pack();
	}

	private void añadirComponentes() {
		panelDatos.add(labelNombreSerie);
		panelDatos.add(textFieldNombreSerie);

		panelDatos.add(labelNumTemporada);
		panelDatos.add(textFieldNumTemporada);

		panelDatos.add(labelSeparadorPalabras);
		panelDatos.add(textFieldSeparadorPalabras);

		panelDatos.add(labelTamSerie);
		panelDatos.add(textFieldTamNombreSerie);

		panelDatos.add(labelIndicadorFinal);
		panelDatos.add(textFieldIndicadorFinal);

		panelDatos.add(labelSeparadorFinal);
		panelDatos.add(textFieldSeparadorFinal);
	}

	private void crearPanelDatosComunes() {

		panelDatosComunes = new JPanel();
		panelDatosComunes.setBorder(BorderFactory
				.createTitledBorder("Datos comunes"));

		labelCalidad = new JLabel("Calidad: ");
		textFielCalidad = new JTextField("1080p", TAM_TEXTFIELDS_STANDAR);
		panelDatosComunes.add(labelCalidad);
		panelDatosComunes.add(textFielCalidad);

		labelIdioma = new JLabel("Idioma: ");
		textFieldIdioma = new JTextField("Dual", TAM_TEXTFIELDS_STANDAR);
		panelDatosComunes.add(labelIdioma);
		panelDatosComunes.add(textFieldIdioma);

		labelExtension = new JLabel("Extensión: ");
		textFieldExtension = new JTextField("mkv", TAM_TEXTFIELDS_STANDAR);
		panelDatosComunes.add(labelExtension);
		panelDatosComunes.add(textFieldExtension);

	}

	private void crearcomponentesOpcion2() {

		(labelNombreSerie = new JLabel("Nombre serie")).setVisible(false);

		(textFieldNombreSerie = new JTextField(TAM_TEXTFIELDS_STANDAR))
				.setVisible(false);

		panelDatos.add(labelNombreSerie);
		panelDatos.add(textFieldNombreSerie);

		(labelNumTemporada = new JLabel("Número temporada")).setVisible(false);

		(textFieldNumTemporada = new JTextField(TAM_TEXTFIELDS_STANDAR))
				.setVisible(false);

	}

	private void crearComponentesOpcion1() {

		labelSeparadorPalabras = new JLabel("Separador de palabras");
		textFieldSeparadorPalabras = new JTextField(TAM_TEXTFIELDS_STANDAR);
		panelDatos.add(labelSeparadorPalabras);
		panelDatos.add(textFieldSeparadorPalabras);

		labelTamSerie = new JLabel("Tam primer nombre");
		textFieldTamNombreSerie = new JTextField(TAM_TEXTFIELDS_STANDAR);
		panelDatos.add(labelTamSerie);
		panelDatos.add(textFieldTamNombreSerie);

		labelIndicadorFinal = new JLabel("Indicador de final: ");
		textFieldIndicadorFinal = new JTextField(TAM_TEXTFIELDS_STANDAR);
		panelDatos.add(labelIndicadorFinal);
		panelDatos.add(textFieldIndicadorFinal);

		labelSeparadorFinal = new JLabel("Separador final");
		textFieldSeparadorFinal = new JTextField(TAM_TEXTFIELDS_STANDAR);
		panelDatos.add(labelSeparadorFinal);
		panelDatos.add(textFieldSeparadorFinal);

	}

	private void agregarManejadoresDeEventos() {
		ALVentanaPrincipal oyente = new ALVentanaPrincipal();
		FLVentanaCrearProfesor oyenteFocus = new FLVentanaCrearProfesor();

		textFieldDirectorio.addFocusListener(oyenteFocus);
		textFieldSeparadorFinal.addFocusListener(oyenteFocus);
		botonIniciar.addActionListener(oyente);
		botonTest.addActionListener(oyente);
		comboEleccion.addActionListener(oyente);

		textFieldExtension.addFocusListener(oyenteFocus);

		this.addWindowListener(new WLVentanaMostrarProfesor());
	}

	private void rellenarAreaFicheros(File dir) {
		textAreaFicheros.setText("");

		directorio = dir;
		String[] nombre_ficheros = dir.list();

		if (!VentanaPrincipal.this.textFieldExtension.getText().equals("")) {
			for (String nom : nombre_ficheros) {
				String extension = nom.substring(nom.lastIndexOf(".") + 1);
				if (extension
						.equalsIgnoreCase(VentanaPrincipal.this.textFieldExtension
								.getText())) {
					textAreaFicheros.append(" - " + nom
							+ System.getProperty("line.separator"));
				}

			}
		} else {
			for (String nom : nombre_ficheros)
				textAreaFicheros.append(" - " + nom
						+ System.getProperty("line.separator"));
		}

	}

	private void ocultarElementos() {
		labelSeparadorPalabras.setVisible(false);
		textFieldSeparadorPalabras.setVisible(false);
		labelTamSerie.setVisible(false);
		textFieldTamNombreSerie.setVisible(false);
		// labelCalidad.setVisible(false);
		// textFielCalidad.setVisible(false);
		// labelIdioma.setVisible(false);
		// textFieldIdioma.setVisible(false);
		labelIndicadorFinal.setVisible(false);
		textFieldIndicadorFinal.setVisible(false);

		labelNombreSerie.setVisible(false);
		textFieldNombreSerie.setVisible(false);
		labelSeparadorFinal.setVisible(false);
		textFieldSeparadorFinal.setVisible(false);
		labelNumTemporada.setVisible(false);
		textFieldNumTemporada.setVisible(false);

	}

	public class FLVentanaCrearProfesor implements FocusListener {

		public void focusGained(FocusEvent e) {

			// if(e.getSource() == txtFieldID_Turno){
			// }
		}

		public void focusLost(FocusEvent e) {

			if (e.getSource() == textFieldExtension) {
				String path = textFieldDirectorio.getText();
				File dir = new File(path);
				rellenarAreaFicheros(dir);
			}

			if (e.getSource() == textFieldDirectorio) {
				String path = textFieldDirectorio.getText();

				if (!path.equalsIgnoreCase("")) {

					File dir = new File(path);

					if (dir.exists()) {
						rellenarAreaFicheros(dir);
					} else {
						JOptionPane.showMessageDialog(null,
								"El directorio no existe!");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Ruta vacia!");
					textFieldDirectorio.requestFocus();
				}
			}

			if (e.getSource() == textFieldSeparadorFinal) {
				int num_nombre_serie = 0;
				textAreaEjemplo.setText("");

				// Mostrar ejemplo
				try {

					if (((String) comboEleccion.getSelectedItem()).equalsIgnoreCase(opciones.elementAt(0))) {
						num_nombre_serie = Integer
								.parseInt(textFieldTamNombreSerie.getText());
					}

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,
							"Inserta un numero de palabras inicial!");
					textFieldTamNombreSerie.requestFocus();
				}

				String nombreFichero = "";
				if (comboEleccion.getSelectedItem().equals(
						opciones.elementAt(0))) {
					TransferParametros parametros = new TransferParametros(
							num_nombre_serie,
							VentanaPrincipal.this.textFieldIndicadorFinal
									.getText(),
							VentanaPrincipal.this.textFielCalidad.getText(),
							VentanaPrincipal.this.textFieldIdioma.getText(),
							VentanaPrincipal.this.textFieldSeparadorPalabras
									.getText(), directorio,
							VentanaPrincipal.this.textFieldSeparadorFinal
									.getText(),
							VentanaPrincipal.this.textFieldExtension.getText());

					nombreFichero = (String) Controlador.getInstance().action(
							EventoGUI.EXTRAER_NOMBRE_FICHERO,
							TipoRenombrador.NOMBRESERIE_TxCC_NOMBRECAPITULO,
							parametros);

				} else if (comboEleccion.getSelectedItem().equals(
						opciones.elementAt(1))) {

					TransferParametros parametros = new TransferParametros(
							directorio,
							VentanaPrincipal.this.textFielCalidad.getText(),
							VentanaPrincipal.this.textFieldIdioma.getText(),
							VentanaPrincipal.this.textFieldSeparadorFinal
									.getText(),
							VentanaPrincipal.this.textFieldNombreSerie
									.getText(),
							VentanaPrincipal.this.textFieldNumTemporada
									.getText(),
							VentanaPrincipal.this.textFieldExtension.getText());

					nombreFichero = (String) Controlador.getInstance().action(
							EventoGUI.EXTRAER_NOMBRE_FICHERO,
							TipoRenombrador.RENOMBRAR_A_MANO, parametros);

					textAreaEjemplo.setText(nombreFichero);

				}

				textAreaEjemplo.setText(nombreFichero);

			}
		}

	}

	public class ALVentanaPrincipal implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == botonIniciar) {

				int num_nombre_serie = 0;
				textAreaEjemplo.setText("");

				// Mostrar ejemplo
				try {
					
					if (((String) comboEleccion.getSelectedItem()).equalsIgnoreCase(opciones.elementAt(0))) {
						num_nombre_serie = Integer
								.parseInt(textFieldTamNombreSerie.getText());
					}
					
					// obtencion de parametros e inicializacion de negocio
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,
							"Inserta un numero de palabras inicial!");
					textFieldTamNombreSerie.requestFocus();
				}

				if (comboEleccion.getSelectedItem().equals(
						opciones.elementAt(0))) {
					TransferParametros parametros = new TransferParametros(
							num_nombre_serie,
							VentanaPrincipal.this.textFieldIndicadorFinal
									.getText(),
							VentanaPrincipal.this.textFielCalidad.getText(),
							VentanaPrincipal.this.textFieldIdioma.getText(),
							VentanaPrincipal.this.textFieldSeparadorPalabras
									.getText(), directorio.listFiles()[0],
							VentanaPrincipal.this.textFieldSeparadorFinal
									.getText(),
							VentanaPrincipal.this.textFieldExtension.getText());

					Controlador.getInstance().action(
							EventoGUI.CAMBIAR_NOMBRE_FICHERO,
							TipoRenombrador.NOMBRESERIE_TxCC_NOMBRECAPITULO,
							parametros);
				}else if (comboEleccion.getSelectedItem().equals(
						opciones.elementAt(1))) {
					
					TransferParametros parametros = new TransferParametros(
							directorio,
							VentanaPrincipal.this.textFielCalidad.getText(),
							VentanaPrincipal.this.textFieldIdioma.getText(),
							VentanaPrincipal.this.textFieldSeparadorFinal
									.getText(),
							VentanaPrincipal.this.textFieldNombreSerie
									.getText(),
							VentanaPrincipal.this.textFieldNumTemporada
									.getText(),
							VentanaPrincipal.this.textFieldExtension.getText());

					Controlador.getInstance().action(
							EventoGUI.CAMBIAR_NOMBRE_FICHERO,
							TipoRenombrador.RENOMBRAR_A_MANO,
							parametros);
				}
				
				
				
				JOptionPane.showMessageDialog(null, "Ficheros renombrados!");
				VentanaPrincipal.this.rellenarAreaFicheros(directorio);
			}

			if (e.getSource() == comboEleccion) {
				if (comboEleccion.getSelectedItem().equals(
						opciones.elementAt(0))) {
					ocultarElementos();
					labelSeparadorPalabras.setVisible(true);
					textFieldSeparadorPalabras.setVisible(true);

					labelIndicadorFinal.setVisible(true);
					textFieldIndicadorFinal.setVisible(true);

					labelTamSerie.setVisible(true);
					textFieldTamNombreSerie.setVisible(true);
					
					labelSeparadorFinal.setVisible(true);
					textFieldSeparadorFinal.setVisible(true);

				}

				if (comboEleccion.getSelectedItem().equals(
						opciones.elementAt(1))) {
					ocultarElementos();

					labelSeparadorFinal.setVisible(true);
					textFieldSeparadorFinal.setVisible(true);

					labelNombreSerie.setVisible(true);
					textFieldNombreSerie.setVisible(true);

					labelNumTemporada.setVisible(true);
					textFieldNumTemporada.setVisible(true);

				}

			}

		}
	}

	public class WLVentanaMostrarProfesor implements WindowListener {

		public void windowActivated(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente

		}

		public void windowClosed(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente

		}

		public void windowClosing(WindowEvent e) {
			VentanaPrincipal.this.dispose();
		}

		public void windowDeactivated(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente

		}

		public void windowDeiconified(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente

		}

		public void windowIconified(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente

		}

		public void windowOpened(WindowEvent e) {
			// TODO Apéndice de método generado automáticamente

		}
	}

}
