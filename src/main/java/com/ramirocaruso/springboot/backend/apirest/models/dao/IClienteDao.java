package com.ramirocaruso.springboot.backend.apirest.models.dao;

import com.ramirocaruso.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
