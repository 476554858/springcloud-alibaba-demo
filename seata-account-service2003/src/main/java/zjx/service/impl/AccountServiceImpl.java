package zjx.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjx.domain.CommonResult;
import zjx.domain.Account;
import zjx.mapper.AccountMapper;
import zjx.service.AccountService;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public CommonResult decreaseMoney(Long userId, BigDecimal money){

//        try {
//            //模拟异常
////            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Account account = new Account();
        account.setUserId(userId);
        account = accountMapper.selectOne(account);

        account.setUsed(account.getUsed().add(money) );
        account.setResidue(account.getResidue().subtract(money));
        accountMapper.updateById(account);

        return CommonResult.success();
    }
}
