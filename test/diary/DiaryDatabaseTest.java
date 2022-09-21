package diary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryDatabaseTest {
    private DiaryDatabase diaryDatabase;
    private Diary diary;

    @BeforeEach
    void setUp(){
        diaryDatabase = new DiaryDatabase();
        diary = new Diary("13/9/22", "first", "Testing diary");
    }
    @Test
    void testToShowThatEntryCanBeMadeIntoDiaryDatabase(){
        diaryDatabase.addEntry("14/9/2022","First Entry","I am adding my first diary content");
        assertEquals("I am adding my first diary content",diaryDatabase.searchContent("14/9/2022"));
    }
    @Test
    void testToKnowTheNumberOfEntriesMadeIntoDiaryDatabase(){
        diaryDatabase.addEntry("14/9/2022","First Entry","I am adding my first diary content");
        diaryDatabase.addEntry("14/9/2022","Second Entry","I am adding my second diary content");
        diaryDatabase.addEntry("14/9/2022","Third Entry","I am adding my third diary content");
        assertEquals(3, diaryDatabase.getNumberOfEntries());
        diaryDatabase.searchDiary("14/9/2022");
    }

    @Test
    void dairyInformationCanBeDeletedTest(){
        diaryDatabase.addEntry("14/9/2022","First Entry","I am adding my first diary content");
        diaryDatabase.addEntry("13/9/2022","Second Entry","I am adding my second diary content");
        diaryDatabase.addEntry("12/9/2022","Third Entry","I am adding my third diary content");
        diaryDatabase.delete("14/9/2022");
        assertNull(diaryDatabase.searchContent("14/9/2022"));
    }

}