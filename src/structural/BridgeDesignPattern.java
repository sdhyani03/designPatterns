package structural;

public class BridgeDesignPattern {

    public  static void main(String args[]){

        Payment payment=new CardPayment();
        payment.iPaymentSystem=new HDFCPaymentSystem();
        payment.makePayment();
    }
}

 interface IPaymentSystem{
    public void processPayment(String paymentSystem);
}

class HDFCPaymentSystem implements IPaymentSystem{

    @Override
    public void processPayment(String paymentSystem) {
        System.out.println("Processing payment from HDFC using :"+paymentSystem);
    }
}

class CitiPaymentSystem implements  IPaymentSystem{

    @Override
    public void processPayment(String paymentSystem) {
        System.out.println("Processing payment from CITI using :" + paymentSystem);
    }
}

abstract class Payment {
    IPaymentSystem iPaymentSystem;
    public abstract void makePayment();
}

class CardPayment extends Payment{

    @Override
    public void makePayment() {
        iPaymentSystem.processPayment("Card Payment");
    }
}
class InternetBanking extends Payment{

    @Override
    public void makePayment() {
        iPaymentSystem.processPayment("InternetBanking");
    }
}

