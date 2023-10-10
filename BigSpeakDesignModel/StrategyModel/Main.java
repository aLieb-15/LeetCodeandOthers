package BigSpeakDesignModel.StrategyModel;

/**
 * 策略模式定义一系列算法，这些算法完成相同的工作，只是实现不同
 * 算法的调用方式都是一样的
 * Strategy类层次为Context定义了一系列可供重用的算法和行为
 * 这有助于析取所有算法的公共功能
 * 并且有助于简化单元测试，每个算法都有自己的类，可以通过自己的接口进行单独测试
 */
public class Main {
    private static Double total = 0.0d;

    private static void btnClick(String price, String totalNum) {
        CashSuper cs = CashFactory.createCashAccept("满300返100");
        double totalPrices = 0d;
        totalPrices = cs.acceptCash(Double.parseDouble(price) * Double.parseDouble(totalNum));
        total += totalPrices;
        System.out.println("单价：" + price + " 数量：" + totalNum + " 合计：" + total);
    }

    private static void btnClickStrategy(String price, String totalNum) {
        CashContext cc = null;
        cc = new CashContext("打8折");
        // cc = new CashContext(new CashRebate("0.78"));
        double totalPrices = 0d;
        totalPrices = cc.getResult(Double.parseDouble(price) * Double.parseDouble(totalNum));
        total += totalPrices;
        System.out.println("单价：" + price + " 数量：" + totalNum + " 合计：" + total);

    }

    public static void main(String[] args) {
        btnClick("100", "5");
        btnClick("450", "4");

        btnClickStrategy("200", "3");
        btnClickStrategy("300", "1");
    }
}
