package zjx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zjx.domain.CommonResult;
import zjx.service.OrderService;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/createOrder")
    public CommonResult getPayment(){
        return orderService.createOrder();
    }

}
