import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllAncestors(){
        Person parent11 = new Person();
        Person parent21 = new Person();
        Person parent12 = new Person();
        Person parent22 = new Person();
        Person parent1 = new Person();
        Person parent2 = new Person();
        Person targetPerson = new Person();

        List<Person> parentsOfParent1 = new ArrayList<>();
        parentsOfParent1.add(parent11);
        parentsOfParent1.add(parent12);
        parent1.setParents(parentsOfParent1);

        List<Person> parentsOfParent2 = new ArrayList<>();
        parentsOfParent2.add(parent21);
        parentsOfParent2.add(parent22);
        parent2.setParents(parentsOfParent2);

        List<Person> parentsOfTargetPerson = new ArrayList<>();
        parentsOfTargetPerson.add(parent1);
        parentsOfTargetPerson.add(parent2);
        targetPerson.setParents(parentsOfTargetPerson);

        List<Person> ancestors = new ArrayList<>();
        ancestors = getAncestors(targetPerson, ancestors);

        List<Person> trueAncestorList = new ArrayList<>();
        trueAncestorList.add(parent1);
        trueAncestorList.add(parent11);
        trueAncestorList.add(parent12);
        trueAncestorList.add(parent2);
        trueAncestorList.add(parent21);
        trueAncestorList.add(parent22);

        assertEquals(trueAncestorList,ancestors);

    }

    private List<Person> getAncestors(Person targetPerson, List<Person> ancestors) {
        if(targetPerson.getParents() != null) {
            for (Person parent :
                    targetPerson.getParents()) {
                ancestors.add(parent);
                ancestors = getAncestors(parent, ancestors);

            }
        }
        return ancestors;

    }
}