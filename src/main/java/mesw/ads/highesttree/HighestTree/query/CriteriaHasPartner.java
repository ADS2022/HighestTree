package mesw.ads.highesttree.HighestTree.query;

import mesw.ads.highesttree.HighestTree.model.Person;

import java.util.ArrayList;
import java.util.List;

public class CriteriaHasPartner implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> personsWithPartner = new ArrayList<>();

        for (Person person : persons) {
            if(person.getPartners() != null && !person.getPartners().isEmpty()){
                personsWithPartner.add(person);
            }
        }
        return personsWithPartner;
    }
}
