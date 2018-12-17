package net.emecas.gpluspager.parsing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Verification {
	private String adHocVerified;

	public String getAdHocVerified() {
		return adHocVerified;
	}

	public void setAdHocVerified(String adHocVerified) {
		this.adHocVerified = adHocVerified;
	}

	@Override
	public String toString() {
		return String.format("Verification [adHocVerified=%s]", adHocVerified);
	}
	
	
}
