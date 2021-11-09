public class PackageInformation {
    private int packageID;
    private float weight;

    public PackageInformation() {
        //packageInformation object
    }

    public int getPackageID() {
        return packageID;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        //e.g. employee manually weigh package and update it
        this.weight = weight;
    }

    public void setWeight(int ...amt) { //have an unlimited amount of argument
        //take in the weight of each package and total them up here
    }
}
