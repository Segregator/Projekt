import java.util.Random;
import java.util.Scanner;

public class Dice {
    public static void main(Player player) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int diceRollOne, diceRollTwo,diceTotal;
        double amount = 0;
        boolean ready = false, play = true;
        char sure, response;
        if(player.getMoney() > 0) {
            System.out.println("\t\t\tWybrałeś grę Lucky12\t\t\t\nInstrukcja\n" +
                    "-Aby wygrać musisz trafić kośćmi łączną sume 12 oczek. \n" +
                    "-Masz 8% szans na trafienie\n" +
                    "-Jeśli trafisz twój bet pomonoży sie 13 krotnie\n" +
                    "Powodzenia :D\n");
        }
        try {
            while((play && player.getMoney() > 0)) {
                System.out.println("\nTwoje saldo = " + player.getMoney());
                while (!ready) {

                    System.out.print("Ile chcesz postawic : ");
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

                diceRollOne = random.nextInt(6) + 1;
                diceRollTwo = random.nextInt(6) + 1;
                diceTotal = diceRollOne + diceRollTwo;

                System.out.println("Kość 1: " + diceRollOne);
                System.out.println("Kość 2: " + diceRollTwo);
                System.out.println("Total: " + diceTotal + "\n");

                if (diceTotal == 12) {
                    System.out.println("!!!!JACKOPOT!!!! ");
                    System.out.println("Wygrałeś $" + amount * 13 + "\n");
                    player.setMoney(player.getMoney() + amount * 13);
                    System.out.println("Stan konta $" + player.getMoney() + "\n");

                } else {
                    System.out.println("Przegrałeś :( Może następnym razem sie uda :D \n");
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
        } catch(Exception exception){
            System.out.println("Error");
            scanner.next();

        }
    }
}