package com.sheepfly.designpattern.part2.section2;

import com.sheepfly.chapter2.part2.section2.Computer;
import com.sheepfly.chapter2.part2.section2.ComputerFactory;
import com.sheepfly.chapter2.part2.section2.Laptop;
import com.sheepfly.chapter2.part2.section2.PersonComputer;
import org.junit.Test;

public class SimpleFactoryTest {
    @Test
    public void noFactory() {
        Computer personComputer = new PersonComputer();
        Computer laptop = new Laptop();
        personComputer.playGame();
        laptop.playGame();
    }

    // @Test
    public void useFactoryInstance() {
        ComputerFactory factory = new ComputerFactory();
        Computer personComputer = factory.createComputer("laptop");
        Computer laptop = factory.createComputer("personComputer");
        Computer computer = factory.createComputer("");
        personComputer.playGame();
        laptop.playGame();
        computer.playGame();
    }

    @Test
    public void useReflectFactory() {
        Computer personComputer = ComputerFactory.reflectCreateComputer("com.sheepfly.designpattern.factory.simplefactory.PersonComputer");
        Computer laptop = ComputerFactory.reflectCreateComputer("com.sheepfly.designpattern.factory.simplefactory.Laptop");
        personComputer.playGame();
        laptop.playGame();
    }

    @Test
    public void useReflectFactory2() {
        Computer laptop = ComputerFactory.reflectCreateComputer2(Laptop.class);
        Computer personComputer = ComputerFactory.reflectCreateComputer2(PersonComputer.class);
        laptop.playGame();
        personComputer.playGame();
    }
}
