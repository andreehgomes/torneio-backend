package br.com.pardalzada.torneioapi.dataproviders.repositories;

import br.com.pardalzada.torneioapi.dataproviders.models.UsuarioDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioDBRepository extends JpaRepository<UsuarioDB, Long> {

    Optional<UsuarioDB> findByEmail(String email);
}
