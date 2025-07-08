public class Problema3_Juego {
    public static void main(String[] args) {
        Atacante atacante = new Atacante("Juan Pérez", 9, "12.345.678-9");
        atacante.registrarEstadisticas(2, 10, 5);
        System.out.println("=== Atacante ===");
        System.out.println(atacante);

        Defensor defensor = new Defensor("Luis Gómez", 5, "11.222.333-4");
        defensor.registrarEstadisticas(0, 15, 7);
        System.out.println("\n=== Defensor ===");
        System.out.println(defensor);

        Portero portero = new Portero("Carlos Ruiz", 1, "22.333.444-5");
        portero.registrarEstadisticas(0, 6);
        System.out.println("\n=== Portero ===");
        System.out.println(portero);
    }

    static class Jugador {
        protected String nombre;
        protected int dorsal;
        protected String rut;
        protected int goles;

        public Jugador(String nombre, int dorsal, String rut) {
            this.nombre = nombre;
            this.dorsal = dorsal;
            this.rut = rut;
        }

        public void registrarEstadisticas(int goles) {
            this.goles = goles;
        }

        public int calcularValoracion() {
            return goles * 30;
        }

        @Override
        public String toString() {
            return "Nombre: " + nombre +
                   "\nDorsal: " + dorsal +
                   "\nRUT: " + rut +
                   "\nGoles: " + goles +
                   "\nValoración: " + calcularValoracion();
        }
    }

    static class Atacante extends Jugador {
        protected int pasesExitosos;
        protected int recuperaciones;

        public Atacante(String nombre, int dorsal, String rut) {
            super(nombre, dorsal, rut);
        }

        public void registrarEstadisticas(int goles, int pasesExitosos, int recuperaciones) {
            super.registrarEstadisticas(goles);
            this.pasesExitosos = pasesExitosos;
            this.recuperaciones = recuperaciones;
        }

        @Override
        public int calcularValoracion() {
            return super.calcularValoracion() + recuperaciones * 3;
        }

        @Override
        public String toString() {
            return super.toString() +
                   "\nPases Exitosos: " + pasesExitosos +
                   "\nRecuperaciones: " + recuperaciones;
        }
    }

    static class Defensor extends Jugador {
        protected int pasesExitosos;
        protected int recuperaciones;

        public Defensor(String nombre, int dorsal, String rut) {
            super(nombre, dorsal, rut);
        }

        public void registrarEstadisticas(int goles, int pasesExitosos, int recuperaciones) {
            super.registrarEstadisticas(goles);
            this.pasesExitosos = pasesExitosos;
            this.recuperaciones = recuperaciones;
        }

        @Override
        public int calcularValoracion() {
            return super.calcularValoracion() + recuperaciones * 4;
        }

        @Override
        public String toString() {
            return super.toString() +
                   "\nPases Exitosos: " + pasesExitosos +
                   "\nRecuperaciones: " + recuperaciones;
        }
    }

    static class Portero extends Jugador {
        protected int atajadas;

        public Portero(String nombre, int dorsal, String rut) {
            super(nombre, dorsal, rut);
        }

        public void registrarEstadisticas(int goles, int atajadas) {
            super.registrarEstadisticas(goles);
            this.atajadas = atajadas;
        }

        @Override
        public int calcularValoracion() {
            return super.calcularValoracion() + atajadas * 5;
        }

        @Override
        public String toString() {
            return super.toString() +
                   "\nAtajadas: " + atajadas;
        }
    }

}
