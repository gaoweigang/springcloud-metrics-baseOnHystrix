package com.gwg.springcloud.remote;

import com.gwg.springcloud.common.Result;
import com.gwg.springcloud.remote.fallback.IHelloFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 注意：微服务名称不能瞎取，需要和应用名称保持一致
 * name：指定FeignClient的名称，如果项目使用了Ribbon，name属性会作为微服务的名称，用于服务发现
 */
@FeignClient(value = "service-provider",  fallbackFactory = IHelloFallback.class)
public interface IHelloRemote {

    @RequestMapping(value = "/provider/{name}/{age}", method = RequestMethod.GET)
    @ResponseBody Result<String> printServiceProvider(@PathVariable("name") String name, @PathVariable("age") int age);


}
