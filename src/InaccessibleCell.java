

public class InaccessibleCell extends RPGCell {

    public InaccessibleCell(){
        isAccessible=false;
    }
    @Override
    public void cellFunction(Player player){

    }
    public String toString(){
        if(isHeroLocated){
            return "*";
        }
        return "X";
    }
}
