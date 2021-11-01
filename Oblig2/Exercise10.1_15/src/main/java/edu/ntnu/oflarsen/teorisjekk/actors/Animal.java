package edu.ntnu.oflarsen.teorisjekk.actors;

import edu.ntnu.oflarsen.teorisjekk.Actor;

public class Animal extends Actor {
    public Animal() {
    }

    public void display(){
        System.out.println(1);
    }

    protected void test(){
        System.out.println("protected");
    }


}
