package HighestTree.model;

import mesw.ads.highesttree.HighestTree.model.place.Location;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LocationTest {
    private Location testLocation1;
    private Location testLocation2;
    private Location impossibleLocation;

    @BeforeEach
    void setUp() {
        this.testLocation1 = new Location(
                "My place",
                "Portugal",
                "Porto",
                "V.N.Gaia",
                "Av. Dr. Moreira de Sousa 1041 5ºesq.",
                "My place");

        this.testLocation2 = new Location(
                "BMW park",
                "Germany",
                "Bayern",
                "München",
                "Am Olympiapark 2, 80809 München, Germany",
                "BMW museum");

        this.testLocation1.setSensitive(true);
        this.testLocation2.setSensitive(false);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Do something after each test");
    }

    @Test
    void impossibleLocationTest() {
        try {
            this.impossibleLocation = new Location("", "", "", "", "", "");
            this.impossibleLocation.setSensitive(true);
            Assertions.assertNull(this.impossibleLocation.toString());
        } catch (Exception e) {
            System.out.println("This test should throw an exception");
        }
    }

    @Test
    void getCountry() {
        String expected1 = "Portugal";
        String expected2 = "Germany";

        String actual1 = testLocation1.getCountry();
        String actual2 = testLocation2.getCountry();

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    void getCity() {
        String expected1 = "V.N.Gaia";
        String expected2 = "München";

        String actual1 = testLocation1.getCity();
        String actual2 = testLocation2.getCity();

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    void getDistrict() {
        String expected1 = "Porto";
        String expected2 = "Bayern";

        String actual1 = testLocation1.getDistrict();
        String actual2 = testLocation2.getDistrict();

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    void getStreet() {
        String expected1 = "Av. Dr. Moreira de Sousa 1041 5ºesq.";
        String expected2 = "Am Olympiapark 2, 80809 München, Germany";

        String actual1 = testLocation1.getStreet();
        String actual2 = testLocation2.getStreet();

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    void getDescription() {
        String expected1 = "My place";
        String expected2 = "BMW museum";

        String actual1 = testLocation1.getDescription();
        String actual2 = testLocation2.getDescription();

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    void isSensitive() {
        boolean expected1 = true;
        boolean expected2 = false;

        boolean actual1 = testLocation1.isSensitive();
        boolean actual2 = testLocation2.isSensitive();

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    void testEquals() {
        Location testLocation = new Location("United Kingdom",
                "London",
                "London",
                "London",
                "London SW1A 1AA, United Kingdom",
                "Buckingham Palace");
        testLocation.setSensitive(true);
        Assertions.assertNotEquals(this.testLocation1, testLocation);
    }

    @Test
    void testHashCode() {
        Location testLocation = new Location("United Kingdom",
                "London",
                "London",
                "London",
                "London SW1A 1AA, United Kingdom",
                "Buckingham Palace");
        testLocation.setSensitive(true);
        Assertions.assertNotEquals(this.testLocation1.hashCode(), testLocation.hashCode());
    }

    @Test
    void testToString() {
        String actualToString = this.testLocation1.toString();
        String expectedToString = "The location name => 'My place', " +
                "the country => 'Portugal', the district='Porto', the city='V.N.Gaia' " +
                "and the street='Av. Dr. Moreira de Sousa 1041 5ºesq.'. " +
                "Location description {'My place'} is the information sensitive ? true.";
        Assertions.assertEquals(actualToString, expectedToString);
    }
}