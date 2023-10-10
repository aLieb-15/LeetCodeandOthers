package BaiduAgain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, MyTable> tables = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String temp = sc.nextLine();
            int dataCount = Integer.valueOf(temp.split(" ")[0]);
            int prpoNum = Integer.valueOf(temp.split(" ")[1]);
            String prpoString = sc.nextLine();
            MyTable table = new MyTable(name, prpoNum, dataCount, prpoString);
            tables.put(name, table);
            for (int j = 0; j < dataCount; j++) {
                String data = sc.nextLine();
                table.insertData(data);
            }
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String sqlString = sc.nextLine();
            String[] splited = sqlString.split(" ");
            if (splited[0].equals("select")) {
                String tableName = splited[splited.length - 1];
                tableName = tableName.substring(0, tableName.length() - 1);
                tables.get(tableName).selectData(sqlString);
            } else {
                String tableName = splited[1];
                tables.get(tableName).updateData(sqlString);
            }
        }
    }
}

class MyTable {
    private String name;
    private int prpoNum;
    private int dataCount;
    private List<String> prpoAndData;
    private Map<String, Integer> prpoMap;

    public MyTable(String name, int prpoNum, int dataCount, String prpoString) {
        this.name = name;
        this.prpoNum = prpoNum;
        this.dataCount = dataCount;
        prpoAndData = new ArrayList<>();
        prpoMap = new HashMap<>();
        String[] prpos = prpoString.split(" ");
        for (int i = 0; i < prpos.length; i++) {
            String prpo = prpos[i];
            prpoAndData.add(prpo);
            prpoMap.put(prpo, i);
        }
    }

    public void insertData(String dataString) {
        for (String data : dataString.split(" ")) {
            prpoAndData.add(data);
        }
    }

    public void selectData(String sqlString) {
        String[] splited = sqlString.split(" ");
        String prpoString = splited[1];
        String[] prpos = prpoString.split(",");
        int count = prpos.length;
        prpoString = "";
        for (int i = 0; i < prpos.length; i++) {
            if (i == 0) {
                prpoString = prpoString + prpos[i];
            } else {
                prpoString = prpoString + " " + prpos[i];
            }
        }
        System.out.println(prpoString);
        for (int i = 0; i < dataCount; i++) {
            String[] datas = new String[count];
            for (int j = 0; j < count; j++) {
                int startIndex = prpoMap.get(prpos[j]);
                int dataIndex = startIndex + prpoNum * (i + 1);
                datas[j] = prpoAndData.get(dataIndex);
            }
            String dataOut = "";
            for (int p = 0; p < count; p++) {
                if (p == 0) {
                    dataOut = dataOut + datas[p];
                } else {
                    dataOut = dataOut + " " + datas[p];
                }
            }
            System.out.println(dataOut);
        }
    }

    public void updateData(String updateString) {
        String[] splited = updateString.split(" ");
        int setIndex = 0, whereIndex = 0;
        for (int i = 0; i < splited.length; i++) {
            if (splited[i].equals("set")) {
                setIndex = i;
            }
            if (splited[i].equals("where")) {
                whereIndex = i;
            }
        }
        for (int i = setIndex + 1; i < whereIndex; i++) {

        }
    }
}
