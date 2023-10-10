package BigSpeakDesignModel.StrategyModel;

public class CashContext {
    private CashSuper cs;

    // public CashContext(CashSuper cSuper) {
    //     this.cs = cSuper;
    // }

    /**
     * 策略模式+简单工厂
     * 客户端只需要识别出CashContext一个类即可
     * 只是用简单工厂模式，客户端需要识别CashSuper和CashFactory两个类
     * 使用策略模式+简单工厂进一步降低了系统代码的耦合度
     * 客户端算账只需要调用CashContext的getResult方法
     * 使得收费算法和客户端彻底分离
     * @param type
     */
    public CashContext(String type) {
        switch (type) {
            case "正常收费":
                cs = new CashNomal();
                break;
            case "满300返100":
                cs = new CashReturn("300", "100");
                break;
            case "打8折":
                cs = new CashRebate("0.8");
                break;
        }
    }

    public double getResult(double money) {
        return cs.acceptCash(money);
    }
}
