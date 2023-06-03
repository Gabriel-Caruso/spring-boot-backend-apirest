package com.ramirocaruso.springboot.backend.apirest.models.services;

import com.ramirocaruso.springboot.backend.apirest.models.entity.Cliente;

import java.util.List;

public interface IClienteService {

    public Iterable<Cliente> findAll();

    public Cliente findById(Long id);

    Cliente update(Cliente cliente, Long id);

    Cliente create(Cliente cliente);

    public void delete(Long id);

}
