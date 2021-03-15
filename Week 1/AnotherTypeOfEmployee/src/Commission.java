public class Commission extends Hourly {
    private double totalSale;
    private double commissionRate;

    public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate, double commissionRate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.commissionRate = commissionRate;
    }

    public void addSale(double moreSale) {
        this.totalSale += moreSale;
    }
    
    public double pay() {
        double x = super.pay() + this.totalSale + this.commissionRate;
        this.totalSale = 0;
        return x;
    }

    public String toString() {
        return super.toString() + "\nTotal Sale: " + this.totalSale + "\n";
    }
}