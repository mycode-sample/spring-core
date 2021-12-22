package com.sheepfly.chapter2.section7.part2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GroupBuyStrategy implements PromotionStrtegy {
    @Override
    public void doPromotion() {
        log.info("拼团促销。");
    }
}
