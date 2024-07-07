package a_ObjectOriented.b_BlackJack;

import java.util.Scanner;

class GameRound {
    private static final Scanner input = new Scanner(System.in);
    private final UserPlayer player;
    private final Dealer dealer;
    private final Deck deck;

    public GameRound(UserPlayer player, Dealer dealer, Deck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
    }

    private int getBetUser() {
        System.out.print("Enter a bet amount: ");
        return input.nextInt();
    }

    private void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            player.addCard(deck.draw());
            dealer.addCard(deck.draw());
        }
        System.out.println("Player hand:");
        player.getHand().print();
        Card dealerCard = dealer.getHand().getCards().get(0);
        System.out.println("Dealer's first card:");
        dealerCard.print();
    }

    private void cleanupRound() {
        player.clearHand();
        dealer.clearHand();
        System.out.println("Player balance: " + player.getBalance());
    }

    public void play() {
        deck.shuffle();

        if (player.getBalance() <= 0) {
            System.out.println("Player has no more money =)");
            return;
        }
        int userBet = getBetUser();
        player.placeBet(userBet);

        dealInitialCards();

        // User makes moves
        while (player.makeMove()) {
            Card drawnCard = deck.draw();
            System.out.println("Player draws " + drawnCard.getSuit() + " " + drawnCard.getValue());
            player.addCard(drawnCard);
            System.out.println("Player score: " + player.getHand().getScore());
        }
        if (player.getHand().getScore() > 21) {
            System.out.println("Player loses");
            cleanupRound();
            return;
        }

        // Dealer makes moves
        dealer.updateTargetScore(player.getHand().getScore());
        while (dealer.makeMove()) {
            dealer.addCard(deck.draw());
        }

        // Determine winner
        int dealerScore = dealer.getHand().getScore();
        int playerScore = player.getHand().getScore();
        if (dealerScore > 21) {
            System.out.println("Player wins");
            player.receiveWinnings(userBet * 2);
        } else if (dealerScore > playerScore) {
            System.out.println("Player loses");
        } else {
            System.out.println("Game ends in a draw");
            player.receiveWinnings(userBet);
        }
        cleanupRound();
    }
}
