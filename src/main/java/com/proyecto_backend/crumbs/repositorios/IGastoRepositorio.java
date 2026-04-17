package com.proyecto_backend.crumbs.repositorios;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto_backend.crumbs.modelos.Gasto;

@Repository

public interface IGastoRepositorio extends JpaRepository<Gasto,Integer> {

    // 1. BUSCAR POR DESCRIPCIÓN
    List<Gasto> findByDescripcion(String descripcion);

    // 2. BUSCAR POR FECHA 
    List<Gasto> findByFecha(LocalDate fecha);

    // 3. BUSCAR POR VALOR
    List<Gasto> findByValor(Double valor);

    // 4. BUSCAR POR IMAGEN 
    Optional<Gasto> findByImagen(String imagen);

    // 5. BUSCAR POR TIPO DE NECESIDAD 
    List<Gasto> findByTipoNecesidad(String tipoNecesidad);

    // 6. BUSCAR POR FRECUENCIA DE GASTO 
    List<Gasto> findByFrecuenciaGasto(String frecuenciaGasto);

    // 7. BUSCAR POR LUGAR DE CONSUMO
    List<Gasto> findByLugarConsumo(String lugarConsumo);

    // 8. BUSCAR POR MEDIO DE VERIFICACIÓN (Ej: "Con comprobante", "Sin comprobante")
    List<Gasto> findByMedioVerficacion(String medioVerficacion);

    // 9. BUSCAR POR GRADO DE NECESIDAD (Ej: "5", "1")
    List<Gasto> findByGradoNecesidad(String gradoNecesidad);


}