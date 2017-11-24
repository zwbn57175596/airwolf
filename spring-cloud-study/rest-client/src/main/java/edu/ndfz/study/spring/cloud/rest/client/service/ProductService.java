package edu.ndfz.study.spring.cloud.rest.client.service;

import edu.ndfz.study.spring.cloud.rest.core.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("REST-API")
public interface ProductService {

  @RequestMapping(value = "/products", method = RequestMethod.GET)
  List<Product> findAll();

  @RequestMapping(value = "/products/{itemCode}", method = RequestMethod.GET)
  Product loadByItemCode(@PathVariable("itemCode") String itemCode);
}
