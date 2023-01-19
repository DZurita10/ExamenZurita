package ec.edu.espe.zuritaexamen.cliente.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.zuritaexamen.cliente.model.Turno;

public interface TurnoRepository extends MongoRepository<Turno, Long>{

    Turno findByNumerTurno(Integer numerTurno);
    Turno findByCedula(String cedula);
    Turno findByNombre(String nombre);
    
}
