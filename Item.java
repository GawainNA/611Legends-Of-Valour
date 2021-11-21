

import java.util.ArrayList;

public abstract class Item {
    String name;
    int price;
    int selling_price;
    int level_require;


    Item(String name, int price, int level_require){
        this.name=name;
        this.price=price;
        this.selling_price=(int)(price*0.7);
        this.level_require=level_require;
    }

    public abstract void printDetail();

    public abstract void UseFromBag(Bag bag,Hero hero);

    public int getPrice() {
        return price;
    }

    public int getLevel_require() {
        return level_require;
    }

    public String getName() {
        return name;
    }

    public int getSelling_price() {
        return selling_price;
    }
}
