public class Rocket implements Spaceship {

    //Fields
    private int pCost;
    private int pWeight;
    private int pTareWight;
    private int pMaxWeight;
    private double pLaunchFail;
    private double pLandFail;

    //constructor
    Rocket(int cost, int weight, int maxWeight, double launchFail, double landFail) {
        pCost = cost;
        pWeight = weight;
        pTareWight = weight;
        pMaxWeight = maxWeight;
        pLaunchFail = launchFail;
        pLandFail = landFail;
    }

    //getter for cost
    public int returnCost(){
        return pCost;
    }


    //method for adding weight to a rocket("Loading it")
    public void addWeight(int weight) {
        pWeight = pWeight + weight;
    }

    //Overriding methods for Spaceship interface
    @Override
    public boolean launch() {
       double weightRatio = (double)(pWeight-pTareWight)/(pMaxWeight-pTareWight);
        if(Math.random()>pLaunchFail*weightRatio){
        return true;}
        else {return false;}
    }

    @Override
    public boolean land() {
        double weightRatio = (double)(pWeight-pTareWight)/(pMaxWeight-pTareWight);
        if(Math.random()>pLandFail*weightRatio){
            return true;}
        else {return false;}
    }

    @Override
    public boolean canCarry(Item item) {
        if (item.returnWeight() <= pMaxWeight - pWeight) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void carry(Item item) {
        if(canCarry(item)){
           addWeight(item.returnWeight());
        }

    }
}
