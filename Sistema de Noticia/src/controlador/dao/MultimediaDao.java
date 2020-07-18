/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.Conexion;
import modelo.Multimedia;

/**
 *
 * @author Víctor Andrés Rojas
 */
public class MultimediaDao extends AdaptadorDao<Multimedia> {

    private Multimedia multimedia;

    public MultimediaDao() {
        super(new Conexion(), Multimedia.class);
    }

    public Multimedia getMultimedia() {
        if (multimedia == null) {
            multimedia = new Multimedia();
        }
        return multimedia;
    }

    public void fijaInstancia(Multimedia multimedia) {
        this.multimedia = multimedia;
    }

    public boolean guardar() {
        boolean band = false;
        try {
            if (multimedia.getId() != null) {
                //modificar
            } else {
                this.multimedia.setId(generarID());
                this.guardar(multimedia);
            }
            band = true;
        } catch (Exception e) {
            System.out.println("No se pudo guardar " + e);
        }
        return band;
    }
}
