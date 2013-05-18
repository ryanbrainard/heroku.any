package com.heroku.api;

public class Dyno {

  /**
   * The name of this process on this app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String name;

  /**
   * Current status of process (either: crashed, down, starting, or up)
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String state;

  /**
   * Type of process
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String type;

  /**
   * When domain was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * Command used to start this process
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String command;

  /**
   * Release
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Release release;

  /**
   * When process last changed state
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

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
   * Unique identifier of this dyno
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * Construct empty Dyno
   */
  public Dyno() {
  }

  public Dyno(String name, String state, String type, java.util.Date created_at, String command, Release release, java.util.Date updated_at, Number size, String attach_url, java.util.UUID id) {
    this.name = name;
    this.state = state;
    this.type = type;
    this.created_at = created_at;
    this.command = command;
    this.release = release;
    this.updated_at = updated_at;
    this.size = size;
    this.attach_url = attach_url;
    this.id = id;
  }

  /**
   * Get the name of this process on this app
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get current status of process (either: crashed, down, starting, or up)
   */
  public String getState() {
    return this.state;
  }

  /**
   * Get type of process
   */
  public String getType() {
    return this.type;
  }

  /**
   * Get when domain was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get command used to start this process
   */
  public String getCommand() {
    return this.command;
  }

  /**
   * Get release
   */
  public Release getRelease() {
    return this.release;
  }

  /**
   * Get when process last changed state
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
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
   * Get unique identifier of this dyno
   */
  public java.util.UUID getId() {
    return this.id;
  }

  @Override
  public String toString() {
    return "Dyno{" + 
        "name='" + name + '\'' +
        ", " + "state='" + state + '\'' +
        ", " + "type='" + type + '\'' +
        ", " + "createdAt='" + created_at + '\'' +
        ", " + "command='" + command + '\'' +
        ", " + "release='" + release + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        ", " + "size='" + size + '\'' +
        ", " + "attachUrl='" + attach_url + '\'' +
        ", " + "id='" + id + '\'' +
        '}';
  }

}
