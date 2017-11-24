package edu.ndfz.study.spring.cloud.rest.client.service;

import edu.ndfz.study.spring.cloud.rest.core.IProductService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("REST-API")
public interface ProductServiceClient extends IProductService {

}
