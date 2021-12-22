package com.sheepfly.chapter2.section7.part2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PromotionScheme {
    private PromotionStrategy promotionStrategy;

    private PromotionScheme() {
        throw new IllegalStateException("禁止使用无参构造函数。");
    }

    public PromotionScheme(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void promote() {
        log.info("开始使用优惠");
        promotionStrategy.doPromotion();
        log.info("优惠使用完成");
    }
}
