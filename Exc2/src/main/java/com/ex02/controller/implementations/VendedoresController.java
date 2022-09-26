package com.ex02.controller.implementations;

import com.ex02.controller.contracts.IServicioPersistenciaMockLocal;
import com.ex02.controller.contracts.IServicioVendedoresMockLocal;
import com.ex02.controller.contracts.IServicioVendedoresMockRemote;
import com.ex02.dto.Vendedor;
import com.ex02.excepciones.OperacionInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedoresController implements IServicioVendedoresMockRemote, IServicioVendedoresMockLocal {

    @Autowired
    IServicioPersistenciaMockLocal iServicioPersistenciaMockLocal;


    @Override
    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void agregarVendedor(@RequestBody Vendedor vendedor) throws OperacionInvalidaException {
        try {
            iServicioPersistenciaMockLocal.create(vendedor);
        }catch (OperacionInvalidaException opexc){
            throw  new OperacionInvalidaException(opexc.getMessage());
        }

    }

    @Override
    @DeleteMapping(value = "/delete-vendedor/{id}" )
    public void eliminarVendedor(@PathVariable("id") long id) throws OperacionInvalidaException {
        Vendedor v=(Vendedor) iServicioPersistenciaMockLocal.findById(Vendedor.class, id);
        try
        {
            iServicioPersistenciaMockLocal.delete(v);
        } catch (OperacionInvalidaException ex)
        {
            throw new OperacionInvalidaException(ex.getMessage());
        }
    }

    @Override
    @GetMapping(value = "/all-vendedor" )
    public List<Vendedor> getVendedores() {
        return  iServicioPersistenciaMockLocal.findAll(Vendedor.class);
    }
}
