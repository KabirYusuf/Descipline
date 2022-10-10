package set;

public class GetName {

    private int id;

    public GetName(int id) {
        this.id = id;
    }

    public void setNameChange(SetName setName){
        var name = setName.getName();
        name = id;

    }
}
