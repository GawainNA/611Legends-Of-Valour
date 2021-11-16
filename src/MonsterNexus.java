public class MonsterNexus extends NexusCell{
    @Override
    public void inCellFunction(Character NPC){

    }

    public void outCellFunction(Character NPC){

    }

    @Override
    public String toString() {
        if(isHeroLocated){
            return "*";
        }
        return " ";
    }
}
