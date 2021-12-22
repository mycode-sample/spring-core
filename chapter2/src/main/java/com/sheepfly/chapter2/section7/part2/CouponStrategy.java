package com.sheepfly.chapter2.section7.part2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CouponStrategy implements PromotionStrtegy{
    @Override
    public void doPromotion() {
        log.info("使用优惠券抵扣。");
    }
}
