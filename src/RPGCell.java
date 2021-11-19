

public abstract class RPGCell {
    boolean isAccessible;
    boolean isHeroLocated;

    RPGCell(){
        isAccessible=true;
        isHeroLocated=false;
    }

    public void setHeroLocated(boolean located){
        isHeroLocated=located;
    }

    public boolean isHeroLocated(){
        return isHeroLocated;
    }

    public boolean isAccessible(){
        return isAccessible;
    }

<<<<<<< HEAD
    public abstract void cellFunction(Character player);
=======
    public abstract void inCellFunction(Character NPC);
    public abstract void outCellFunction(Character NPC);
>>>>>>> main
    public abstract String toString();
}
