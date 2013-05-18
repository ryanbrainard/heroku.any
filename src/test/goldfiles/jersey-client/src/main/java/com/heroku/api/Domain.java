package com.heroku.api;

public class Domain {

  /**
   * When domain was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * Full hostname
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String hostname;

  /**
   * Unique identifier of this domain
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * When domain was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Construct empty Domain
   */
  public Domain() {
  }

  public Domain(java.util.Date created_at, String hostname, java.util.UUID id, java.util.Date updated_at) {
    this.created_at = created_at;
    this.hostname = hostname;
    this.id = id;
    this.updated_at = updated_at;
  }

  /**
   * Get when domain was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get full hostname
   */
  public String getHostname() {
    return this.hostname;
  }

  /**
   * Get unique identifier of this domain
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get when domain was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  @Override
  public String toString() {
    return "Domain{" + 
        "createdAt='" + created_at + '\'' +
        ", " + "hostname='" + hostname + '\'' +
        ", " + "id='" + id + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        '}';
  }

}
