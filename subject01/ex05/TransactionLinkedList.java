package ex05;

import java.util.UUID;

public class TransactionLinkedList implements TransactionListinreface {
    Node _head;
    int _size;
    Node _last;

    static class Node {
        Transaction data;
        Node next;

        Node(Transaction d) {
            data = d;
            next = null;
        }
        
        public Transaction getData() {return this.data; }
    }

    public int getSize() { return this._size; }
    
    public void printList() {
        Node tmp = this._head;

        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    @Override
    public void addTransaction(Transaction data) {
        Node new_node = new Node(data);

        if (this._head == null) {
            this._head = new_node;
            this._last = this._head;
            this._size++;
        } else {
            this._last.next = new_node;
            this._last = this._last.next;
            this._size++;
        }
    }

    @Override
    public void removeTransactionById(UUID ID) {
        try {
            if (this._head == null) {
                return ;
            }
            
            if (this._head.data.getTranID() == ID) {
                this._head = this._head.next;
                this._size--;
                return ;
            }
            
            Node current = this._head;
            Node tmp = null;
            while (current != null && current.data.getTranID() != ID) {
                tmp = current;
                current = current.next;
            }
            if (current != null) {
                tmp.next = current.next;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                this._last = tmp;
                this._size--;
            }
        } catch (TransactionNotFoundException e) {
            throw new TransactionNotFoundException("UUID NOT FOUND");
        }
    }

    public Node getTransactionById(UUID ID) {
        try {
            if (this._head == null) {
                return null;
            }
            
            if (this._head.data.getTranID().equals(ID)) {
                return this._head;
            }
            
            Node current = this._head;
            while (current != null && (!current.data.getTranID().equals(ID))) {
                current = current.next;
            }
            System.out.println(current);
            if (current != null) {
                return current;
            }
        } catch (TransactionNotFoundException e) {
            throw new TransactionNotFoundException("UUID NOT FOUND");
        }
        return null;
    }

    @Override
    public Transaction[] transformToArray() {
        if (this._size == 0) {
            return null;
        }
        Transaction[] ret = new Transaction[this._size + 1];
        Node tmp = this._head;

        for (int i = 0; i < this._size; i++) {
            ret[i] = tmp.data;
            tmp = tmp.next;
        }
        ret[this._size] = null;
        return ret;
    }
}
