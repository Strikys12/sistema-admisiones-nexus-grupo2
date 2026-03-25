package com.grupo2.nexus.repository;

import com.grupo2.nexus.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Spring navegará: Usuario -> datosPersonales -> email
    Optional<Usuario> findByDatosPersonalesEmail(String email);

    // Y el de validación que usamos en el save:
    boolean existsByDatosPersonalesEmail(String email);
}
