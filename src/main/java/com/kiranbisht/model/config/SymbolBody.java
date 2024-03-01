package com.kiranbisht.model.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SymbolBody {

	@JsonProperty("reward_multiplier")
	private Double rewardMultiplier;

	private SymbolType type;

	private ImpactType impact;

	private Integer extra;

	public SymbolBody() {
		// TODO Auto-generated constructor stub
	}

	public Double getRewardMultiplier() {
		return rewardMultiplier;
	}

	public void setRewardMultiplier(Double rewardMultiplier) {
		this.rewardMultiplier = rewardMultiplier;
	}

	public SymbolType getType() {
		return type;
	}

	public void setType(SymbolType type) {
		this.type = type;
	}

	public ImpactType getImpact() {
		return impact;
	}

	public void setImpact(ImpactType impact) {
		this.impact = impact;
	}

	public Integer getExtra() {
		return extra;
	}

	public void setExtra(Integer extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "SymbolBody [rewardMultiplier=" + rewardMultiplier + ", type=" + type + ", impact=" + impact + ", extra="
				+ extra + "]";
	}

}
