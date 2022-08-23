package com.xb.desafioXB.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xb.desafioXB.models.Vendedor;

public interface vendedorRepository extends JpaRepository<Vendedor, Long> {

    public Optional<Vendedor> findByNome(String nome);

    public Optional<Vendedor> findByTotalVendas(int totalVendas);

}
