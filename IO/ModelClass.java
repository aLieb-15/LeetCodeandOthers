package IO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ModelClass implements Serializable{
    private static final long serialVersionUID = 1000L;

    String name;
    List<Status> m1 = new ArrayList<>();
    List<InnerModel> m2 = new ArrayList<>();

    ModelClass() {
        name = "jth";
        System.out.println(m1.size());
        m1.add(Status.ERROR);
        System.out.println(m1.size());
        m2.add(new InnerModel("jzf"));
    }

    static class InnerModel implements Serializable {
        private static final long serialVersionUID = 1001L;
        String value;

        InnerModel(String val) {
            this.value = val;
        }
    }

    public enum Status {
        OK,
        ERROR,
        NA,
        WARNNING,
        FATAL;
    }
}