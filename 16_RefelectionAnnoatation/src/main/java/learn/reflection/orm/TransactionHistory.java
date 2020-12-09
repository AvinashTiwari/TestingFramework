package learn.reflection.orm;

import learn.reflection.orm.annotation.Column;
import learn.reflection.orm.annotation.PrimaryKey;

public class TransactionHistory {

    @PrimaryKey
    long transactionId;
    @Column
    int accountNumber;
    @Column
    String name;
    @Column
    String transactionType;
    @Column
    double amount;

    public TransactionHistory(  int accountNumber, String name, String transactionType, double amount) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.name = name;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public TransactionHistory() {
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "transactionId=" + transactionId +
                ", accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                '}';
    }
}
