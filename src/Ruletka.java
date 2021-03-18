import java.util.Random;
import java.util.Scanner;

public class Ruletka {
    public static void Kasyno(Player player) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        double amount = 0;
        int choice, win = 0, lose = 0, spin = 0;
        int number;
        int rouletteNum;
        int result;
        char response = 'y';
        int resultArr[] = new int[36];
        boolean ready = false, play = true;
        char sure;
        if(player.getMoney() > 0) {
            System.out.println("\t\t\tWybrałeś grę Ruletka\t\t\t\nInstrukcja\n" +
                    "Masz do wyboru 3 opcje :\n" +
                    "-parzyste + 100% $\n" +
                    "-nieparzyste +100% $\n" +
                    "-Liczba(wybierasz liczbe od 1-36) $ * 35");
        }
        try {
            while (play && player.getMoney() > 0) {
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

                System.out.print("0 - parzyste\n1 - nieparzyste\n2 - Liczba\n");
                choice = -1;

                while (choice < 0 || choice > 2) {
                    System.out.print("Postaw  pieniadze na :");
                    choice = scanner.nextInt();
                }

                number = 0;
                if (choice == 2) {
                    while (number < 1 || number > 36) {
                        System.out.print("Postaw pieniadze na liczbe(1-36): \n");
                        number = scanner.nextInt();
                    }
                }

                rouletteNum = random.nextInt(37);
                spin++;
                System.out.println("Wylosowana liczba: " + rouletteNum + "\n");

                if (choice == 2) {
                    if (rouletteNum == number)
                        result = 35;
                    else
                        result = 0;
                } else {
                    if (rouletteNum == 0 || rouletteNum % 2 != choice)
                        result = 0;
                    else
                        result = 1;
                }

                if (result > 0) {
                    System.out.println("!!Gratulacje Wygrałeś!!\n");
                    System.out.println("Wygrałeś : $" + result * amount + "\n");
                    player.setMoney(result * amount + player.getMoney());
                    System.out.println("Portfel :  $" + player.getMoney() + "\n");
                    win++;
                    resultArr[rouletteNum]++;
                } else {
                    System.out.println("Nie udało ci sie :[.\n");
                    System.out.println("Straciłes $" + amount + "\n");
                    player.setMoney(player.getMoney() - amount);
                    System.out.println("Portfel : $" + player.getMoney() + "\n");
                    lose++;
                    resultArr[rouletteNum]++;

                    if (player.getMoney() <= 0) {
                        System.out.println("BANKRUT\n");
                        break;
                    }
                }

                System.out.println("Zostało jeszcze :$" + player.getMoney() + "\n");
                System.out.println("Wygrałeś " + win + " gier.\n");
                System.out.println("Przegrałes " + lose + " gier.\n");
                System.out.println("Zakręciłeś juz " + spin + " razy.\n");
                System.out.print("Chcesz zagrac jeszcze raz? (y/n) \n");
                response = scanner.next().charAt(0);
                if (response == 'n' || response == 'N') {
                    play = false;
                }

            }
        } catch (Exception exception) {
            System.out.println("Error");
            scanner.next();
        }
    }
}