package zjx.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_account")
public class Account {

    @TableId(type = IdType.AUTO)
    private Long id;

    //用户ID
    private Long userId;

    //总库存
    private BigDecimal total;

    //已用额度
    private BigDecimal used;

    //剩余额度
    private BigDecimal residue;
}
