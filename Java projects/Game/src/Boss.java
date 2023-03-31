import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Boss extends Monster
{
    private String tittle;


    public String tittleMaker()
    {
        List<String> tittles = new ArrayList<>();
        tittles.add("Maneater");
        tittles.add("VolkGraf");
        tittles.add("TreeLord");
        Random random = new Random();
        int num = random.nextInt(0,2);
        if (num == 0)
            return tittles.get(0);
        if (num == 1)
            return tittles.get(1);
        else
            return tittles.get(2);
    }
    public Boss(int health, int attackPower, int attackChance)
    {
        super(health, attackPower, attackChance);
        this.tittle = tittleMaker();
    }


    @Override
    public int getHealth()
    {
        if (tittle.equals("Maneater"))
            return super.getHealth() - 25;
        if (tittle.equals("VolkGraf"))
            return super.getHealth() - 30;
        else
            return super.getHealth() + 10;
    }

    @Override
    public int attack()
    {
        if (tittle.equals("Maneater"))
            return super.attack() + 35;
        if (tittle.equals("VolkGraf"))
            return super.attack() + 50;
        else
            return super.attack() + 10;
    }

    public String getTittle()
    {
        return tittle;
    }

    @Override
    public void setTittle(String tittle)
    {
        this.tittle = tittle;
    }
}
