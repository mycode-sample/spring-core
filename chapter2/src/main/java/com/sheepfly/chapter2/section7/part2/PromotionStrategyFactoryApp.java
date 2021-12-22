package com.sheepfly.chapter2.section7.part2;

public class PromotionStrategyFactoryApp {
    public static void main(String[] args) {
        if (args.length == 0) {
            PromotionStrategyFactory.getPromotionStrategy("NoStrategy").doPromotion();
        } else {
            PromotionStrategyFactory.getPromotionStrategy(args[0]).doPromotion();
        }
    }
}
