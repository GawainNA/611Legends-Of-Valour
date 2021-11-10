

public class data {
    static String[] Armor= {"Platinum_Shield 150 1 20 20",
                     "Breastplate 350 3 50 50",
                     "Full_Body_Armor 1000 8 300 100",
                     "Wizard_Shield 1200 10 800 200",
                     "Guardian_Angel 2000 10 500 1200"};
    static String[] Weapon={"Sword 200 2 80 20","Wand 300 2 30 100", "Bow 500 5 130 80","Excalibur 2000 10 500 300",
                            "DarkEye 2000 11 120 670"};
    static String[] IceSpell={"Ice_Blade 250 1 150 50","Snow_Cannon 500 2 200 80","Arctic_Storm 700 6 800 300"};

    static String[] FireSpell={"Breath_of_Fire 350 1 450 100","Flame_Tornado 700 4 850 300"};

    static String[] LightingSpell={"Lightning_Dagger 400 1 500 150","Thunder_Blast 750 4 950 400"};


    //Heroes' data          {name,dodge,DC_UP, HP, AD, AP, AR, MR, MP, AD_UP, AP_UP, AR_UP, MR_UP, HP_UP, MP_UP}
    static String[] Warrior={"Warrior","0.2","0.05","300","100","20","20","10","100","10","5","10","5","100","30"};
    static String[] Tank =  {"Tank","0.05","0.05","500", "80","30","40","30","150","5", "5","20","20","150","30"};
    static String[] Caster= {"Caster","0.1","0.05","300","50","150","20","15","300", "5", "10","5","10","75","80"};

    //Monsters' data       {name, HP, dodge,attack_damage, ability_power,attack_resist,magic_resist, level}
    static String[] Dragon={"Dragon","1000","0.1","100","100","100","100","10"};
    static String[] DarkDragon={"Dark Dragon","9999","0.1","1000","1000","300","300","50"};
    static String[] MonsterCaster={"MonsterCaster","200","0.1","10","50","10","30","1"};
    static String[] MonsterFighter={"MonsterFighter","300","0.2","50","10","30","0","1"};

    //potion data          {name,price,level,HP,MP,AD,AP,AR,MR}
    static String[] potion={"Little_Heal_Potion 100 1 100 0 0 0 0 0","Little_Mana_Potion 100 1 0 100 0 0 0 0",
                            "AD_Strength_Potion 100 1 0 0 30 0 0 0","AP_Strength_Potion 100 1 0 0 0 40 0 0"};

    public static String[] getWarrior(){
        return Warrior;
    }

    public static String[] getTank(){
        return Tank;
    }

    public static String[] getArmor(){
        return Armor;
    }
    public static String[] getWeapon(){return Weapon;}

    public static String[] getCaster(){
        return Caster;
    }
    public static String[] getDragon(){
        return Dragon;
    }
    public static String[] getDarkDragon(){return DarkDragon;}
    public static String[] getMonsterCaster(){
        return MonsterCaster;
    }
    public static String[] getMonsterFighter(){
        return MonsterFighter;
    }
    public static String[] getFireSpell(){return FireSpell;}
    public static String[] getIceSpell(){return IceSpell;}

    public static String[] getLightingSpell() {
        return LightingSpell;
    }
    public static String[] getPotion(){
        return potion;
    }
}
