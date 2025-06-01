package library;

import datastructures.lists.CustomLinkedList;
import datastructures.lists.CustomArrayList;

public class Member {
    private String memberId;
    private String name;
    private CustomLinkedList<Transaction> transactions;
    private CustomArrayList<String> borrowedBooks;

    public Member(String memberId, String name) {
        if (memberId == null || name == null) {
            throw new NullPointerException("Member ID and name cannot be null");
        }
        this.memberId = memberId;
        this.name = name;
        this.transactions = new CustomLinkedList<>();
        this.borrowedBooks = new CustomArrayList<>();
    }


    public void borrowBook(String isbn) {
        if (isbn == null) {
            throw new NullPointerException("ISBN cannot be null");
        }
        if (!borrowedBooks.contains(isbn)) {
            borrowedBooks.add(isbn);
        }
    }

    public void returnBook(String isbn) {
        if (isbn == null) {
            throw new NullPointerException("ISBN cannot be null");
        }
        borrowedBooks.remove(isbn);
    }

    public boolean hasBook(String isbn) {
        if (isbn == null) {
            throw new NullPointerException("ISBN cannot be null");
        }
        return borrowedBooks.contains(isbn);
    }


    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public void addTransaction(Transaction transaction) {
        if (transaction == null) {
            throw new NullPointerException("Transaction cannot be null");
        }
        transactions.addLast(transaction);
    }

    public Transaction getLastTransaction() {
        if (transactions.isEmpty()) {
            return null;
        }
        return transactions.getLast();
    }

    public int getTransactionCount() {
        return transactions.size();
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", borrowedBooksCount=" + borrowedBooks.size() +
                '}';
    }
}