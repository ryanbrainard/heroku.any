package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class AccountUpdateAction
    implements Action<Account> {


  public AccountUpdateAction() {
  }

  public String httpMethod() {
    return "PATCH";
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
