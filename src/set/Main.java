package set;

public class Main {
    public static void main(String[] args) {
        SetName setName = new SetName();
        GetName getName = new GetName(8);
        getName.setNameChange(setName);
        setName.display();


    }
}
