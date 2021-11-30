module mesw.ads.highesttreemaven {
    requires javafx.controls;
    requires javafx.fxml;


    opens mesw.ads.highesttree to javafx.fxml;
    exports mesw.ads.highesttree;
    exports mesw.ads.highesttree.HighestTree.controller;
    opens mesw.ads.highesttree.HighestTree.controller to javafx.fxml;
    exports mesw.ads.highesttree.HighestTree.controller.location;
    opens mesw.ads.highesttree.HighestTree.controller.location to javafx.fxml;
    exports mesw.ads.highesttree.HighestTree.controller.errors;
    opens mesw.ads.highesttree.HighestTree.controller.errors to javafx.fxml;
    exports mesw.ads.highesttree.HighestTree.controller.database;
    opens mesw.ads.highesttree.HighestTree.controller.database to javafx.fxml;
}