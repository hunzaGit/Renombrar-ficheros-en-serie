
import java.io.File;
import java.lang.Exception;

import javax.swing.SwingUtilities;

import Presentacion.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger
					.getLogger(VentanaPrincipal.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger
					.getLogger(VentanaPrincipal.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger
					.getLogger(VentanaPrincipal.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger
					.getLogger(VentanaPrincipal.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		}


		// p.insertarObstaculos();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new VentanaPrincipal().setVisible(true);
			}
		});

	}

}