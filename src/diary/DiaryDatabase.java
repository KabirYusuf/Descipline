package diary;

import java.util.ArrayList;

public class DiaryDatabase {

    ArrayList<Diary>diaries = new ArrayList<>();
    private int numberOfEntries = 0;

    public void addEntry(String date, String title, String content) {
        Diary diary = new Diary(date, title, content);
        diaries.add(diary);
        numberOfEntries++;
    }

    public Diary searchDiary(String date) {
        for (Diary diary:diaries) {
            if(date.equals(diary.getDate())){
                //System.out.println(diary);
                return diary;
            }

        }
        return null;
    }


    public String searchContent(String date) {
        Diary diary = searchDiary(date);
        return diary.getContent();
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public void delete(String date) {
        Diary diary = searchDiary(date);
        diaries.remove(diary);
    }
}
