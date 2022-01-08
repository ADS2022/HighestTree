package mesw.ads.highesttree.HighestTree.query;

import mesw.ads.highesttree.HighestTree.model.Person;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSpouses implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> partners = new ArrayList<>();
        for (Person person : persons) {
            if(person.getPartners()!=null && !person.getPartners().isEmpty()){
                partners.addAll(person.getPartners());
            }
        }
        return partners;
    }
}
