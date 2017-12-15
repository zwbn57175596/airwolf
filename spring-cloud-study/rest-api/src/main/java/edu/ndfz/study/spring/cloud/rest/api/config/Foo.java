package edu.ndfz.study.spring.cloud.rest.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
public class Foo {

  @Value("${foo}")
  private String foo;

  public String getFoo() {
    return foo;
  }
}
