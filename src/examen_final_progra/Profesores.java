/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_final_progra;

/**
 *
 * @author Joel Cartuche
 */
public class Profesores {

    private String cedula;

    private String nombres;

    private String sapellidos;

    private int horasClase;

    private String carrera;

    private String tipoProfesor;

    private int horas_complementarias;

    public Profesores() {
    }

    public Profesores(String cedula, String nombres, String sapellidos, int horasClase, String carrera, String tipoProfesor) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.sapellidos = sapellidos;
        this.horasClase = horasClase;
        this.carrera = carrera;
        this.tipoProfesor = tipoProfesor;
    }

    @Override
    public String toString() {
        return "Profesores{" + "cedula=" + cedula + ", nombres=" + nombres + ", sapellidos=" + sapellidos + ", horasClase=" + horasClase + ", carrera=" + carrera + ", tipoProfesor=" + tipoProfesor + ", horas_complementarias=" + horas_complementarias + '}'+"\n";
    }

    public Profesores(String cedula, String nombres, String sapellidos, int horasClase, String carrera, String tipoProfesor, int horas_complementarias) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.sapellidos = sapellidos;
        this.horasClase = horasClase;
        this.carrera = carrera;
        this.tipoProfesor = tipoProfesor;
        this.horas_complementarias = horas_complementarias;
    }

    

    public int horasComplementarias(ProfesorTiempoParcial prof) {
        tipoProfesor = "ProfesorTiempoParcial";
        horas_complementarias =prof.getHorasSemanales() - horasClase;
        return prof.getHorasSemanales() - horasClase;
    }

    public int horasComplementarias(ProfesorMedioTiempo prof) {
        tipoProfesor="ProfesorMedioTiempo";
        horas_complementarias=prof.getHoras_semanales() - horasClase;
        return prof.getHoras_semanales() - horasClase;
    }

    public int horasComplementarias(ProfesorTiempoCompleto prof) {
        tipoProfesor ="ProfesorTiempoCompleto";
        horas_complementarias=prof.getHoras_Semanales() - horasClase;
        return prof.getHoras_Semanales() - horasClase;
    }

    public String getTipoProfesor() {
        return tipoProfesor;
    }

    public int getHoras_complementarias() {
        return horas_complementarias;
    }


    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
    }

    public String getSapellidos() {
        return sapellidos;
    }

    public void setSapellidos(String sapellidos) {
        this.sapellidos = sapellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

}
