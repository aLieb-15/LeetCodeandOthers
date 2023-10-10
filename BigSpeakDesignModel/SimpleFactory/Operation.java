package BigSpeakDesignModel.SimpleFactory;

// public class Operation {
//     public static Double getResult(Double numA, Double numB, String operator) {
//         Double result = 0d;
//         switch (operator) {
//             case "+" :
//                 result = numA + numB;
//                 break;
//             case "-" :
//                 result = numA - numB;
//                 break;
//             case "*" :
//                 result = numA * numB;
//                 break;
//             case "/" :
//                 result = numA / numB;
//                 break;
//         }
//         return result;
//     }
// }
public class Operation {
    public Double numA;
    public Double numB;

    public Double getNumA() {
        return numA;
    }

    public Double getNumB() {
        return numB;
    }

    public void setNumA(Double numA) {
        this.numA = numA;
    }

    public void setNumB(Double numB) {
        this.numB = numB;
    }

    public Double getResult() throws Exception {
        Double result = 0d;
        return result;
    }
}

class OperationAdd extends Operation {
        public Double getResult() {
            return numA + numB;
        }
    }

    class OperationSub extends Operation {
        public Double getResult() {
            return numA - numB;
        }
    }

    class OperationMul extends Operation {
        public Double getResult() {
            return numA * numB;
        }
    }

    class OperationDiv extends Operation {
        public Double getResult() throws Exception {
            if (numB == 0d) {
                throw new Exception("numB is 0!");
            }
            return numA / numB;
        }
    }