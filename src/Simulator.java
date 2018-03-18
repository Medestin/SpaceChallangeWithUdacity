import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulator {

    //Method for loading items into an array.
    public ArrayList<Item> loadItems(int phase) {

        //set the file to be loaded
        String phaseName;
        if (phase == 1) {
            phaseName = "phase-1.txt";
        } else {
            phaseName = "phase-2.txt";
        }

        //initialize ArrayList of items
        ArrayList<Item> itemArrayList = new ArrayList<>();
        Item currentItem;

        //initialize File and Scanner
        File file = new File(phaseName);

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //add Items to the array from the file
        assert scanner != null;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int indexOfEqual = line.indexOf('=');
            String name = line.substring(0, indexOfEqual);
            int weight = Integer.parseInt(line.substring(indexOfEqual + 1));
            currentItem = new Item(name, weight);
            itemArrayList.add(currentItem);

        }

        return itemArrayList;
    }

    //Loading U1 rockets
    public ArrayList<U1> loadU1(ArrayList<Item> itemArrayList) {
        ArrayList<U1> loadedU1 = new ArrayList<>();
        U1 currentU1 = new U1();

        //load all cargo
        while (itemArrayList.size() > 0) {
            Item currentItem = itemArrayList.get(0);
            if (currentU1.canCarry(currentItem)) {
                currentU1.carry(currentItem);
                itemArrayList.remove(0);
            } else {
                loadedU1.add(currentU1);
                currentU1 = new U1();
            }
        }

        loadedU1.add(currentU1);

        return loadedU1;

    }


    //Loading U2 rockets
    public ArrayList<U2> loadU2(ArrayList<Item> itemArrayList) {
        ArrayList<U2> loadedU2 = new ArrayList<>();
        U2 currentU2 = new U2();

        //load all cargo
        while (itemArrayList.size() > 0) {
            Item currentItem = itemArrayList.get(0);
            if (currentU2.canCarry(currentItem)) {
                currentU2.carry(currentItem);
                itemArrayList.remove(0);
            } else {
                loadedU2.add(currentU2);
                currentU2 = new U2();
            }
        }

        loadedU2.add(currentU2);

        return loadedU2;

    }


    //run simulation for U2 rockets
    public int runSimulationU2(ArrayList<U2> loadedRockets) {
        Rocket currentRocket = loadedRockets.get(0);
        int launchCrashes = 0;
        int landingCrashes = 0;
        int totalRockets = 0;
        int oneRocketCost = currentRocket.returnCost();

        while (loadedRockets.size() > 0) {

            if (currentRocket.launch()) {
                if (currentRocket.land()) {
                    totalRockets++;
                    loadedRockets.remove(0);

                    if (loadedRockets.size() > 0) {
                        currentRocket = loadedRockets.get(0);

                    }


                } else {
                    totalRockets++;
                    landingCrashes++;
                }

            } else {
                totalRockets++;
                launchCrashes++;
            }


        }


        System.out.println("Total crashes at launch: " + launchCrashes);
        System.out.println("Total crashes at landing: " + landingCrashes);
        System.out.println("Total rockets: " + totalRockets);

        return totalRockets * oneRocketCost;


    }


    //run simulation for u1 rockets:
    public int runSimulationU1(ArrayList<U1> loadedRockets) {
        Rocket currentRocket = loadedRockets.get(0);
        int launchCrashes = 0;
        int landingCrashes = 0;
        int totalRockets = 0;
        int oneRocketCost = currentRocket.returnCost();

        while (loadedRockets.size() > 0) {

            if (currentRocket.launch()) {
                if (currentRocket.land()) {
                    totalRockets++;
                    loadedRockets.remove(0);
                    if (loadedRockets.size() > 0) {
                        currentRocket = loadedRockets.get(0);

                    }

                } else {
                    totalRockets++;
                    landingCrashes++;
                }

            } else {
                totalRockets++;
                launchCrashes++;
            }


        }


        System.out.println("Total crashes at launch: " + launchCrashes);
        System.out.println("Total crashes at landing: " + landingCrashes);
        System.out.println("Total rockets: " + totalRockets);

        return totalRockets * oneRocketCost;


    }


}
