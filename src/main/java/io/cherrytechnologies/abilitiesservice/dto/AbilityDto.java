package io.cherrytechnologies.abilitiesservice.dto;

import io.cherrytechnologies.abilitiesservice.domain.Ability;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Builder
@Data
@ToString
public class AbilityDto implements Serializable {
    private String name;
    private String url;
    private boolean is_hidden;
    private int slot;
    private UUID pokemonId;

    public Ability dtoToAbility(){
        Ability ability = new Ability();

        ability.set_hidden(is_hidden);
        ability.setUrl(url);
        ability.setSlot(slot);
        ability.setName(name);
        ability.setPokemonId(pokemonId);

        return ability;
    }
}
