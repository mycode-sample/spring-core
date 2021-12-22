package com.sheepfly.chapter2.section7.part2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoStrategy implements PromotionStrtegy{
    @Override
    public void doPromotion() {
        log.info("对不起，您没有参与任何促销活动。");
    }
}
