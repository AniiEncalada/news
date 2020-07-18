/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.utilitario;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Utilitario {

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/avatar.png"));
        return retValue;
    }

    public void verificadorNumeros(String texto, java.awt.event.KeyEvent evt) {//texto que se puede reemplazar por un JTextField.getText
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')
                || //delimitar con numeros que van de 0 a 9
                (texto.contains("."))
                && //Verificar que no haya ingresao comas o puntos decimales.
                (car != (char) KeyEvent.VK_BACK_SPACE)) {//No admitira espacios entre numeros
            evt.consume();//el evento consumira caracteres segun la condicion
        }
    }

    public void verificadorTexto(java.awt.event.KeyEvent evt) {//texto que se puede reemplazar por un JTextField.getText
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z')
                && //limita letras desde a hasta z en minuscula
                (car < 'A' || car > 'Z')
                && //limita letras desde a hasta z en mayuscula
                (car != (char) KeyEvent.VK_BACK_SPACE)
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();//el evento consumira caracteres segun la condicion
        }
    }

    public boolean isEmail(String texto) {
        String patron = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(texto);
        return matcher.matches();

    }

    public void verificadorEmail(String texto) {
        if (isEmail(texto)) {

        } else {
            JOptionPane.showMessageDialog(null, "Solo se admite correo");
            //JTextField.requestFocus();
        }
    }

    public void verificadorCedula(String cedula) {
        String[] division = cedula.split("");
        String ultimo = division[division.length - 1];
        int dg1, dg2, dg3, dg4, dg5, dg6, dg7, dg8, dg9, op1, op2, op3, op4, op5,
                op6, op7, op8, op9, sum = 0, res = 0, dgverificador;
        if (cedula.length() == 10) {
            dg1 = Integer.parseInt(division[division.length - 10]);
            dg2 = Integer.parseInt(division[division.length - 9]);
            dg3 = Integer.parseInt(division[division.length - 8]);
            dg4 = Integer.parseInt(division[division.length - 7]);
            dg5 = Integer.parseInt(division[division.length - 6]);
            dg6 = Integer.parseInt(division[division.length - 5]);
            dg7 = Integer.parseInt(division[division.length - 4]);
            dg8 = Integer.parseInt(division[division.length - 3]);
            dg9 = Integer.parseInt(division[division.length - 2]);
            dgverificador = Integer.parseInt(division[division.length - 1]);
            String pres = " " + dg1 + " " + dg2 + " " + dg3 + " " + dg4 + " " + dg5 + " " + dg6 + " " + dg7 + " " + dg8 + " " + dg9;
            op1 = dg1 * 2;
            if (op1 >= 10) {
                op1 = op1 - 9;
            }
            op2 = dg2 * 1;
            op3 = dg3 * 2;
            if (op3 >= 10) {
                op3 = op3 - 9;
            }
            op4 = dg4 * 1;
            op5 = dg5 * 2;
            if (op5 >= 10) {
                op5 = op5 - 9;
            }
            op6 = dg6 * 1;
            op7 = dg7 * 2;
            if (op7 >= 10) {
                op7 = op7 - 9;
            }
            op8 = dg8 * 1;
            op9 = dg9 * 2;
            if (op9 >= 10) {
                op9 = op9 - 9;
            }
            sum = op1 + op2 + op3 + op4 + op5 + op6 + op7 + op8 + op9;
            res = sum % 10;
            if (res == 0) {
                if (res == dgverificador) {
                    JOptionPane.showMessageDialog(null, "Correcto");
                } else {
                    JOptionPane.showMessageDialog(null, "Cedula incorrecta");
                    cedula = null;
                }
            } else {
                if (res >= 1) {
                    res = 10 - res;
                    if (res == dgverificador) {
                        JOptionPane.showMessageDialog(null, "Digito correcta");
                    } else {
                        JOptionPane.showMessageDialog(null, "Digito incorrecto");
                        cedula = null;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Cedula incorrecta");
                    cedula = null;
                }
            }
        }

    }
}
