package HighestTree.model;/*
 * Copyright (c) 2021.
 * Created by Francisco Bastos (202103393) assembled in your computers
 *
 * Facebook: https://www.facebook.com/francisco.bastos.9022
 * Instagram: https://www.instagram.com/francisco_jf_bastos/
 * LinkedIn: https://www.linkedin.com/in/francisco-bastos-031369160/
 * GitHub: https://github.com/FranciscoBastos
 *
 * “Do. Or do not. There is no try.” The Empire Strikes Back
 *
 */

import mesw.ads.highesttreemaven.HighestTree.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventTest {

    private Event testEvent1;
    private Event testEvent2;
    // TODO TEST BETTER WHEN SOURCE, SUPER DATE AND PERSONS ARE IMPLEMENTED
    private Source testSource;
    private SuperDate testSuperDate;
    private Place testPlace;
    private Person testPerson;

    private Event impossibleEvent;

    @BeforeEach
    void setUp() {
        this.testSource = new Source();
        this.testSuperDate = new Date("1999", "09", "30");
        this.testPerson = new Person();

        this.testPlace = new Place("Portugal",
                "Porto",
                "V.N.Gaia",
                "Pedroso",
                "Av. Dr. Moreira de Sousa 1041 5ºesq.",
                this.testSource,
                "My place",
                this.testSuperDate,
                true);

        Events testStandardEvent1 = Events.MARRIAGE;
        Events testStandardEvent2 = Events.DEATH;

        this.testEvent1 = new Event(
                "Marriage of person Jhon and Mary",
                "The marriage of person Jhon and Mary",
                testStandardEvent1,
                testSuperDate,
                this.testPlace,
                testPerson,
                this.testSource,
                true);

        this.testEvent2 = new Event(
                "Death of Jhon",
                "The death Jhon",
                testStandardEvent2,
                testSuperDate,
                this.testPlace,
                testPerson,
                this.testSource,
                true);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Do something after each test");
    }

    @Test
    void impossibleEventTest() {
        try {
            this.impossibleEvent = new Event("",
                    "",
                    Events.UNKNOWN,
                    null,
                    null,
                    null,
                    null,
                    true);
            Assertions.assertNull(impossibleEvent.toString());
        } catch (Exception e) {
            System.out.println("It should not create an event");
        }
    }

    @Test
    void getStandardEvents() {
        Events expected = Events.MARRIAGE;
        Events actual = this.testEvent1.getStandardEvents();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getName() {
        String expected = "Marriage of person Jhon and Mary";
        String actual = this.testEvent1.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getDescription() {
        String expected = "The marriage of person Jhon and Mary";
        String actual = this.testEvent1.getDescription();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getSuperDate() {
        SuperDate expected = this.testSuperDate;
        SuperDate actual = this.testEvent1.getSuperDate();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPlace() {
        Place expected = this.testPlace;
        Place actual = this.testEvent1.getPlace();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPersonsInvolved() {
        Person expected = this.testPerson;
        Person actual = this.testEvent1.getPersonsInvolved().get(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void insertPerson() {
        try {
            Person newTestPerson = new Person();
            this.testEvent1.insertPerson(newTestPerson);
            int expectedSize = 2;
            int actualSize = this.testEvent1.getPersonsInvolved().size();

            Assertions.assertEquals(expectedSize, actualSize);
            this.testEvent1.insertPerson(newTestPerson);
            Assertions.assertEquals(expectedSize, actualSize);
        } catch (Exception e) {
            System.out.println("It's ok to throw exception, 'cause there is already a person");
        }
    }

    @Test
    void getSource() {
        Source expected = this.testSource;
        Source actualSource = this.testEvent1.getSource();

        Assertions.assertEquals(expected, actualSource);
    }

    @Test
    void isSensitive() {
        boolean expected = true;
        boolean actual = this.testEvent1.isSensitive();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEquals() {
        Assertions.assertNotEquals(this.testEvent1, this.testEvent2);
    }

    @Test
    void testHashCode() {
        Assertions.assertNotEquals(this.testEvent1.hashCode(), testEvent2.hashCode());
    }

    @Test
    void testToString() {
        Assertions.assertNotEquals(this.testEvent1.toString(), this.testEvent2.toString());
    }
}