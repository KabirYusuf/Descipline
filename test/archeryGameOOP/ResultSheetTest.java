package archeryGameOOP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultSheetTest {
private ResultSheet resultSheet;
    @BeforeEach
    void setUp() {
        resultSheet = new ResultSheet();
    }

    @Test
    void testThatResultSheetHasNoRecordBeforeTheGameBegins(){
        var sheet = resultSheet.getResultSheet();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(0, sheet[i][j]);
            }
        }
    }

    @Test
    void testThatResultSheetCanBeDisplayed(){
        resultSheet.displayResultSheet();
    }
}