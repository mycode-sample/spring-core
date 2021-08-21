package com.sheepfly.designpattern.part2.section2;

public class ComputerFactory {
    public static Computer staticCreateComputer(String name) {
        if ("laptop".equals(name)) {
            return new Laptop();
        } else if ("personComputer".equals(name)) {
            return new PersonComputer();
        }
        return null;
    }

    public static Computer reflectCreateComputer(String name) {
        if ("".equals(name) || name == null) {
            return null;
        }
        Computer computer = null;
        try {
            Object o = Class.forName(name).newInstance();
            computer = (Computer) o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return computer;
    }

    public static Computer reflectCreateComputer2(Class<? extends Computer> cla) {
        Computer computer = null;
        if (cla == null) {
            return null;
        }
        try {
            computer = cla.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return computer;
    }

    public Computer createComputer(String name) {
        if ("laptop".equals(name)) {
            return new Laptop();
        } else if ("personComputer".equals(name)) {
            return new PersonComputer();
        }
        return null;
    }
}
