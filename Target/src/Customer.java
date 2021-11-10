public class Customer {
    private int custID;
    private String address;
    private String billAddress;
    private int phoneNum;
    private String creditCard;

    public Customer() {
        //Customer constructor
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

    public int getPhoneNum() {
        return phoneNum;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBillAddress(String billAddress) {
        this.billAddress = billAddress;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
