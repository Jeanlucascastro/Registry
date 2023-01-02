package com.artrede.registry.resources;

import com.artrede.registry.entities.Usuario;
import com.artrede.registry.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

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
}
