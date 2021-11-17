
public class Caster extends Hero{
    Caster(String name){
        super(name);
        spells.add(SpellFactory.createFireSpell(data.getFireSpell()[0]));
        AD_uprate = 10;
        AP_uprate = 50;
        DC_uprate = 0.05;
        AR_uprate = 20;
        MR_uprate = 30;
        HP_uprate = 100;
        MP_uprate = 200;
    }
}
