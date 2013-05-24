package com.heroku.api;

public class Domain
    implements java.io.Serializable {

  protected static final long serialVersionUID = 1597518425L;

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
   * Domain is created in response to API calls
   */
  protected Domain() {
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
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    Domain domain = (Domain) o;

    if (created_at != null ? !created_at.equals(domain.created_at) : domain.created_at != null) return false;
    if (hostname != null ? !hostname.equals(domain.hostname) : domain.hostname != null) return false;
    if (id != null ? !id.equals(domain.id) : domain.id != null) return false;
    if (updated_at != null ? !updated_at.equals(domain.updated_at) : domain.updated_at != null) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
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
