package com.sheepfly.chapter2.section7.part2;

import java.util.HashMap;
import java.util.Map;

public class PromotionStrategyFactory {
    private static final Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();

    private static final PromotionStrategy NO_PROMOTION_STRATEGY = new NoStrategy();

    static {
        PROMOTION_STRATEGY_MAP.put("CashBackStrategy", new CashBackStrategy());
        PROMOTION_STRATEGY_MAP.put("CouponStrategy", new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put("GroupBuyStrategy", new GroupBuyStrategy());
        PROMOTION_STRATEGY_MAP.put("NoStrategy", NO_PROMOTION_STRATEGY);
    }

    private PromotionStrategyFactory() {
        throw new IllegalStateException("禁止使用构造函数");
    }

    public static PromotionStrategy getPromotionStrategy(String key) {
        if (PROMOTION_STRATEGY_MAP.containsKey(key)) {
            return PROMOTION_STRATEGY_MAP.get(key);
        } else {
            return NO_PROMOTION_STRATEGY;
        }
    }

    public interface PromotionKey {
        String CASH_BACK_STRATEGY = "CashBackStrategy";
        String COUPON_STRATEGY = "CouponStrategy";
        String GROUP_BUY_STRATEGY = "GroupBuyStrategy";
        String NO_STRATEGY = "NoStrategy";
    }
}
