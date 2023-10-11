package BigSpeakDesignModel.AgentModel;

public class Main {
    public static void main(String[] args) {
        SchoolGirl girl = new SchoolGirl();
        girl.setName("jzf");

        Pursuit pursuit = new Pursuit(girl);

        Proxy shx = new Proxy(girl);

        shx.giveDolls();
        shx.giveFlowers();
        shx.giveMoney();
    }
}
