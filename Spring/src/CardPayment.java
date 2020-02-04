public class CardPayment implements Payment {

    @Override
    public void pay(int amount) {
        System.out.println("You need to pay: " + amount + "kr with card");
    }
}
