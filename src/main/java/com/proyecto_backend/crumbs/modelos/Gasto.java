package com.proyecto_backend.crumbs.modelos;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private String tipoNecesidad;
    private String frecuenciaGasto;
    private String lugarConsumo;
    private String medioVerificacion;
    private String gradoNecesidad;

    // Relaciones (Mantenidas arriba para mejor orden)
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "medio_pago_id")
    private MedioPago medioPago; 

    @ManyToOne
    @JoinColumn(name = "comercio_id")
    private Comercio comercio;

    // Constructores
    public Gasto() {}

    // Constructor incluyendo las relaciones
    public Gasto(Integer id, String descripcion, Double valor, Usuario usuario, Categoria categoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.valor = valor;
        this.usuario = usuario;
        this.categoria = categoria;
    }



    // Getters y Setters

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



    public String getMedioVerificacion() {
        return medioVerificacion;
    }



    public void setMedioVerificacion(String medioVerificacion) {
        this.medioVerificacion = medioVerificacion;
    }



    public String getGradoNecesidad() {
        return gradoNecesidad;
    }



    public void setGradoNecesidad(String gradoNecesidad) {
        this.gradoNecesidad = gradoNecesidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }   

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }





}
