package com.proyecto_backend.crumbs.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import java.util.List;  





@Entity
@Table(name = "usuarios")
public class Usuario {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String nombres;
    private String tipoDocumento;
    private String documento;
    private Integer edad;

    private String ocupacionPrincipal; 
    // Muestra en qué trabaja el usuario.
    // Ayuda a saber si su dinero es fijo o cambia cada mes.

    private String nivelSocioeconomico; 
    // Indica el nivel de vida del usuario.
    // Sirve para entender mejor sus gastos.

    private String rangoIngresosMensuales; 
    // Muestra cuánto gana el usuario al mes.
    // Es importante para comparar sus gastos con sus ingresos.

    private String ubicacionGeografica; 
    // Dice en qué ciudad vive.
    // Es importante porque los precios cambian según el lugar.

    private String genero; 
    // Permite comparar hábitos de gasto entre personas.



    // Constructor vacío
    public Usuario() {
    }

    // Constructor con todos los atributos
    public Usuario(Integer id, String nombres, String tipoDocumento, String documento,
                   Integer edad, String ocupacionPrincipal, String nivelSocioeconomico,
                   String rangoIngresosMensuales, String ubicacionGeografica, String genero) {
        this.id = id;
        this.nombres = nombres;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.edad = edad;
        this.ocupacionPrincipal = ocupacionPrincipal;
        this.nivelSocioeconomico = nivelSocioeconomico;
        this.rangoIngresosMensuales = rangoIngresosMensuales;
        this.ubicacionGeografica = ubicacionGeografica;
        this.genero = genero;
    }




    // Getters
    public Integer getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getOcupacionPrincipal() {
        return ocupacionPrincipal;
    }

    public String getNivelSocioeconomico() {
        return nivelSocioeconomico;
    }

    public String getRangoIngresosMensuales() {
        return rangoIngresosMensuales;
    }

    public String getUbicacionGeografica() {
        return ubicacionGeografica;
    }

    public String getGenero() {
        return genero;
    }



    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setOcupacionPrincipal(String ocupacionPrincipal) {
        this.ocupacionPrincipal = ocupacionPrincipal;
    }

    public void setNivelSocioeconomico(String nivelSocioeconomico) {
        this.nivelSocioeconomico = nivelSocioeconomico;
    }

    public void setRangoIngresosMensuales(String rangoIngresosMensuales) {
        this.rangoIngresosMensuales = rangoIngresosMensuales;
    }

    public void setUbicacionGeografica(String ubicacionGeografica) {
        this.ubicacionGeografica = ubicacionGeografica;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    @OneToMany(mappedBy = "usuario")
    private List<Gasto> gastos;

    @OneToMany(mappedBy = "usuario") 
    private List<MedioPagos> metodosPago; 

    @OneToMany(mappedBy = "usuario") 
    private List<Categoria> categoriasCreadas;

}
