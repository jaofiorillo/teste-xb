package com.xb.desafioXB;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xb.desafioXB.models.Vendedor;
import com.xb.desafioXB.repository.vendedorRepository;

@RequestMapping("/vendedor")
@RestController
public class loginControler {

    private List<Vendedor> vendedores = new ArrayList<>();

    @Autowired
    private vendedorRepository VendedorRepository;

    @GetMapping("/{id}")
    public Vendedor vendedor(@PathVariable("id") Long id) {

        Optional<Vendedor> vendedorFind = VendedorRepository.findById(id);

        if (vendedorFind.isPresent()) {
            return vendedorFind.get();
        }

        return null;
    }

    @PostMapping("/")
    public Vendedor vendedor(@RequestBody Vendedor vendedor) {
        vendedores.add(vendedor);
        VendedorRepository.save(vendedor);
        return vendedor;

    }

    @GetMapping("/list")
    public List<Vendedor> list() {
        return VendedorRepository.findAll();
    }
}
