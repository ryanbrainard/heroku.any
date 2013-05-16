package com.heroku.api;

public class Formation {

  /**
   * Dyno size (default: 1)
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Number size;

  /**
   * When domain was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * When dyno type was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Type of process to maintain
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String type;

  /**
   * Command to use for process type
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String command;

  /**
   * Number of processes to maintain
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Number quantity;

  /**
   * Construct empty Formation
   */
  public Formation() {
  }

  public Formation(Number size, java.util.Date created_at, java.util.Date updated_at, String type, String command, Number quantity) {
    this.size = size;
    this.created_at = created_at;
    this.updated_at = updated_at;
    this.type = type;
    this.command = command;
    this.quantity = quantity;
  }

  /**
   * Get dyno size (default: 1)
   */
  public Number getSize() {
    return this.size;
  }

  /**
   * Get when domain was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get when dyno type was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  /**
   * Get type of process to maintain
   */
  public String getType() {
    return this.type;
  }

  /**
   * Get command to use for process type
   */
  public String getCommand() {
    return this.command;
  }

  /**
   * Get number of processes to maintain
   */
  public Number getQuantity() {
    return this.quantity;
  }

}
