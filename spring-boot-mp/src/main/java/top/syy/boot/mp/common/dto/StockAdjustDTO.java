package top.syy.boot.mp.common.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author 小c
 */
@Data
public class StockAdjustDTO {
    @NotNull(message = "调整数量不能为空")
    private Integer amount;
    @NotNull(message = "调整类型不能为空（1: 入库，2: 出库）")
    private Integer type;
}
