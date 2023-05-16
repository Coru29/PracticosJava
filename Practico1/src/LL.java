
public class LL<T extends  Comparable<T>> implements Lista<T>{

    Node<T> head;


    @Override
    public void add(T value) {

        Node<T> nuevoNodo = new Node<>();
        nuevoNodo.value = value;

        //si la lista esta vacia
        nuevoNodo.next = null;
        if(head == null){
            head = nuevoNodo;
        }
        //si la lista no esta vacia
        else{
            //mientras que no este parado en el ultimo sigo avanzando
            Node<T> tempNode = head;
            while (tempNode.next != null){
                tempNode = tempNode.next;
            }
            //una vez ya estoy en el ulimo, en el next pongo el q quiero poner
            tempNode.next = nuevoNodo;
        }

    }

    @Override
    public void remove(int position) {
        Node<T> tempNode = head;

        //recorro la lista y me paro en el anterior al que quiero eliminar
        for(int i = 0; i < position-1; i++){
            tempNode = tempNode.next;
        }
        //el puntero del anterior pasa a apunutar al proximo del q quiero elinimar, entonces lo pasa de largo
        tempNode.next = tempNode.next.next;

    }

    @Override
    public void get(int position) {
        Node<T> tempNode = head;

        //recorro la lista y me paro en el anterior al que quiero eliminar
        for(int i = 0; i != position; i++){
            tempNode = tempNode.next;
        }
        System.out.println("en el indice " +position+ " esta el valor " +tempNode.value);
    }

    @Override
    public void find(T value){
        Node<T> tempNode = head;

        if (tempNode.value == value) System.out.println("el valor "+value +" es el head!");

        else{
            int i = 0;
            boolean esta = false;
            while (tempNode.next != null){

                if (tempNode.value == value){
                    System.out.println("el valor " +value+ " esta en la posicion " + i);
                    esta = true;
                    break;
                }else{
                    tempNode = tempNode.next;
                    i++;
                }
            }
            if (!esta) System.out.println("el valor " + value+ " no esta! :(");


        }

    }

    @Override
    public void addFirst(T value) {
        Node<T> nuevoNodo = new Node<>();
        nuevoNodo.value = value;

        nuevoNodo.next = head;
        head = nuevoNodo;
    }

    @Override
    public void addAt(T value, int position) {
        Node<T> nuevoNodo = new Node<>();
        nuevoNodo.value = value;
        nuevoNodo.next = null;

        Node<T> tempNode = head;

        //en caso de q la poscicion sea 0
        if(position == 0){
            addFirst(value);

        }else{
            for(int i = 0; i < position-1; i++){
                tempNode = tempNode.next;
            }
            nuevoNodo.next = tempNode.next;
            tempNode.next = nuevoNodo;
        }

    }

    @Override
    public void addInOrder(T value) {
//        Node<T> tempNode = head;
//
//        Node<T> nuevoNodo = new Node<>();
//        nuevoNodo.value = value;
//
//        if (tempNode.value < nuevoNodo.value){
//            nuevoNodo.next = tempNode.next;
//            tempNode.next = nuevoNodo;
//        }
//        else{
//            while (tempNode.next != null){
//                if(tempNode.next.value < nuevoNodo.value){
//                    tempNode = tempNode.next;
//                }
//                tempNode = tempNode.next; // no se si este va, me marie, creo q no
//                nuevoNodo.next = tempNode.next;
//                tempNode.next = nuevoNodo;
//            }
//        }
    }

    @Override
    public void imprimir() {

        Node<T> temporaryNode = head;

        while (temporaryNode.next != null){
            System.out.print(temporaryNode.value + " --> ");
            temporaryNode = temporaryNode.next;
        }
        System.out.println(temporaryNode.value);
    }

    // -----  ------  -----  ------  -----  ------  -----  ------  -----  ------  -----  ------
    //aca arranca el main
    public static void main(String[] args) {
        LL<Integer> listita = new LL<>();



        //pruebo lo de añadir
        listita.add(1);
        listita.add(2);
        listita.add(3);
        listita.add(4);

        listita.imprimir();

        //pruebo el remove
        listita.remove(1);

        //pruebo el get
        listita.get(2);

        //pruebo el addFirst
        listita.addFirst(7);
        System.out.println();

        //pruebo el addAt
        listita.addAt(0, 0);
        System.out.println();
        listita.imprimir();
        //pruebo el esta
        listita.find(0);
        listita.find(7);
        listita.find(4);
        listita.find(45);


        // -----  ------  -----  ------  -----  ------  -----  ------  -----  ------  -----  ------
        // voy a intentar lo de insertar ordenadamente


    }
}





