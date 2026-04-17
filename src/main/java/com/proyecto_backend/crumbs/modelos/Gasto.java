package com.proyecto_backend.crumbs.modelos;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "gasto")

public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;
    private LocalDate fecha;
    private Double valor;
    private String imagen;

    private String tipoNecesidad;// Permite clasificar el gasto según su importancia.
    // Ayuda a diferenciar lo que es obligatorio de lo que es un gusto o impulso.

    private String frecuenciaGasto; // Indica cada cuánto se repite el gasto.
   // Sirve para identificar gastos pequeños que, al repetirse, pueden sumar mucho dinero.

    private String lugarConsumo;  // Registra el lugar donde se realizó el gasto.
    // Ayuda a identificar en qué sitios se gasta más dinero.

    private String medioVerficacion; // Indica si el gasto tiene comprobante (factura o recibo).
   // Permite llevar un mejor control y respaldo de la información.

    private  String gradoNecesidad; // Representa qué tan necesario era el gasto en una escala del 1 al 5.
    // Ayuda a comparar si realmente valió la pena lo que se pagó


    
    public Gasto() {
    }



    public Gasto(Integer id, String descripcion, LocalDate fecha, Double valor, String imagen, String tipoNecesidad,
            String frecuenciaGasto, String lugarConsumo, String medioVerficacion, String gradoNecesidad) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.valor = valor;
        this.imagen = imagen;
        this.tipoNecesidad = tipoNecesidad;
        this.frecuenciaGasto = frecuenciaGasto;
        this.lugarConsumo = lugarConsumo;
        this.medioVerficacion = medioVerficacion;
        this.gradoNecesidad = gradoNecesidad;
    }



    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public String getDescripcion() {
        return descripcion;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public LocalDate getFecha() {
        return fecha;
    }



    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }



    public Double getValor() {
        return valor;
    }



    public void setValor(Double valor) {
        this.valor = valor;
    }



    public String getImagen() {
        return imagen;
    }



    public void setImagen(String imagen) {
        this.imagen = imagen;
    }



    public String getTipoNecesidad() {
        return tipoNecesidad;
    }



    public void setTipoNecesidad(String tipoNecesidad) {
        this.tipoNecesidad = tipoNecesidad;
    }



    public String getFrecuenciaGasto() {
        return frecuenciaGasto;
    }



    public void setFrecuenciaGasto(String frecuenciaGasto) {
        this.frecuenciaGasto = frecuenciaGasto;
    }



    public String getLugarConsumo() {
        return lugarConsumo;
    }



    public void setLugarConsumo(String lugarConsumo) {
        this.lugarConsumo = lugarConsumo;
    }



    public String getMedioVerficacion() {
        return medioVerficacion;
    }



    public void setMedioVerficacion(String medioVerficacion) {
        this.medioVerficacion = medioVerficacion;
    }



    public String getGradoNecesidad() {
        return gradoNecesidad;
    }



    public void setGradoNecesidad(String gradoNecesidad) {
        this.gradoNecesidad = gradoNecesidad;
    }



 



}
