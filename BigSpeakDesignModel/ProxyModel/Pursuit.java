package BigSpeakDesignModel.ProxyModel;

public class Pursuit implements GiveGift{
    SchoolGirl mm;
    public Pursuit(SchoolGirl mm) {
        this.mm = mm;
    }

    @Override
    public void giveDolls() {
        System.out.println(mm.getName() + " give you a doll");
    }

    @Override
    public void giveFlowers() {
        System.out.println(mm.getName() + " give you a flower");
    }

    @Override
    public void giveMoney() {
        System.out.println(mm.getName() + " give you money");
    }
}
