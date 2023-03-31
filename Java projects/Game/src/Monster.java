import java.util.Random;

public class Monster
{
    private int health;
    private final int attackPower;
    private final int attackChance;


    public Monster(int health, int attackPower, int attackChance)
    {
        this.health = health;
        this.attackPower = attackPower;
        this.attackChance = attackChance;
    }

    public int attack()
    {
        int chance = new Random().nextInt(1,100);
        if (this.attackChance > chance)
            return this.attackPower;
        else
            System.out.println("Monster attack failed");
        return 0;
    }

    public int getHealth()
    {
        return health;
    }

    public boolean isAlive()
    {
        return this.health > 0;
    }

    public void hurt(double damage)
    {
        this.health -= damage;
    }

}
