Name: Junyi Huang               TEAMMATES:      Name: Hantian Liu               Name: Aditya Pal
BUID: U57383185                                 BUID: U49252828                 BUID: U93001700
Email: gawain7@bu.edu                           Email: htliu@bu.edu             Email: paditya@bu.edu

Thank you for grading and reading this long readme. 

Run Instruction : 1.make sure you are in the "src" folder or super folder of "src" 2. run "javac GameLauncher.java" 3 run "java GameLauncher"

*** We Implement Colorful words and Background in our Code. Please make sure you could run java with colors. ***
*** If you are in windows, both Cmder and Git Bash could run with colors well!                               ***

( IF there are errors with sound, please open GameLauncher.java and switch "m.runWithBGM()" to "m.run()". )

------------------------------------------------------------------------------------------------------------------------
Game Rules Description:
Almost the same as the Assignment's game rules. But I changed some rules. Here are the differences:


1. When your screen is showing the map, you can move, exit game, look up Heroes' information and bag at any rounds.
   And when you look up bag, you could select one of Items in bag to use, like drinking potions and switching Weapons and Armories.

2. Any Characters in this game including Hero and Monster all have the same attributes below:
   HP: Health Points.
   MP: Mana Points
   AD: Attack Damage, means ability of physical attack.
   AP: Ability power, means ability of magical attack.
   AR: Attack resist, means ability of defensing attack damage, useless to magical attack.
   MR: Magic resist, means ability of defensing magical attack, useless to physical attack.

3. You could only select these three types of Heroes.
   Tank: High Health Point and High defense.  Warrior: High Attack Damage.  Caster: High Ability Power
   You can repeatedly select the same type of Heroes, but up to three Heroes at most.

4. When a Hero is in a Hero Nexus, you can buy anything if the Hero's money is enough regardless the level requirement.
   But When you want to use one Item, if a Hero doesn't meet the item's level requirement, the Hero cannot use it.

All the rest of my Game Rules are the same as Assignment's Description.


------------------------------------------------------------------------------------------------------------------------
Class Description:
General :
                                                                    TeamMonster <------------|
                    |<------- Bag <-----|                                                    |
 Item <---Contain---|-------------------|<---Contain--- Hero <-----Contain--- TeamHero <-----|
                    |                                                                        |
                    |---------Market <----USE---RPGCell <---Contain--- Map <-----------------|----Contain---LegendsValor
                                                                       player <--------------|


Legends have one Player, one Map, one Team of Heroes and one Team of Monsters.
TeamHero has some Heroes, TeamMonster has some Monsters.
Hero has one bag.
Bag has some items. Items can be used by Hero.
Market also has some items. Item can be sold and bought between Hero's bag and market.
Map has some RPGCells. When Heroes come into one Cell, Legends will call the cellFunction in that Cell.

---------------------------------------------------
                          LegendsValor Design

<<Playable>> <---implement--- LegendsValor ---Contain---> SoundFactory---implement---> <<PlayableWithBGM>>

LegendsValor is a basic game Class that can be played. So we create Interface <Playable> which defines basic methods of playable game.
SoundFactory is a Class that help Playable game to play with background music. So we create Interface <PlayableWithBGM> which defines basic add-music methods corresponding <Playable>
(In the SoundFactory Class, we create an Audio Input Stream,using a clip of music. And then open the clip and start with loop)

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
RPGCell <---extends BushCell & CaveCell & InaccessibleCell & KouLouCell & SafeCell
        <---extends NexusCell <---extends HeroNexusCell & Monster NexusCell

RPGCell defines general Cell methods in map. When Hero enter one cell, cell will auto call inCellFunction() method, and call outCellFunction() when Hero go out.
BushCell & CaveCell & KouLouCell are used to improve one of Hero's attributes.
NexusCell defines common methods and attributes of Nexus, currently no content inside, but it's convenient to add some common things of Hero & Monster Nexus.
HeroNexusCell defines the different processes base on different situations. When Hero enter the HeroNexusCell, it will call the market.  When Monster enter here, it will add lose decision to system.
MonsterNexusCell is similar to HeroNexusCell. But No extra process for Monster.

--------------------------------------------------
                          Team Design Pattern
Team <---extends TeamHero & TeamMonster

Team defines general Team methods and attributes.
TeamHero has a list of Heroes
TeamMonster has a list of Monsters
---------------------------------------------------
                          Market Design

Buy and Sell between Hero and market.
Using bag and money from Hero.

------------------------------------------------------------------------------------------------------------------------

Thank you so much for reading!