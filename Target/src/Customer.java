public class Customer {
    private int custID;
    private String address;
    private String billAddress;
    private String phoneNum;
    private String creditCard;
    private String username;
    private String password;

    public Customer(int ID, String add, String billAdd, String phoNum, String credCard, String user, String pass)
    {
        custID = ID;
        address = add;
        billAddress = billAdd;
        phoneNum = phoNum;
        creditCard = credCard;
        username = user;
        password = pass;
    }

    public int getCustID() {
        return custID;
    }

    public String getAddress() {
        return address;
    }

    public String getBillAddress() {
        return billAddress;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBillAddress(String billAddress) {
        this.billAddress = billAddress;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCustID(int custID){
        this.custID = custID;
    }

}
