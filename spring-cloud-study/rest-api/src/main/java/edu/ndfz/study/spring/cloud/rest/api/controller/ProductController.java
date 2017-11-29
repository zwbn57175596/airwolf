package edu.ndfz.study.spring.cloud.rest.api.controller;

import edu.ndfz.study.spring.cloud.rest.core.IProductService;
import edu.ndfz.study.spring.cloud.rest.core.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController implements IProductService {

//  private final Logger log = LoggerFactory.getLogger(ProductController.class);

  @Override
//  @RequestMapping(method = RequestMethod.GET)
  public List<Product> list() {
    return this.buildProducts();
  }

  @Override
//  @RequestMapping(value = "/{itemCode}", method = RequestMethod.GET)
  public Product detail(@PathVariable String itemCode) {
    List<Product> products = this.buildProducts();
    for (Product product : products) {
      if (product.getItemCode().equalsIgnoreCase(itemCode))
        return product;
    }
    return null;
  }

  protected List<Product> buildProducts() {
    List<Product> products = new ArrayList<>();
    products.add(new Product("item-1", "测试商品-1", "TwoStepsFromJava", 100));
    products.add(new Product("item-2", "测试商品-2", "TwoStepsFromJava", 200));
    products.add(new Product("item-3", "测试商品-3", "TwoStepsFromJava", 300));
    products.add(new Product("item-4", "测试商品-4", "TwoStepsFromJava", 400));
    products.add(new Product("item-5", "测试商品-5", "TwoStepsFromJava", 500));
    products.add(new Product("item-6", "测试商品-6", "TwoStepsFromJava", 600));
    return products;
  }

}
