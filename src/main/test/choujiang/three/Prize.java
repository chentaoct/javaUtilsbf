package choujiang.three;

import java.math.BigDecimal;

/**
 * Created by 陈涛 on 2017/6/2.
 */
public class Prize {

    /**
     * 奖品唯一标示
     */
    private Integer prizeId;

    /**
     * 中奖概率
     */
    private BigDecimal probability;

    /**
     * 奖品数量
     */
    private Integer quantity;

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public BigDecimal getProbability() {
        return probability;
    }

    public void setProbability(BigDecimal probability) {
        this.probability = probability;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
