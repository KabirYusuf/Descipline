package diary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryRepoImplTest {

    private final DiaryRepo diaryRepo = new DiaryRepoImpl();

    private DiaryContent content;
    private DiaryContent secondContent;

    @BeforeEach
    void setUp() {
        content = new DiaryContent();
        content.setTitle("My name");
        content.setMainContent("My name is kabir");

        secondContent = new DiaryContent();
        secondContent.setTitle("My life");
        secondContent.setMainContent("Protecting my priority");
    }

    @Test
    void save() {
        assertEquals(0, diaryRepo.size());
        diaryRepo.save(content);
        assertEquals(1, diaryRepo.size());
    }
    @Test
    void searchByTitle() {
        diaryRepo.save(content);
        DiaryContent findContent = diaryRepo.searchByTitle("My name");
        assertEquals(content, findContent);
    }

    @Test
    void delete() {
        assertEquals(0, diaryRepo.size());
        diaryRepo.save(content);
        diaryRepo.save(secondContent);
        assertEquals(2, diaryRepo.size());
        diaryRepo.deleteByTitle("My life");
        diaryRepo.deleteByTitle("My name");
        assertEquals(0, diaryRepo.size());
    }



    @Test
    void searchByDate() {
    }

    @Test
    void size() {
        assertEquals(0, diaryRepo.size());
        diaryRepo.save(content);
        diaryRepo.save(secondContent);
        assertEquals(2,diaryRepo.size());
    }

    @Test
    void deleteAll() {
        diaryRepo.save(content);
        diaryRepo.save(secondContent);
        assertEquals(2, diaryRepo.size());
        diaryRepo.deleteAll();
        assertEquals(0,diaryRepo.size());
    }
}