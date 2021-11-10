
public class Caster extends Hero{
    Caster(String name){
        super(name);
        spells.add(SpellFactory.createFireSpell(data.getFireSpell()[0]));
    }
}
