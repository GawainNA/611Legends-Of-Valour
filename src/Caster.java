
public class Caster extends Hero{
    Caster(String name){
        super(name);
        String[] tmp = data.getFireSpellData().get(0).split("\\s+");
        spells.add(SpellFactory.createFireSpell(tmp[0],Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]),Integer.parseInt(tmp[3]),Integer.parseInt(tmp[4])));
        AD_uprate = 10;
        AP_uprate = 50;
        DC_uprate = 0.05;
        AR_uprate = 20;
        MR_uprate = 30;
        HP_uprate = 100;
        MP_uprate = 200;
    }
}
