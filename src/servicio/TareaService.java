/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;
import dominio.Tarea;
import dao.TareaDAO;
import excepciones.DatosInvalidosException;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author qadri
 */
public class TareaService {
    private List<Tarea> tareas = new ArrayList<>();
    private Deque<Tarea> eliminadas = new ArrayDeque<>();
    private TareaDAO dao = new TareaDAO();

    public List<Tarea> obtenerTareas() throws SQLException {
        tareas = dao.listar();
        return tareas;
    }

    public void agregarTarea(Tarea tarea) throws DatosInvalidosException, SQLException {
        if (tarea.getTitulo().isEmpty() || tarea.getPrioridad() < 1 || tarea.getPrioridad() > 3) {
            throw new DatosInvalidosException("Datos inválidos en la tarea.");
        }
        dao.insertar(tarea);
    }

    public void alternarEstado(Tarea tarea) throws SQLException {
        tarea.setEstado(!tarea.isEstado());
        dao.actualizarEstado(tarea.getId(), tarea.isEstado());
    }

    public void eliminarTarea(Tarea tarea) throws SQLException {
        eliminadas.push(tarea);
        dao.marcarEliminada(tarea.getId());
    }

    public void deshacerEliminacion() throws SQLException {
        if (!eliminadas.isEmpty()) {
            Tarea restaurada = eliminadas.pop();
            dao.restaurar(restaurada.getId());
        }
    }
}
