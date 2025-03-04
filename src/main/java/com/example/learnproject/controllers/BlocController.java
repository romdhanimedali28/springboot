package com.example.learnproject.controllers;

import com.example.learnproject.entities.Bloc;
import com.example.learnproject.services.BlocService;
import com.example.learnproject.servicesimplement.BlocServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blocs")
public class BlocController {

    @Autowired
    private BlocService blocService;



    @GetMapping
    public List<Bloc> getAllBlocs() {
        return blocService.getAllBlocs();
    }

    @GetMapping("/{id}")
    public Bloc getBlocById(@PathVariable Long id) {
        return blocService.getBlocById(id);
    }

   /* @GetMapping
    public ResponseEntity<List<Bloc>> retrieveAllBlocs() {
        List<Bloc> blocs = blocService.retrieveBlocs();
        return ResponseEntity.ok(blocs);
    }*/

    @PostMapping
    public ResponseEntity<Bloc> addBloc(@RequestBody Bloc bloc) {
        Bloc savedBloc = blocService.addBloc(bloc);
        return ResponseEntity.status(201).body(savedBloc); // 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bloc> updateBloc(@PathVariable long id, @RequestBody Bloc updatedBloc) {
        updatedBloc.setIdBloc(id); // Ensure the ID is set
        Bloc updated = blocService.updateBloc(updatedBloc);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


  /*  @GetMapping("/{id}")
    public ResponseEntity<Bloc> retrieveBloc(@PathVariable long id) {
        Bloc bloc = blocService.retrieveBloc(id);
        if (bloc != null) {
            return ResponseEntity.ok(bloc);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeBloc(@PathVariable long id) {
        blocService.removeBloc(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}