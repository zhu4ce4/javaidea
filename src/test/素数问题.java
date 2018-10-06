package test;


/*
题目：判断101-200之间有多少个素数，并输出所有素数。素数又叫质数，就是除了1和它本身之外，再也没有整数能被它整除的数。也就是素数只有两个因子。
*/
class SuShu {
    private int shu;

    public SuShu(int num) {
        shu = num;
    }

    public int getShu() {
        return shu;
    }

    public boolean isSuShuOrNot() {
        for (int i = 2; i < shu; i++) {
            if (shu % i == 0) {
                return false;
            } else {
                continue;
            }
        }
//        System.out.println("是素数：" + shu); //不要在方法里面直接打印，应该返回true或者false值；之后在调用该函数的地方进行if判断后再打印！！！！
        return true;
    }
}

class SuShuTest {
    public static void main(String[] args) {
        int countNumOfSuShu = 0;
        System.out.println("是素数：");
        for (int i = 101; i < 200; i++) {
            SuShu ashu = new SuShu(i);
            if (ashu.isSuShuOrNot()) {
                countNumOfSuShu++;
                System.out.print(ashu.getShu() + "  ");
            }
        }
        System.out.printf("\n总共有素数: %d个", countNumOfSuShu);
    }
}
