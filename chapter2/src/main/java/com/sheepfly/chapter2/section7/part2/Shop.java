package com.sheepfly.chapter2.section7.part2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Shop {
    public static void main(String[] args) {
        PromotionStrtegy ps1 = new CouponStrategy();
        PromotionStrtegy ps2 = new GroupBuyStrategy();
        PromotionScheme scheme  = new PromotionScheme(ps1);
        PromotionScheme scheme2  = new PromotionScheme(ps2);
        scheme.promote();
        scheme2.promote();
    }
}
