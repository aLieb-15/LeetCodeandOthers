package BigSpeakDesignModel.StrategyModel;

public class CashNomal extends CashSuper{
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
