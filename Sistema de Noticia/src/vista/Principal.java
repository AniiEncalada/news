/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.servicio.ServicioAdministrador;
import controlador.servicio.ServicioNoticia;
import controlador.utilidades.Sesiones;
import controlador.utilidades.Utilidades;
import it.sauronsoftware.base64.Base64;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import modelo.enums.TipoNoticia;

//import java.util.Date;
//import modelo.enums.TipoNoticia;
/**
 *
 * @author PotatoPower
 */
public class Principal {

    public static Scanner obtenerScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    public static void main(String[] args) {
        ServicioAdministrador servicioAdministrador = new ServicioAdministrador();
        ServicioNoticia servicioNoticia = new ServicioNoticia();

        //Crear usuario
//        servicioAdministrador.listado();
//        servicioAdministrador.obtenerAdministrador().setNombre("Victor");
//        servicioAdministrador.obtenerAdministrador().setApellido("Rojas");
//        servicioAdministrador.obtenerAdministrador().setUsuario("victor");
//        servicioAdministrador.obtenerAdministrador().setClave(Base64.encode("victor"));
//        if (servicioAdministrador.guardar()) {
//            System.out.println("Ha guardado");
//        } else {
//            System.out.println("No ha guardado");
//        }
        Sesiones.setSesion(servicioAdministrador.inicioSesion("victor", "victor"));
        System.out.println("Bienvenido al sistema de noticias");
        while (true) {
            if (Sesiones.getSesion() == null) {
                System.out.println("Inicie sesión");
                System.out.print("Ingrese su usuario: ");
                String usuario = Principal.obtenerScanner().nextLine();
                System.out.print("Ingrese su clave: ");
                String clave = Principal.obtenerScanner().nextLine();
                Sesiones.setSesion(servicioAdministrador.inicioSesion(usuario, clave));
            } else {
                //break;
                System.out.println("1. Registro de noticias\n"
                        + "2. Listado de noticias\n"
                        + "3. Edición de noticias\n"
                        + "4. Buscar\n"
                        + "5. Salir");
                System.out.print("Ingrese una opción: ");
                try {
                    int opcion = Integer.parseInt(Principal.obtenerScanner().nextLine());

                    switch (opcion) {
                        case 1:
                            //Registro
                            JComboBox<TipoNoticia> listado = new JComboBox<>();
                            for (TipoNoticia tipo : TipoNoticia.values()) {
                                listado.addItem(tipo);
                            }
                            String titulo = JOptionPane.showInputDialog("Ingrese el título de la Noticia");
                            JTextArea textoNoticia = new JTextArea();
                            textoNoticia.setColumns(30);
                            textoNoticia.setLineWrap(true);
                            textoNoticia.setWrapStyleWord(true);
                            JOptionPane.showMessageDialog(null, new JScrollPane(textoNoticia),
                                    "Ingrese el cuerpo de la Noticia", JOptionPane.INFORMATION_MESSAGE);
                            String cuerpo = textoNoticia.getText();
                            if (Utilidades.isEmpty(titulo) || Utilidades.isEmpty(cuerpo)) {
                                JOptionPane.showMessageDialog(null, "Faltan campos por llenar");
                                break;
                            }
                            ServicioAdministrador aux = new ServicioAdministrador();
                            aux.obtenerAdministrador().setId(Sesiones.getSesion().getId());
                            servicioNoticia.obtenerNoticia().setAdministrador(aux.obtenerAdministrador());
                            JOptionPane.showMessageDialog(null, listado,
                                    "Seleccione el tipo de Noticia", JOptionPane.INFORMATION_MESSAGE);
                            servicioNoticia.obtenerNoticia().setTipoNoticia((TipoNoticia) listado.getSelectedItem());
                            servicioNoticia.obtenerNoticia().setTitulo(titulo);
                            servicioNoticia.obtenerNoticia().setContenido(cuerpo);
                            servicioNoticia.obtenerNoticia().setFecha(new Date());

                            if (servicioNoticia.guardar()) {
                                JOptionPane.showMessageDialog(null, "Se ha guardado con éxito");
                                servicioNoticia.fijarInstancia(null);
                            } else {
                                JOptionPane.showMessageDialog(null, "No se pudo guardar");
                            }
                            break;

                        case 2://Listar
                            JTextArea resultado1 = new JTextArea();
                            resultado1.setColumns(70);
                            resultado1.setLineWrap(true);
                            resultado1.setWrapStyleWord(true);
                            resultado1.setText(Utilidades.verNoticiasListado(
                                    servicioNoticia.listarNoticiaAdministrador(Sesiones.getSesion().getId())));
                            JOptionPane.showMessageDialog(null, resultado1, "Lista de Noticias", JOptionPane.INFORMATION_MESSAGE);

                            /*System.out.println(Utilidades.verNoticiasListado(servicioNoticia
                                    .listarNoticiaAdministrador(Sesiones.getSesion().getId())));*/
                            break;

                        case 3://Editar
                            System.out.println(Utilidades.verNoticiasListado(servicioNoticia
                                    .listarNoticiaAdministrador(Sesiones.getSesion().getId())));
                            String escogido = JOptionPane.showInputDialog("Escoga una Noticia del listado");
                            try {
                                int posNot = Integer.parseInt(escogido);
                                if (posNot >= 1 && posNot <= servicioNoticia.listarNoticiaAdministrador(
                                        Sesiones.getSesion().getId()).size()) {//Rango de la lista de noticias
                                    servicioNoticia.fijarInstancia(servicioNoticia.listarNoticiaAdministrador(
                                            Sesiones.getSesion().getId()).get(posNot - 1));

                                    JComboBox<TipoNoticia> listadoMod = new JComboBox<>();
                                    for (TipoNoticia tipo : TipoNoticia.values()) {
                                        listadoMod.addItem(tipo);
                                    }
                                    listadoMod.setSelectedItem(servicioNoticia.obtenerNoticia().getTipoNoticia());
                                    String tituloMod = JOptionPane.showInputDialog("Ingrese el titulo de la noticia",
                                            servicioNoticia.obtenerNoticia().getTitulo());
                                    JTextArea textoNoticiaMod = new JTextArea();
                                    textoNoticiaMod.setColumns(30);
                                    textoNoticiaMod.setLineWrap(true);
                                    textoNoticiaMod.setWrapStyleWord(true);
                                    textoNoticiaMod.setText(servicioNoticia.obtenerNoticia().getContenido());
                                    JOptionPane.showMessageDialog(null, new JScrollPane(textoNoticiaMod),
                                            "Ingrese el cuerpo de la noticia", JOptionPane.INFORMATION_MESSAGE);
                                    String cuerpoMod = textoNoticiaMod.getText();
                                    if (Utilidades.isEmpty(tituloMod) || Utilidades.isEmpty(cuerpoMod)) {
                                        JOptionPane.showMessageDialog(null, "Faltan campos por llenar ");
                                        break;
                                    }
                                    JOptionPane.showMessageDialog(null, listadoMod, "Seleccione una Noticia", JOptionPane.INFORMATION_MESSAGE);
                                    servicioNoticia.obtenerNoticia().setTipoNoticia((TipoNoticia) listadoMod.getSelectedItem());
                                    servicioNoticia.obtenerNoticia().setContenido(cuerpoMod);
                                    servicioNoticia.obtenerNoticia().setTitulo(tituloMod);
                                    servicioNoticia.obtenerNoticia().setFecha(new Date());

                                    if (servicioNoticia.guardar()) {
                                        JOptionPane.showMessageDialog(null, "Se ha modificado con exito");
                                        servicioNoticia.fijarInstancia(null);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No se pudo guardar");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Se necesita un número a buscar", "Error",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "No se encontró la noticia", "Mensaje",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                            break;

                        case 4://Buscar
                            String busqueda = JOptionPane.showInputDialog("Ingrese título a buscar: ");
                            if (Utilidades.isEmpty(busqueda)) {
                                JOptionPane.showMessageDialog(null, "Se necesita un texto a buscar", "Mensaje", JOptionPane.ERROR_MESSAGE);
                            } else {
                                JTextArea resultado = new JTextArea();
                                resultado.setColumns(70);
                                resultado.setLineWrap(true);
                                resultado.setWrapStyleWord(true);
                                resultado.setText(Utilidades
                                        .verNoticiasListado(
                                                servicioNoticia
                                                        .listarNoticiaAdministradorBusqueda(Sesiones.getSesion().getId(), busqueda)));
                                JOptionPane.showMessageDialog(null, resultado, "Resultado de la busqueda", JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;
                        case 5:
                            System.out.println("Se ha cerrado la sesión.");
                            break;
                        default:
                            System.out.println("Opción no válida");
                    }
                    if (opcion == 5) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Opción no válida.");
                }
            }
        }
        System.out.println("Ha salido del sistema de noticias");
    }
}
