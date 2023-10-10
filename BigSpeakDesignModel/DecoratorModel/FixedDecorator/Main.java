package BigSpeakDesignModel.DecoratorModel.FixedDecorator;

public class Main {
    public static void main(String[] args) {
        Person xc = new Person("JTH");
        System.out.println("suit 1");
        TShirts tShirts = new TShirts();
        BigTrouser bigTrouser = new BigTrouser();
        tShirts.Decorate(xc);
        bigTrouser.Decorate(tShirts);
        bigTrouser.Show();

        System.out.println("suit 2");
        Sneakers sneakers = new Sneakers();
        sneakers.Decorate(xc);
        sneakers.Show();
    }
}
