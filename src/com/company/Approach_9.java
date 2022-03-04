package com.company;

import java.util.List;

public class Approach_9 {
    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();
        roster.stream()
                .filter(p->p.getGender() == Person.Sex.MALE
                        && p.getAge()>=18
                        && p.getAge()<= 35)
                .map(p->p.getEmail())
                .forEach(email-> System.out.println(email));
    }
}
/*
Obtain a source of objects 	Stream<E> stream()
Filter objects that match a Predicate object 	Stream<T> filter(Predicate<? super T> predicate)
Map objects to another value as specified by a Function object 	<R> Stream<R> map(Function<? super T,? extends R> mapper)
Perform an action as specified by a Consumer object 	void forEach(Consumer<? super T> action)
 */