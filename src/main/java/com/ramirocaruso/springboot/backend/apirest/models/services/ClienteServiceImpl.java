package com.ramirocaruso.springboot.backend.apirest.models.services;

import com.ramirocaruso.springboot.backend.apirest.models.dao.IClienteDao;
import com.ramirocaruso.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(readOnly = true) //Permite que por defecto todos sean readOnly = true
public class ClienteServiceImpl implements IClienteService{

    private final IClienteDao clienteDao;

    public ClienteServiceImpl(IClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    public Iterable<Cliente> findAll() {
        return clienteDao.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    private Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = false)
    public Cliente update(Cliente clienteData, Long id){
        Cliente clienteToUpdate = findById(id);
        if (clienteToUpdate == null){
            return null;
        }
        clienteToUpdate.setApellido(clienteData.getApellido());
        clienteToUpdate.setNombre(clienteData.getNombre());
        clienteToUpdate.setEmail(clienteData.getEmail());
        return save(clienteToUpdate);
    }

    @Override
    @Transactional(readOnly = false)
    public Cliente create(Cliente cliente) {
        cliente.setCreateAt(new Date());
        return save(cliente);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }
}
