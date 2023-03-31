import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Arena
{
    private Avatar player;
    private Monster monster;
    private int winCount = 0;

    public Monster randomizer()
    {
        List<Monster>monsters = new ArrayList<>();
        monsters.add(new Monster(new Random().nextInt(10,30),
                new Random().nextInt(5,30),
                new Random().nextInt(15,60)));
        monsters.add(new Boss(new Random().nextInt(35,70),
                new Random().nextInt(10,30),
                new Random().nextInt(20,75)));
        int number = new Random().nextInt(1,100);
        if (number <= 40)
            return monsters.get(0);
        else
            return monsters.get(1);
    }
    public Arena(Avatar player)
    {
        this.player = player;
        this.monster = randomizer();
        if (winCount == 4)
        {
            this.monster = new Boss(400,150,70);
        }

    }

    public void fight() throws InterruptedException {

        String ans;
        do
        {
            this.monster = randomizer();
            if (monster instanceof Boss boss)
                System.out.println("Boss has appeared !!! \nand his name is " + boss.getTittle());
            System.out.println("Fight begins !");
            Scanner scanner = new Scanner(System.in);
            while (player.isAlive() && monster.isAlive()) {
                System.out.println("Choose your next step \n"
                        + "1. Attack   2. Check your bag and equip an item     3. Heal");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.println("Player attacks !");
                    monster.hurt(player.attack());
                    Thread.sleep(1000);
                } else if (choice == 2) {
                    System.out.println("\nChoose item you want to use and write its name");
                    player.displayBag();
                    String name = scanner.next();
                    player.getFromBackpack(name);
                    Thread.sleep(1000);
                } else if (choice == 3) {
                    if (player.isInBag("healing potion")) {
                        player.getFromBackpack("healing potion");
                        player.attack();
                    } else
                        System.out.println("No more healing potions");
                    Thread.sleep(1000);
                } else
                    System.out.println("Wrong action taken !");
                System.out.println("Monster attacks !");
                player.hurt(monster.attack());
                System.out.println("You have " + player.getHealth() + " health");
                System.out.println("Monster has " + monster.getHealth() + " health\n");
                Thread.sleep(1000);
            }
            if (player.isAlive())
            {
                Random random = new Random();
                Weapon[] weapon = {
                        new Weapon("excalibur", 10, 250, 10),
                        new Weapon("ozymandis", 5, 600, 1),
                        new Axe("belmond", 15, 120, 60),
                        new Spear("deciver", 8, 200, 70)
                };
                System.out.println("Player has won");
                if (monster instanceof Boss) {
                    int ran = random.nextInt(0, 3);
                    System.out.println("You receive a special weapon !!!");
                    System.out.println(weapon[ran]);
                    player.addToBackpack(weapon[ran]);
                }
                winCount++;

            }
            else if (monster.isAlive())
                System.out.println("Monster killed you :(");
            else
                System.out.println("Draw");
            System.out.println("Want to continue ?");
            ans = scanner.next();
        } while (ans.equals("yes"));
    }
}
