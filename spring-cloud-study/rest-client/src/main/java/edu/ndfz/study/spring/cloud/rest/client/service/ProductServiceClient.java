package edu.ndfz.study.spring.cloud.rest.client.service;

import edu.ndfz.study.spring.cloud.rest.core.IProductService;
import edu.ndfz.study.spring.cloud.rest.core.Product;
import org.springframework.cloud.netflix.feign.FeignClient;

import java.util.List;

@FeignClient(value = "REST-API", fallback = ComputeClientHystrix.class)
public interface ProductServiceClient extends IProductService {

}

class ComputeClientHystrix implements IProductService {

  @Override
  public List<Product> list() {
    return null;
  }

  @Override
  public Product detail(String itemCode) {
    return null;
  }
}
