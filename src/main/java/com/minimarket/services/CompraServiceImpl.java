package com.minimarket.services;

import com.minimarket.models.Compra;
import com.minimarket.repos.CompraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements CompraService{

    @Autowired
    private CompraRepo compraRepo;

    @Override
    public Compra crearCompra(Compra compra) {
        return compraRepo.save(compra);
    }

    @Override
    public Compra findById(Long id) {
        return compraRepo.findById(id).orElse(null);
    }
}
