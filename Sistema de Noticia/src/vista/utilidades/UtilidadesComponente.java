/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.utilidades;

import controlador.utilidades.Utilidades;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import modelo.enums.TipoNoticia;

/**
 *
 * @author Víctor Andrés Rojas
 */
public class UtilidadesComponente {

    public static boolean mostrarError(JComponent componente, String mensaje, char tipoValidacion) {
        boolean band = false;
        switch (tipoValidacion) {
            case 'r':
                if (componente instanceof JTextComponent) {
                    JTextComponent txt = (JTextComponent) componente;
                    if (Utilidades.isEmpty(txt.getText())) {
                        componente.setBorder(BorderFactory.createLineBorder(Color.RED));
                        componente.setToolTipText(mensaje);
                    } else {
                        componente.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                        componente.setToolTipText(null);
                        band = true;
                    }
                }
        }

        return band;
    }

    public static void mensajeError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void mensajeOK(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    //Programación en Espejo.- Enviar un objeto y se refleja el cambio
    public static void cargarComboTipo(JComboBox cbx) {
        cbx.removeAllItems();
        for (TipoNoticia tipo : TipoNoticia.values()) {
            cbx.addItem(tipo);
        }
    }
}
