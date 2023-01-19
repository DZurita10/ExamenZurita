package ec.edu.espe.zuritaexamen.cliente.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "cliente")
public class Cliente {
    @Id
    private String id;
    @Indexed(unique = true)
    private String cedula;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    private String correo;

    private List<Cuenta> cuentas;

}
