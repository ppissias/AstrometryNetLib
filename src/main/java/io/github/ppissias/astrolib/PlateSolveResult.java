/*
 * SpacePixels
 * 
 * Copyright (c)2020-2023, Petros Pissias.
 * See the LICENSE file included in this distribution.
 *
 * author: Petros Pissias <petrospis at gmail.com>
 *
 */
package io.github.ppissias.astrolib;

import java.util.Map;

public class PlateSolveResult {

	private final boolean success;
	private final String failureReason;
	private final String warning;
	
	private final Map<String, String> solveInformation;

	public PlateSolveResult(boolean success, String failureReason, String warning,
			Map<String, String> solveInformation) {
		super();
		this.success = success;
		this.failureReason = failureReason;
		this.warning = warning;
		this.solveInformation = solveInformation;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public String getWarning() {
		return warning;
	}

	public Map<String, String> getSolveInformation() {
		return solveInformation;
	}

	@Override
	public String toString() {
		return "PlateSolveResult [success=" + success + ", failureReason=" + failureReason + ", warning=" + warning
				+ ", solveInformation=" + solveInformation + "]";
	}
	
	
}
