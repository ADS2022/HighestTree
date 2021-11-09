/*
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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpecialFieldTest {
    private SpecialField testSpecialField;
    // TODO TEST BETTER WHEN SOURCE, SUPER DATE AND PERSONS ARE IMPLEMENTED
    private Source testSource;
    private SuperDate testSuperDate;
    private Place testPlace;
    private Person testPerson;

    private SpecialField impossibleSpecialField;

    @BeforeEach
    void setUp() {
        this.testSource = new Source();
        this.testSuperDate = new SuperDate();
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

        this.testSpecialField = new SpecialField(
                "Marriage of person Jhon and Mary",
                "The marriage of person Jhon and Mary",
                testStandardEvent1,
                testSuperDate,
                this.testPlace,
                testPerson,
                this.testSource,
                true,
                "With no priest but with a capitan of a boat");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Do something after each test");
    }

    @Test
    void impossibleEventTest() {
        try {
            this.impossibleSpecialField = new SpecialField("",
                    "",
                    Events.UNKNOWN,
                    null,
                    null,
                    null,
                    null,
                    true,
                    "");
            Assertions.assertNull(impossibleSpecialField.toString());
        } catch (Exception e) {
            System.out.println("It should not create an special field");
        }
    }

    @Test
    void getSpecialFieldName() {
        String expected = "With no priest but with a capitan of a boat";
        String actual = this.testSpecialField.getSpecialFieldName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEquals() {
        Assertions.assertNotEquals(this.testSpecialField, new SpecialField(
                "Marriage of person Jhon and Mary",
                "The marriage of person Jhon and Mary",
                Events.MARRIAGE,
                testSuperDate,
                this.testPlace,
                testPerson,
                this.testSource,
                true,
                "With no priest but with a capitan of an airplane"
        ));
    }

    @Test
    void testHashCode() {
        Assertions.assertNotEquals(this.testSpecialField.hashCode(), new SpecialField(
                "Marriage of person Jhon and Mary",
                "The marriage of person Jhon and Mary",
                Events.MARRIAGE,
                testSuperDate,
                this.testPlace,
                testPerson,
                this.testSource,
                true,
                "With no priest but with a capitan of an airplane"
        ).hashCode());
    }

    @Test
    void testToString() {
        String actual = "SpecialField{specialFieldName='With no priest but with a capitan of a boat'}";
        String expected = this.testSpecialField.toString();

        Assertions.assertEquals(expected, actual);
    }
}