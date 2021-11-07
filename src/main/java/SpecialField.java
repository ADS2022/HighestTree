import java.util.Objects;

public class SpecialField extends Event {
    private String specialFieldName;

    public SpecialField(String name, String description, Events standardEvents, SuperDate superDate, Place place, Person personInvolved, Source source, boolean isSensitive, String specialFieldName) {
        super(name, description, standardEvents, superDate, place, personInvolved, source, isSensitive);
        setSpecialFieldName(specialFieldName);
    }

    public String getSpecialFieldName() {
        return specialFieldName;
    }

    public void setSpecialFieldName(String specialFieldName) {
        if (specialFieldName == null || specialFieldName.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.specialFieldName = specialFieldName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpecialField)) return false;
        if (!super.equals(o)) return false;
        SpecialField that = (SpecialField) o;
        return Objects.equals(getSpecialFieldName(), that.getSpecialFieldName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSpecialFieldName());
    }

    @Override
    public String toString() {
        return "SpecialField{" +
                "specialFieldName='" + specialFieldName + '\'' +
                '}';
    }
}
