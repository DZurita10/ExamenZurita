package ec.edu.espe.zuritaexamen.cliente.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cuenta {
    private String numeroCuenta;
    private String tipoCuenta;
    private String saldo;
    
}
