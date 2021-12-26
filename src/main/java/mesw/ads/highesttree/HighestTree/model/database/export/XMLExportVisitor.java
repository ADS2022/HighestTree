package mesw.ads.highesttree.HighestTree.model.database.export;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.FileReader;

public class XMLExportVisitor implements Visitor {

    private BufferedReader bufferedReader;
    private StreamResult streamResult;
    private TransformerHandler transformerHandler;
    private AttributesImpl attributes;

    public XMLExportVisitor(String pathToTextFile, String pathToOutputFile, int kind) {
        try {
            bufferedReader = new BufferedReader(new FileReader(pathToTextFile));
            streamResult = new StreamResult(pathToOutputFile);
            String str;
            switch (kind) {
                case 1:
                    this.personXLMInitializer();
                    while ((str = bufferedReader.readLine()) != null) {
                        visitLocation(str);
                    }
                    bufferedReader.close();
                    this.personXMLCloser();
                    break;
                case 2:
                    this.placeXLMInitializer();
                    while ((str = bufferedReader.readLine()) != null) {
                        visitLocation(str);
                    }
                    bufferedReader.close();
                    this.placeXMLCloser();
                    break;
                case 3:
                    this.eventXLMInitializer();
                    while ((str = bufferedReader.readLine()) != null) {
                        visitLocation(str);
                    }
                    bufferedReader.close();
                    this.eventXMLCloser();
                    break;

                default:
                    System.out.println("The options are:\n1 - Person\n2 - Place\n3 - Event\n");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void placeXLMInitializer() throws ParserConfigurationException,
            TransformerConfigurationException, SAXException {
        SAXTransformerFactory transformerFactory = (SAXTransformerFactory) SAXTransformerFactory
                .newInstance();

        transformerHandler = transformerFactory.newTransformerHandler();
        Transformer serializer = transformerHandler.getTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
        serializer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "4");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformerHandler.setResult(streamResult);
        transformerHandler.startDocument();
        attributes = new AttributesImpl();
        transformerHandler.startElement("", "", "Place", attributes);
    }

    private void placeXMLCloser() throws SAXException {
        transformerHandler.endElement("", "", "Place");
        transformerHandler.endDocument();
    }

    private void eventXLMInitializer() throws ParserConfigurationException,
            TransformerConfigurationException, SAXException {
        SAXTransformerFactory transformerFactory = (SAXTransformerFactory) SAXTransformerFactory
                .newInstance();

        transformerHandler = transformerFactory.newTransformerHandler();
        Transformer serializer = transformerHandler.getTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
        serializer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "4");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformerHandler.setResult(streamResult);
        transformerHandler.startDocument();
        attributes = new AttributesImpl();
        transformerHandler.startElement("", "", "Event", attributes);
    }

    private void eventXMLCloser() throws SAXException {
        transformerHandler.endElement("", "", "Event");
        transformerHandler.endDocument();
    }

    private void personXLMInitializer() throws ParserConfigurationException,
            TransformerConfigurationException, SAXException {
        SAXTransformerFactory transformerFactory = (SAXTransformerFactory) SAXTransformerFactory
                .newInstance();

        transformerHandler = transformerFactory.newTransformerHandler();
        Transformer serializer = transformerHandler.getTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
        serializer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "4");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformerHandler.setResult(streamResult);
        transformerHandler.startDocument();
        attributes = new AttributesImpl();
        transformerHandler.startElement("", "", "Person", attributes);
    }

    private void personXMLCloser() throws SAXException {
        transformerHandler.endElement("", "", "Person");
        transformerHandler.endDocument();
    }

    @Override
    public void visitPerson(String person) throws SAXException {

        String[] elements = person.split(",");
        attributes.clear();

        transformerHandler.startElement("", "", "id", attributes);
        transformerHandler.characters(elements[0].toCharArray(), 0, elements[0].length());
        transformerHandler.endElement("", "", "id");

        transformerHandler.startElement("", "", "first_name", attributes);
        transformerHandler.characters(elements[1].toCharArray(), 0, elements[1].length());
        transformerHandler.endElement("", "", "first_name");

        transformerHandler.startElement("", "", "last_name", attributes);
        transformerHandler.characters(elements[2].toCharArray(), 0, elements[2].length());
        transformerHandler.endElement("", "", "last_name");

        transformerHandler.startElement("", "", "nationality", attributes);
        transformerHandler.characters(elements[3].toCharArray(), 0, elements[3].length());
        transformerHandler.endElement("", "", "nationality");

        transformerHandler.startElement("", "", "events", attributes);
        transformerHandler.characters(elements[4].toCharArray(), 0, elements[4].length());
        transformerHandler.endElement("", "", "events");

        transformerHandler.startElement("", "", "source", attributes);
        transformerHandler.characters(elements[5].toCharArray(), 0, elements[5].length());
        transformerHandler.endElement("", "", "source");

        transformerHandler.startElement("", "", "description", attributes);
        transformerHandler.characters(elements[6].toCharArray(), 0, elements[6].length());
        transformerHandler.endElement("", "", "description");

        transformerHandler.startElement("", "", "parents", attributes);
        transformerHandler.characters(elements[7].toCharArray(), 0, elements[7].length());
        transformerHandler.endElement("", "", "parents");

        transformerHandler.startElement("", "", "partner", attributes);
        transformerHandler.characters(elements[7].toCharArray(), 0, elements[8].length());
        transformerHandler.endElement("", "", "partner");

        transformerHandler.startElement("", "", "isSensitive", attributes);
        transformerHandler.characters(elements[9].toCharArray(), 0, elements[9].length());
        transformerHandler.endElement("", "", "isSensitive");


    }

