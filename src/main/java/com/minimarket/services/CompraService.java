package com.minimarket.services;

import com.minimarket.models.Compra;

public interface CompraService {

    public Compra crearCompra(Compra compra);

    public Compra findById(Long id);


}
