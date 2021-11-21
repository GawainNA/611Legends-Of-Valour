
public  class potion extends ConsumableItem {

    int HP_recover;
    int MP_recover;
    int AD_Strength;
    int AP_Strength;
    int AR_Strength;
    int MR_Strength;
    public potion(String name, int price, int level_require,int HP,int MP,int AD, int AP, int AR, int MR){
        super(name, price, level_require);
        HP_recover=HP;
        MP_recover=MP;
        AD_Strength=AD;
        AP_Strength=AP;
        AR_Strength=AR;
        MR_Strength=MR;
    }

    @Override
    public void printDetail() {
        if(HP_recover>0){
            System.out.println("Healing: "+HP_recover);
        }
        if(MP_recover>0){
            System.out.println("Mana Recover: "+MP_recover);
        }
        if(AD_Strength>0){
            System.out.println("Strength AD: "+AD_Strength);
        }
        if(AP_Strength>0){
            System.out.println("Strength AP: "+AP_Strength);
        }
        if(AR_Strength>0){
            System.out.println("Strength AR: "+AR_Strength);
        }
        if(MR_Strength>0){
            System.out.println("Strength MR: "+MR_Strength);
        }
    }

    @Override
    public void consume(Hero hero) {
        hero.getHeal(HP_recover);
        hero.recoverMP(MP_recover);
        hero.setAttack_damage(hero.getAttack_damage()+AD_Strength);
        hero.setAbility_power(hero.getAbility_power()+AP_Strength);
        hero.setAttack_resist(hero.getAttack_resist()+AR_Strength);
        hero.setMagic_resist(hero.getMagic_resist()+MR_Strength);
        System.out.println("Drink "+name+" successfully!");
    }
}
