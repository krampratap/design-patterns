package a_ObjectOriented.b_BlackJack;


/*
    CardSuit
    Card
    Deck -- random, shuffle
    Player
        UserPlayer
        Dealer
    Hand - Each player will have a hand
    GameRound
 */
class ZBlackJack {
    public static void main(String[] args) {
        UserPlayer player = new UserPlayer(1000, new Hand());
        Dealer dealer = new Dealer(new Hand());
        while (player.getBalance() > 0) {
            new GameRound(player, dealer, new Deck()).play();
        }
    }
}
