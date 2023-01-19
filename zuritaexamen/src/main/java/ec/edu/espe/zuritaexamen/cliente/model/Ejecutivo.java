package ec.edu.espe.zuritaexamen.cliente.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "ejecutivo")
public class Ejecutivo {
    @Id
    private String id;
    @Indexed(unique = true)
    private String codigoEjecutivo;
    private String nombreEjecutivo;
    private String estado;

}
