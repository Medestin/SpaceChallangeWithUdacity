import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //initialize simulator
        Simulator simulator = new Simulator();

        //load up item lists of both phases
        ArrayList<Item> u1phase1ArrayList;
        u1phase1ArrayList = simulator.loadItems(1);

        ArrayList<Item> u1phase2ArrayList;
        u1phase2ArrayList = simulator.loadItems(2);

        //initialize U1 arrays for both phases and put loaded rockets in
        ArrayList<U1> u1Phase1 = simulator.loadU1((u1phase1ArrayList));
        ArrayList<U1> u1Phase2 = simulator.loadU1(u1phase2ArrayList);


        //initialize and run simulations for U1 in both phases, print results
        int u1Phase1cost = simulator.runSimulationU1(u1Phase1);
        System.out.println("Sending U1's on phase 1: " + u1Phase1cost);
        int u1Phase2cost = simulator.runSimulationU1(u1Phase2);
        System.out.println("Sending U1's on phase 2: " + u1Phase2cost);


        //load up item lists for both phases again(Cannot use the lists already loaded, because
        //method simulator.LoadItems removes items form array lists)
        ArrayList<Item> u2phase1ArrayList;
        u2phase1ArrayList = simulator.loadItems(1);

        ArrayList<Item> u2phase2ArrayList;
        u2phase2ArrayList = simulator.loadItems(2);

        //initialize U2 arrays for both phases and put loaded rockets in
        ArrayList<U2> u2Phase1 = simulator.loadU2(u2phase1ArrayList);
        ArrayList<U2> u2Phase2 = simulator.loadU2(u2phase2ArrayList);


        //initialize and run simulations for U1 in both phases, print results
        int u2Phase1cost = simulator.runSimulationU2(u2Phase1);
        System.out.println("Sending U2's on phase 1: " + u2Phase1cost);
        int u2Phase2cost = simulator.runSimulationU2(u2Phase2);
        System.out.println("Sending U2's on phase 2: " + u2Phase2cost);


        //Print outcome:
        if (u1Phase1cost > u2Phase1cost) {
            System.out.println("It's cheaper to use U2's on phase 1");
        } else if (u1Phase1cost < u2Phase1cost) {
            System.out.println("It's cheaper to use U1's on phase 1");
        } else {
            System.out.println("It costs exactly the same to use either on phase 1");
        }

        if (u1Phase2cost > u2Phase2cost) {
            System.out.println("It's cheaper to use U2's on phase 2");
        } else if (u1Phase2cost < u2Phase2cost) {
            System.out.println("It's cheaper to use U1's on phase 2");
        } else {
            System.out.println("It costs exactly the same to use either on phase 2");
        }


    }


}

