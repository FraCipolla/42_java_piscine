package ex01;

/**
 * DictionaryList
 */
public class DictionaryList {
    private Node _head;
    private int  _size;
    /**
     * Node
     */
    public class Node {
        String _data;
        Node _next;

        Node(String data) {
            this._data = data;
            this._next = null;
        }
        Node(Node node) {
            this._data = node._data;
            this._next = node._next;
        }
    }

    int getSize() { return this._size; };

    public void insert(String data) {
        Node new_node = new Node(data);
        
        if (this._head == null) {
            this._head = new_node;
            this._size++;
            return ;
        }
        Node tmp = this._head;
        Node pred = this._head;
        while (tmp._next != null && data.compareTo(tmp._data) > 0 && !tmp._next._data.equals(data)) {
            pred = tmp;
            tmp = tmp._next;
        }
        if (tmp._next != null) {
            if (data.compareTo(tmp._data) < 0) {
                if (pred._data == this._head._data) {
                    new_node._next = pred;
                    this._head = new_node;
                    this._size++;
                    return ;
                }
                new_node._next = pred._next;
                pred._next = new_node;
                this._size++;
                return ;
            }
        } else {
            tmp._next = new_node;
            this._size++;
        }
    }

    public void printList() {
        System.out.println("Printing list");
        System.out.println("-----------------------------------------");
        Node tmp = this._head;

        while (tmp != null) {
            if (tmp._next != null) {
                System.out.print(tmp._data + ", ");
            } else {
                System.out.println(tmp._data);
            }
            tmp = tmp._next;
        }
        System.out.println("-----------------------------------------");
    }

    public String[] toArr() {
        String[] ret = new String[this._size];
        Node tmp = this._head;

        int i = 0;
        while (tmp != null) {
            ret[i++] = tmp._data;
            tmp = tmp._next; 
        }

        return ret;
    }
}