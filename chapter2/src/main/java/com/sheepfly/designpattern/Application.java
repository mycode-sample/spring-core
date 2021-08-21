package com.sheepfly.designpattern;

import com.sheepfly.designpattern.part2.section2.Computer;
import com.sheepfly.designpattern.part2.section2.ComputerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
    private final static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        log.info("hello world.");
        ComputerFactory factory = new ComputerFactory();
        Computer personComputer = factory.createComputer("laptop");
        Computer laptop = factory.createComputer("personComputer");
        Computer computer = factory.createComputer("");
        personComputer.playGame();
        laptop.playGame();
        computer.playGame();
    }
}
