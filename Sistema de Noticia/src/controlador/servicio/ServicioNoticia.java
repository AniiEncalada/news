/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servicio;

import controlador.dao.NoticiaDao;
import java.util.List;
import modelo.Noticia;

/**
 *
 * @author Víctor Andrés Rojas
 */
public class ServicioNoticia {

    private NoticiaDao obj;

    public ServicioNoticia() {
        this.obj = new NoticiaDao();
    }

    public boolean guardar() {
        return this.obj.guardar();
    }

    public Noticia obtenerNoticia() {
        return obj.getNoticia();
    }

    public Noticia obtenerNoticia(Long id) {
        return obj.obtener(id);
    }

    public void fijarInstancia(Noticia noticia) {
        obj.fijaInstancia(noticia);
    }

    public List<Noticia> listado() {
        return obj.listar();
    }

    /*public boolean eliminar(Long id) {
        return obj.eliminar(id);
    }*/
    public List<Noticia> listarNoticiaAdministrador(Long id) {
        return obj.listarNoticiaAdministrador(id);
    }

    public List<Noticia> listarNoticiaAdministradorBusqueda(Long id, String texto) {
        return obj.listarNoticiaAdministradorBusqueda(id, texto);
    }
}
