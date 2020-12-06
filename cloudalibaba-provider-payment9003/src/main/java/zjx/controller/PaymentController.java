package zjx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static Map<Long, Object> map = new HashMap<Long, Object>();
    static {
        map.put(1L, "订单1");
        map.put(2L, "订单2");
        map.put(3L, "订单3");
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public String getPayment(@PathVariable("id") Long id){
        return "from mysql,serverPort: " + serverPort + "," + map.get(id);
    }

}
