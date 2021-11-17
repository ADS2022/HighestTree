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

import mesw.ads.highesttreemaven.HighestTree.model.Date;
import mesw.ads.highesttreemaven.HighestTree.model.Place;
import mesw.ads.highesttreemaven.HighestTree.model.Source;
import mesw.ads.highesttreemaven.HighestTree.model.SuperDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaceTest {
    private Place testPlace1;
    private Place testPlace2;
    private Place testPlace3;
    private Place testPlace4;
    private Source testSource;
    private SuperDate testSuperDate;

    private Place impossiblePlace;

    @BeforeEach
    void setUp() {
        this.testSource = new Source();
        this.testSuperDate = new Date("1999", "09", "30");

        this.testPlace1 = new Place("Portugal",
                "Porto",
                "V.N.Gaia",
                "Pedroso",
                "Av. Dr. Moreira de Sousa 1041 5ºesq.",
                testSource,
                "My place",
                testSuperDate,
                true);

        this.testPlace2 = new Place("Germany",
                "München",
                "München",
                "Am Olympiapark",
                "Am Olympiapark 2, 80809 München, Germany",
                testSource,
                "Other place",
                true);

        this.testPlace3 = new Place("United Kingdom",
                "London",
                "London",
                "London",
                testSource,
                "A place",
                true);

        this.testPlace4 = new Place("France",
                "Paris",
                testSource,
                "The last place",
                true);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Do something after each test");
    }

    @Test
    void impossiblePlaceTest() {
        try {
            this.impossiblePlace = new Place("",
                    "",
                    "",
                    "",
                    "",
                    testSource,
                    "",
                    testSuperDate,
                    true);
            Assertions.assertNull(impossiblePlace.toString());
        } catch (Exception e) {
            System.out.println("It should not create a place");
        }
    }

    @Test
    void getCountry() {
        String expected1 = "Portugal";
        String expected2 = "Germany";
        String expected3 = "United Kingdom";
        String expected4 = "France";

        String actual1 = testPlace1.getCountry();
        String actual2 = testPlace2.getCountry();
        String actual3 = testPlace3.getCountry();
        String actual4 = testPlace4.getCountry();

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        Assertions.assertEquals(expected3, actual3);
        Assertions.assertEquals(expected4, actual4);
    }

    @Test
    void getCity() {
        String expected1 = "V.N.Gaia";
        String expected2 = "München";

        String actual1 = testPlace1.getCity();
        String actual2 = testPlace2.getCity();

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    void getDistrict() {
        String expected1 = "Porto";
        String expected2 = "München";
        String expected3 = "London";

        String actual1 = testPlace1.getDistrict();
        String actual2 = testPlace2.getDistrict();
        String actual3 = testPlace3.getDistrict();

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        Assertions.assertEquals(expected3, actual3);
    }

    @Test
    void getParish() {
        String expected1 = "Pedroso";
        String expected2 = "Am Olympiapark";
        String expected3 = "London";

        String actual1 = testPlace1.getParish();
        String actual2 = testPlace2.getParish();
        String actual3 = testPlace3.getParish();

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        Assertions.assertEquals(expected3, actual3);
    }

    @Test
    void getStreet() {
        String expected1 = "Av. Dr. Moreira de Sousa 1041 5ºesq.";
        String expected2 = "Am Olympiapark 2, 80809 München, Germany";

        String actual1 = testPlace1.getStreet();
        String actual2 = testPlace2.getStreet();

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    void getSource() {
        Source expected1 = this.testSource;

        Source actual1 = testPlace1.getSource();

        Assertions.assertEquals(expected1, actual1);
    }

    @Test
    void getDescription() {
        String expected1 = "My place";
        String expected2 = "Other place";
        String expected3 = "A place";
        String expected4 = "The last place";

        String actual1 = testPlace1.getDescription();
        String actual2 = testPlace2.getDescription();
        String actual3 = testPlace3.getDescription();
        String actual4 = testPlace4.getDescription();

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        Assertions.assertEquals(expected3, actual3);
        Assertions.assertEquals(expected4, actual4);
    }

    @Test
    void getSuperDate() {
        SuperDate expected1 = this.testSuperDate;

        SuperDate actual1 = testPlace1.getSuperDate();

        Assertions.assertEquals(expected1, actual1);
    }

    @Test
    void isSensitive() {
        boolean expected1 = true;
        boolean expected2 = true;
        boolean expected3 = true;
        boolean expected4 = true;

        boolean actual1 = testPlace1.isSensitive();
        boolean actual2 = testPlace1.isSensitive();
        boolean actual3 = testPlace1.isSensitive();
        boolean actual4 = testPlace1.isSensitive();

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        Assertions.assertEquals(expected3, actual3);
        Assertions.assertEquals(expected4, actual4);
    }

    @Test
    void testEquals() {
        Place testPlace = new Place("United Kingdom",
                "London",
                "London",
                "London",
                "London SW1A 1AA, United Kingdom",
                testSource,
                "Buckingham Palace",
                testSuperDate,
                true);
        Assertions.assertNotEquals(this.testPlace1, testPlace);
    }

    @Test
    void testHashCode() {
        Place testPlace = new Place("United Kingdom",
                "London",
                "London",
                "London",
                "London SW1A 1AA, United Kingdom",
                testSource,
                "Buckingham Palace",
                testSuperDate,
                true);
        Assertions.assertNotEquals(this.testPlace1.hashCode(), testPlace.hashCode());
    }

    @Test
    void testToString() {
        String actualToString = this.testPlace1.toString();
        String expectedToString = "Place{country='Portugal'," +
                " city='V.N.Gaia', district='Porto', parish='Pedroso'," +
                " street='Av. Dr. Moreira de Sousa 1041 5ºesq.'," +
                " description='My place'," +
                " superDate=Date{year='1999', month='09', day='30'}, isSensitive=true}";
        Assertions.assertEquals(actualToString, expectedToString);
    }
}