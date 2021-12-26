package mesw.ads.highesttree.HighestTree.model.database.export;

public class Main {
    public static void main(String[] args) {
        new XMLExportVisitor("/Users/franciscobastos/Developer/ADS/HighestTree/files/location.txt",
                "/Users/franciscobastos/Developer/ADS/HighestTree/files/location.xml", 2);
    }
}
