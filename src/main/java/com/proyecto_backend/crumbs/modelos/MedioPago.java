package com.proyecto_backend.crumbs.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.util.List;
import java.time.LocalDateTime;

@Entity
@Table(name = "medio_pagos")
public class MedioPago {

    // --- Identificador ---
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    // --- Atributos básicos ---
    private String nombre;
    private LocalDateTime fechaCreacion;
    private String responsable;
    private String justificacion;
    private String naturalezaGasto;
    private String comportamientoEsperado;
    private String periodicidadSugerida;
    private String claseConsumo;
    private Double limiteOperativo;

    // --- Relaciones ---
    
    @ManyToOne 
    @JoinColumn(name = "usuario_id") // Esta es la columna FK en la base de datos
    private Usuario usuario; 

    @OneToMany(mappedBy = "medioPago") 
    private List<Gasto> gastos;

    // --- Constructor vacío (Requerido por JPA) ---
    public MedioPago() {
    }

    // --- Constructor con parámetros ---
    public MedioPago(Integer id, String nombre, LocalDateTime fechaCreacion, String responsable, 
                      String justificacion, String naturalezaGasto, String comportamientoEsperado, 
                      String periodicidadSugerida, String claseConsumo, Double limiteOperativo, Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.responsable = responsable;
        this.justificacion = justificacion;
        this.naturalezaGasto = naturalezaGasto;
        this.comportamientoEsperado = comportamientoEsperado;
        this.periodicidadSugerida = periodicidadSugerida;
        this.claseConsumo = claseConsumo;
        this.limiteOperativo = limiteOperativo;
        this.usuario = usuario;
    }

    // --- Getters y Setters ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getNaturalezaGasto() {
        return naturalezaGasto;
    }

    public void setNaturalezaGasto(String naturalezaGasto) {
        this.naturalezaGasto = naturalezaGasto;
    }

    public String getComportamientoEsperado() {
        return comportamientoEsperado;
    }

    public void setComportamientoEsperado(String comportamientoEsperado) {
        this.comportamientoEsperado = comportamientoEsperado;
    }

    public String getPeriodicidadSugerida() {
        return periodicidadSugerida;
    }

    public void setPeriodicidadSugerida(String periodicidadSugerida) {
        this.periodicidadSugerida = periodicidadSugerida;
    }

    public String getClaseConsumo() {
        return claseConsumo;
    }

    public void setClaseConsumo(String claseConsumo) {
        this.claseConsumo = claseConsumo;
    }

    public Double getLimiteOperativo() {
        return limiteOperativo;
    }

    public void setLimiteOperativo(Double limiteOperativo) {
        this.limiteOperativo = limiteOperativo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }
}