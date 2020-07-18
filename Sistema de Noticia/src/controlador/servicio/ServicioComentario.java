/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servicio;

import controlador.dao.ComentarioDao;
import java.util.List;
import modelo.Comentario;

/**
 *
 * @author Víctor Andrés Rojas
 */
public class ServicioComentario {

    private ComentarioDao obj;

    public ServicioComentario() {
        this.obj = new ComentarioDao();
    }

    public boolean guardar() {
        return this.obj.guardar();
    }

    public Comentario obtenerComentario() {
        return obj.getComentario();
    }

    public Comentario obtenerComentario(Long id) {
        return obj.obtener(id);
    }

    public List<Comentario> listado() {
        return obj.listar();
    }
}
