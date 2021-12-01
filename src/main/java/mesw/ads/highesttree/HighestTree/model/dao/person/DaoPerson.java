package mesw.ads.highesttree.HighestTree.model.dao.person;

import mesw.ads.highesttree.HighestTree.model.Person;
import mesw.ads.highesttree.HighestTree.model.dao.Dao;

import java.util.*;
import java.util.stream.Collectors;

public class DaoPerson implements Dao<Person> {

    private List<Person> personList = new LinkedList<>();

    @Override
    public Optional<Person> get(int id) {
        return Optional.ofNullable(personList.get(id));
    }

    @Override
    public Collection<Person> getAll() {
        return personList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public int save(Person person) {
        personList.add(person);
        int index = personList.size() - 1;
        person.setId(index);
        return index;
    }

    @Override
    public void update(Person person) {
        personList.set(person.getId(), person);
    }

    @Override
    public void delete(Person person) {
//        personList.set(Person.getId(), null);
    }
}
