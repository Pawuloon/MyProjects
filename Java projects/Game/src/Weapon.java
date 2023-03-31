public class Weapon extends Stuff
{
   private int baseAttack;
   private int bonusAttack;

    public Weapon(String name, int weight, int baseAttack, int bonusAttack)
    {
        super(name, weight);
        this.baseAttack = baseAttack;
        this.bonusAttack = bonusAttack;
    }


    public int getBaseAttack()
    {
        return baseAttack;
    }

    public int getBonusAttack()
    {
        return bonusAttack;
    }

    public void setBaseAttack(int baseAttack)
    {
        this.baseAttack = baseAttack;
    }
}
