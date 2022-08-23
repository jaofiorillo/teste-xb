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

import com.xb.desafioXB.models.Venda;
import com.xb.desafioXB.models.Vendedor;
import com.xb.desafioXB.repository.vendaRepository;
import com.xb.desafioXB.repository.vendedorRepository;

@RequestMapping("/venda")
@RestController
public class vendaControler {

    private List<Venda> vendas = new ArrayList<>();

    @Autowired
    private vendaRepository VendaRepository;

    @Autowired
    private vendedorRepository VendedorRepository;

    private Optional<Vendedor> findByNome;

    @GetMapping("/{id}")
    public Venda venda(@PathVariable("id") Long id) {
        Optional<Venda> vendaFind = VendaRepository.findById(id);

        if (vendaFind.isPresent()) {
            return vendaFind.get();
        }

        return null;
    }

    @PostMapping("/")
    public Venda venda(@RequestBody Venda venda) {

        String nome = venda.getNome_vendedor();
        findByNome = VendedorRepository.findByNome(nome);
        if (findByNome.isPresent()) {

            Vendedor vendedor = findByNome.get();
            int Tvendas = (vendedor.getTotalVendas() + 1);
            float Media = (Tvendas / 5);
            vendedor.setTotalVendas(Tvendas);
            vendedor.setMediaVendas(Media);

            return VendaRepository.save(venda);

        }

        return null;

    }

    @GetMapping("/list")
    public List<Venda> vendas() {
        return VendaRepository.findAll();
    }

}
