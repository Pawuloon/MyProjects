public class Warrior extends Avatar
{

    public Warrior(String characterName, int health,int capacity)
    {
        super(characterName, health,capacity);
    }

    @Override
    public int attack()
    {
        if (getHand() instanceof Weapon weapon)
            return super.attack() + weapon.getBonusAttack();
        return 0;
    }
}
