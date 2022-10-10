package diary;

import java.util.Objects;

public class User {
    private final DiaryRepo diaryRepo = new DiaryRepoImpl();

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void writeToDiary(String title, String mainContent){
        DiaryContent diaryContent = new DiaryContent();
        diaryContent.setTitle(title);
        diaryContent.setMainContent(mainContent);
        diaryRepo.save(diaryContent);
    }

    public int getNumberOfEntries() {
        return diaryRepo.size();
    }

    public DiaryContent searchByTitle(String title, String password) {
        if(isValidPassword(password))throw new RuntimeException("Invalid Password");
        else return diaryRepo.searchByTitle(title);
    }
    private boolean isValidPassword(String password){
        return !Objects.equals(this.password, password);
    }

    public void deleteByTitle(String title, String password) {
        if(isValidPassword(password))throw new RuntimeException("Content cant be deleted due to invalid password");
        else diaryRepo.deleteByTitle(title);
    }

    public void displayEntries(){
        diaryRepo.displayEntries();
    }
}
