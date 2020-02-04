public class Main {



    public static void main(String[] args) {


        WebShop webShop = new WebShop(new ApplePay());

        webShop.checkout(50);

    }
}
