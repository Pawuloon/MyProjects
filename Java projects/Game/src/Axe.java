import java.util.Random;

public class Axe extends Weapon
{
    public Axe(String name, int weight, int baseAttack, int bonusAttack)
    {
        super(name, weight, baseAttack, bonusAttack);
        baseAttack +=  new Random().nextInt(20,100);
        setBaseAttack(baseAttack);
    }
}
