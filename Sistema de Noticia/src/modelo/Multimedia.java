/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import modelo.enums.TipoMultimedia;

/**
 *
 * @author Víctor Andrés Rojas
 */
@Getter
@Setter
public class Multimedia implements Serializable {

    private Long id;
    private String ubicacion;
    private TipoMultimedia tipo;
    private boolean portada;
    private Noticia noticia;
}
