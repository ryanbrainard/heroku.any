package com.heroku.api;

public class Formation {

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
   * Construct empty Formation
   */
  public Formation() {
  }

  public Formation(java.util.Date updated_at, Number quantity, String type, java.util.UUID id, java.util.Date created_at, String command, Number size) {
    this.updated_at = updated_at;
    this.quantity = quantity;
    this.type = type;
    this.id = id;
    this.created_at = created_at;
    this.command = command;
    this.size = size;
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

}
