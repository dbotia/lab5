package com.udea.lab5.com.udea.lab5.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * @author Lenovo
 */
@Entity(name = "Persona")
@NamedQueries({
@NamedQuery(name = "Persona.findAll", query = "Select e from Persona e"),
@NamedQuery(name = "Persona.findByNombre", query = "Select p from Persona p where p.nombre=:nombre"),
@NamedQuery(name = "Persona.findByEmail", query = "Select p from Persona p where p.email=:email"),
@NamedQuery(name = "Persona.findByDireccion", query = "Select p from Persona p where p.direccion=:direccion"),
@NamedQuery(name = "Persona.findBySalario", query = "Select p from Persona p where p.salario=:salario")})
public class Persona implements Serializable {

    

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    @NotNull
    private Long id;

    @Basic
    @Column(name = "nombre", nullable = false)
    @NotNull
    private String nombre;

    @Basic
    @Column(name = "email", nullable = false)
    @NotNull
    private String email;

    @Basic
    @Column(name = "direccion", nullable = false)
    @NotNull
    private String direccion;

    @Basic
    @Column(name = "salario", nullable = false)
    @NotNull
    @Positive
    private double salario;

    public Persona() {
    }
    
    public Persona(Long id, String nombre, String email, String direccion, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Objects.equals(getClass(), obj.getClass())) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!java.util.Objects.equals(this.getId(), other.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.getId());
        return hash;
    }

    @Override
    public String toString() {
        return "Persona{" + " id=" + id + ", nombre=" + nombre + ", email=" + email + ", direccion=" + direccion + ", salario=" + salario + '}';
    }

}