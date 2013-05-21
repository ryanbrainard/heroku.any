package com.heroku.api;

public class LogSession
    implements java.io.Serializable {

  protected static final long serialVersionUID = -1378042525L;

  /**
   * When log connection was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * Unique identifier of this log session
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * Url for log streaming session
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String logplex_url;

  /**
   * When log session was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Log Session is created in response to API calls
   */
  protected LogSession() {
  }

  /**
   * Get when log connection was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get unique identifier of this log session
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get url for log streaming session
   */
  public String getLogplexUrl() {
    return this.logplex_url;
  }

  /**
   * Get when log session was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    LogSession logsession = (LogSession) o;

    if (created_at != logsession.created_at) return false;
    if (id != logsession.id) return false;
    if (logplex_url != logsession.logplex_url) return false;
    if (updated_at != logsession.updated_at) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "LogSession{" + 
        "createdAt='" + created_at + '\'' +
        ", " + "id='" + id + '\'' +
        ", " + "logplexUrl='" + logplex_url + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        '}';
  }

}
