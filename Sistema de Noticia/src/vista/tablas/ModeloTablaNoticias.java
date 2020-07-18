/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tablas;

import controlador.utilidades.Utilidades;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Getter;
import lombok.Setter;
import modelo.Noticia;

/**
 *
 * @author Víctor Andrés Rojas
 */
public class ModeloTablaNoticias extends AbstractTableModel {

    @Getter
    @Setter
    private List<Noticia> lista = new ArrayList<>();

    //N° de Columnas
    @Override
    public int getColumnCount() {
        return 4;
    }

    //N° de Filas
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Noticia n = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return n.getTitulo();
            case 1:
                return n.getContenido();
            case 2:
                return Utilidades.formatearFecha(n.getFecha());
            case 3:
                return n.getTipoNoticia().toString();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Titulo";
            case 1:
                return "Contenido";
            case 2:
                return "Fecha";
            case 3:
                return "Tipo de noticia";
            default:
                return null;
        }
    }
}
