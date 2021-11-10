
public class SpellFactory {

    public static Spell createIceSpell(String attributes){
        String[] tmp = attributes.split(" ");
        return new IceSpell(tmp[0],Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]),Integer.parseInt(tmp[3]),Integer.parseInt(tmp[4]));
    }

    public static Spell createFireSpell(String attributes){
        String[] tmp = attributes.split(" ");
        return new IceSpell(tmp[0],Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]),Integer.parseInt(tmp[3]),Integer.parseInt(tmp[4]));
    }

    public static Spell createLightingSpell(String attributes){
        String[] tmp = attributes.split(" ");
        return new IceSpell(tmp[0],Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]),Integer.parseInt(tmp[3]),Integer.parseInt(tmp[4]));
    }

}
