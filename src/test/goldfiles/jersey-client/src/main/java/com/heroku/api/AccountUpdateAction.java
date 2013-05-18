package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class AccountUpdateAction
    implements Action<Account> {

  private String email;
  private boolean allow_tracking;
  private boolean beta;

  public AccountUpdateAction() {
  }

  public String httpMethod() {
    return "PATCH";
  }

  public String path() {
    return "/account";
  }

  public Object requestEntity() {
    return this;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200);
  }

  public com.sun.jersey.api.client.GenericType<Account> responseType() {
    return new com.sun.jersey.api.client.GenericType<Account>(){};
  }

  public String getEmail() {
    return this.email;
  }

  public boolean getAllowTracking() {
    return this.allow_tracking;
  }

  public boolean getBeta() {
    return this.beta;
  }

  /**
   * Set email address of account
   */
  public AccountUpdateAction setEmail(String email) {
    this.email = email;
    return this;
  }

  /**
   * Set whether to allow web activity tracking with third-party services like Google Analytics
   */
  public AccountUpdateAction setAllowTracking(boolean allowTracking) {
    this.allow_tracking = allowTracking;
    return this;
  }

  /**
   * Set whether to utilize beta Heroku features
   */
  public AccountUpdateAction setBeta(boolean beta) {
    this.beta = beta;
    return this;
  }
}
