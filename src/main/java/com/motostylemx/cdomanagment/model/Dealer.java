package com.motostylemx.cdomanagment.model;


import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class Dealer {
    @Getter @Setter private int id;
    @Getter @Setter @NotBlank(message = "Dealer name is mandatory") private final String dealer;
    @Getter @Setter @NotBlank(message = "Dealer name is mandatory") private final String slug;
    
    public Dealer(@NotBlank(message = "Dealer name is mandatory") @JsonProperty("dealer") String dealer,
            @NotBlank(message = "Dealer name is mandatory") @JsonProperty("slug") String slug) {
        this.dealer = dealer;
        this.slug = slug;
    }

    public Dealer(@JsonProperty("id") int id, @NotBlank(message = "Dealer name is mandatory") @JsonProperty("dealer") String dealer,
            @NotBlank(message = "Dealer name is mandatory") @JsonProperty("slug") String slug) {
        this.id = id;
        this.dealer = dealer;
        this.slug = slug;
    }

    
}
