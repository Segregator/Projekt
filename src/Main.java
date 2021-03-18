import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Player playerOne = new Player("Bartek",1000.00,18);
        rzutMoneta rzutMoneta = new rzutMoneta();
        Dice dice = new Dice();


        Scanner scanner = new Scanner(System.in);
        boolean stan = true;
        do{
            System.out.println("777WITAMY W KASYNIE777\nWybierz gre\n[0]Exit\n[1]Lucky12\n[2]Ruletka\n[3]Rzut Moneta\n|Twoje saldo = "
                    + playerOne.getMoney() + "|");
            String choice = scanner.next();
            switch (choice) {
                case "0" -> {
                    System.out.println("Exit");
                    stan = false;
                }

                case "1" -> {
                    dice.main(playerOne);
                }

                case "2" -> {
                    Ruletka.Kasyno(playerOne);
                }

                case "3"->{
                    rzutMoneta.main(playerOne);
                }

                default -> System.out.println("Błąd");
            }
        }while (stan);
    }
}