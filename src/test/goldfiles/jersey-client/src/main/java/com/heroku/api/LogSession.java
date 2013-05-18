package com.heroku.api;

public class LogSession {

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
   * Construct empty Log Session
   */
  public LogSession() {
  }

  public LogSession(java.util.Date created_at, java.util.UUID id, String logplex_url, java.util.Date updated_at) {
    this.created_at = created_at;
    this.id = id;
    this.logplex_url = logplex_url;
    this.updated_at = updated_at;
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
  public String toString() {
    return "LogSession{" + 
        "createdAt='" + created_at + '\'' +
        ", " + "id='" + id + '\'' +
        ", " + "logplexUrl='" + logplex_url + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        '}';
  }

}
