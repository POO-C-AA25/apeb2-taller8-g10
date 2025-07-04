public class Problema1_JuegoRoles{
    static Personaje g1;
    static Personaje m1;
    static Personaje a1;
    
    public static void main(String[] args) {
        g1 = new Guerrero("Super fuerza", 3, 100);
        m1 = new Mago("Fuego", 3, 50);
        a1 = new Arquero("Disparo", 3, 30);
        boolean gana = g1.ataque(m1);
        if(gana){
            g1.defensa(m1);
        } else {
            m1.defensa(g1);
        }
        
        System.out.println("Guerrero: " + g1 + "Mago: " + m1);
    }
}

abstract class Personaje{
    public int vidas;
    public int nivelEXP;
    public int batallasW;
    public int puntosDefensa;
    
    public Personaje(int vidas, int puntosDefensa){
        this.vidas = vidas;
        this.puntosDefensa = puntosDefensa;
    }
    
    public abstract boolean ataque(Personaje personaje);
    public abstract int defensa(Personaje personaje);

    @Override
    public String toString() {
        return "Personaje{" + "vidas=" + vidas + ", nivelEXP=" + nivelEXP + ", batallasW=" + batallasW + ", puntosDefensa=" + puntosDefensa + '}';
    }
}

class Guerrero extends Personaje{
    public String habilidades;

    public Guerrero(String habilidades, int vidas, int puntosDefensa) {
        super(vidas, puntosDefensa);
        this.habilidades = habilidades;
    }
    
    public boolean ataque(Personaje personaje){
        int bandera = (int) (Math.random()*2);
        return (((Math.random()*2) == 1) ? true : false);
    }
    
    public int defensa(Personaje personaje){
        int defensa = puntosDefensa - (int)(Math.random()*10);
        return 0;
    }

    public String toString() {
        return "Guerrero{" + "habilidades=" + habilidades + '}' + super.toString();
    }
}

class Arquero extends Personaje{
    public String estrategia;

    public Arquero(String estrategia, int vidas, int puntosDefensa) {
        super(vidas, puntosDefensa);
        this.estrategia = estrategia;
    }
    
    public boolean ataque(Personaje personaje){
        return true;
    }
    
    public int defensa(){
        return 0;
    }
}

class Mago extends Personaje{
    public String atributo;

    public Mago(String atributo, int vidas, int puntosDefensa) {
        super(vidas, puntosDefensa);
        this.atributo = atributo;
    }
    
    public boolean ataque(Personaje personaje){
        return true;
    }
    
    public int defensa(){
        return 0;
    }
}