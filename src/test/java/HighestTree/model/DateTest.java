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

import mesw.ads.highesttree.HighestTree.model.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateTest {

    private Date testDate1;
    private Date impossibleDate;
    private Date testDate3;

    @BeforeEach
    void setUp() {
        this.testDate1 = new Date("1999", "09", "30");
        this.testDate3 = new Date("1969", "07", "16");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Do something after each test");
    }

    @Test
    public void impossibleDateTest() {
        try {
            this.impossibleDate = new Date("", "12", "19");
            Assertions.assertNull(this.impossibleDate.toString());
        } catch (Exception e) {
            System.out.println("It should not create a date with missing fields");
        }
    }

    @Test
    void getYear() {
        String expectedYear1 = "1999";

        String actualYear1 = testDate1.getYear();

        Assertions.assertEquals(expectedYear1, actualYear1);
    }

    @Test
    void getMonth() {
        String expectedMonth1 = "09";
        String expectedMonth3 = "07";

        String actualMonth1 = testDate1.getMonth();
        String actualMonth3 = testDate3.getMonth();

        Assertions.assertEquals(expectedMonth1, actualMonth1);
        Assertions.assertEquals(expectedMonth3, actualMonth3);
    }

    @Test
    void getDay() {
        String expectedDay1 = "30";
        String expectedDay3 = "16";

        String actualDay1 = testDate1.getDay();
        String actualDay3 = testDate3.getDay();

        Assertions.assertEquals(expectedDay1, actualDay1);
        Assertions.assertEquals(expectedDay3, actualDay3);
    }

    @Test
    void testEquals() {
        Assertions.assertFalse(this.testDate1.equals(this.testDate3));
    }

    @Test
    void testHashCode() {
        Assertions.assertNotEquals(this.testDate1.hashCode(), this.testDate3.hashCode());
    }

    @Test
    void testToString() {
        String actualDateString = this.testDate1.toString();
        String expectedDateString = "Date{year='1999', month='09', day='30'}";

        Assertions.assertEquals(expectedDateString, actualDateString);
    }

    @Test
    void impossibleDate() {
        try {
            Date impossibleDate = new Date("", "", "");
            Assertions.assertNull(impossibleDate.toString());
        } catch (Exception e) {
            System.out.println("It should not create a date");
        }
    }

    @Test
    void returnDateString() {
        String actualDateString = this.testDate1.returnDateString();
        String expectedDateString = "Date{year='1999', month='09', day='30'}";

        Assertions.assertEquals(expectedDateString, actualDateString);
    }
}