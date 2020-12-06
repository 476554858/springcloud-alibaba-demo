package zjx.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public String paymentSQL(Long id) {
        return "服务降级。。。";
    }
}
