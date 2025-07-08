public class Problema4_Dispositivo {
    public static void main(String[] args) {
        DispositivoMonitoreo costa = new DispositivoCosta(1, "Guayas");
        costa.registrarDatos(35.0, 20.0, 40.0, 25.0);
        System.out.println("=== Costa ===");
        System.out.println(costa.generarReporte());

        DispositivoMonitoreo sierra = new DispositivoSierra(2, "Pichincha");
        sierra.registrarDatos(15.0, 250.0, 120.0, 60.0);
        System.out.println("\n=== Sierra ===");
        System.out.println(sierra.generarReporte());

        DispositivoMonitoreo oriente = new DispositivoOriente(3, "Napo");
        oriente.registrarDatos(28.0, 40.0, 50.0, 35.0);
        System.out.println("\n=== Oriente ===");
        System.out.println(oriente.generarReporte());
    }

    static class DispositivoMonitoreo {
        protected int id;
        protected String ubicacion;
        protected double temperatura;
        protected double precipitacion;
        protected double calidadAire;
        protected double humedadSuelo;

        public DispositivoMonitoreo(int id, String ubicacion) {
            this.id = id;
            this.ubicacion = ubicacion;
        }

        public void registrarDatos(double temperatura, double precipitacion, double calidadAire, double humedadSuelo) {
            this.temperatura = temperatura;
            this.precipitacion = precipitacion;
            this.calidadAire = calidadAire;
            this.humedadSuelo = humedadSuelo;
        }

        public String analizarDatos() {
            return "Análisis general: Datos dentro de rangos normales.";
        }

        public String generarReporte() {
            return toString() + "\n" + analizarDatos();
        }

        @Override
        public String toString() {
            return "ID: " + id +
                   "\nUbicación: " + ubicacion +
                   "\nTemperatura: " + temperatura +
                   "\nPrecipitación: " + precipitacion +
                   "\nCalidad del Aire: " + calidadAire +
                   "\nHumedad del Suelo: " + humedadSuelo;
        }
    }

    static class DispositivoCosta extends DispositivoMonitoreo {
        public DispositivoCosta(int id, String ubicacion) {
            super(id, ubicacion);
        }

        @Override
        public String analizarDatos() {
            if (humedadSuelo < 30) {
                return "Riesgo: Posible sequía en la Costa.";
            } else {
                return "Condiciones normales en la Costa.";
            }
        }
    }

    static class DispositivoSierra extends DispositivoMonitoreo {
        public DispositivoSierra(int id, String ubicacion) {
            super(id, ubicacion);
        }

        @Override
        public String analizarDatos() {
            if (precipitacion > 200) {
                return "Riesgo: Posibles deslizamientos en la Sierra.";
            } else if (calidadAire > 100) {
                return "Riesgo: Alta contaminación del aire en la Sierra.";
            } else {
                return "Condiciones normales en la Sierra.";
            }
        }
    }

    static class DispositivoOriente extends DispositivoMonitoreo {
        public DispositivoOriente(int id, String ubicacion) {
            super(id, ubicacion);
        }

        @Override
        public String analizarDatos() {
            if (humedadSuelo < 40 && precipitacion < 50) {
                return "Riesgo: Posible deforestación o sequía en el Oriente.";
            } else {
                return "Condiciones normales en el Oriente.";
            }
        }
    }
}
