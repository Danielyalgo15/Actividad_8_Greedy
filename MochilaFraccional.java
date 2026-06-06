import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class Objeto {
    String nombre;
    double valor;
    double peso;
    public Objeto(String nombre, double valor, double peso) {
        this.nombre = nombre;
        this.valor = valor;
        this.peso = peso;
    }
    public double relacion() {
        return valor / peso;
    }
}
public class MochilaFraccional {
    public static void resolver(ArrayList<Objeto> objetos, double capacidad) {
        Collections.sort(objetos,
                Comparator.comparingDouble(Objeto::relacion).reversed());
        double valorTotal = 0;
        System.out.println("Objetos seleccionados:");
        for (Objeto obj : objetos) {
            if (capacidad == 0)
                break;
            if (obj.peso <= capacidad) {
                System.out.println(obj.nombre + " completo");
                capacidad -= obj.peso;
                valorTotal += obj.valor;
            }
            else {
                double fraccion = capacidad / obj.peso;
                System.out.printf("%.2f%% del objeto %s%n",fraccion * 100,obj.nombre);
                valorTotal += obj.valor * fraccion;
                capacidad = 0;
            }
        }
        System.out.println("Valor total obtenido: " + valorTotal);
    }
    public static void main(String[] args) {
        ArrayList<Objeto> objetos = new ArrayList<>();
        objetos.add(new Objeto("A", 60, 10));
        objetos.add(new Objeto("B", 100, 20));
        objetos.add(new Objeto("C", 120, 30));
        double capacidad = 50;
        resolver(objetos, capacidad);
    }
}