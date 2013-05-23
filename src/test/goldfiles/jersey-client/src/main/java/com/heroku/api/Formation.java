package com.heroku.api;

public class Formation
    implements java.io.Serializable {

  protected static final long serialVersionUID = -969217626L;

  /**
   * Command to use for process type
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String command;

  /**
   * When domain was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * Unique identifier of this process type
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * Number of processes to maintain
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Number quantity;

  /**
   * Dyno size (default: 1)
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Number size;

  /**
   * Type of process to maintain
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String type;

  /**
   * When dyno type was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Formation is created in response to API calls
   */
  protected Formation() {
  }

  /**
   * Get command to use for process type
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
   * Get unique identifier of this process type
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get number of processes to maintain
   */
  public Number getQuantity() {
    return this.quantity;
  }

  /**
   * Get dyno size (default: 1)
   */
  public Number getSize() {
    return this.size;
  }

  /**
   * Get type of process to maintain
   */
  public String getType() {
    return this.type;
  }

  /**
   * Get when dyno type was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    Formation formation = (Formation) o;

    if (command != null ? !command.equals(formation.command) : formation.command != null) return false;
    if (created_at != null ? !created_at.equals(formation.created_at) : formation.created_at != null) return false;
    if (id != null ? !id.equals(formation.id) : formation.id != null) return false;
    if (quantity != null ? !quantity.equals(formation.quantity) : formation.quantity != null) return false;
    if (size != null ? !size.equals(formation.size) : formation.size != null) return false;
    if (type != null ? !type.equals(formation.type) : formation.type != null) return false;
    if (updated_at != null ? !updated_at.equals(formation.updated_at) : formation.updated_at != null) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Formation{" + 
        "command='" + command + '\'' +
        ", " + "createdAt='" + created_at + '\'' +
        ", " + "id='" + id + '\'' +
        ", " + "quantity='" + quantity + '\'' +
        ", " + "size='" + size + '\'' +
        ", " + "type='" + type + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        '}';
  }

}
