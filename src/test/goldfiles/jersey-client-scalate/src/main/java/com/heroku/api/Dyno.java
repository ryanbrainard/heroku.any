package com.heroku.api;

public class Dyno
    implements java.io.Serializable {

  protected static final long serialVersionUID = 270322495L;

  /**
   * A url to stream output from for attached processes or null for non-attached processes
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String attach_url;

  /**
   * Command used to start this process
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String command;

  /**
   * When domain was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * Unique identifier of this dyno
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * The name of this process on this app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String name;

  /**
   * Release
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Release release;

  /**
   * Dyno size (default: 1)
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Number size;

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
   * When process last changed state
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;


  protected Dyno() {
  }

  /**
   * Get a url to stream output from for attached processes or null for non-attached processes
   */
  public String getAttachUrl() {
    return this.attach_url;
  }

  /**
   * Get command used to start this process
   */
  public String getCommand() {
    return this.command;
  }

  /**
   * Get when domain was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get unique identifier of this dyno
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get the name of this process on this app
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get release
   */
  public Release getRelease() {
    return this.release;
  }

  /**
   * Get dyno size (default: 1)
   */
  public Number getSize() {
    return this.size;
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
   * Get when process last changed state
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    Dyno dyno = (Dyno) o;

  
    if (attach_url != null ? !attach_url.equals(dyno.attach_url) : dyno.attach_url != null) return false;
    
    if (command != null ? !command.equals(dyno.command) : dyno.command != null) return false;
    
    if (created_at != null ? !created_at.equals(dyno.created_at) : dyno.created_at != null) return false;
    
    if (id != null ? !id.equals(dyno.id) : dyno.id != null) return false;
    
    if (name != null ? !name.equals(dyno.name) : dyno.name != null) return false;
    
    if (release != null ? !release.equals(dyno.release) : dyno.release != null) return false;
    
    if (size != null ? !size.equals(dyno.size) : dyno.size != null) return false;
    
    if (state != null ? !state.equals(dyno.state) : dyno.state != null) return false;
    
    if (type != null ? !type.equals(dyno.type) : dyno.type != null) return false;
    
    if (updated_at != null ? !updated_at.equals(dyno.updated_at) : dyno.updated_at != null) return false;
  
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Dyno{" +
           "attachUrl='" + attach_url + '\'' +
           ", " + "command='" + command + '\'' +
           ", " + "createdAt='" + created_at + '\'' +
           ", " + "id='" + id + '\'' +
           ", " + "name='" + name + '\'' +
           ", " + "release='" + release + '\'' +
           ", " + "size='" + size + '\'' +
           ", " + "state='" + state + '\'' +
           ", " + "type='" + type + '\'' +
           ", " + "updatedAt='" + updated_at + '\'' +
        '}';
  }

}
