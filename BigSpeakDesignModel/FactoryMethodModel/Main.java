package BigSpeakDesignModel.FactoryMethodModel;

public class Main {
    public static void main(String[] args) {
        Leifeng jth = new Undergraduate();

        jth.buyRice();
        jth.wash();;
        jth.sweep();

        Leifeng jth1 = new Undergraduate();
        jth1.buyRice();
        Leifeng jth2 = new Undergraduate();
        jth2.wash();
        Leifeng jth3 = new Undergraduate();
        jth3.sweep();

        IFactory leifengFactory = new UndergraduateFactory();
        Leifeng student = leifengFactory.createLeifeng();
        student.buyRice();
    }
}
