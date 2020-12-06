package zjx.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zjx.handler.CustomerBlockHandler;

@RestController
public class RateLimitController {

    @GetMapping("/byResouce")
    @SentinelResource(value = "byResource", blockHandler = "handlerException")
    public Object byResource(){
        return "ok";
    }

    public Object handlerException(BlockException b){
        return "服务不可用";
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public Object byUrl(){
        return "服务不可用";
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,
    blockHandler = "handleException2")
    public Object customerBlockHandler(){
        return "ok";
    }
}
