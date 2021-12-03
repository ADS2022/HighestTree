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
import mesw.ads.highesttree.HighestTree.model.TimePeriod;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimePeriodTest {
    private TimePeriod testTimePeriod1;
    private TimePeriod testTimePeriod2;

    private Date testDate1;
    private Date testDate2;
    private Date testDate3;
    private Date testDate4;

    @BeforeEach
    void setUp() {
        this.testDate3 = new Date("1969", "07", "16");
        this.testDate2 = new Date("1972", "12", "7");
        this.testTimePeriod1 = new TimePeriod(this.testDate3, this.testDate2);

        this.testDate1 = new Date("1977", "12", "06");
        this.testDate4 = new Date("2019", "12", "19");
        this.testTimePeriod2 = new TimePeriod(this.testDate1, this.testDate4);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Do something after each test");
    }

    @Test
    void getStartDate() {
        Date expectedStartDateTimePeriod1 = this.testDate3;
        Date actualStarDateTimePeriod1 = this.testTimePeriod1.getStartDate();
        Assertions.assertEquals(expectedStartDateTimePeriod1, actualStarDateTimePeriod1);

        Date expectedStartDateTimePeriod2 = this.testDate1;
        Date actualStarDateTimePeriod2 = this.testTimePeriod2.getStartDate();
        Assertions.assertEquals(expectedStartDateTimePeriod2, actualStarDateTimePeriod2);
    }

    @Test
    void getEndDate() {
        Date expectedEndDateTimePeriod1 = this.testDate2;
        Date actualEndDateTimePeriod1 = this.testTimePeriod1.getEndDate();
        Assertions.assertEquals(expectedEndDateTimePeriod1, actualEndDateTimePeriod1);

        Date expectedStartDateTimePeriod2 = this.testDate4;
        Date actualEndDateTimePeriod2 = this.testTimePeriod2.getEndDate();
        Assertions.assertEquals(expectedStartDateTimePeriod2, actualEndDateTimePeriod2);
    }

    @Test
    void testEquals() {
        Assertions.assertNotEquals(this.testTimePeriod1, this.testTimePeriod2);
    }

    @Test
    void testHashCode() {
        Assertions.assertNotEquals(this.testTimePeriod1.hashCode(), this.testTimePeriod2.hashCode());
    }

    @Test
    void testToString() {
        String expectedTimePeriod1 = "TimePeriod{startDate=Date{year='1969'," +
                " month='07', day='16'}, endDate=Date{year='1972', month='12', day='7'}}";
        String actualTimePeriod1 = this.testTimePeriod1.toString();
        Assertions.assertEquals(expectedTimePeriod1, actualTimePeriod1);
    }

    @Test
    void returnDateString() {
        String expectedTimePeriod1 = "TimePeriod{startDate=Date{year='1969'," +
                " month='07', day='16'}, endDate=Date{year='1972', month='12', day='7'}}";
        String actualTimePeriod1 = this.testTimePeriod1.returnDateString();
        Assertions.assertEquals(expectedTimePeriod1, actualTimePeriod1);
    }

    @Test
    void impossibleTimePeriod() {
        try {
            TimePeriod testImpossibleTimePeriod = new TimePeriod(this.testDate1, null);
            Assertions.assertNull(testImpossibleTimePeriod.getEndDate());
        } catch (Exception e) {
            System.out.println("It should not create a time period");
        }
    }
}