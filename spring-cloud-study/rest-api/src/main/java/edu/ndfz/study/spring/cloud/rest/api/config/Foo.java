package edu.ndfz.study.spring.cloud.rest.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class Foo {

  @Value("${foo}")
  private String foo;

  public String getFoo() {
    return foo;
  }
}
