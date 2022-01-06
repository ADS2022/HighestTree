package mesw.ads.highesttree.HighestTree.model.database.export;

import org.xml.sax.SAXException;

import java.io.IOException;

public interface Visitor {
    void visitPersonTXTToXML(String person) throws SAXException, IOException;

    void visitLocationTXTToXML(String location) throws SAXException;

    void visitEventTXTToXML(String event) throws SAXException;

    void visitPersonTXTToCSV() throws IOException;

    void visitLocationTXTToCSV() throws IOException;

    void visitEventTXTToCSV() throws IOException;
}
