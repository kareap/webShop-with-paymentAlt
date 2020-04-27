import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardGame {
    Scanner scanner = new Scanner(System.in);
    List<PlayingCard> playersHand = new ArrayList<>();
    List<PlayingCard> dealersHand = new ArrayList<>();
    boolean play = true;
    ArrayList<PlayingCard> aceList = new ArrayList<>();

    public static void main(String[] args) {
        CardGame cardGame = new CardGame();
        cardGame.showMenu();
    }

    void showMenu() {
        System.out.println("------------------------ BLACK JACK ------------------------");
        System.out.println("                      (1)-Play Game");
        System.out.println("                      (2)-Show Game Rules");
        System.out.println("                      (3)-Quit Game");
        int menuChoice = scanner.nextInt();
        String fixNextIntProblem = scanner.nextLine();

        if (menuChoice == 1) {
            playGame();
        } else if (menuChoice == 2) {
            showRules();
        } else if (menuChoice == 3) {
            System.out.println("You ended the game");
        }
    }

    void playGame() {
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffleDeck(deck);

        pickDealersHand(deck);
        faceCardCheck(dealersHand);
        pickPlayersHand(deck);
        faceCardCheck(playersHand);
        System.out.println("The dealer dealing two cards for you and two cards for henself");
        printStatusHands();

        while (play) {
            System.out.println("-------------------------------------------------------------\n" +
                    "Do you want to HIT (pick a new card) or STAND (happy with your hand)\n" +
                    "HIT(1)\n" +
                    "STAND(2)");
            int playChoice = scanner.nextInt();
            String fixNextIntProblem = scanner.nextLine();

            if (playChoice == 1) {
                PlayingCard newCard = deck.pickCard();
                if (newCard.getValue() == 1) {
                    aceList.add(newCard);
                }
                playersHand.add(newCard);
                faceCardCheck(playersHand);
                printStatusHands();
            } else if (playChoice == 2) {
                System.out.println("You chose to STAND");
                System.out.println("\n Now its the dealer's turn to play...\n");
                System.out.println("The dealers cards are: ");
                for (int i = 0; i < dealersHand.size(); i++) {
                    System.out.println(" card " + (i + 1) + ": " + dealersHand.get(i));
                }
                if (sumHand(dealersHand)>= 17) {
                    System.out.println("The sum of the dealers hand is more than 17 and the dealer must STAND");
                }
                else {
                    System.out.println("The sum of the dealers hand is less than 17 and the dealer can pick a card...");
                    dealersHand.add(deck.pickCard());
                    faceCardCheck(dealersHand);
                    sumHand(dealersHand);
                    System.out.println("The dealer picks "+ dealersHand.get(2).toString());
                }
                setWinner();
                play = false;
            }
        }
    }

    void pickPlayersHand(Deck deck) {
        for (int i = 0; i < 2; i++) {
            playersHand.add(deck.pickCard());
            if (playersHand.get(i).getValue() == 1) {
                aceList.add(playersHand.get(i));
            }
        }
    }

    void pickDealersHand(Deck deck) {
        PlayingCard dealersCard1 = deck.pickCard();
        dealersCard1.setHidden(true);
        dealersHand.add(dealersCard1);
        PlayingCard dealersCard2 = deck.pickCard();
        dealersHand.add(dealersCard2);
    }

    void printStatusHands() {
        System.out.println(".............................................................." +
                "\nDealer's hand: \n card 1: is Hidden \n card 2: " + dealersHand.get(1) +
                "\n..............................................................\n" +
                "Your hand: ");
        for (int i = 0; i < playersHand.size(); i++) {
            System.out.println(" card " + (i + 1) + ": " + playersHand.get(i));
        }
        System.out.println("The sum of your hand is: "+sumHand(playersHand));
    }

    void faceCardCheck(List<PlayingCard> hand) {
        for (PlayingCard card : hand) {
            if (card.getValue() == 11 || card.getValue() == 12 || card.getValue() == 13) {
                card.setGameValue(10);
            }
        }
    }

    int sumHand(List<PlayingCard> hand) {
        int sum = 0;
        for (int i = 0; i < hand.size(); i++) {
            sum = sum + (hand.get(i).getGameValue());
        }
        if (sum > 21 && aceList.size() < 1) {
            System.out.println("\nYour sum is > 21!");
            System.out.println("You LOST!!!\n");
            play = false;
            showMenu();
        } else if (sum > 21 && aceList.size() > 1) {
            for (int i = 0; i < hand.size(); i++) {
                if (i == 0){
                    continue;
                }
                else if (hand.get(i).getValue() == 1) {
                    hand.get(i).setGameValue(1);
                }
            }
        }
        sum = 0;
        for (int i = 0; i < hand.size(); i++) {
            sum = sum + (hand.get(i).getGameValue());
            if (sum > 21) {
                System.out.println("\nYour sum is > 21!");
                System.out.println("You LOST!!!\n");
                play = false;
                showMenu();
            }
        }
            return sum;
        }


    void setWinner() {
        System.out.println("\nYour sum is: "+ sumHand(playersHand));
        System.out.println("The dealers sum is: "+ sumHand(dealersHand));
        if (sumHand(dealersHand) > sumHand(playersHand)) {
            System.out.println("\n YOU LOST...");
        }
        else {
            System.out.println("\n       ******     " +
                    "\n **** YOU WON!!! ****" +
                    "\n        *****     ");
        }
    }

    void showRules() {
        System.out.println("Målet med spillet er å få 21, eller nærmere denne poengsummen enn dealeren. " +
                "Både spiller og dealer vil få to kort hver. Spilleren vil derimot kun se det ene kortet til " +
                "dealeren, mens det andre kortet vil ligge vendt ned mot bordet. Heretter vil spilleren måtte " +
                "velge om han skal ha flere kort, eller «stå» med kortene han allerede har. Dealeren må alltid " +
                "stå på 17, noe som betyr at hvis han havner på 17 eller over, vil han ikke kunne trekke flere kort." +
                "Hvis den samlede verdien på kortene er over 21 har spilleren tapt" +
                "Dealeren må stå på totalverdi 17 eller mer" +
                "Et ess med 10 eller et billedkort er en «ekte» blackjack");
    }
}
