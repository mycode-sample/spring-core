package com.sheepfly.chapter2.section7.part2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Shop {
    public static void main(String[] args) {
        PromotionScheme scheme;
        if (args.length == 0) {
            log.warn("不使用优惠");
        } else {

            String strategy = args[0];
            switch (strategy) {
                case "cashBack": {
                    scheme = new PromotionScheme(new CashBackStrategy());
                    break;
                }
                case "coupon": {
                    scheme = new PromotionScheme(new CouponStrategy());
                    break;
                }
                case "groupBuy": {
                    scheme = new PromotionScheme(new GroupBuyStrategy());
                    break;
                }
                default: {
                    log.warn("优惠无效");
                    scheme = new PromotionScheme(new NoStrategy());
                }
            }
            scheme.promote();
        }
    }
}
