package com.xb.desafioXB.helpers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.xb.desafioXB.models.Vendedor;
import com.xb.desafioXB.repository.vendedorRepository;

public class vendedorHelper {

    @Autowired
    private vendedorRepository VendedorRepository;

}
