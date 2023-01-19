package ec.edu.espe.zuritaexamen.cliente.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.zuritaexamen.cliente.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, Long>{
    public Cliente findByCedula(String cedula);    
}
