package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class AccountInfoAction
    implements Action<Account> {


  public AccountInfoAction() {
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/account";
  }

  public Object requestEntity() {
    return null;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200);
  }

  public com.sun.jersey.api.client.GenericType<Account> responseType() {
    return new com.sun.jersey.api.client.GenericType<Account>(){};
  }
}
