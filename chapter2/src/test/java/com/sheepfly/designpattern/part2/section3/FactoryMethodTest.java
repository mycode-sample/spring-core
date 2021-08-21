package com.sheepfly.designpattern.part2.section3;

import com.sheepfly.designpattern.part2.section2.Computer;
import org.junit.Test;

public class FactoryMethodTest {
    @Test
    public void testFactoryMethod() {
        ComputerFactory personComputerFactory = new PersonComputerFactory();
        ComputerFactory laptopFactory = new LaptopFactory();
        Computer laptop = laptopFactory.create();
        Computer personComputer = personComputerFactory.create();
        laptop.playGame();
        personComputer.playGame();
    }

    @Test
    public void testAccurateFactoryMethod() {
        PersonComputerFactory personComputerFactory = new PersonComputerFactory();
        LaptopFactory laptopFactory = new LaptopFactory();
        Computer laptop = laptopFactory.create();
        Computer personComputer = personComputerFactory.create();
        laptop.playGame();
        personComputer.playGame();
    }
}
