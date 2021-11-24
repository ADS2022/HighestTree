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

public class Place {
    private String country;
    private String city;
    private String district;
    private String parish;
    private String street;
    private Source source;
    private String description;
    private SuperDate superDate;
    private boolean isSensitive;

    public Place(String country,
                 String district,
                 String city,
                 String parish,
                 String street,
                 Source source,
                 String description,
                 SuperDate superDate,
                 boolean isSensitive) {
        setCountry(country);
        setCity(city);
        setDistrict(district);
        setParish(parish);
        setStreet(street);
        setSource(source);
        setDescription(description);
        setSuperDate(superDate);
        setSensitive(isSensitive);
    }

    public Place(String country,
                 String district,
                 String city,
                 String parish,
                 String street,
                 Source source,
                 String description,
                 boolean isSensitive) {
        setCountry(country);
        setCity(city);
        setDistrict(district);
        setParish(parish);
        setStreet(street);
        setSource(source);
        setDescription(description);
        setSensitive(isSensitive);
    }

    public Place(String country,
                 String district,
                 String city,
                 String parish,
                 Source source,
                 String description,
                 boolean isSensitive) {
        setCountry(country);
        setCity(city);
        setDistrict(district);
        setParish(parish);
        setSource(source);
        setDescription(description);
        setSensitive(isSensitive);
    }

    public Place(String country,
                 String city,
                 Source source,
                 String description,
                 boolean isSensitive) {
        setCountry(country);
        setCity(city);
        setSource(source);
        setDescription(description);
        setSensitive(isSensitive);
    }

    public Place() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country == null || country.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city == null || city.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        if (district == null || district.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.district = district;
    }

    public String getParish() {
        return parish;
    }

    public void setParish(String parish) {
        if (parish == null || parish.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.parish = parish;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if (street == null || street.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.street = street;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        if (source == null)
            throw new IllegalArgumentException();
        else
            this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.description = description;
    }

    public SuperDate getSuperDate() {
        return superDate;
    }

    public void setSuperDate(SuperDate superDate) {
        if (superDate == null)
            throw new IllegalArgumentException();
        else
            this.superDate = superDate;
    }

    public boolean isSensitive() {
        return isSensitive;
    }

    public void setSensitive(boolean sensitive) {
        isSensitive = sensitive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place)) return false;
        Place place = (Place) o;
        return isSensitive() == place.isSensitive() &&
                Objects.equals(getCountry(), place.getCountry()) &&
                Objects.equals(getCity(), place.getCity()) &&
                Objects.equals(getDistrict(), place.getDistrict()) &&
                Objects.equals(getParish(), place.getParish()) &&
                Objects.equals(getStreet(), place.getStreet()) &&
                Objects.equals(getSource(), place.getSource()) &&
                Objects.equals(getDescription(), place.getDescription()) &&
                Objects.equals(getSuperDate(), place.getSuperDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountry(),
                getCity(),
                getDistrict(),
                getParish(),
                getStreet(),
                getSource(),
                getDescription(),
                getSuperDate(),
                isSensitive());
    }

    @Override
    public String toString() {
        return "Place{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", parish='" + parish + '\'' +
                ", street='" + street + '\'' +
                // ", source=" + source +
                ", description='" + description + '\'' +
                ", superDate=" + superDate +
                ", isSensitive=" + isSensitive +
                '}';
    }
}
