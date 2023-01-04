package com.artrede.registry.resources;

import com.artrede.registry.entities.Usuario;
import com.artrede.registry.repositories.UsuarioRepository;
import com.artrede.registry.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private final PasswordEncoder encoder;

    public UsuarioResource(UsuarioService service, PasswordEncoder encoder) {
        this.service = service;
        this.encoder = encoder;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario usr = service.findById(id);
        return ResponseEntity.ok().body(usr);
    }

    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody Usuario usr) {
        usr.setPassword(encoder.encode(usr.getPassword()));
        usr = service.insert(usr);
        return ResponseEntity.ok().body(usr);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usr) {
        usr = service.update(id, usr);
        return ResponseEntity.ok().body(usr);
    }

    @GetMapping("/validarSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String userName, @RequestParam String password) {

    Optional<Usuario> opUsuario = repository.findByUserName(userName);
    if (opUsuario.isEmpty()) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
    }

        boolean valid = false;

        Usuario usuario = opUsuario.get();
        valid = encoder.matches(password, usuario.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
}
