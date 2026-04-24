package com.proyecto_backend.crumbs.modelos;

import java.time.LocalDateTime;

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
@Table(name = "categoria")

public class Categoria {

     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private LocalDateTime fechaCreacion;
    private String responsable;
    private String justificacion;

    private String naturalezaGasto; // Indica si el gasto es fijo o variable.
    // Ayuda a saber qué gastos son obligatorios y cuáles se pueden reducir si es necesario.

    private String comportamientoEsperado; // Muestra la estrategia financiera del usuario.
    // Permite saber si la persona busca ahorrar, controlar o gastar libremente.

    private String periodicidadSugerida; // Indica cada cuánto sería recomendable hacer ese gasto.
    // Sirve para alertar si el usuario está gastando más seguido de lo normal.

    private String claseConsumo; // Diferencia si el gasto fue en un producto físico o en un servicio.
    // Ayuda a identificar gastos como suscripciones que pasan desapercibidas.

    private Double limiteOperativo; // Representa el monto máximo que se debería gastar.
    // Sirve como referencia para no exceder el presupuesto mensual.


    //Constructores

    //Constructor vacio

       public Categoria() {
    }

    //Constructor con todos los campos
    public Categoria(Integer id, String nombre, LocalDateTime fechaCreacion, String responsable, String justificacion,
            String naturalezaGasto, String comportamientoEsperado, String periodicidadSugerida, String claseConsumo,
            Double limiteOperativo) {
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
    }

    // Getters y Setters
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


    // Relaciones con otras entidades
@OneToMany(mappedBy = "categoria")
private List<Gasto> gastos;
@ManyToOne
@JoinColumn(name = "usuario_id")
private Usuario usuario;
}
