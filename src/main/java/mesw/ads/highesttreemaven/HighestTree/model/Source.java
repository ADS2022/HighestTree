package mesw.ads.highesttreemaven.HighestTree.model;/*
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

public class Source {
    private int id;
    private String researchersName;
    private SuperDate superDate;
    private String description;
    private String sourceOfInformation;
    private boolean sensitivity;

    public Source() {
        // Empty constructor
    }

    public Source(String researchersName,
                  SuperDate superDate,
                  String description,
                  String sourceOfInformation,
                  boolean sensitivity) {
        setId();
        setResearchersName(researchersName);
        setSuperDate(superDate);
        setDescription(description);
        setSourceOfInformation(sourceOfInformation);
        setSensitivity(sensitivity);
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = this.hashCode();
    }

    public String getResearchersName() {
        return researchersName;
    }

    public void setResearchersName(String researchersName) {
        if (researchersName == null || researchersName.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.researchersName = researchersName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.description = description;
    }

    public String getSourceOfInformation() {
        return sourceOfInformation;
    }

    public void setSourceOfInformation(String sourceOfInformation) {
        if (sourceOfInformation == null || sourceOfInformation.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.sourceOfInformation = sourceOfInformation;
    }

    public boolean isSensitive() {
        return sensitivity;
    }

    public void setSensitivity(boolean sensitivity) {
        this.sensitivity = sensitivity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Source)) return false;
        Source source = (Source) o;
        return getId() == source.getId() &&
                isSensitive() == source.isSensitive() &&
                Objects.equals(getResearchersName(), source.getResearchersName()) &&
                Objects.equals(getSuperDate(), source.getSuperDate()) &&
                Objects.equals(getDescription(), source.getDescription()) &&
                Objects.equals(getSourceOfInformation(), source.getSourceOfInformation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getResearchersName(),
                getSuperDate(),
                getDescription(),
                getSourceOfInformation(),
                isSensitive());
    }

    @Override
    public String toString() {
        return "Source{" +
                "id=" + id +
                ", researchersName='" + researchersName + '\'' +
                ", superDate=" + superDate +
                ", description='" + description + '\'' +
                ", sourceOfInformation='" + sourceOfInformation + '\'' +
                ", sensitivity=" + sensitivity +
                '}';
    }
}
