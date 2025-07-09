import java.util.ArrayList;
import java.util.List;

public class Problema5_Emprendimientos{
    public static void main(String[] args) {
        Mentor mentor1 = new Mentor("Ana Torres", "Marketing");
        Mentor mentor2 = new Mentor("Carlos Diaz", "Desarrollo de Software");
        Mentor mentor3 = new Mentor("Lucia Perez", "Contabilidad");

        EmpTec eTec1 = new EmpTec("LojaTech", "Innovar con tecnologia desde Loja", "contacto@lojatech.com");
        eTec1.agregarProducto("App Educativa");
        eTec1.agregarProducto("Sistema de control");
        eTec1.asignarMentor(mentor1);
        eTec1.asignarMentor(mentor2);

        EmpArt eArt1 = new EmpArt("ArteLoja", "Promover artesanias locales", "contacto@arteloja.com");
        eArt1.agregarProducto("Ceramica");
        eArt1.agregarProducto("Tejidos");

        EmpGas eGas1 = new EmpGas("GustiLoja", "Sabores tradicionales", "contacto@saborloja.com");
        eGas1.agregarProducto("Tamales");
        eGas1.asignarMentor(mentor1);

        FeriaTec feriaTec = new FeriaTec("Expo Digital 2025");
        FeriaArt feriaArt = new FeriaArt("Feria de Arte Loja");
        FeriaGas feriaGas = new FeriaGas("Festival Gastronomico Loja");

        System.out.println("===            PARTICIPACION EN FERIAS            ===");
        eTec1.participacionF(feriaTec);
        eArt1.participacionF(feriaArt);
        eGas1.participacionF(feriaGas);

        System.out.println("\n===            EVOLUCION DE EMPRENDIMIENTOS            ===");
        eTec1.evolucion();
        eArt1.evolucion();
        eGas1.evolucion();

        System.out.println("\n===            INFORMACION DE EMPRENDIMIENTOS            ===");
        System.out.println(eTec1);
        System.out.println(eArt1);
        System.out.println(eGas1);
    }
}

class Emprendimiento{
    public String nombre;
    public String mision;
    public List<String> productos;
    public String contacto;
    public List<Mentor> mentores;

    public Emprendimiento(String nombre, String mision, String contacto) {
        this.nombre = nombre;
        this.mision = mision;
        this.contacto = contacto;
        this.productos = new ArrayList<>();
        this.mentores = new ArrayList<>();
    }

    public void agregarProducto(String producto) {
        productos.add(producto);
    }

    public void asignarMentor(Mentor mentor) {
        mentores.add(mentor);
    }
    
    public void evolucion() {
        if (((int) (Math.random() * 2)) == 1) {
            System.out.println("Emprendimiento: " + nombre + " evoluciono.");
            System.out.println("    Sedes abiertas: " + ((int) (Math.random() * 5 + 1)));
            System.out.println("    Extension de lineas de producto: +" + ((int)(Math.random() * 20 + 1)));
        } else {
            System.out.println("Emprendimiento: " + nombre + " NO evoluciono.");
        }
    }
    
    public void participacionF(Feria feria){
        feria.presentar(this);
    }

    @Override
    public String toString() {
        return "Emprendimiento{" +
                "nombre='" + nombre + '\'' +
                ", mision='" + mision + '\'' +
                ", productos=" + productos +
                ", contacto='" + contacto + '\'' +
                ", mentores=" + mentores +
                '}';
    }
}

class EmpTec extends Emprendimiento{   
    public EmpTec(String nombre, String mision, String contacto) {
        super(nombre, mision, contacto);
    }
}

class EmpArt extends Emprendimiento{  
    public EmpArt(String nombre, String mision, String contacto) {
        super(nombre, mision, contacto);
    }
}

class EmpGas extends Emprendimiento{
    public EmpGas(String nombre, String mision, String contacto) {
        super(nombre, mision, contacto);
    }
}

class Mentor{
    public String nombre;
    public String especialidad;

    public Mentor(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Mentor{" + "nombre=" + nombre + ", especialidad=" + especialidad + '}';
    }
}

abstract class Feria{
    public String nombre;

    public Feria(String nombre) {
        this.nombre = nombre;
    }
    
    public abstract void presentar(Emprendimiento e);
}

class FeriaTec extends Feria{
    public FeriaTec(String nombre) {
        super(nombre);
    }

    @Override
    public void presentar(Emprendimiento e) {
        System.out.println("---Participacion en Feria Tecnologica: " + this.nombre + "---");
        System.out.println("Emprendimiento: " + e.nombre);
        System.out.println("Productos: " + e.productos);
        System.out.println("Mentores: " + e.mentores + "\n");
    }
}

class FeriaArt extends Feria{
    public FeriaArt(String nombre) {
        super(nombre);
    }

    @Override
    public void presentar(Emprendimiento e) {
        System.out.println("---Participacion en Feria de Artesanias: " + this.nombre + "---");
        System.out.println("Emprendimiento: " + e.nombre);
        System.out.println("Productos: " + e.productos);
        System.out.println("Mentores: " + e.mentores + "\n");
    }
}

class FeriaGas extends Feria{
    public FeriaGas(String nombre) {
        super(nombre);
    }

    @Override
    public void presentar(Emprendimiento e) {
        System.out.println("---Participacion en Feria Gastronomica: " + this.nombre + "---");
        System.out.println("Emprendimiento: " + e.nombre);
        System.out.println("Productos: " + e.productos);
        System.out.println("Mentores: " + e.mentores + "\n");
    }
}