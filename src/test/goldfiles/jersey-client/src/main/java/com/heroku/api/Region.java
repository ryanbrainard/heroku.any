package com.heroku.api;

public class Region
    implements java.io.Serializable {

  protected static final long serialVersionUID = 1L;

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
   * Region is created in response to API calls
   */
  protected Region() {
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
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    Region region = (Region) o;

    if (id != region.id) return false;
    if (created_at != region.created_at) return false;
    if (updated_at != region.updated_at) return false;
    if (name != region.name) return false;
    if (description != region.description) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
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
