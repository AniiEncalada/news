/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servicio;

import controlador.dao.MultimediaDao;
import java.util.List;
import modelo.Multimedia;

/**
 *
 * @author Víctor Andrés Rojas
 */
public class ServicioMultimedia {

    private MultimediaDao obj;

    public ServicioMultimedia() {
        this.obj = new MultimediaDao();
    }

    public boolean guardar() {
        return this.obj.guardar();
    }

    public Multimedia obtenerMultimedia() {
        return obj.getMultimedia();
    }

    public Multimedia obtenerMultimedia(Long id) {
        return obj.obtener(id);
    }

    public List<Multimedia> listado() {
        return obj.listar();
    }
}
