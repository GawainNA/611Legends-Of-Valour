

public class InaccessibleCell extends RPGCell {

    public InaccessibleCell(){
        isAccessible=false;
    }
    @Override
<<<<<<< HEAD
    public void cellFunction(Character player){
=======
    public void inCellFunction(Character NPC){}
>>>>>>> main


    public void outCellFunction(Character NPC){}
    public String toString(){
        if(isHeroLocated){
            return "*";
        }
        return "X";
    }
}
