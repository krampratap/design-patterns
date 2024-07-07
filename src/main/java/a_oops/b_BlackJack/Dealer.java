package a_oops.b_BlackJack;

class Dealer extends Player {
    private int targetScore;

    public Dealer(Hand hand) {
        super(hand);
        this.targetScore = 17;
    }

    public void updateTargetScore(int score) {
        this.targetScore = score;
    }

    @Override
    public boolean makeMove() {
        return this.getHand().getScore() < this.targetScore;
    }
}
