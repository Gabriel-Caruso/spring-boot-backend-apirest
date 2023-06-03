package com.ramirocaruso.springboot.backend.apirest.controllers;

import com.ramirocaruso.springboot.backend.apirest.models.entity.Cliente;
import com.ramirocaruso.springboot.backend.apirest.models.services.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

    private final IClienteService clienteService;

    public ClienteRestController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //OBTENER CLIENTES
    @GetMapping("/clientes")
    public Iterable<Cliente> index(){
        return clienteService.findAll();
    }

    //READ POR ID
    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> show(@PathVariable("id") Long id){
        Cliente clienteById = clienteService.findById(id);
        if (clienteById!=null) {
            return new ResponseEntity<>(clienteById, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //CREATE
    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.create(cliente);
    }

    //UPDATE
    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable("id") Long id){
        Cliente update = clienteService.update(cliente, id);
        if (update!=null) {
            return new ResponseEntity<>(update, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        clienteService.delete(id);
    }

}
