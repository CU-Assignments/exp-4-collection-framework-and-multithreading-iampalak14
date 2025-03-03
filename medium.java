import java.util.*;

class Card {
    String symbol;
    String value;

    Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public String toString() {
        return symbol + " " + value;
    }
}

public class medium {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Card>> cardCollection = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Card\n2. Find Cards by Symbol\n3. Display All Cards\n4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Card Symbol (e.g., Hearts, Spades): ");
                    String symbol = sc.nextLine();
                    System.out.print("Enter Card Value (e.g., Ace, 10, King): ");
                    String value = sc.nextLine();

                    cardCollection.putIfAbsent(symbol, new ArrayList<>());
                    cardCollection.get(symbol).add(new Card(symbol, value));
                    System.out.println("Card added!");
                    break;

                case 2:
                    System.out.print("Enter Symbol to find cards: ");
                    String searchSymbol = sc.nextLine();
                    if (cardCollection.containsKey(searchSymbol)) {
                        System.out.println("Cards in " + searchSymbol + ": " + cardCollection.get(searchSymbol));
                    } else {
                        System.out.println("No cards found for this symbol.");
                    }
                    break;

                case 3:
                    System.out.println("All Cards:");
                    for (String key : cardCollection.keySet()) {
                        System.out.println(key + ": " + cardCollection.get(key));
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
