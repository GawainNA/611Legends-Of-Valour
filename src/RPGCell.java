

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

    public abstract void inCellFunction(Character NPC);
    public abstract void outCellFunction(Character NPC);
    public abstract String toString();
}
