package com.proyecto_backend.crumbs.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import java.util.List;

@Entity
@Table(name = "comercio")
public class Comercio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nit;
    private String nombre;
    private String actividad;
    private String contacto;

    private String segmentoMercado;

    private String canalVenta;

    private Boolean fidelizacionActiva;

    private Integer calificacionConfianza;

    private Integer frecuenciaRecurrencia;

    // Constructores

    // Constructor vacío necesario
    public Comercio() {
    }

    // Constructor con parámetros
    public Comercio(Integer id, String nit, String nombre, String actividad, String contacto,
            String segmentoMercado, String canalVenta, Boolean fidelizacionActiva,
            Integer calificacionConfianza, Integer frecuenciaRecurrencia) {

        this.id = id;
        this.nit = nit;
        this.nombre = nombre;
        this.actividad = actividad;
        this.contacto = contacto;
        this.segmentoMercado = segmentoMercado;
        this.canalVenta = canalVenta;
        this.fidelizacionActiva = fidelizacionActiva;
        this.calificacionConfianza = calificacionConfianza;
        this.frecuenciaRecurrencia = frecuenciaRecurrencia;
    }

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getSegmentoMercado() {
        return segmentoMercado;
    }

    public void setSegmentoMercado(String segmentoMercado) {
        this.segmentoMercado = segmentoMercado;
    }

    public String getCanalVenta() {
        return canalVenta;
    }

    public void setCanalVenta(String canalVenta) {
        this.canalVenta = canalVenta;
    }

    public Boolean getFidelizacionActiva() {
        return fidelizacionActiva;
    }

    public void setFidelizacionActiva(Boolean fidelizacionActiva) {
        this.fidelizacionActiva = fidelizacionActiva;
    }

    public Integer getCalificacionConfianza() {
        return calificacionConfianza;
    }

    public void setCalificacionConfianza(Integer calificacionConfianza) {
        this.calificacionConfianza = calificacionConfianza;
    }

    public Integer getFrecuenciaRecurrencia() {
        return frecuenciaRecurrencia;
    }

    public void setFrecuenciaRecurrencia(Integer frecuenciaRecurrencia) {
        this.frecuenciaRecurrencia = frecuenciaRecurrencia;
    }

    // Relaciones con otras entidades

    @ManyToOne
    @JoinColumn(name = "creador_id")
    private Usuario creador;

    @OneToMany(mappedBy = "comercio")
    private List<Gasto> gastos;
}