package ec.edu.espe.zuritaexamen.cliente.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.zuritaexamen.cliente.model.Ejecutivo;

public interface EjecutivoRepository extends MongoRepository<Ejecutivo, Long> {
    Ejecutivo findByEstado(String estado);
}
