

public class InaccessibleCell extends RPGCell {

    public InaccessibleCell(){
        isAccessible=false;
    }
    @Override
    public void inCellFunction(Character NPC){}


    public void outCellFunction(Character NPC){}
    public String toString(){
        if(isHeroLocated){
            return "*";
        }
        return "X";
    }
}
