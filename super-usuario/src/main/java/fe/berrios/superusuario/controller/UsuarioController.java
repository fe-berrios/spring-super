package fe.berrios.superusuario.controller;

import fe.berrios.superusuario.entity.Usuario;
import fe.berrios.superusuario.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // CRUD
    @PostMapping
    public ResponseEntity createUsuario(@RequestBody Usuario usuario){
        usuarioService.createUsuario(usuario);
        return new ResponseEntity<String>("Usuario creado: " + usuario.getId(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public Usuario readUsuario(@PathVariable Integer id){
        return usuarioService.readUsuario(id);
    }

    @GetMapping
    public List<Usuario> readUsuarios(){
        return usuarioService.readUsuarios();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario){
        usuarioService.updateUsuario(id, usuario);
        return new ResponseEntity<String>("Usuario actualizado: " + id, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsuario(@PathVariable Integer id){
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<String>("Usuario eliminado: " + id, HttpStatus.OK);
    }
}
