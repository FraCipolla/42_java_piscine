package ex03;

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
        
    }
    
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

    @Override
    public Transaction[] transformToArray() {
        if (this._size == 0) {
            return null;
        }
        Transaction[] ret = new Transaction[this._size];
        Node tmp = this._head;

        for (int i = 0; i < this._size; i++) {
            ret[i] = tmp.data;
            tmp = tmp.next;
        }
        return ret;
    }
}
