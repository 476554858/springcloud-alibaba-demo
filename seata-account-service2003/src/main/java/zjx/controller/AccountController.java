package zjx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zjx.domain.CommonResult;
import zjx.service.AccountService;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/account/decrease")
    public CommonResult decreaseStorage(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        return accountService.decreaseMoney(userId, money);
    }

}
