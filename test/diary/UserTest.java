package diary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;
    private User secondUser;

    private User thirdEntry;

    private DiaryContent diaryContent;

    @BeforeEach
    void setUp() {
        diaryContent = new DiaryContent();
        user = new User();
        secondUser = new User();
        thirdEntry = new User();
        user.setUserName("Kaybee");
        user.setPassword("123456");
        secondUser.setUserName("ade");
        secondUser.setPassword("12309");
    }

    @Test
    void writeToDiarySavesIntoDBTest() {
        assertEquals(0, user.getNumberOfEntries());
        user.writeToDiary("My Name","My name is kabir");
        assertEquals(1, user.getNumberOfEntries());

        assertEquals(0, secondUser.getNumberOfEntries());
        secondUser.writeToDiary("My Life","My life is sweet");
        assertEquals(1, secondUser.getNumberOfEntries());

    }

    @Test
    void testThatContentOfDairySearchedIsReturnedOnlyIfPasswordMatches(){
        diaryContent.setTitle("My Name");
        diaryContent.setMainContent("My name is kabir");
        user.writeToDiary(diaryContent.getTitle(),diaryContent.getMainContent());
        DiaryContent findContent = user.searchByTitle(diaryContent.getTitle(), "123456");
        assertEquals(diaryContent, findContent);
    }

    @Test
    void testThatContentOfDiaryCanBeDeletedByTitle(){
        assertEquals(0, user.getNumberOfEntries());
        user.writeToDiary("My Name","My name is kabir");
        user.writeToDiary("My Woman","My everything");
        assertEquals(2, user.getNumberOfEntries());
        user.deleteByTitle("My Woman", "123456");
        assertEquals(1,user.getNumberOfEntries());
    }

    @Test
    void testThatContentOfDiaryCanDisplay(){
        user.writeToDiary("My Name","My name is kabir");
        user.writeToDiary("My Woman","My everything");
        user.displayEntries();
    }
}