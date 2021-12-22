package mesw.ads.highesttree.HighestTree.query;
import mesw.ads.highesttree.HighestTree.model.Person;

import java.util.List;

public interface Criteria {
    List<Person> meetCriteria(List<Person> persons);
}

