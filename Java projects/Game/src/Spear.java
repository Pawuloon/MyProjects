import java.util.Random;

public class Spear extends Weapon
{
    public Spear(String name, int weight, int baseAttack, int bonusAttack)
    {
        super(name, weight, baseAttack, bonusAttack);
        baseAttack +=  new Random().nextInt(50,100);
        setBaseAttack(baseAttack);
    }
}
