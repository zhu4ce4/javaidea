package test;

/*
题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
*/
class FlowerData {
    private String num;

    public FlowerData(int aNum) {
        num = "" + aNum;
    }

    public String getNum() {
        return num;
    }

    public boolean isFlowerDataOrNot() {
        int totalCount = 0;
        for (int i = 0; i < num.length(); i++) {
            totalCount += Math.pow(num.charAt(i) - '0', 3);
        }
        return (Integer.parseInt(num) == totalCount);
    }
}

class FlowerTest {
    public static void main(String[] args) {
        int flowerDataCount = 0;
        for (int i = 100; i < 154; i++) {
            FlowerData f = new FlowerData(i);
            if (f.isFlowerDataOrNot()) {
                System.out.printf("%s是水仙花数\n", f.getNum());
                flowerDataCount++;
            } else {
                System.err.printf("%s不是水仙花数\n", f.getNum());
            }
        }
        System.out.println("总共有" + flowerDataCount + "个水仙花数.");
    }
}
