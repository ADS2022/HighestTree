module mesw.ads.highesttreemaven {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires json.simple;


    opens mesw.ads.highesttree.HighestTree to javafx.fxml;
    exports mesw.ads.highesttree.HighestTree.controller;
    opens mesw.ads.highesttree.HighestTree.controller to javafx.fxml;
    exports mesw.ads.highesttree.HighestTree;
}