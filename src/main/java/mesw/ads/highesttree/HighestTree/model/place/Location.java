package mesw.ads.highesttree.HighestTree.model.place;

import java.util.Objects;

public class Location {
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
        try {
            this.name = name;
        } catch (NullPointerException ex) {
            System.out.println("The name cannot be null");
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
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
        try {
            this.description = description;
        } catch (NullPointerException ex) {
            System.out.println("The description cannot be null");
        }
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
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return isSensitive() == location.isSensitive() &&
                getName().equals(location.getName()) &&
                Objects.equals(getCountry(), location.getCountry()) &&
                Objects.equals(getDistrict(), location.getDistrict()) &&
                Objects.equals(getCity(), location.getCity()) &&
                Objects.equals(getStreet(), location.getStreet()) &&
                getDescription().equals(location.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCountry(), getDistrict(),
                getCity(), getStreet(), getDescription(), isSensitive());
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", description='" + description + '\'' +
                ", isSensitive=" + isSensitive +
                '}';
    }
}
