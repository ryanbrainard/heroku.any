package com.heroku.api;

public class Formation
    implements java.io.Serializable {

  protected static final long serialVersionUID = 1L;

  /**
   * When dyno type was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Number of processes to maintain
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Number quantity;

  /**
   * Type of process to maintain
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String type;

  /**
   * Unique identifier of this process type
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * When domain was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * Command to use for process type
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String command;

  /**
   * Dyno size (default: 1)
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Number size;

  /**
   * Formation is created in response to API calls
   */
  protected Formation() {
  }

  /**
   * Get when dyno type was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  /**
   * Get number of processes to maintain
   */
  public Number getQuantity() {
    return this.quantity;
  }

  /**
   * Get type of process to maintain
   */
  public String getType() {
    return this.type;
  }

  /**
   * Get unique identifier of this process type
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get when domain was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get command to use for process type
   */
  public String getCommand() {
    return this.command;
  }

  /**
   * Get dyno size (default: 1)
   */
  public Number getSize() {
    return this.size;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    Formation formation = (Formation) o;

    if (updated_at != formation.updated_at) return false;
    if (quantity != formation.quantity) return false;
    if (type != formation.type) return false;
    if (id != formation.id) return false;
    if (created_at != formation.created_at) return false;
    if (command != formation.command) return false;
    if (size != formation.size) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Formation{" + 
        "updatedAt='" + updated_at + '\'' +
        ", " + "quantity='" + quantity + '\'' +
        ", " + "type='" + type + '\'' +
        ", " + "id='" + id + '\'' +
        ", " + "createdAt='" + created_at + '\'' +
        ", " + "command='" + command + '\'' +
        ", " + "size='" + size + '\'' +
        '}';
  }

}
