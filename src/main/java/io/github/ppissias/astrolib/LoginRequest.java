/**
 * 
 */
package io.github.ppissias.astrolib;

import javax.annotation.processing.Generated;

/**
 * Login request
 * @author Petros Pissias
 *
 */
public class LoginRequest {
	private String apikey;

	@Generated("SparkTools")
	private LoginRequest(Builder builder) {
		this.apikey = builder.apikey;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	/**
	 * Creates builder to build {@link LoginRequest}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link LoginRequest}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String apikey;

		private Builder() {
		}

		public Builder withApikey(String apikey) {
			this.apikey = apikey;
			return this;
		}

		public LoginRequest build() {
			return new LoginRequest(this);
		}
	}

	
}
