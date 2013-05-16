package com.heroku.api;

public class Dyno {

  /**
   * Type of process
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String type;

  /**
   * Dyno size (default: 1)
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Number size;

  /**
   * A url to stream output from for attached processes or null for non-attached processes
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String attach_url;

  /**
   * When domain was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * The name of this process on this app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String name;

  /**
   * When process last changed state
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Current status of process (either: crashed, down, starting, or up)
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String state;

  /**
   * Unique identifier of this dyno
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * Release
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Release release;

  /**
   * Command used to start this process
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String command;

  /**
   * Construct empty Dynos
   */
  public Dyno() {
  }

  public Dyno(String type, Number size, String attach_url, java.util.Date created_at, String name, java.util.Date updated_at, String state, java.util.UUID id, Release release, String command) {
    this.type = type;
    this.size = size;
    this.attach_url = attach_url;
    this.created_at = created_at;
    this.name = name;
    this.updated_at = updated_at;
    this.state = state;
    this.id = id;
    this.release = release;
    this.command = command;
  }

  /**
   * Get type of process
   */
  public String getType() {
    return this.type;
  }

  /**
   * Get dyno size (default: 1)
   */
  public Number getSize() {
    return this.size;
  }

  /**
   * Get a url to stream output from for attached processes or null for non-attached processes
   */
  public String getAttachUrl() {
    return this.attach_url;
  }

  /**
   * Get when domain was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get the name of this process on this app
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get when process last changed state
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  /**
   * Get current status of process (either: crashed, down, starting, or up)
   */
  public String getState() {
    return this.state;
  }

  /**
   * Get unique identifier of this dyno
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get release
   */
  public Release getRelease() {
    return this.release;
  }

  /**
   * Get command used to start this process
   */
  public String getCommand() {
    return this.command;
  }

}
