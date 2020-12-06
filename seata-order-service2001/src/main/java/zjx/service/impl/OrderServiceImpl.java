package zjx.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjx.domain.CommonResult;
import zjx.domain.Order;
import zjx.mapper.OrderMapper;
import zjx.service.AccountService;
import zjx.service.OrderService;
import zjx.service.StorageService;
import java.math.BigDecimal;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "zjx_tx_group", rollbackFor = Exception.class)
    public CommonResult createOrder(){

        log.info("开始创建订单。。。。。");
        Order order = new Order();
        order.setMoney(new BigDecimal(100));
        order.setCount(10);
        order.setProductId(1l);
        order.setStatus(0);
        order.setUserId(1l);
        orderMapper.insert(order);

        log.info("订单微服务开始调用库存，做扣减 count");
        storageService.decrease(order.getProductId(), order.getCount());

        log.info("订单微服务开始调用库存，做扣减 money");
        accountService.decrease(order.getUserId(), order.getMoney());

        log.info("修改订单状态");

        order.setStatus(1);
        orderMapper.updateById(order);
        return CommonResult.success();
    }
}
