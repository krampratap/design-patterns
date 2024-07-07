package a_oops.d_Bank;

class Withdrawal extends Transaction {
    private final int amount;

    public Withdrawal(int customerId, int tellerId, int amount) {
        super(customerId, tellerId);
        this.amount = amount;
    }

    @Override
    public String getTransactionDescription() {
        return "Teller " + getTellerId() + " withdrew " + amount + " from account " + getCustomerId();
    }
}
