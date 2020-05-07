package pe.edu.pucp.congresoft.model;

import java.util.Date;

/**
 *
 * @author Jhan Leyton
 */
public class Congreso {
    private int ID;
    private String nombre;
    private Date fechaIni;
    private Date fechaFin;
    private String pais;
    private int estado;

    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public String mostrarDatos(){
        return ID + " - " + nombre + " - " + pais +" - "
                +fechaIni+" - "+ fechaFin + " - " + estado;
    }
}
