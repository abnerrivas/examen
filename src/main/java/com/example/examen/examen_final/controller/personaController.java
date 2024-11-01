package com.example.examen.examen_final.controller;

import com.example.examen.examen_final.exception.ResourceNotFoundException;
import com.example.examen.examen_final.model.Persona;
import com.example.examen.examen_final.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/persona")
public class personaController {
    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("/all")
    private List<Persona> personas(){
        return  personaRepository.findAll();
    }

    @PostMapping("/save")
    public Persona save(@RequestBody Persona persona){
        return personaRepository.save(persona);
    }
    @GetMapping("{id}")
    public ResponseEntity<Persona> ListarAutorPorId(@PathVariable int id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("persona no encontrado : " + id));
        return ResponseEntity.ok(persona);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Persona> editarPersona(@PathVariable int id, @RequestBody Persona personaRequest){
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("persona id :" + id));
        persona.setNombre(personaRequest.getNombre());
        persona.setApellido(personaRequest.getApellido());
        persona.setDireccion(personaRequest.getDireccion());
        Persona personaActualizada = personaRepository.save(persona);
        return ResponseEntity.ok(personaActualizada);

    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarPersona(@PathVariable int id){
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("persona no encontrado :" + id));
        personaRepository.delete(persona);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",true);
        return ResponseEntity.ok(response);

    }




}
