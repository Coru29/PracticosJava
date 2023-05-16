
public interface Lista<T> {
    void add (T value);
    void remove (int position);
    void get (int position);
    void find(T value);
    void addFirst(T value);
    void addAt (T value, int position);
    void addInOrder(T value);
    void imprimir ();

}
