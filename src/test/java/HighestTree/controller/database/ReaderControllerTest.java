package HighestTree.controller.database;

import javafx.scene.layout.VBox;
import mesw.ads.highesttree.HighestTree.controller.database.ReaderController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class ReaderControllerTest {

    @Mock
    private ReaderController readerController;
    @Mock
    private VBox mainVBox;
    @InjectMocks
    private ReaderController loadController;

    @Test
    public void testTestOnly() {
        // loadController.testOnly();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void initialize() {
    }

    @Test
    void actionBack() {
    }

    @Test
    void actionRegisterPlace() {
    }
}