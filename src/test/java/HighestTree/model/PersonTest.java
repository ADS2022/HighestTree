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

import mesw.ads.highesttree.HighestTree.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PersonTest {
    private Person parent11;
    private Person parent21;
    private Person parent12;
    private Person parent22;
    private Person parent1;
    private Person parent2;
    private Person targetPerson;

    private Person testPerson1;
    private Person testParent1Person1;
    private Person testParent2Person1;

    private Person testPerson2;

    private SuperDate testSuperDate;

    private Source testSource;

    private Event testEvent1;

    private Place testPlace;

    @BeforeEach
    void setUp() {
        this.parent11 = new Person();
        this.parent21 = new Person();
        this.parent12 = new Person();
        this.parent22 = new Person();
        this.parent1 = new Person();
        this.parent2 = new Person();
        this.targetPerson = new Person();

        this.testParent1Person1 = new Person();
        this.testParent2Person1 = new Person();

        this.testSuperDate = new Date("1999", "09", "30");

        this.testSource = new Source();

        this.testPlace = new Place("Portugal",
                "Porto",
                "Porto",
                "Lapa",
                "Largo da Lapa, nº1 4050-069 Porto",
                this.testSource,
                "Birth place of Francisco Bastos",
                this.testSuperDate,
                true);

        Events testStandardEvent1 = Events.BIRTH;

        this.testEvent1 = new Event(
                "Birth of Francisco Bastos",
                "Birth of Francisco Bastos",
                testStandardEvent1,
                testSuperDate,
                this.testPlace,
                this.testSource,
                true);

        LinkedList<Person> parentTestPerson1 = new LinkedList<>();
        parentTestPerson1.add(this.testParent1Person1);
        parentTestPerson1.add(this.testParent2Person1);

        LinkedList<Person> partnerTestPerson1 = new LinkedList<>();
        partnerTestPerson1.add(this.testPerson2);

        this.testPerson2 = new Person();

        this.testPerson1 = new Person(
                "Francisco José",
                "Fortuna Bastos",
                "PRT",
                this.testEvent1,
                this.testSource,
                "A software developer",
                parentTestPerson1,
                partnerTestPerson1,
                true);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Do something after each test");
    }

    @Test
    void getAllAncestors() {
        LinkedList<Person> parentsOfParent1 = new LinkedList<>();
        parentsOfParent1.add(this.parent11);
        parentsOfParent1.add(this.parent12);
        parent1.setParents(parentsOfParent1);

        LinkedList<Person> parentsOfParent2 = new LinkedList<>();
        parentsOfParent2.add(this.parent21);
        parentsOfParent2.add(this.parent22);
        parent2.setParents(parentsOfParent2);

        LinkedList<Person> parentsOfTargetPerson = new LinkedList<>();
        parentsOfTargetPerson.add(this.parent1);
        parentsOfTargetPerson.add(this.parent2);
        targetPerson.setParents(parentsOfTargetPerson);

        LinkedList<Person> ancestors = new LinkedList<>();
        ancestors = Person.getAncestors(targetPerson, ancestors);

        LinkedList<Person> trueAncestorList = new LinkedList<>();
        trueAncestorList.add(this.parent1);
        trueAncestorList.add(this.parent11);
        trueAncestorList.add(this.parent12);
        trueAncestorList.add(this.parent2);
        trueAncestorList.add(this.parent21);
        trueAncestorList.add(this.parent22);

        assertEquals(trueAncestorList, ancestors);
    }

    @Test
    void getPartners() {
        int actual = this.testPerson1.getPartners().size();
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getId() {
        int expected = this.testPerson1.getId();
        int actual = this.testPerson1.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getFirstName() {
        String expected = "Francisco José";
        String actual = this.testPerson1.getFirstName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getLastName() {
        String expected = "Fortuna Bastos";
        String actual = this.testPerson1.getLastName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getNationality() {
        String expected = "PRT";
        String actual = this.testPerson1.getNationality();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getParents() {
        int expected = 2;
        int actual = this.testPerson1.getParents().size();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getEvents() {
        LinkedList<Person> testRelationShip1 = new LinkedList<>();
        testRelationShip1.add(this.testPerson1);
        testRelationShip1.add(this.testPerson2);

        this.testPerson1.associateEvents(
                new Event(
                        "Marriage of Francisco Bastos and unknown",
                        "Marriage of Francisco Bastos and unknown",
                        Events.MARRIAGE,
                        new Date("YYYY",
                                "MM",
                                "DD"),
                        new Place("Country",
                                "District",
                                "City",
                                "Parish",
                                "Street",
                                this.testSource,
                                "A nice place",
                                new Date("YYYY", "MM", "DD"),
                                false),
                        this.testSource,
                        true
                )
        );
        this.testPerson1.setPartner(testRelationShip1);
        System.out.println("Number of relationships => " + this.testPerson1.getPartners().size());

        int expected = 2;
        int actual = this.testPerson1.getEvents().size();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getDescription() {
        String expected = "A software developer";
        String actual = this.testPerson1.getDescription();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void isSensitive() {
        boolean actual = this.testPerson1.isSensitive();

        Assertions.assertTrue(actual);
    }

    @Test
    void testEquals() {
        assertFalse(this.testPerson1.equals(this.testPerson2));
    }

    @Test
    void testToString() {
        String expected = "Person{id=-1768320971, " +
                "firstName='Francisco José', " +
                "lastName='Fortuna Bastos', nationality='PRT', " +
                "events=[Event{name='Birth of Francisco Bastos', " +
                "standardEvents=BIRTH," +
                " description='Birth of Francisco Bastos'," +
                " superDate=Date{year='1999'," +
                " month='09', day='30'}," +
                " place=Place{country='Portugal'," +
                " city='Porto'," +
                " district='Porto'," +
                " parish='Lapa'," +
                " street='Largo da Lapa, nº1 4050-069 Porto'," +
                " description='Birth place of Francisco Bastos'," +
                " superDate=Date{year='1999'," +
                " month='09', day='30'}," +
                " isSensitive=true}," +
                " personsInvolved=[]," +
                " source=Source{id=0," +
                " researchersName='null'," +
                " superDate=null," +
                " description='null'," +
                " sourceOfInformation='null'," +
                " sensitivity=false}, isSensitive=true}]," +
                " source=Source{id=0, researchersName='null'," +
                " superDate=null, description='null'," +
                " sourceOfInformation='null'," +
                " sensitivity=false}," +
                " description='A software developer'," +
                " parents=[Person{id=0, firstName='null'," +
                " lastName='null'," +
                " nationality='null'," +
                " events=null," +
                " source=null," +
                " description='null'," +
                " parents=null," +
                " partner=null," +
                " sensitive=false}," +
                " Person{id=0," +
                " firstName='null'," +
                " lastName='null'," +
                " nationality='null', events=null," +
                " source=null," +
                " description='null'," +
                " parents=null," +
                " partner=null," +
                " sensitive=false}]," +
                " partner=[null], sensitive=true}";
        String actual = this.testPerson1.toString();

        Assertions.assertEquals(expected, actual);
    }
}