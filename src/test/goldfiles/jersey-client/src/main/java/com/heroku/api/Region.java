package com.heroku.api;

public class Region {

  /**
   * Unique name of the region
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String name;

  /**
   * When region was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * Unique identifier of this region
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * When region was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Description of the region
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String description;

  /**
   * Construct empty Regions
   */
  public Region() {
  }

  public Region(String name, java.util.Date created_at, java.util.UUID id, java.util.Date updated_at, String description) {
    this.name = name;
    this.created_at = created_at;
    this.id = id;
    this.updated_at = updated_at;
    this.description = description;
  }

  /**
   * Get unique name of the region
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get when region was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get unique identifier of this region
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get when region was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  /**
   * Get description of the region
   */
  public String getDescription() {
    return this.description;
  }

}
