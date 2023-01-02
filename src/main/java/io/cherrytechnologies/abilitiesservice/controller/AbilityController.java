package io.cherrytechnologies.abilitiesservice.controller;

import io.cherrytechnologies.abilitiesservice.dto.AbilityDto;
import io.cherrytechnologies.abilitiesservice.service.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/ability")
public class AbilityController {

    private final AbilityService service;

    @Autowired
    public AbilityController(AbilityService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbilityDto> getAbilityById(@PathVariable UUID id) {
        return ResponseEntity
                .ok(service.getAbilityById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<AbilityDto> getAbilityByName(@PathVariable String name) {
        return ResponseEntity
                .ok(service.getAbilityByName(name));
    }

    @PostMapping("/")
    public ResponseEntity<AbilityDto> saveAbility(@RequestBody AbilityDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(dto));
    }

    @PostMapping("/all")
    public ResponseEntity<List<AbilityDto>> saveAllAbility(@RequestBody List<AbilityDto> dtos) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveAll(dtos));
    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<List<AbilityDto>> getAllByPokemonId(@PathVariable UUID id) {
        return ResponseEntity
                .ok(service.getAllByPokemonId(id));
    }
}
