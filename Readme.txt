Name: Junyi Huang
BUID:U57383185

Thank you for grading and reading this long readme. 

Run Instrcution : javac GameLauncher.java(may have warning but it's doesn't matter for running) and then java GameLauncher
------------------------------------------------------------------------------------------------------------------------
Game Rules Description:
Almost the same as the Assignment's game rules. But I changed some rules, here are the differences.

1. Map has Five types of area(cell):
   "X" means inaccessible, you cannot enter this area.
   "?" means dangerous area, you may meet Monsters here.
   "M" means Market, you could buy and sell Items here.
   "B" means Boss Area. Do not Enter this place without enough preparation.
   " " means safe area, you can pass this area without any events.

2. When your screen is showing the map, you can move, exit game, look up Heroes' information and bag, even when you are in a dangerous area.
   But Please notice that if you did one action in a dangerous area, like looking up bag or Heroes' information, Monsters may find you after that.

3. Any Characters in this game including Hero and Monster all have the same attributes below:
   HP: Health Points.
   MP: Mana Points
   AD: Attack Damage, means ability of physical attack.
   AP: Ability power, means ability of magical attack.
   AR: Attack resist, means ability of defensing attack damage, useless to magical attack.
   MR: Magic resist, means ability of defensing magical attack, useless to physical attack.

4. You could only select these three types of Heroes.
   Tank: High Health Point and High defense.  Warrior: High Attack Damage.  Caster: High Ability Power
   You can repeatedly select the same type of Heroes, but up to three Heroes at most.
   (I only create three Heroes for each type in the game, but the data could be easily changed in the data.java file)

5. Player has one bag and one wallet. They will be used by all Heroes together in this game.

6. When you are in a Market, you can buy anything if your money is enough, don't need to worried about the level requirement.
   But When you want to use one Item, if a Hero doesn't meet the item's level requirement, you cannot use it for that Hero.

All the rest of my Game Rules are the same as Assignment's Description.


------------------------------------------------------------------------------------------------------------------------
Class Description:
General :
               |<---Contain--- Bag <----------|
    ----> Item |<---Contain--- Character <----|----Contain--- Player <-----|
    |                                                                      |
    |-----Market <----|---USE---RPGCell <---Contain--- Map <---------------|----Contain---Legends
     BattleField <----|

Legends have one Player and one Map.
Player has one Bag and some Heroes.
Bag has some items. Items can be used by Player from bag to Hero.
Market also has some items. Item can be sold and bought here.
BattleField has some Monsters and use some Heroes to call a Battle Round.
Map has some RPGCells. When Heroes come into one Cell, Legends will call the cellFunction in that Cell. Like MarketCell
                       will call a Market, DangerousCell will Call a BattleField.

PS: I read data from data.java file, so I don't have any other TXT file for data.

---------------------------------------------------
                          Item Design Pattern
Item <---extends-- Equipment      <---extends-- Armor & Weapon            <-----------------------------------|
     <---extends-- ConsumableItem <---extends-- Spell  <---extends-- IceSpell & FireSpell & Lighting Spell<---|---Produce----Factories
                                  <---extends-- potion <------------------------------------------------------|

Item is the most general Class for all items that could be stored in Market and Bag.
Equipment implements <Equipable> interface, which means it can be equipped by Hero. Thus, I could easily add more
          Equipment item, like ear ring, by extending Equipment Class.
ConsumableItem implements <Consumable> interface, which means it will be disappeared after using once from bag.
          When Spell in bag it will be a scroll. Hero can lean though it but after that it will be disappeared.
          Thus, anything that can only be used once could be easily added to this Game.
All these Classes have the corresponding Factories to build them for others.

--------------------------------------------------
                          Character Design Pattern
Character <---extends Hero    <---extends Tank & Warrior & Caster  <---------------------|
          <---extends Monster <---extends MonsterCaster & MonsterFighter & Dragon <------|-----Produce-----Factories

Character is the most general Class for all characters in this game. Defines base attributes.
Hero defines general Hero attributes and methods with no specialist. All its children Class could define some unique
          skills(Like Tank has high chance to get attack).
Monster defines general Monster attributes and methods, it can be extended by multiple ways. Here I depart Monster by
          MonsterCaster(Use Magic Power), MonsterFighter(Use Physical Attack), Dragon(Cause damage with magic and physic)
All these Classes have the corresponding Factories to build them for others.

--------------------------------------------------
                          Cell Design Pattern
RPGCell <---extends BossCell & DangerousCell & InaccessibleCell & MarketCell & SafeCell

RPGCell defines general Cell methods in map. When Hero enter one cell, cell will auto call cellFunction() method.
BossCell will call the Boss Battle.
DangerousCell may call the usual Battle between Heroes and Monsters.
MarketCell will call the Entering Market method.

--------------------------------------------------
                          BattleField Design
Auto Create Monsters based on Heroes.
Has Two types of battle, Boss battle and usual battle.

---------------------------------------------------
                          Market Design
Buy and Sell between player and market.
Using bag and money from player.

---------------------------------------------------
                          Player Design
Have one bag and some Heroes.
Only game logic method is to lookup bag.

------------------------------------------------------------------------------------------------------------------------

Thank you so much for reading!