import java.util.ArrayList;

public class Problema2_Restaurant {
    public static void main(String[] args) {
        MenuCarta carta = new MenuCarta("Lomo Fino", 20.0, 5.0, 2.0, 10);
        carta.calcularCuenta();

        MenuDia dia = new MenuDia("Arroz con Pollo", 8.0, 2.0, 1.5);
        dia.calcularCuenta();

        MenuNinos ninos = new MenuNinos("Hamburguesa Kids", 6.0, 1.0, 1.5);
        ninos.calcularCuenta();

        MenuEconomico eco = new MenuEconomico("Arroz con Menestra", 5.0, 20);
        eco.calcularCuenta();

        Cuenta cuenta = new Cuenta("Pedro Pérez");
        cuenta.agregarMenu(carta);
        cuenta.agregarMenu(dia);
        cuenta.agregarMenu(ninos);
        cuenta.agregarMenu(eco);
        cuenta.calcularTotal();

        cuenta.mostrarCuenta();
    }

    public static abstract class Menu {
        public String nombrePlato;
        public double valorInicialMenu;
        public double valorMenu;

        public Menu(String nombrePlato, double valorInicialMenu) {
            this.nombrePlato = nombrePlato;
            this.valorInicialMenu = valorInicialMenu;
        }

        public abstract void calcularCuenta();

        public abstract void mostrarMenu();
    }

    public static class MenuCarta extends Menu {
        public double valorPorcionGuarnicion;
        public double valorBebida;
        public double porcentajeAdd;

        public MenuCarta(String nombrePlato, double valorInicialMenu,
                         double valorPorcionGuarnicion, double valorBebida, double porcentajeAdd) {
            super(nombrePlato, valorInicialMenu);
            this.valorPorcionGuarnicion = valorPorcionGuarnicion;
            this.valorBebida = valorBebida;
            this.porcentajeAdd = porcentajeAdd;
        }

        @Override
        public void calcularCuenta() {
            valorMenu = valorInicialMenu + valorPorcionGuarnicion + valorBebida
                    + (valorInicialMenu * porcentajeAdd / 100);
        }

        @Override
        public void mostrarMenu() {
            System.out.println("Menú Carta:");
            System.out.println("Plato: " + nombrePlato);
            System.out.println("Valor Inicial: $" + valorInicialMenu);
            System.out.println("Guarnición: $" + valorPorcionGuarnicion);
            System.out.println("Bebida: $" + valorBebida);
            System.out.println("Adicional (%): " + porcentajeAdd);
            System.out.println("Valor Total: $" + valorMenu);
            System.out.println();
        }
    }

    public static class MenuDia extends Menu {
        public double valorPostre;
        public double valorBebida;

        public MenuDia(String nombrePlato, double valorInicialMenu, double valorPostre, double valorBebida) {
            super(nombrePlato, valorInicialMenu);
            this.valorPostre = valorPostre;
            this.valorBebida = valorBebida;
        }

        @Override
        public void calcularCuenta() {
            valorMenu = valorInicialMenu + valorPostre + valorBebida;
        }

        @Override
        public void mostrarMenu() {
            System.out.println("Menú Día:");
            System.out.println("Plato: " + nombrePlato);
            System.out.println("Valor Inicial: $" + valorInicialMenu);
            System.out.println("Postre: $" + valorPostre);
            System.out.println("Bebida: $" + valorBebida);
            System.out.println("Valor Total: $" + valorMenu);
            System.out.println();
        }
    }

    public static class MenuNinos extends Menu {
        public double valorPorcionHelado;
        public double valorPorcionPastel;

        public MenuNinos(String nombrePlato, double valorInicialMenu,
                         double valorPorcionHelado, double valorPorcionPastel) {
            super(nombrePlato, valorInicialMenu);
            this.valorPorcionHelado = valorPorcionHelado;
            this.valorPorcionPastel = valorPorcionPastel;
        }

        @Override
        public void calcularCuenta() {
            valorMenu = valorInicialMenu + valorPorcionHelado + valorPorcionPastel;
        }

        @Override
        public void mostrarMenu() {
            System.out.println("Menú Niños:");
            System.out.println("Plato: " + nombrePlato);
            System.out.println("Valor Inicial: $" + valorInicialMenu);
            System.out.println("Helado: $" + valorPorcionHelado);
            System.out.println("Pastel: $" + valorPorcionPastel);
            System.out.println("Valor Total: $" + valorMenu);
            System.out.println();
        }
    }

    public static class MenuEconomico extends Menu {
        public double porcentajeDescuento;

        public MenuEconomico(String nombrePlato, double valorInicialMenu, double porcentajeDescuento) {
            super(nombrePlato, valorInicialMenu);
            this.porcentajeDescuento = porcentajeDescuento;
        }

        @Override
        public void calcularCuenta() {
            valorMenu = valorInicialMenu - (valorInicialMenu * porcentajeDescuento / 100);
        }

        @Override
        public void mostrarMenu() {
            System.out.println("Menú Económico:");
            System.out.println("Plato: " + nombrePlato);
            System.out.println("Valor Inicial: $" + valorInicialMenu);
            System.out.println("Descuento (%): " + porcentajeDescuento);
            System.out.println("Valor Total: $" + valorMenu);
            System.out.println();
        }
    }

    public static class Cuenta {
        public String nombreCliente;
        public ArrayList<Menu> listadoMenus = new ArrayList<>();
        public double subtotal;
        public double iva = 12;
        public double total;

        public Cuenta(String nombreCliente) {
            this.nombreCliente = nombreCliente;
        }

        public void agregarMenu(Menu menu) {
            listadoMenus.add(menu);
        }

        public void calcularTotal() {
            subtotal = 0;
            for (Menu m : listadoMenus) {
                subtotal += m.valorMenu;
            }
            total = subtotal + (subtotal * iva / 100);
        }

        public void mostrarCuenta() {
            System.out.println("CLIENTE: " + nombreCliente);
            System.out.println("------ MENÚS ------");
            for (Menu m : listadoMenus) {
                m.mostrarMenu();
            }
            System.out.println("Subtotal: $" + subtotal);
            System.out.println("IVA: " + iva + "%");
            System.out.println("Total a cancelar: $" + total);
        }
    }
}
