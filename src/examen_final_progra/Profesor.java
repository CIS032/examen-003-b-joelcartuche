/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_final_progra;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Joel Cartuche
 */
@Entity
@Table(name = "PROFESOR", catalog = "", schema = "JOEL")
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")
    , @NamedQuery(name = "Profesor.findByCedula", query = "SELECT p FROM Profesor p WHERE p.cedula = :cedula")
    , @NamedQuery(name = "Profesor.findByNombre", query = "SELECT p FROM Profesor p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Profesor.findByApellido", query = "SELECT p FROM Profesor p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Profesor.findByCarrera", query = "SELECT p FROM Profesor p WHERE p.carrera = :carrera")
    , @NamedQuery(name = "Profesor.findByTipoProfesor", query = "SELECT p FROM Profesor p WHERE p.tipoProfesor = :tipoProfesor")
    , @NamedQuery(name = "Profesor.findByHorasClase", query = "SELECT p FROM Profesor p WHERE p.horasClase = :horasClase")
    , @NamedQuery(name = "Profesor.findByHorasComplementarias", query = "SELECT p FROM Profesor p WHERE p.horasComplementarias = :horasComplementarias")})
public class Profesor implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULA")
    private String cedula;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "CARRERA")
    private String carrera;
    @Column(name = "TIPO_PROFESOR")
    private String tipoProfesor;
    @Column(name = "HORAS_CLASE")
    private String horasClase;
    @Column(name = "HORAS_COMPLEMENTARIAS")
    private String horasComplementarias;

    public Profesor() {
    }

    public Profesor(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        String oldCedula = this.cedula;
        this.cedula = cedula;
        changeSupport.firePropertyChange("cedula", oldCedula, cedula);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        String oldApellido = this.apellido;
        this.apellido = apellido;
        changeSupport.firePropertyChange("apellido", oldApellido, apellido);
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        String oldCarrera = this.carrera;
        this.carrera = carrera;
        changeSupport.firePropertyChange("carrera", oldCarrera, carrera);
    }

    public String getTipoProfesor() {
        return tipoProfesor;
    }

    public void setTipoProfesor(String tipoProfesor) {
        String oldTipoProfesor = this.tipoProfesor;
        this.tipoProfesor = tipoProfesor;
        changeSupport.firePropertyChange("tipoProfesor", oldTipoProfesor, tipoProfesor);
    }

    public String getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(String horasClase) {
        String oldHorasClase = this.horasClase;
        this.horasClase = horasClase;
        changeSupport.firePropertyChange("horasClase", oldHorasClase, horasClase);
    }

    public String getHorasComplementarias() {
        return horasComplementarias;
    }

    public void setHorasComplementarias(String horasComplementarias) {
        String oldHorasComplementarias = this.horasComplementarias;
        this.horasComplementarias = horasComplementarias;
        changeSupport.firePropertyChange("horasComplementarias", oldHorasComplementarias, horasComplementarias);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examen_final_progra.Profesor[ cedula=" + cedula + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
