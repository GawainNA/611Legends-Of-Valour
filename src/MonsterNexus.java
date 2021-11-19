public class MonsterNexus extends NexusCell{
    @Override
    public void inCellFunction(Character NPC){
        if(NPC instanceof Hero){
            System.out.println("Hero reached Monster's Nexus!");
        }
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
