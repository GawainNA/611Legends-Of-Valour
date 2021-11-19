

public class SafeCell extends RPGCell {

    @Override
    public void cellFunction(Character player){

    }

    @Override
    public String toString() {
        if(isHeroLocated){
            return "*";
        }
        return " ";
    }
}
