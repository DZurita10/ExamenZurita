package ec.edu.espe.zuritaexamen.cliente.controller.dto.response;

import java.io.Serializable;
import java.util.List;

import ec.edu.espe.zuritaexamen.cliente.model.Cuenta;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteRS implements Serializable {
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String telefono;
    private String correo;
    private String fechaNacimiento;
    private List<Cuenta> cuentas;

}
