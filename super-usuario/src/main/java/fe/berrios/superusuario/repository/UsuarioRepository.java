package fe.berrios.superusuario.repository;

import fe.berrios.superusuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> getUsuarioById(int id);
}
