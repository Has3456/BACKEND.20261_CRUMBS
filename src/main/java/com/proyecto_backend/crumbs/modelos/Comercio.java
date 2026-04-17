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

    private String segmentoMercado; // Indica a qué tipo de negocio pertenece el comercio 
    //  // (ej: cafetería, supermercado, streaming). 
    // Permite identificar en qué sectores se gasta más dinero.

    private String canalVenta;// Indica si la compra fue en tienda física o por internet.
    // Ayuda a analizar dónde ocurren más gastos.

    private Boolean fidelizacionActiva; // Indica si el comercio tiene programa de puntos o membresía.
    // Permite analizar si estos incentivos influyen en gastar más seguido.

    private Integer calificacionConfianza; // Representa qué tan satisfecho está el usuario con el comercio.
    // Ayuda a saber si vale la pena lo que se está pagando.

    private Integer frecuenciaRecurrencia;  // Mide qué tan frecuente compra el usuario en este lugar.
    // Permite detectar comercios donde se gasta constantemente.


    //Constructores

    // Constructor vacío necesario para JPA
    public Comercio() {
    }

    // Constructor con parámetros
    public Comercio(Integer id, String nit, String nombre, String actividad, String contacto,
            String segmentoMercado, String canalVenta, Boolean fidelizacionActiva, Integer calificacionConfianza,
            Integer frecuenciaRecurrencia) {
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


    @ManyToOne 
@JoinColumn(name = "creador_id") private Usuario creador; 
@OneToMany(mappedBy = "categoria") private List<Gasto> gastos;


}