    @Override
    public void visitLocation(String location) throws SAXException {
        String[] elements = location.split(",");
        attributes.clear();

        transformerHandler.startElement("", "", "id", attributes);
        transformerHandler.characters(elements[0].toCharArray(), 0, elements[0].length());
        transformerHandler.endElement("", "", "id");

        transformerHandler.startElement("", "", "name", attributes);
        transformerHandler.characters(elements[1].toCharArray(), 0, elements[1].length());
        transformerHandler.endElement("", "", "name");

        transformerHandler.startElement("", "", "country", attributes);
        transformerHandler.characters(elements[2].toCharArray(), 0, elements[2].length());
        transformerHandler.endElement("", "", "country");

        transformerHandler.startElement("", "", "district", attributes);
        transformerHandler.characters(elements[3].toCharArray(), 0, elements[3].length());
        transformerHandler.endElement("", "", "district");

        transformerHandler.startElement("", "", "city", attributes);
        transformerHandler.characters(elements[4].toCharArray(), 0, elements[4].length());
        transformerHandler.endElement("", "", "city");

        transformerHandler.startElement("", "", "street", attributes);
        transformerHandler.characters(elements[5].toCharArray(), 0, elements[5].length());
        transformerHandler.endElement("", "", "street");

        transformerHandler.startElement("", "", "description", attributes);
        transformerHandler.characters(elements[6].toCharArray(), 0, elements[6].length());
        transformerHandler.endElement("", "", "description");

        transformerHandler.startElement("", "", "is_sensitive", attributes);
        transformerHandler.characters(elements[7].toCharArray(), 0, elements[7].length());
        transformerHandler.endElement("", "", "is_sensitive");
    }

    @Override
    public void visitEvent(String event) throws SAXException {
        String[] elements = event.split(",");
        attributes.clear();

        transformerHandler.startElement("", "", "id", attributes);
        transformerHandler.characters(elements[0].toCharArray(), 0, elements[0].length());
        transformerHandler.endElement("", "", "id");

        transformerHandler.startElement("", "", "name", attributes);
        transformerHandler.characters(elements[1].toCharArray(), 0, elements[1].length());
        transformerHandler.endElement("", "", "name");

        transformerHandler.startElement("", "", "standard_events", attributes);
        transformerHandler.characters(elements[2].toCharArray(), 0, elements[2].length());
        transformerHandler.endElement("", "", "standard_events");

        transformerHandler.startElement("", "", "description", attributes);
        transformerHandler.characters(elements[3].toCharArray(), 0, elements[3].length());
        transformerHandler.endElement("", "", "description");

        transformerHandler.startElement("", "", "super_date", attributes);
        transformerHandler.characters(elements[4].toCharArray(), 0, elements[4].length());
        transformerHandler.endElement("", "", "super_date");

        transformerHandler.startElement("", "", "location", attributes);
        transformerHandler.characters(elements[5].toCharArray(), 0, elements[5].length());
        transformerHandler.endElement("", "", "location");

        transformerHandler.startElement("", "", "persons_involved", attributes);
        transformerHandler.characters(elements[6].toCharArray(), 0, elements[6].length());
        transformerHandler.endElement("", "", "persons_involved");

        transformerHandler.startElement("", "", "source", attributes);
        transformerHandler.characters(elements[7].toCharArray(), 0, elements[7].length());
        transformerHandler.endElement("", "", "source");

        transformerHandler.startElement("", "", "isSensitive", attributes);
        transformerHandler.characters(elements[8].toCharArray(), 0, elements[8].length());
        transformerHandler.endElement("", "", "isSensitive");

    }
}
