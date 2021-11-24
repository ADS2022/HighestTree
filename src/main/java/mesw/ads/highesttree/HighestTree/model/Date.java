package mesw.ads.highesttree.HighestTree.model;/*
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

import java.util.Objects;

public class Date implements SuperDate {
    private String year;
    private String month;
    private String day;

    public Date() {
        // Empty constructor
    }

    public Date(String year,
                String month,
                String day) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        if (year == null || year.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        if (month == null || month.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        if (day == null || day.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date)) return false;
        Date date = (Date) o;
        return Objects.equals(getYear(), date.getYear()) &&
                Objects.equals(getMonth(), date.getMonth()) &&
                Objects.equals(getDay(), date.getDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getMonth(), getDay());
    }

    @Override
    public String toString() {
        return "Date{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                '}';
    }

    @Override
    public String returnDateString() {
        return toString();
    }
}
