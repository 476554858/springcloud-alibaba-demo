package zjx.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zjx.service.PaymentService;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "handlerFallback",  blockHandler = "blockFallback", exceptionsToIgnore = RuntimeException.class)
    public String getPayment(@PathVariable("id") Integer id){
        if(id == 4){
            throw new RuntimeException("人为的异常");
        }
        return restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, String.class);
    }

    public String handlerFallback(@PathVariable("id") Integer id, Throwable e){
        return "java 兜底异常";
    }

    public String blockFallback(@PathVariable("id") Integer id, BlockException e){
        return "流控 兜底异常";
    }

    @GetMapping(value = "/payment/openFeign/{id}")
    public String payment(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }

}
