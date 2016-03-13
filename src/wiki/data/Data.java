
package wiki.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

	private String server_script_path;
	private String serverName;
	private Boolean minor;
	private Boolean bot;
	private String wiki;
	private Length length;
	private String title;
	private String type;
	private Revision revision;
	private Integer namespace;
	private String comment;
	private Integer id;
	private String serverUrl;
	private String user;
	private Integer timestamp;

	/**
	 * 
	 * @return The serverScriptPath
	 */
	public String getServerScriptPath() {
		return server_script_path;
	}

	/**
	 * 
	 * @param serverScriptPath
	 *            The server_script_path
	 */
	public void setServerScriptPath(String server_script_path) {
		this.server_script_path = server_script_path;
	}

	/**
	 * 
	 * @return The serverName
	 */
	public String getServerName() {
		return serverName;
	}

	/**
	 * 
	 * @param serverName
	 *            The server_name
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	/**
	 * 
	 * @return The minor
	 */
	public Boolean getMinor() {
		return minor;
	}

	/**
	 * 
	 * @param minor
	 *            The minor
	 */
	public void setMinor(Boolean minor) {
		this.minor = minor;
	}

	/**
	 * 
	 * @return The bot
	 */
	public Boolean getBot() {
		return bot;
	}

	/**
	 * 
	 * @param bot
	 *            The bot
	 */
	public void setBot(Boolean bot) {
		this.bot = bot;
	}

	/**
	 * 
	 * @return The wiki
	 */
	public String getWiki() {
		return wiki;
	}

	/**
	 * 
	 * @param wiki
	 *            The wiki
	 */
	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

	/**
	 * 
	 * @return The length
	 */
	public Length getLength() {
		return length;
	}

	/**
	 * 
	 * @param length
	 *            The length
	 */
	public void setLength(Length length) {
		this.length = length;
	}

	/**
	 * 
	 * @return The title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 *            The title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            The type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return The revision
	 */
	public Revision getRevision() {
		return revision;
	}

	/**
	 * 
	 * @param revision
	 *            The revision
	 */
	public void setRevision(Revision revision) {
		this.revision = revision;
	}

	/**
	 * 
	 * @return The namespace
	 */
	public Integer getNamespace() {
		return namespace;
	}

	/**
	 * 
	 * @param namespace
	 *            The namespace
	 */
	public void setNamespace(Integer namespace) {
		this.namespace = namespace;
	}

	/**
	 * 
	 * @return The comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * 
	 * @param comment
	 *            The comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * 
	 * @return The id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The serverUrl
	 */
	public String getServerUrl() {
		return serverUrl;
	}

	/**
	 * 
	 * @param serverUrl
	 *            The server_url
	 */
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	/**
	 * 
	 * @return The user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * 
	 * @param user
	 *            The user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * 
	 * @return The timestamp
	 */
	public Integer getTimestamp() {
		return timestamp;
	}

	/**
	 * 
	 * @param timestamp
	 *            The timestamp
	 */
	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}

}
