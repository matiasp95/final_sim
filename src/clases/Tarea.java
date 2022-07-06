/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Matias
 */
public class Tarea {
    private double horaLlegada, horaFin, horaFinEventoActual, tiempoEnSistema;
    private int posicion;
    private EstadoTareas estado;

    public Tarea() {
        horaLlegada = 999999.0;
        horaFin = 999999.0;
        horaFinEventoActual = 999999.0;
        tiempoEnSistema = 0;
        posicion = 0;
        estado = EstadoTareas.Inactiva;
    }

    public Tarea(double horaLlegada, double horaFin, double horaFinEventoActual, double tiempoEnSistema, int posicion, EstadoTareas estado) {
        this.horaLlegada = horaLlegada;
        this.horaFin = horaFin;
        this.horaFinEventoActual = horaFinEventoActual;
        this.tiempoEnSistema = tiempoEnSistema;
        this.posicion = posicion;
        this.estado = estado;
    }

    public double getTiempoEnSistema() {
        return tiempoEnSistema;
    }

    public void setTiempoEnSistema(double tiempoEnSistema) {
        this.tiempoEnSistema = tiempoEnSistema;
    }

    

    public double getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(double horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public double getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(double horaFin) {
        this.horaFin = horaFin;
    }

    public double getHoraFinEventoActual() {
        return horaFinEventoActual;
    }

    public void setHoraFinEventoActual(double horaFinEventoActual) {
        this.horaFinEventoActual = horaFinEventoActual;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public EstadoTareas getEstado() {
        return estado;
    }

    public void setEstado(EstadoTareas estado) {
        this.estado = estado;
    }
    
    
}
