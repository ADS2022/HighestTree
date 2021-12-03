package mesw.ads.highesttree.HighestTree.model;
import java.util.Objects;

public class TimePeriod implements SuperDate {
    private Date startDate;
    private Date endDate;

    public TimePeriod() {
        // Empty constructor
    }

    public TimePeriod(Date startDate,
                      Date endDate) {
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        if (startDate == null)
            throw new NullPointerException();
        else
            this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        if (endDate == null)
            throw new NullPointerException();
        else
            this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimePeriod)) return false;
        TimePeriod that = (TimePeriod) o;
        return Objects.equals(getStartDate(), that.getStartDate()) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartDate(), endDate);
    }

    @Override
    public String toString() {
        return "TimePeriod{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    @Override
    public String returnDateString() {
        return toString();
    }
}
