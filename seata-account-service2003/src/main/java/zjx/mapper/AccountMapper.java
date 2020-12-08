package zjx.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import zjx.domain.Account;

import java.math.BigDecimal;

@Mapper
public interface AccountMapper extends BaseMapper<Account>{

//    Integer updateAccount( BigDecimal used, BigDecimal residue, Long id);
}
