/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.Conexion;
import modelo.Comentario;

/**
 *
 * @author Víctor Andrés Rojas
 */
public class ComentarioDao extends AdaptadorDao<Comentario> {

    private Comentario comentario;

    public ComentarioDao() {
        super(new Conexion(), Comentario.class);
    }

    public Comentario getComentario() {
        if (comentario == null) {
            comentario = new Comentario();
        }
        return comentario;
    }

    public void fijaInstancia(Comentario comentario) {
        this.comentario = comentario;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            if (comentario.getId() != null) {
                //modificar
            } else {
                this.comentario.setId(generarID());
                this.guardar(comentario);
            }
            band = true;
        } catch (Exception e) {
            System.out.println("No se pudo guardar " + e);
        }
        return band;
    }
}
