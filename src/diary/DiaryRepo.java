package diary;

public interface DiaryRepo{
    void save(DiaryContent diaryContent);

    void deleteByTitle(String title);

    DiaryContent searchByTitle(String title);

    DiaryContent searchByDate(String date);

    int size();


    void deleteAll();

    void displayEntries();



}
