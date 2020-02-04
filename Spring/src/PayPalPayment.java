public class PayPalPayment implements Payment{

    @Override
    public void pay(int amount) {
        System.out.println("You need to pay: "+ amount + "kr with paypal");
    }

}