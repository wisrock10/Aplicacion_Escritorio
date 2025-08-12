/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import dominio.Tarea;
import java.sql.*;
import java.util.*;

/**
 *
 * @author qadri
 */
public class TareaDAO {
    public void insertar(Tarea tarea) throws SQLException {
        String sql = "INSERT INTO Tareas (titulo, prioridad, estado, especial, fecha) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tarea.getTitulo());
            ps.setInt(2, tarea.getPrioridad());
            ps.setBoolean(3, tarea.isEstado());
            ps.setBoolean(4, tarea.isEspecial());
            ps.setString(5, tarea.getFecha());
            ps.executeUpdate();
        }
    }

    public List<Tarea> listar() throws SQLException {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT * FROM Tareas WHERE estado IS NOT NULL";
        try (Connection conn = ConexionBD.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Tarea t = new Tarea(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getInt("prioridad"),
                    rs.getBoolean("estado"),
                    rs.getBoolean("especial"),
                    rs.getDate("fecha").toString()
                );
                lista.add(t);
            }
        }
        return lista;
    }

    public void actualizarEstado(int id, boolean nuevoEstado) throws SQLException {
        String sql = "UPDATE Tareas SET estado = ? WHERE id = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, nuevoEstado);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public void marcarEliminada(int id) throws SQLException {
        String sql = "UPDATE Tareas SET estado = NULL WHERE id = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public void restaurar(int id) throws SQLException {
        String sql = "UPDATE Tareas SET estado = 0 WHERE id = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
