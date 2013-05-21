package com.heroku.api;

public class Region
    implements java.io.Serializable {

  protected static final long serialVersionUID = -90172572L;

  /**
   * When region was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * Description of the region
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String description;

  /**
   * Unique identifier of this region
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * Unique name of the region
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String name;

  /**
   * When region was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Region is created in response to API calls
   */
  protected Region() {
  }

  /**
   * Get when region was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get description of the region
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Get unique identifier of this region
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get unique name of the region
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get when region was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    Region region = (Region) o;

    if (created_at != region.created_at) return false;
    if (description != region.description) return false;
    if (id != region.id) return false;
    if (name != region.name) return false;
    if (updated_at != region.updated_at) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Region{" + 
        "createdAt='" + created_at + '\'' +
        ", " + "description='" + description + '\'' +
        ", " + "id='" + id + '\'' +
        ", " + "name='" + name + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        '}';
  }

}
