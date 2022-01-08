package mesw.ads.highesttree.HighestTree.model.database.export;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class ExportVisitor implements Visitor {

    private BufferedReader bufferedReader;
    private StreamResult streamResult;
    private TransformerHandler transformerHandler;
    private AttributesImpl attributes;

    private static final String ENCODING = "UTF-8";
    private static final String URL = "{http://xml.apache.org/xslt}indent-amount";

    private static final String FILES_EVENT_TXT = "files/event.txt";
    private static final String FILES_LOCATION_TXT = "files/location.txt";
    private static final String FILES_PERSON_TXT = "files/person.txt";

    private static final String FILES_EVENT_XML = "files/event.xml";
    private static final String FILES_PERSON_XML = "files/person.xml";
    private static final String FILES_LOCATION_XML = "files/location.xml";

    private static final String PATH_TO_FILE = "files/";

    public ExportVisitor(int kind) {
        try {
            String str;
            switch (kind) {
                case 1:
                    bufferedReader = new BufferedReader(new FileReader(FILES_PERSON_TXT));
                    streamResult = new StreamResult(FILES_PERSON_XML);

                    this.personXLMInitializer();
                    while ((str = bufferedReader.readLine()) != null) {
                        visitPersonTXTToXML(str);
                    }

                    bufferedReader.close();
                    this.personXMLCloser();
                    System.out.println("File exported to XML");
                    break;
                case 2:
                    bufferedReader = new BufferedReader(new FileReader(FILES_LOCATION_TXT));
                    streamResult = new StreamResult(FILES_LOCATION_XML);

                    this.locationXLMInitializer();
                    while ((str = bufferedReader.readLine()) != null) {
                        visitLocationTXTToXML(str);
                    }

                    bufferedReader.close();
                    this.locationXMLCloser();
                    System.out.println("File exported to XML");
                    break;
                case 3:
                    bufferedReader = new BufferedReader(new FileReader(FILES_EVENT_TXT));
                    streamResult = new StreamResult(FILES_EVENT_XML);

                    this.eventXLMInitializer();
                    while ((str = bufferedReader.readLine()) != null) {
                        visitEventTXTToXML(str);
                    }

                    bufferedReader.close();
                    this.eventXMLCloser();
                    System.out.println("File exported to XML");
                    break;

                case 4:
                    visitPersonTXTToCSV();
                    System.out.println("File exported to CSV");
                    break;

                case 5:
                    visitLocationTXTToCSV();
                    System.out.println("File exported to CSV");
                    break;

                case 6:
                    visitEventTXTToCSV();
                    System.out.println("File exported to CSV");
                    break;

                default:
                    System.out.println("Wrong action");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeToCSV(Path txt, Path csv) throws IOException {
        Charset utf8 = StandardCharsets.UTF_8;
        try (
                final Scanner scanner = new Scanner(Files.newBufferedReader(txt, utf8));
                final PrintWriter pw = new PrintWriter(Files.newBufferedWriter(csv, utf8, StandardOpenOption.CREATE_NEW))) {
            while (scanner.hasNextLine()) {
                pw.println(scanner.nextLine().replace(',', ','));
            }
        }
    }

    private void locationXLMInitializer() throws TransformerConfigurationException, SAXException {
        transformerFactory();
        transformerHandler.startElement("", "", "Place", attributes);
    }

    private void transformerFactory() throws TransformerConfigurationException, SAXException {
        SAXTransformerFactory transformerFactory = (SAXTransformerFactory) SAXTransformerFactory
                .newInstance();

        transformerHandler = transformerFactory.newTransformerHandler();
        Transformer serializer = transformerHandler.getTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, ENCODING);
        serializer.setOutputProperty(
                URL, "4");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformerHandler.setResult(streamResult);
        transformerHandler.startDocument();
        attributes = new AttributesImpl();
    }

    private void locationXMLCloser() throws SAXException {
        transformerHandler.endElement("", "", "Place");
        transformerHandler.endDocument();
    }

    private void eventXLMInitializer() throws TransformerConfigurationException, SAXException {
        transformerFactory();
        transformerHandler.startElement("", "", "Event", attributes);
    }

    private void eventXMLCloser() throws SAXException {
        transformerHandler.endElement("", "", "Event");
        transformerHandler.endDocument();
    }

    private void personXLMInitializer() throws TransformerConfigurationException, SAXException {
        transformerFactory();
        transformerHandler.startElement("", "", "Person", attributes);
    }

    private void personXMLCloser() throws SAXException {
        transformerHandler.endElement("", "", "Person");
        transformerHandler.endDocument();
    }

    @Override
    public void visitPersonTXTToXML(String person) throws SAXException, IOException {
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
    }

    @Override
    public void visitLocationTXTToXML(String location) throws SAXException {
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
    public void visitEventTXTToXML(String event) throws SAXException {
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

    @Override
    public void visitPersonTXTToCSV() throws IOException {
        Path path = Paths.get(PATH_TO_FILE);
        Path txt = path.resolve("person.txt");
        Path csv = path.resolve("person.csv");
        writeToCSV(txt, csv);

    }

    @Override
    public void visitLocationTXTToCSV() throws IOException {
        Path path = Paths.get(PATH_TO_FILE);
        Path txt = path.resolve("location.txt");
        Path csv = path.resolve("location.csv");
        writeToCSV(txt, csv);
    }

    @Override
    public void visitEventTXTToCSV() throws IOException {
        Path path = Paths.get(PATH_TO_FILE);
        Path txt = path.resolve("event.txt");
        Path csv = path.resolve("event.csv");
        writeToCSV(txt, csv);

    }
}
