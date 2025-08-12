/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author qadri
 */
public class Tarea {
    private int id;
    private String titulo;
    private int prioridad;
    private boolean estado;
    private boolean especial;
    private String fecha;

    public Tarea(int id, String titulo, int prioridad, boolean estado, boolean especial, String fecha) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.estado = estado;
        this.especial = especial;
        this.fecha = fecha;
    }

    public Tarea(String titulo, int prioridad, boolean especial, String fecha) {
        this(0, titulo, prioridad, false, especial, fecha);
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getPrioridad() { return prioridad; }
    public boolean isEstado() { return estado; }
    public boolean isEspecial() { return especial; }
    public String getFecha() { return fecha; }

    public void setEstado(boolean estado) { this.estado = estado; }

    @Override
    public String toString() {
        return titulo + " [" + prioridad + "] " + (estado ? "Hecho" : "Pendiente");
    }
}
