

public class Main
{
    public static void main(String[] args)
    {

       Avatar avatar = new Avatar("War",120,100);
       avatar.setHand(new Weapon("Sword",12,100,20));
       avatar.addToBackpack(new Potion("healingPotion",10,100));
       avatar.addToBackpack(new Axe("dom",20,90,20));
       Arena arena = new Arena(avatar);
       try
       {
            arena.fight();
       }
       catch (Exception exception)
       {
            exception.printStackTrace();
       }

    }
}
