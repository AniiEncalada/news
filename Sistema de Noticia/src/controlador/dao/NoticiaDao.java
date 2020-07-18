/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.Conexion;
import java.util.ArrayList;
import java.util.List;
import modelo.Noticia;

/**
 *
 * @author Víctor Andrés Rojas
 */
public class NoticiaDao extends AdaptadorDao<Noticia> {

    private Noticia noticia;

    public NoticiaDao() {
        super(new Conexion(), Noticia.class);
    }

    public Noticia getNoticia() {
        if (noticia == null) {
            noticia = new Noticia();
        }
        return noticia;
    }

    public void fijaInstancia(Noticia noticia) {
        this.noticia = noticia;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            if (noticia.getId() != null) {
                /*List<Noticia> lista = listar();
                for (Noticia noti : lista) {
                    if (noti.getId().intValue() == this.noticia.getId().intValue()) {
                        this.guardar(noticia, lista.indexOf(noti));
                        break;
                    }
                }*/
                this.modificar(noticia);
            } else {
                this.noticia.setId(generarID());
                this.guardar(noticia);
            }
            band = true;
        } catch (Exception e) {
            System.out.println("No se pudo guardar " + e);
        }
        return band;
    }

    /*public boolean eliminar(Long id) {
        boolean band = false;
        try {
            this.fijaInstancia(this.obtener(id));
            this.eliminar(noticia);
            band = true;
        } catch (Exception e) {
            System.out.println("No se pudo eliminar " + e);
        }
        return band;
    }*/
    public List<Noticia> listarNoticiaAdministrador(Long id) {
        List<Noticia> listado = new ArrayList<>();
        for (Noticia aux : listar()) {
            if (aux.getAdministrador().getId().intValue() == id.intValue()) {
                listado.add(aux);
            }
        }
        return listado;
    }

    public List<Noticia> listarNoticiaAdministradorBusqueda(Long id, String texto) {
        List<Noticia> listado = new ArrayList<>();
        for (Noticia aux : listar()) {
            if (aux.getAdministrador().getId().intValue() == id.intValue()
                    && aux.getTitulo().toLowerCase().contains(texto.toLowerCase())) {
                listado.add(aux);
            }
        }
        return listado;
    }
}
