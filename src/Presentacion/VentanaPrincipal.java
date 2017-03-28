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

import Negocio.Negocio;

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
	private JPanel panelDirectorio;
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

	private int tamTextFieldStandar = 7;
	private JPanel panelNorte;
	private JPanel panelCentral;
	private JTextArea textAreaFicheros;
	private JPanel panelEjemploResultado;
	private JTextArea textAreaEjemplo;
	private JPanel panelBotones;
	private JButton botonIniciar;

	
	
	private Negocio negocio; 
	private File directorio;
	
	public VentanaPrincipal() {
		super("Renombrar ficheros");

		negocio = new Negocio();
		
		create();
		agregarManejadoresDeEventos();

		setLocationRelativeTo(null);
		setResizable(false);
	}

	public void create() {

		// Panel de path
		panelDirectorio = new JPanel();
		panelDirectorio.setBorder(BorderFactory
				.createTitledBorder("Directorio"));
		textFieldDirectorio = new JTextField(45);

		/*JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("choosertitle");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	      System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
	      System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
	    } else {
	      System.out.println("No Selection ");
	    }
		
		
		panelDirectorio.add(chooser);
		*/

		panelDirectorio.add(textFieldDirectorio);
		
		// Panel de datos necesario		
		panelDatos = new JPanel();
		panelDatos.setBorder(BorderFactory.createTitledBorder("Datos"));
		
		labelSeparadorPalabras = new JLabel("Separador de palabras");
		textFieldSeparadorPalabras = new JTextField(tamTextFieldStandar);

		labelTamSerie = new JLabel("Tam primer nombre");
		textFieldTamNombreSerie = new JTextField(tamTextFieldStandar);
		
		labelCalidad = new JLabel("Calidad: ");
		textFielCalidad = new JTextField("1080p", tamTextFieldStandar);

		labelIdioma = new JLabel("Idioma: ");
		textFieldIdioma = new JTextField("Dual", tamTextFieldStandar);

		labelIndicadorFinal = new JLabel("Indicador de final: ");
		textFieldIndicadorFinal = new JTextField(tamTextFieldStandar);

		panelDatos.add(labelSeparadorPalabras);
		panelDatos.add(textFieldSeparadorPalabras);
		
		panelDatos.add(labelTamSerie);
		panelDatos.add(textFieldTamNombreSerie);

		panelDatos.add(labelCalidad);
		panelDatos.add(textFielCalidad);

		panelDatos.add(labelIdioma);
		panelDatos.add(textFieldIdioma);

		panelDatos.add(labelIndicadorFinal);
		panelDatos.add(textFieldIndicadorFinal);



		// Panel central
		// Panel Ejemplo resultado
		panelEjemploResultado = new JPanel();
		panelEjemploResultado.setBorder(BorderFactory.createTitledBorder("Resultado final de nombre fichero"));
		
		textAreaEjemplo = new JTextArea(1, 50);
		textAreaEjemplo.setBorder(BorderFactory.createTitledBorder("Ficheros encontrados"));
		textAreaEjemplo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelEjemploResultado.add(textAreaEjemplo);
		
		panelEjemploResultado.add(textAreaEjemplo);
		
		
		panelNorte = new JPanel(new BorderLayout());
		panelNorte.add(panelDirectorio, BorderLayout.NORTH);
		panelNorte.add(panelDatos, BorderLayout.CENTER);
		
		
		panelCentral = new JPanel(new BorderLayout());

		// Text area ficheros
		textAreaFicheros = new JTextArea(20, 50);
		textAreaFicheros.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textAreaFicheros.setEditable(false);
		panelCentral.add(textAreaFicheros);
		
		
		panelCentral.add(panelEjemploResultado, BorderLayout.SOUTH);
		

		
		
		//panel sur
		
		panelBotones = new JPanel();
		panelBotones.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
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

	private void agregarManejadoresDeEventos() {
		ALVentanaMostrarProfesor oyente = new ALVentanaMostrarProfesor();
		FLVentanaCrearProfesor oyenteFocus = new FLVentanaCrearProfesor();

		textFieldDirectorio.addFocusListener(oyenteFocus);
		textFieldIndicadorFinal.addFocusListener(oyenteFocus);
		
		botonIniciar.addActionListener(oyente);

		this.addWindowListener(new WLVentanaMostrarProfesor());
	}

	
	private void rellenarAreaFicheros(File dir) {
		textAreaFicheros.setText("");
		
		
		directorio = dir;
		String[] nombre_ficheros = dir.list();
		for (String nom : nombre_ficheros)
			textAreaFicheros.append(" - " + nom + System.getProperty("line.separator"));
		
	}
	
	
	
	
	
	public class FLVentanaCrearProfesor implements FocusListener {


		public void focusGained(FocusEvent e) {

			// if(e.getSource() == txtFieldID_Turno){
			// }
		}

		public void focusLost(FocusEvent e) {
			
		
			if(e.getSource() == textFieldDirectorio){
				String path = textFieldDirectorio.getText();
				//String path = "C:/Users/Rodrigo de Miguel/Desktop/Nueva carpeta";
				//textFieldDirectorio.setText(path);
				//textFieldTamNombreSerie.setText("3");
				//textFieldIndicadorFinal.setText("1080p");
				
				if(!path.equalsIgnoreCase("")){
					
					File dir = new File(path);
					
					if(dir.exists()){
						
						rellenarAreaFicheros(dir);
					
					}else{
						JOptionPane.showMessageDialog(null, "No existe ese directorio!");
						textFieldDirectorio.requestFocus();
					}

				}else{
					JOptionPane.showMessageDialog(null, "Ruta vacia!");
					textFieldDirectorio.requestFocus();
				}
			}
			
			
			if(e.getSource() == textFieldIndicadorFinal){
				int num_nombre_serie = 0 ;
				textAreaEjemplo.setText("");
				
				//Mostrar ejemplo
				try{
					num_nombre_serie = Integer.parseInt(textFieldTamNombreSerie.getText());
					//obtencion de parametros e inicializacion de negocio
					negocio.setParametros(num_nombre_serie, VentanaPrincipal.this.textFieldIndicadorFinal.getText(), VentanaPrincipal.this.textFielCalidad.getText(), VentanaPrincipal.this.textFieldIdioma.getText(), VentanaPrincipal.this.textFieldSeparadorPalabras.getText());
				}catch (NumberFormatException e1){
					JOptionPane.showMessageDialog(null, "Inserta un numero de palabras inicial!");
					textFieldTamNombreSerie.requestFocus();
				}
				
				negocio.setParametros(num_nombre_serie, VentanaPrincipal.this.textFieldIndicadorFinal.getText(), VentanaPrincipal.this.textFielCalidad.getText(), VentanaPrincipal.this.textFieldIdioma.getText(), VentanaPrincipal.this.textFieldSeparadorPalabras.getText());
				textAreaEjemplo.setText(negocio.extraerNombreDeFichero(directorio.listFiles()[0]));
			
			}
		}


	}

	public class ALVentanaMostrarProfesor implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == botonIniciar){
				negocio.cambiarNombresFicheros(VentanaPrincipal.this.directorio);
				JOptionPane.showMessageDialog(null, "Ficheros renombrados!");
				VentanaPrincipal.this.rellenarAreaFicheros(directorio);
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
