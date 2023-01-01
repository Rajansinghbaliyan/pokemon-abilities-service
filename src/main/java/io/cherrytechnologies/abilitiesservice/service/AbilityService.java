package io.cherrytechnologies.abilitiesservice.service;

import io.cherrytechnologies.abilitiesservice.domain.Ability;
import io.cherrytechnologies.abilitiesservice.dto.AbilityDto;
import io.cherrytechnologies.abilitiesservice.exceptions.AbilityNotAbailable;
import io.cherrytechnologies.abilitiesservice.repository.AbilityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class AbilityService {
    private final AbilityRepository repository;

    @Autowired
    public AbilityService(AbilityRepository repository) {
        this.repository = repository;
    }


    public AbilityDto getAbilityById(UUID uuid){
        log.debug("Get ability by id: "+ uuid);
        return repository
                .findById(uuid)
                .orElseThrow(() -> new AbilityNotAbailable("Ability not available id: " + uuid))
                .abilityToDto();
    }

    public AbilityDto getAbilityByName(String name){
        log.debug("Get ability by name: "+ name);
        return repository
                .getAbilitiesByName(name)
                .orElseThrow(() -> new AbilityNotAbailable("Ability not available name: " + name))
                .abilityToDto();
    }

    public AbilityDto save(AbilityDto dto){
        log.debug("Save ability" + dto);
        return repository.save(dto.dtoToAbility()).abilityToDto();
    }

    public List<AbilityDto> saveAll(List<AbilityDto> dtos){
        log.debug("Save all ability");
        return repository
                .saveAll(dtos
                        .stream()
                        .map(AbilityDto::dtoToAbility)
                        .toList()
                )
                .stream()
                .map(Ability::abilityToDto)
                .toList();
    }

    public List<AbilityDto> getAllByPokemonId(UUID pokemonId){
        log.debug("Get all ability by pokemon id");
        return repository.getAbilitiesByPokemonId(pokemonId)
                .stream()
                .map(Ability::abilityToDto)
                .toList();
    }

}
