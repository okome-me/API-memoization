package app;

public class App {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("引数を2つ指定して下さい");
            System.out.println("第１引数：API実行時に使用するseed文字列");
            System.out.println("第２引数：再帰関数で結果を計算するn整数値");
            System.exit(1);
        }
        if (!Logic.checkIsIntegerValue(args[1])) {
            System.out.println("第２引数は整数値を入力して下さい");
            System.exit(1);
        }

        String seed = args[0];

        Integer n = Integer.parseInt(args[1]);

        Domain domain = new Domain(n, seed);
        System.out.println(domain.calculate(n));
        System.exit(0);
    }
}
