package com.company;

import java.util.List;
import java.util.function.Predicate;

public class Main {


    public static void main(String[] args) {

        List<Person> roster = Person.createRoster();

        System.out.println("\nprintPersonOlderThan: ");
        printPersonOlderThan(roster, 18);

        System.out.println("\nprintPersonsWithinAgeRange: ");
        printPersonsWithinAgeRange(roster, 20, 40);

        System.out.println("\nprintPersons: ");
        printPersons(roster, new CheckPersonEligibleForSelectiveService());

        //Approach 4: Specify Search Criteria Code in an Anonymous Class
        System.out.println("\nprintPersons with anonymous class: ");
        printPersons(roster, new CheckTester() {
            @Override
            public boolean tester(Person p) {
                return p.getGender() == Person.Sex.MALE &&
                        p.getAge() >= 18 && p.getAge() <= 25;
            }
        });

        //Approach 5: Specify Search Criteria Code with a Lambda Expression
        System.out.println("\nprint persons with Specify Search Criteria Code with a Lambda Expression");
        printPersons(roster, (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25);

        //Approach 6: Use Standard Functional Interfaces with Lambda Expressions
        System.out.println("\nprint persons  Use Standard Functional Interfaces with Lambda Expressions");
        printPersonsWithPredicate(roster, p -> p.getGender() == Person.Sex.MALE &&
                p.getAge() >= 18 &&
                p.getAge() <= 25);
    }

    //Approach 1: Create Methods That Search for Members That Match One Characteristic
    public static void printPersonOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    //Approach 2: Create More Generalized Search Methods
    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (p.getAge() >= low && p.getAge() <= high) {
                p.printPerson();
            }
        }

    }

    //Approach 3: Specify Search Criteria Code in a Local Class
    public static void printPersons(List<Person> roster, CheckTester test) {
        for (Person p : roster) {
            if (test.tester(p)) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
}

    interface CheckTester {
        boolean tester(Person p);
    }

    class CheckPersonEligibleForSelectiveService implements CheckTester {

        @Override
        public boolean tester(Person p) {
            return p.gender == Person.Sex.MALE &&
                    p.getAge() >= 18 && p.getAge() <= 25;
        }

    }


