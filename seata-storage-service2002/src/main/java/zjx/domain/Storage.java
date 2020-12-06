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
@TableName("t_storage")
public class Storage {

    @TableId(type = IdType.AUTO)
    private Long id;

    //产品ID
    private Long productId;

    //总库存
    private Integer total;

    //已用库存
    private Integer used;

    //剩余库存
    private Integer residue;
}
