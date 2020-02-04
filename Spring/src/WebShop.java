public class WebShop {

    Payment payment;

    public WebShop(Payment payment) {
        this.payment = payment;
    }

    public void checkout(int amount) {
        payment.pay(amount);
       /* if (payPalPayment != null) {
            PayPalPayment payPalPayment = new PayPalPayment();
            payPalPayment.pay(amount);
        } else if (cardPayment != null){
            CardPayment cardPayment = new CardPayment();
            cardPayment.pay(amount);
        } else if (applePay != null) {
            ApplePay applePay = new ApplePay();
            applePay.pay(amount);
        }*/
    }
}