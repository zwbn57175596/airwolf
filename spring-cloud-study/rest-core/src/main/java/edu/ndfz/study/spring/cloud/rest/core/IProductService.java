package edu.ndfz.study.spring.cloud.rest.core;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface IProductService {

  @RequestMapping(value = "/products", method = RequestMethod.GET)
  List<Product> list();

  @RequestMapping(value = "/products/{itemCode}", method = RequestMethod.GET)
  Product detail(@PathVariable("itemCode") String itemCode);
}
