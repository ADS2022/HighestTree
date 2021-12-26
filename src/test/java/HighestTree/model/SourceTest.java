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
import mesw.ads.highesttree.HighestTree.model.Source;
import mesw.ads.highesttree.HighestTree.model.SuperDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SourceTest {
    private SuperDate testSuperDate;

    private Source testSource1;

    private Source testSource2;

    @BeforeEach
    void setUp() {
        this.testSuperDate = new Date("1999", "09", "30");

        this.testSource1 = new Source(
                "Charles Darwin",
                this.testSuperDate,
                "The evolution of the species",
                "Wikepedia",
                false

        );

        this.testSource2 = new Source();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Do something");
    }

    @Test
    void getId() {
        int actual = this.testSource1.getId();
        int expected = this.testSource1.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getResearchersName() {
        String actual = "Charles Darwin";
        String expected = this.testSource1.getResearchersName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getSuperDate() {
        SuperDate expected = this.testSuperDate;
        SuperDate actual = this.testSource1.getSuperDate();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getDescription() {
        String expected = "The evolution of the species";
        String actual = this.testSource1.getDescription();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getSourceOfInformation() {
        String expected = "Wikepedia";
        String actual = this.testSource1.getSourceOfInformation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void isSensitivity() {
        Assertions.assertFalse(this.testSource1.isSensitive());
    }

    @Test
    void testEquals() {
        Assertions.assertNotEquals(this.testSource1, this.testSource2);
    }

    @Test
    void testToString() {
        String expected = this.testSource1.getId() +
                ",Charles Darwin," +
                "1999,09,30," +
                "The evolution of the species," +
                "Wikepedia," +
                "false";
        String actual = this.testSource1.toString();

        Assertions.assertEquals(expected, actual);
    }
}