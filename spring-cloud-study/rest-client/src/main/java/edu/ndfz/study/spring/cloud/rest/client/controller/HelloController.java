package edu.ndfz.study.spring.cloud.rest.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

  @Autowired
  private RestTemplate restTemplate;

  @Value("${foo}") String foo;

  @RequestMapping(value = "/hi", method = RequestMethod.GET)
  public String hi() {
    return foo;
  }

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String hello() {
    return restTemplate.getForEntity("http://REST-API/hello", String.class).getBody();
  }
}
