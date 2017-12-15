package edu.ndfz.study.spring.cloud.rest.api.controller;

import com.netflix.appinfo.EurekaInstanceConfig;
import edu.ndfz.study.spring.cloud.rest.api.config.Foo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloWorld {

  private static final Logger log = LoggerFactory.getLogger(HelloWorld.class);

  @Autowired
  private EurekaInstanceConfig eurekaInstanceConfig;

  @Value("${server.port}")
  private int serverPort = 0;

  @Resource
  private Foo foo;

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String hello() {
    log.info("/hello, instanceId:{}, host:{}", eurekaInstanceConfig.getInstanceId(),
        eurekaInstanceConfig.getHostName(false));
    return "Hello, Spring Cloud! My port is " + String.valueOf(serverPort);
  }
}
