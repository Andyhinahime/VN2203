package cn.tedu.jsdvn2203.csmall.server.test;

public class ParameterDemo {
    public static void main(String[] args) {
        ParameterDemo p = new ParameterDemo();
        p.sum(1);
        p.sum(1,2);
        p.sum(1,2,3);
        //調用可不給參數
        p.sum();

    }
    //計算兩個數的和
    public int sum(int a,int b){
        return a+b;
    }
    //計算N個數的和
    public int sum(int... arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

}
