import java.util.Random;
import java.util.Scanner;

public class rzutMoneta {
    public static void main(Player player) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String win, lose;
        int number;
        char response;
        int choice;
        double amount = 0;
        boolean ready = false, play = true;
        char sure;

        if(player.getMoney() > 0) {
            System.out.println("\t\t\tWybrałeś grę Rzut monetą\t\t\t\nInstrukcja :\n" +
                    "-Musisz postawić na orła albo reszkę\n" +
                    "-Każda z opcji ma 50% szans na wygraną\n" +
                    "Proste prawda? :D\n");
        }
        try {
            while((play && player.getMoney() > 0)) {
                System.out.println("\nTwoje saldo = " + player.getMoney());
                while (!ready) {

                    System.out.print("Ile chcesz postawic: ");
                    amount = scanner.nextDouble();
                    if (amount > player.getMoney()) {
                        System.out.println("Nie masz tyle.");
                    } else if (amount == player.getMoney()) {
                        System.out.println("Jesteś pewien? tak [y] nie [n]");
                        sure = scanner.next().charAt(0);
                        if (sure == 'y' || sure == 'Y') {
                            ready = true;
                        }
                    } else {
                        ready = true;
                    }

                }
                ready = false;

                System.out.print("[0]Orzeł\n[1]Reszka\n");
                choice = -1;
                while (choice < 0 || choice > 2) {
                    System.out.print("Postaw  pieniadze na: ");
                    choice = scanner.nextInt();

                    number = random.nextInt(100 ) + 1;
                    if (choice == 0) {
                        win = "Orzeł";
                        lose = "Reszka";
                    } else {
                        win = "Reszka";
                        lose = "Orzeł";
                    }
                    if (number <= 45) {
                        System.out.println("Wypadło: " + win + "\n");
                        System.out.println("Wygrałeś!! $" + amount + "\n");
                        player.setMoney(player.getMoney() + amount);
                        System.out.println("Stan konta $" + player.getMoney() + "\n");
                    } else {
                        System.out.println("Wypadło: " + lose + "\n");
                        System.out.println("Przegrałeś:[ $" + amount + "\n");
                        player.setMoney(player.getMoney() - amount);
                        System.out.println("Stan konta $" + player.getMoney() + "\n");
                        if (player.getMoney() <= 0) {
                            System.out.println("BANKRUT\n");
                            break;
                        }

                    }
                    System.out.print("\nChcesz zagrac jeszcze raz? (y/n) \n");
                    response = scanner.next().charAt(0);
                    if (response == 'n' || response == 'N') {
                        play = false;
                    }
                }
            }
        }catch(Exception exception){
            System.out.println("Error");
            scanner.next();
        }
    }
}