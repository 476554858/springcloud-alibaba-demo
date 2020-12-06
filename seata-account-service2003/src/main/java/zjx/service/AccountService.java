package zjx.service;

import zjx.domain.CommonResult;
import java.math.BigDecimal;

public interface AccountService {

    CommonResult decreaseMoney(Long userId, BigDecimal money);
}
