package io.cherrytechnologies.abilitiesservice.domain;

import io.cherrytechnologies.abilitiesservice.dto.AbilityDto;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@Data
@ToString
@Entity
public class Ability extends Base {
    private String name;
    private String url;
    private boolean is_hidden;
    private int slot;
    private UUID pokemonId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ability ability = (Ability) o;
        return Objects.equals(name, ability.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    public AbilityDto abilityToDto(){
            return AbilityDto
                    .builder()
                    .name(name)
                    .url(url)
                    .is_hidden(is_hidden)
                    .slot(slot)
                    .pokemonId(pokemonId)
                    .build();
    }
}
