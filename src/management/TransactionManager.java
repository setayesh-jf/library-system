package management;

import datastructures.lists.CustomArrayList;
import library.Transaction;

public class TransactionManager {
    private CustomArrayList<Transaction> transactions;

    public TransactionManager() {
        this.transactions = new CustomArrayList<>();
    }

    public Transaction addTransaction(String bookTitle, String memberName, String type) {
        String transactionId = "TXN-" + System.currentTimeMillis();
        Transaction transaction = new Transaction(transactionId, bookTitle, memberName, type);
        transactions.add(transaction);
        return transaction;
    }

    public Transaction getTransactionByIndex(int index) {
        if (index < 0 || index >= transactions.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return transactions.get(index);
    }
}