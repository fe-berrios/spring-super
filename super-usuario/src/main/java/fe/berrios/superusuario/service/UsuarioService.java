package fe.berrios.superusuario.service;

import fe.berrios.superusuario.entity.Usuario;
import fe.berrios.superusuario.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // CRUD
    public void createUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario readUsuario(Integer id){
        return usuarioRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Usuario no encontrado: " + (id)));
    }

    public List<Usuario> readUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario updateUsuario(Integer id, Usuario usuario){
        Usuario updatedUsuario = readUsuario(id);
        updatedUsuario.setUsername(usuario.getUsername());
        updatedUsuario.setEmail(usuario.getEmail());

        return  usuarioRepository.save(updatedUsuario);
    }

    public void deleteUsuario(Integer id){
        usuarioRepository.deleteById(id);
    }
}
