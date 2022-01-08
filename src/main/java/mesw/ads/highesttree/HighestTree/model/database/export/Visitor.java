package mesw.ads.highesttree.HighestTree.model.database.export;

import org.xml.sax.SAXException;

import java.io.IOException;

public interface Visitor {
    void visitPersonTXTXML(String person) throws SAXException, IOException;

    void visitLocationTXTXML(String location) throws SAXException;

    void visitEventTXTXML(String event) throws SAXException;

    void visitPersonTXTCSV() throws IOException;

    void visitLocationTXTCSV() throws IOException;

    void visitEventTXTCSV() throws IOException;
}
