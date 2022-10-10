package diary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DiaryRepoImpl implements DiaryRepo{

    List<DiaryContent> diaryContents = new ArrayList<>();

    @Override
    public void save(DiaryContent diaryContent) {
        diaryContents.add(diaryContent);
    }

    @Override
    public void deleteByTitle(String title) {
        DiaryContent content = searchByTitle(title);
        diaryContents.remove(content);
    }

    @Override
    public DiaryContent searchByTitle(String title) {
        for (DiaryContent content: diaryContents) {
            if(Objects.equals(title, content.getTitle())){
                return content;
            }
        }
        throw new RuntimeException("No Content was found using that title");
    }

    @Override
    public DiaryContent searchByDate(String date) {
        return null;
    }

    @Override
    public int size() {
        return diaryContents.size();
    }

    @Override
    public void deleteAll() {
        diaryContents.clear();

    }

    @Override
    public void displayEntries() {
        for (DiaryContent content: diaryContents) {
            System.out.println(content);
        }
    }
}
