import java.util.EmptyStackException;

public class stack<T extends Comparable<T>> implements MyStack<T>{

    public Node <T> head;
    @Override
    public void pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else{
            head = head.next;
        }

    }

    @Override
    public T top() throws EmptyStackException {
        if(isEmpty()){
//            throw new EmptyStackException();
            System.out.println("esta vacia master");

        } else if (head != null) {
            return head.data;
        }
        return null;
    }

    @Override
    public void push(T element) {
        Node<T> nuevoNodo = new Node<>();
        nuevoNodo.data = element;

        nuevoNodo.next = head;
        head = nuevoNodo;

    }

    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public void makeEmpty() {
        while (head !=null){
            pop();
        }

    }

    @Override
    public void imprimir() {
        Node<T> temporaryNode = head;

        while (temporaryNode.next != null){
            System.out.print(temporaryNode.data + " --> ");
            temporaryNode = temporaryNode.next;
        }
        System.out.println(temporaryNode.data);

    }

    // -----  ------  -----  ------  -----  ------  -----  ------  -----  ------  -----  ------
    //aca arranca el main

    public static void main(String[] args){
        stack<Integer> miStack = new stack<>();

        System.out.println("mi lista esta vacia? "+ miStack.isEmpty());
        System.out.println("el primer valor es " +miStack.top());

        System.out.println();

        miStack.push(2);
        miStack.push(3);
        miStack.push(34);
        System.out.println("mi lista esta vacia? "+ miStack.isEmpty());


        miStack.imprimir();
        System.out.println("el primer valor es " +miStack.top());

        miStack.pop();
        miStack.pop();

        miStack.imprimir();

        System.out.println();

        miStack.push(1);
        miStack.push(2);
        miStack.push(3);
        miStack.push(4);
        miStack.push(5);


        miStack.imprimir();
        miStack.makeEmpty();
        System.out.println( "mi lista esta vacia?" + miStack.isEmpty());


    }
}

