package com.proyecto_backend.crumbs.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto_backend.crumbs.modelos.MedioPago;




@Repository
public interface IMedioPagoRepositorio extends JpaRepository<MedioPago, Integer> {
}
