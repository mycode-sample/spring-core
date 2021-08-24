package com.sheepfly.chapter2.part2.section3;

import com.sheepfly.chapter2.part2.section2.Computer;
import com.sheepfly.chapter2.part2.section2.Laptop;

public class LaptopFactory implements ComputerFactory {

    @Override
    public Computer create() {
        return new Laptop();
    }
}
