package com.heroku.api;

public class Config Var
    implements java.io.Serializable {

  protected static final long serialVersionUID = 80129139L;

  /**
   * Key/value pair for dyno env
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Map<String,String> keyValuePairs;


  protected Config Var() {
  }

  /**
   * Get key/value pair for dyno env
   */
  public java.util.Map<String,String> getKeyValuePairs() {
    return this.keyValuePairs;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    Config Var configvar = (Config Var) o;

  
    if (keyValuePairs != null ? !keyValuePairs.equals(configvar.keyValuePairs) : configvar.keyValuePairs != null) return false;
  
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Config Var{" +
           "keyValuePairs='" + keyValuePairs + '\'' +
        '}';
  }

}
