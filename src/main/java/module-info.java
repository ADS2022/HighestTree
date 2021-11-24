module mesw.ads.highesttreemaven {
    requires javafx.controls;
    requires javafx.fxml;


    opens mesw.ads.highesttree to javafx.fxml;
    exports mesw.ads.highesttree;
    exports mesw.ads.highesttree.HighestTree.controller;
    opens mesw.ads.highesttree.HighestTree.controller to javafx.fxml;
}