

public class SafeCell extends RPGCell {

    @Override
<<<<<<< HEAD
    public void cellFunction(Character player){
=======
    public void inCellFunction(Character NPC){

    }

    public void outCellFunction(Character NPC){
>>>>>>> main

    }

    @Override
    public String toString() {
        if(isHeroLocated){
            return "*";
        }
        return " ";
    }
}
