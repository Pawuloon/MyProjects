
import java.util.Random;

public class Avatar
{
    private final String characterName;
    private int health;
    private Stuff hand;

    private final int capacity;

    private final Backpack backpack;

    public Avatar(String characterName, int health, int capacity)
    {
        this.characterName = characterName;
        this.health = health;
        this.hand = null;
        this.capacity = capacity;
        this.backpack = new Backpack();
    }

    
    public int getCapacity()
    {
        return capacity;
    }

    public void getFromBackpack(String name)
    {
        for (var a : backpack)
            if (a.getStuff().getName().equals(name))
            {
                if (!backpack.contains(a.getStuff()))
                {
                    System.out.println("There is no such item");
                }
                System.out.println("Item " + a.getStuff().getName() + " has been equipped");
                hand = a.getStuff();
                return;
            }

    }


    public boolean isInBag(String name)
    {
        for (var a : backpack)
            if (a.getStuff().getName().equals(name))
            {
                return true;
            }
        return false;
    }

    public void addToBackpack(Stuff stuff)
    {
        if (backpack.size() == capacity)
            System.out.println("Backpack full!");
        else
            backpack.add(new Backpack.Node(stuff));
    }
    public Backpack getBackpack()
    {
        return backpack;
    }

    public boolean isAlive()
    {
        return this.health > 0;
    }

    public int attack()
    {
        if (this.hand != null && hand instanceof Weapon weapon)
        {
            int a = new Random().nextInt(1,100);
            if (a > 30)
            {
                System.out.println("Attack successful");
                return weapon.getBaseAttack(); // Base weapon attack
            }
            else
            {
                System.out.println("Attack failed");
                return 0;
            }

        }
        else if (this.hand != null && hand instanceof Potion potion)
        {
            System.out.println("You have been healed \n");
            this.health += potion.getHealAmount();
            backpack.remove(potion);
            this.hand = null;
            return 0;
        }
        return 0;
    }
    public String getCharacterName()
    {
        return characterName;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public Stuff getHand()
    {
        return hand;
    }

    public void setHand(Stuff hand)
    {
        this.hand = hand;
    }

    public void hurt(double damage)
    {
        this.health -= damage;
    }
    public void displayBag()
    {
        if (backpack.size() != 0)
        {
            System.out.println("Contents of your Backpack");
            backpack.print();
        }
    }

    @Override
    public String toString()
    {
        return this.characterName + " " + this.health + " " + this.hand;
    }
}
