package com.company;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Approach_7 {

    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();

        processPersons(roster, p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                person -> person.printPerson());

    }

    //Approach 7: Use Lambda Expressions Throughout Your Application
    public static void processPersons(List<Person> roster,
                                      Predicate<Person> tester,
                                      Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }

    }
}



