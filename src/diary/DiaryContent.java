package diary;

import java.time.LocalDateTime;
import java.util.Objects;

public class DiaryContent {
    private LocalDateTime dateTime;
    private String title;
    private String mainContent;

    public DiaryContent(){
        dateTime = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }

    @Override
    public String toString() {

        return String.format("%s%n%s%n%s%n", dateTime,getTitle(),getMainContent());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiaryContent that = (DiaryContent) o;
        return Objects.equals(title, that.title) && Objects.equals(mainContent, that.mainContent);
    }

}
