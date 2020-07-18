/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import modelo.enums.TipoNoticia;

/**
 *
 * @author Víctor Andrés Rojas
 */
@Getter
@Setter
public class Noticia implements Serializable {

    private Long id;
    private String titulo, contenido;
    private Date fecha;
    private TipoNoticia tipoNoticia;
    private Administrador administrador;
    private List<Multimedia> listaMultimedia = new ArrayList<>();
    private List<Comentario> listaComentario = new ArrayList<>();
}
