package com.kiranbisht.model.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SymbolType {
	
	@JsonProperty("standard")
    STANDARD,
    
    @JsonProperty("bonus")
    BONUS
}