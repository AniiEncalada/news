/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.Conexion;
import it.sauronsoftware.base64.Base64;
import modelo.Administrador;

/**
 *
 * @author Víctor Andrés Rojas
 */
public class AdministradorDao extends AdaptadorDao<Administrador> {

    private Administrador administrador;

    public AdministradorDao() {
        super(new Conexion(), Administrador.class);
    }

    public Administrador getAdministrador() {
        if (administrador == null) {
            administrador = new Administrador();
        }
        return administrador;
    }

    public void fijarInstancia(Administrador administrador) {
        this.administrador = administrador;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            if (administrador.getId() != null) {
                //modificar
            } else {
                this.administrador.setId(generarID());
                this.guardar(administrador);
            }
            band = true;
        } catch (Exception e) {
            System.out.println("No se pudo guardar " + e);
        }
        return band;
    }

    public Administrador inicioSesion(String usuario, String clave) {
        Administrador admin = null;
        for (Administrador aux : listar()) {
            if (aux.getUsuario().equals(usuario) && aux.getClave().equals(Base64.encode(clave))) {
                admin = aux;
                break;
            }
        }
        return admin;
    }
}
