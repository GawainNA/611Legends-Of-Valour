
public abstract class Monster extends Character{
    Monster(String name){
        super(name);
    }
    public abstract int inflict(Hero hero);

}
