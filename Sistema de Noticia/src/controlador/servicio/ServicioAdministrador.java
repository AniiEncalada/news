/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servicio;

import controlador.dao.AdministradorDao;
import java.util.List;
import modelo.Administrador;

/**
 *
 * @author Víctor Andrés Rojas
 */
public class ServicioAdministrador {

    private AdministradorDao obj;

    public ServicioAdministrador() {
        this.obj = new AdministradorDao();
    }

    public boolean guardar() {
        return this.obj.guardar();
    }

    public Administrador obtenerAdministrador() {
        return obj.getAdministrador();
    }

    public Administrador obtenerAdministrador(Long id) {
        return obj.obtener(id);
    }

    public List<Administrador> listado() {
        return obj.listar();
    }

    public Administrador inicioSesion(String usuario, String clave) {
        return obj.inicioSesion(usuario, clave);
    }
}
