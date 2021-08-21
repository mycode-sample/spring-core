package com.sheepfly.designpattern.part2.section4;

public interface AssembleComputer {
    GraphicsCard createGraphicsCard();

    Memory createMemory();

    Processor createProcessor();
}
