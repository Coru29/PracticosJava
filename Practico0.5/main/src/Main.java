public class Main {
    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(potencia(5,6));
        System.out.println(sumN(5));
    }

    public static int factorial(int valor){
        if (valor == 0){
            return 1;
        }
        else {
            return valor * factorial(valor-1);
        }
    }
    public static double potencia(double valor, int potencia){
        if (potencia == 0){
            return 1;

        }
        else{
            return valor * potencia(valor, potencia-1);
        }
    }

    public static int sumN(int n){
        if (n==1){
            return 1;
        }
        else{
            return n + sumN(n-1);
        }
    }

    //voy a ver si este comentario esta en el repo


}