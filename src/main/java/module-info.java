module mesw.ads.highesttreemaven {
    requires javafx.controls;
    requires javafx.fxml;


    opens mesw.ads.highesttreemaven to javafx.fxml;
    exports mesw.ads.highesttreemaven;
    exports mesw.ads.highesttreemaven.HighestTree.controller;
    opens mesw.ads.highesttreemaven.HighestTree.controller to javafx.fxml;
}