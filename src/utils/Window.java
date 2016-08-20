package utils;

import javax.swing.JOptionPane;

/**
 * This class provides helper methods for Java swing.
 */
public class Window {

	public static String input(Object... messages) {
		return JOptionPane.showInputDialog(Utils.join(" ", messages));
	}

	public static int confirm(Object... messages) {
		return JOptionPane.showConfirmDialog(null, Utils.join(" ", messages));
	}

	public static void alert(Object... messages) {
		JOptionPane.showMessageDialog(null, Utils.join(" ", messages));
	}

}
