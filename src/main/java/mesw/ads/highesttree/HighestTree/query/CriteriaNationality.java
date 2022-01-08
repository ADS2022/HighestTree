package mesw.ads.highesttree.HighestTree.query;

import mesw.ads.highesttree.HighestTree.model.Person;

import java.util.ArrayList;
import java.util.List;

public class CriteriaNationality implements Criteria{
    private String queryKey;

    public  CriteriaNationality(String nationality){
        queryKey = nationality.toLowerCase();
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> personsWithNationality = new ArrayList<>();

        for (Person person : persons) {
            String nationality = person.getNationality().toLowerCase();
            if(nationality.equals(queryKey)){
                personsWithNationality.add(person);
            }
        }
        return personsWithNationality;
    }
}
