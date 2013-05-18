package com.heroku.api;

public class Region {

  /**
   * Unique identifier of this region
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * When region was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * When region was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Unique name of the region
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String name;

  /**
   * Description of the region
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String description;

  /**
   * Construct empty Region
   */
  public Region() {
  }

  public Region(java.util.UUID id, java.util.Date created_at, java.util.Date updated_at, String name, String description) {
    this.id = id;
    this.created_at = created_at;
    this.updated_at = updated_at;
    this.name = name;
    this.description = description;
  }

  /**
   * Get unique identifier of this region
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get when region was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get when region was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  /**
   * Get unique name of the region
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get description of the region
   */
  public String getDescription() {
    return this.description;
  }

  @Override
  public String toString() {
    return "Region{" + 
        "id='" + id + '\'' +
        ", " + "createdAt='" + created_at + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        ", " + "name='" + name + '\'' +
        ", " + "description='" + description + '\'' +
        '}';
  }

}
