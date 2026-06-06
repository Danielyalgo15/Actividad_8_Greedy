import java.util.ArrayList;
import java.util.Arrays;
public class CoberturaAntenas {
    public static void colocarAntenas(int[] casas, int rango) {
        Arrays.sort(casas);
        ArrayList<Integer> antenas = new ArrayList<>();
        int i = 0;
        int n = casas.length;
        while (i < n) {
            int inicio = casas[i];
            while (i < n && casas[i] <= inicio + rango) {
                i++;
            }
            int posicionAntena = casas[i - 1];
            antenas.add(posicionAntena);
            while (i < n && casas[i] <= posicionAntena + rango) {
                i++;
            }
        }
        System.out.println("Antenas colocadas en:");
        for (int antena : antenas) {
            System.out.println(antena);
        }
        System.out.println("Cantidad total: " + antenas.size());
    }
    public static void main(String[] args) {
        int[] casas = {1, 2, 7, 11, 20, 21, 30};
        int rango = 5;
        colocarAntenas(casas, rango);
    }
}