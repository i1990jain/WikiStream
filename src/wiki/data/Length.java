
package wiki.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Length {

	private Integer _new;
	private Integer old;

	/**
	 * 
	 * @return The _new
	 */
	public Integer getNew() {
		return _new;
	}

	/**
	 * 
	 * @param _new
	 *            The new
	 */
	public void setNew(Integer _new) {
		this._new = _new;
	}

	/**
	 * 
	 * @return The old
	 */
	public Integer getOld() {
		return old;
	}

	/**
	 * 
	 * @param old
	 *            The old
	 */
	public void setOld(Integer old) {
		this.old = old;
	}

}
