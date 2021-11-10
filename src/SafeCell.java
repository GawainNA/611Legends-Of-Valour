

public class SafeCell extends RPGCell {

    @Override
    public void cellFunction(Player player){

    }

    @Override
    public String toString() {
        if(isHeroLocated){
            return "*";
        }
        return " ";
    }
}
