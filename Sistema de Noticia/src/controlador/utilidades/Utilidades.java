/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.Noticia;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Víctor Andrés Rojas
 */
public class Utilidades extends StringUtils {

    public static String verNoticiasListado(List<Noticia> lista) {
        String noticias = "";
        if (lista.isEmpty()) {
            noticias = "No se pudo encontrar la noticia para este Administrador";
        } else {
            int cont = 1;
            for (Noticia noticia : lista) {
                noticias += cont + "\t";
                noticias += noticia.getTitulo() + "\t";
                noticias += noticia.getContenido() + "\t";
                noticias += formatearFecha(noticia.getFecha()) + "\n";
                cont++;
            }
        }
        return noticias;
    }

    public static String formatearFecha(Date fecha) {
        String fechaSalida = "";
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            fechaSalida = formato.format(fecha);
        } catch (Exception e) {
            System.out.println("No se pudo dar formato a la fecha");
        }
        return fechaSalida;
    }
}
