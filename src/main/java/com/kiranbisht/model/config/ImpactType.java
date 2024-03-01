package com.kiranbisht.model.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ImpactType {
	
	@JsonProperty("multiply_reward")
    MULTIPLY_REWARD,
    
    @JsonProperty("extra_bonus")
    EXTRA_BONUS,
    
    @JsonProperty("miss")
    MISS
}
