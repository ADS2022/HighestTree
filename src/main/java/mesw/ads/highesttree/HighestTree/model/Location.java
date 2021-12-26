package mesw.ads.highesttree.HighestTree.model;

import java.util.Objects;
import java.util.UUID;

public class Location {
    private String id;
    private String name;
    private String country;
    private String district;
    private String city;
    private String street;
    private String description;
    private boolean isSensitive;

    public Location(String name,
                    String country,
                    String district,
                    String city,
                    String street,
                    String description) {
        setId(UUID.randomUUID().toString());
        setName(name);
        setCountry(country);
        setDistrict(district);
        setCity(city);
        setStreet(street);
        setDescription(description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException("The name attribute cannot be empty");
        else
            this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country == null || country.length() == 0)
            throw new IllegalArgumentException("The country attribute cannot be empty");
        else
            this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() == 0)
            throw new IllegalArgumentException("The description attribute cannot be empty");
        else
            this.description = description;

    }

    public boolean isSensitive() {
        return isSensitive;
    }

    public void setSensitive(boolean sensitive) {
        isSensitive = sensitive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getId() == location.getId() &&
                isSensitive() == location.isSensitive() &&
                Objects.equals(getName(), location.getName()) &&
                Objects.equals(getCountry(), location.getCountry()) &&
                getDistrict().equals(location.getDistrict()) &&
                getCity().equals(location.getCity()) &&
                getStreet().equals(location.getStreet()) &&
                Objects.equals(getDescription(), location.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCountry(), getDistrict(),
                getCity(), getStreet(), getDescription(), isSensitive());
    }

    @Override
    public String toString() {
        return id +
                "," + name +
                "," + country +
                "," + district +
                "," + city +
                "," + street +
                "," + description +
                "," + isSensitive;
    }
}