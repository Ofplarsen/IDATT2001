package edu.ntnu.oflarsen.teorisjekk.actors.animals;

import edu.ntnu.oflarsen.teorisjekk.actors.Animal;
import edu.ntnu.oflarsen.teorisjekk.actors.Hunter;

public class Rabbit extends Animal {
    public Rabbit() {
    }

    public void display() {
        System.out.println(2);
    }

    public void protectedTest(){
        super.test();
    }
}
