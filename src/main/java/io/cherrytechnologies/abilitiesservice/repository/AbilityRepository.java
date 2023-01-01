package io.cherrytechnologies.abilitiesservice.repository;

import io.cherrytechnologies.abilitiesservice.domain.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AbilityRepository extends JpaRepository<Ability, UUID> {
    Optional<Ability> getAbilitiesByName(String name);

    List<Ability> getAbilitiesByPokemonId(UUID uuid);
}
