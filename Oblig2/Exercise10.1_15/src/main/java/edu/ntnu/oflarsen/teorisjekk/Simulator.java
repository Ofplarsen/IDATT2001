package edu.ntnu.oflarsen.teorisjekk;

import edu.ntnu.oflarsen.teorisjekk.actors.Animal;
import edu.ntnu.oflarsen.teorisjekk.actors.animals.Fox;
import edu.ntnu.oflarsen.teorisjekk.actors.animals.Rabbit;

public class Simulator {
    public static void main(String[] args) {
        //1
        Rabbit r = new Rabbit();
        System.out.println(r);

        //2
        Animal a = new Rabbit();
        System.out.println(a);

        //3 feil
        //Rabbit r1 = new Animal();

        //4
        Actor actor = new Fox();
        System.out.println(actor);

        //7
        r.display();

        //8
        r.protectedTest();

        Animal animal = new Animal();
        System.out.println(animal instanceof Rabbit);

    }
}
