public class PackageInformation {
    private String packageID;
    private float weight;

    public PackageInformation() {
        //packageInformation object
    }

    public String getPackageID() {
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
