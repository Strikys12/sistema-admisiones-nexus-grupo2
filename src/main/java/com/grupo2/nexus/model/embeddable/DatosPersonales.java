package com.grupo2.nexus.model.embeddable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Embeddable


public class DatosPersonales {
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;


    @Column(nullable = false, unique = true)
    private String email;



    private String telefono;


}
