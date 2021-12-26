package mesw.ads.highesttree.HighestTree.model.database.export;

import mesw.ads.highesttree.HighestTree.model.Event;
import mesw.ads.highesttree.HighestTree.model.Location;
import mesw.ads.highesttree.HighestTree.model.Person;
import org.xml.sax.SAXException;

public interface Visitor {
    void visitPerson(String person) throws SAXException;

    void visitLocation(String location) throws SAXException;

    void visitEvent(String event) throws SAXException;
}
