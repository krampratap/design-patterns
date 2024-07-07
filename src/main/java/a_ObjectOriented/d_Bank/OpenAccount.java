package a_ObjectOriented.d_Bank;

class OpenAccount extends Transaction {
    public OpenAccount(int customerId, int tellerId) {
        super(customerId, tellerId);
    }

    @Override
    public String getTransactionDescription() {
        return "Teller " + getTellerId() + " opened account " + getCustomerId();
    }
}
