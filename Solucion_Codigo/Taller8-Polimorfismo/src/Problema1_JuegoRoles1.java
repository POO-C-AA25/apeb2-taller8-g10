
public class Problema1_JuegoRoles1 {

    static Personaje guerrero;
    static Personaje mago;
    static Personaje arquero;

    public static void main(String[] args) {
        guerrero = new Guerrero();
        mago = new Mago();
        boolean gana = guerrero.ataque(mago);
        if (gana) {
            guerrero.experiencia += 1;
            guerrero.batallasGanadas += 1;
            mago.vidas -= 1;

        } else {
            mago.batallasGanadas += 1;
            mago.experiencia += 1;
            guerrero.vidas += 1;
        }
        System.out.println("Guerrero: "+guerrero+"Mago: "+mago);
    }
}

abstract class Personaje {

    public int vidas;
    public int experiencia;
    public int batallasGanadas;

    public abstract boolean ataque(Personaje personaje);

    public abstract int defensa();

    @Override
    public String toString() {
        return "Personaje{" + "vidas=" + vidas + ", experiencia=" + experiencia + ", batallasGanadas=" + batallasGanadas + '}';
    }
}

class Guerrero extends Personaje {

    public String habilidades;

    public boolean ataque(Personaje personaje) {
        int bandera = (int) (Math.random() * 1);
        boolean gana = (bandera == 1);
        return gana;
    }

    public int defensa() {
        return 0;
    
        
}

    @Override
    public String toString() {
        return "Guerrero{" + "habilidades=" + habilidades + '}'+ super.toString();
    }

class Mago extends Personaje {

    public String estrategia;

    public boolean ataque(Personaje personaje) {
        return false;
    }

    public int defensa() {
        return 0;
    }

        @Override
        public String toString() {
            return "Mago{" + "estrategia=" + estrategia + '}'+ super.toString();
        }
    
}

class Arquero extends Personaje {

    public String atributo;

    public boolean ataque(Personaje personaje) {
        return false;
    }

    public int defensa() {
        return 0;
    }
}
}
