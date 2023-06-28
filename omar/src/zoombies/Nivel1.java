package zoombies;


import java.util.concurrent.CopyOnWriteArrayList;

//clase del nivel enbase a un tiempo iremos poniendo zombies en ciertas posiciones
//ya definidas en tiempos definidos
public class Nivel1 extends Thread {
    CopyOnWriteArrayList<zombies> vectorZombies;// arreglo de zombies
    Plantas p;
    boolean bandera;

    Nivel1(Plantas p,boolean bandera) {
        this.p = p;// obtenemos la referencia de la clase principal
        this.vectorZombies = p.vectorZombies;// igualamos los arreglos
        this.bandera = bandera;
    }

    // iniciamos el hilo
    @Override
    public void run() {

        try {
            Thread.sleep(1); // Espera 10 segundos y panta 3 zombies
            vectorZombies.add(new zombieCubeta(p, 0,bandera));
            vectorZombies.add(new ZombieAmericano(p, 1,bandera));
            vectorZombies.add(new zombiePeriodico(p, 2,bandera));
            vectorZombies.add(new ZombieFlag(p, 3,bandera));
            vectorZombies.add(new ZombieCono(p, 4,bandera));
            
            Thread.sleep(10000);// espera 10 mas depues del anterior y coloca 3 mas
            vectorZombies.add(new ZombiePuerta(p, 0,bandera));
            vectorZombies.add(new zombies(p, 1,bandera));
            vectorZombies.add(new ZombieEnano(p, 2,bandera));
            vectorZombies.add(new ZombieCono(p, 4,bandera));
            Thread.sleep(10000);// espera 10 mas depues del anterior y coloca 3 mas
            vectorZombies.add(new zombies(p, 4,bandera));
            vectorZombies.add(new zombies(p, 2,bandera));
            vectorZombies.add(new zombies(p, 1,bandera));
            Thread.sleep(10000);// espera 10 mas depues del anterior y coloca 3 mas
            vectorZombies.add(new zombies(p, 4,bandera));
            vectorZombies.add(new zombies(p, 2,bandera));
            vectorZombies.add(new zombies(p, 1,bandera));
            Thread.sleep(10000);// espera 10 mas depues del anterior y coloca 3 mas
            vectorZombies.add(new zombies(p, 4,bandera));
            vectorZombies.add(new zombies(p, 2,bandera));
            vectorZombies.add(new zombies(p, 1,bandera));
            Thread.sleep(10000);// espera 10 mas depues del anterior y coloca 3 mas
            vectorZombies.add(new zombies(p, 4,bandera));
            vectorZombies.add(new zombies(p, 2,bandera));
            vectorZombies.add(new zombies(p, 1,bandera));
            Thread.sleep(10000);// espera 10 mas depues del anterior y coloca 3 mas
            vectorZombies.add(new zombies(p, 4,bandera));
            vectorZombies.add(new zombies(p, 2,bandera));
            vectorZombies.add(new zombies(p, 1,bandera));
            Thread.sleep(10000);// espera 10 mas depues del anterior y coloca 3 mas
            vectorZombies.add(new zombiePeriodico(p, 2,bandera));
            vectorZombies.add(new zombies(p, 3,bandera));
            vectorZombies.add(new ZombieAmericano(p, 1,bandera));

            vectorZombies.add(new zombieCubeta(p, 0,bandera));

            while (true) {
                if (vectorZombies.size() == 0) {
                    System.exit(0);
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}