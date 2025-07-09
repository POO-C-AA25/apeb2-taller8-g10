import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problema6_Naciones {
    public static void main(String[] args) {
        NacionDesarrollada usa = new NacionDesarrollada("USA", 330_000_000L, 1_000_000_000, 90, true);
        NacionDesarrollada alemania = new NacionDesarrollada("Alemania", 83_000_000L, 800_000_000, 85, true);
        NacionEnDesarrollo peru = new NacionEnDesarrollo("Peru", 33_000_000L, 200_000_000, 60);
        NacionEnDesarrollo ecuador = new NacionEnDesarrollo("Ecuador", 18_000_000L, 150_000_000, 50);

        usa.agregarAliado(alemania);
        usa.agregarAliado(ecuador);
        alemania.agregarAliado(usa);
        peru.agregarAliado(usa);

        // Simular conflictos aleatorios
        List<Nacion> naciones = new ArrayList<>();
        naciones.add(usa);
        naciones.add(alemania);
        naciones.add(peru);
        naciones.add(ecuador);

        Random rand = new Random();
        int conflictosSimulados = 0;

        for (int i = 0; i < 3; i++) {
            int i1 = rand.nextInt(naciones.size());
            int i2;
            do {
                i2 = rand.nextInt(naciones.size());
            } while (i2 == i1);

            Nacion n1 = naciones.get(i1);
            Nacion n2 = naciones.get(i2);

            n1.simulacionConf(n2);
            conflictosSimulados++;
        }

        System.out.println("\n===== REPORTE FINAL =====");
        for (Nacion n : naciones) {
            System.out.println(n);
        }
        System.out.println("Total de conflictos simulados: " + conflictosSimulados);
    }
}

abstract class Nacion{
    public String nombre;
    public long poblacion;
    public double recursosEconomicos;
    public int poderMilitar;
    public boolean enConflicto;
    public List<Nacion> aliados;

    public Nacion(String nombre, long poblacion, double recursosEconomicos, int poderMilitar) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.recursosEconomicos = recursosEconomicos;
        this.poderMilitar = poderMilitar;
        this.enConflicto = false;
        this.aliados = new ArrayList<>();
    }
    
    public abstract void calcularImpacto();
    
    public void agregarAliado(Nacion a){
        aliados.add(a);
    }
    
    public void simulacionConf(Nacion contra){
        System.out.println("\n--- Conflicto entre " + nombre + " y " + contra.nombre + " ---");

        this.calcularImpacto();
        contra.calcularImpacto();

        this.enConflicto = true;
        contra.enConflicto = true;

        if (this.poderMilitar > contra.poderMilitar) {
            long diferencia = this.poderMilitar - contra.poderMilitar;
            contra.poblacion -= (long)(contra.poblacion * 0.05 * diferencia);
            contra.recursosEconomicos *= 0.9;
            System.out.println(contra.nombre + " fue derrotada.");
        } else if (this.poderMilitar < contra.poderMilitar) {
            long diferencia = contra.poderMilitar - this.poderMilitar;
            this.poblacion -= (long)(this.poblacion * 0.05 * diferencia);
            this.recursosEconomicos *= 0.9;
            System.out.println(this.nombre + " fue derrotada.");
        } else {
            this.recursosEconomicos *= 0.95;
            contra.recursosEconomicos *= 0.95;
            System.out.println("Empate. Ambas naciones pierden recursos.");
        }
    }

    @Override
    public String toString() {
        List<String> nombresAliados = new ArrayList<>();
        for (Nacion a : aliados) {
            nombresAliados.add(a.nombre);
        }

        return "Nacion{" +
                "nombre='" + nombre + '\'' +
                ", poblacion=" + poblacion +
                ", recursosEconomicos=" + recursosEconomicos +
                ", poderMilitar=" + poderMilitar +
                ", enConflicto=" + enConflicto +
                ", aliados=" + nombresAliados +
                '}';
    }
}

class NacionDesarrollada extends Nacion{
    public boolean tecnologiaAvanzada;
    
    public NacionDesarrollada(String nombre, long poblacion, double recursosEconomicos, int poderMilitar, boolean tecnologiaAvanzada) {
        super(nombre, poblacion, recursosEconomicos, poderMilitar);
        this.tecnologiaAvanzada = tecnologiaAvanzada;
    }

    public void calcularImpacto() {
        if (tecnologiaAvanzada) {
            poderMilitar += 10;
            if (poderMilitar > 100) {
                poderMilitar = 100;
            }
        }

        if (!aliados.isEmpty()) {
            poderMilitar += 5;
            if (poderMilitar > 100) {
                poderMilitar = 100;
            }
        }
    }
    
}

class NacionEnDesarrollo extends Nacion{

    public NacionEnDesarrollo(String nombre, long poblacion, double recursosEconomicos, int poderMilitar) {
        super(nombre, poblacion, recursosEconomicos, poderMilitar);
    }

    public void calcularImpacto() {
        double recursosPorHabitante = recursosEconomicos / poblacion;
        double impacto = poderMilitar * recursosPorHabitante;

        poderMilitar = (int)(impacto * 0.5);
        if (poderMilitar < 1) {
            poderMilitar = 1;
        }

        if (!aliados.isEmpty()) {
            poderMilitar += 3;
            if (poderMilitar > 100) {
                poderMilitar = 100;
            }
        }
    }
    
}