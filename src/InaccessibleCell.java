

public class InaccessibleCell extends RPGCell {

    public InaccessibleCell(){
        isAccessible=false;
    }
    @Override
    public void cellFunction(Character player){

    }
    public String toString(){
        if(isHeroLocated){
            return "*";
        }
        return "X";
    }
}
