package BigSpeakDesignModel.StrategyModel;

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
