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

  public int expectedStatus() {
    return 200;
  }

  public Class<Account> responseClass() {
    return Account.class;
  }
}
