package edu.ndfz.study.spring.cloud.rest.client.controller;

import edu.ndfz.study.spring.cloud.rest.client.service.ProductService;
import edu.ndfz.study.spring.cloud.rest.core.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Resource
  private ProductService productService;

  @RequestMapping(method = RequestMethod.GET)
  public List<Product> list() {
    return this.productService.findAll();
  }

  @RequestMapping(value = "/{itemCode}", method = RequestMethod.GET)
  public Product detail(@PathVariable String itemCode) {
    return this.productService.loadByItemCode(itemCode);
  }
}
