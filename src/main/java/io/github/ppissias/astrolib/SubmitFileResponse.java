/**
 * 
 */
package io.github.ppissias.astrolib;

/**
 * Documentation obtained from 
 * http://astrometry.net/doc/net/api.html
 * 
 * @author Petros Pissias
 *
 */
public class SubmitFileResponse {

	/**
	 * The subid is the Submission number. The hash is the sha-1 hash of the contents of the URL you specified.
	 */
	private String status;
	
	private String subid;
	
	private String hash;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubid() {
		return subid;
	}

	public void setSubid(String subid) {
		this.subid = subid;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	@Override
	public String toString() {
		return "SubmitFileResponse [status=" + status + ", subid=" + subid + ", hash=" + hash + "]";
	}
	
	
}
