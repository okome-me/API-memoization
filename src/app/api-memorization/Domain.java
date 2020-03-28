package app;

import java.util.Arrays;

/**
 * 以下の関数を実装したクラス
 *
 * f(0) = 1
 * f(2) = 2
 * それ以外のn値の場合:
 * f(n) = (
 * if n mod 2 = 0 then
 *   f(n - 1) + f(n - 2) + f(n - 3) + f(n - 4)
 * else
 *   askServer(n)
 * )
 * (askServerは前述のrecursive APIを固定のseedで実行した場合の返り値)
 */
public class Domain {

    String seed;
    Integer[] memo;

    public Domain(Integer n, String seed) {
        this.seed = seed;

        memo = new Integer[n+1];
        Arrays.fill(memo, 0);
    }

    /**
     * メモ化利用した再帰関数
     * @param x 関数の引数
     * @return
     */
    public Integer calculate(Integer x) {

        AskServerService askServerService = new AskServerService(seed);

        if (memo[x] != 0) return memo[x];

        switch (x) {
            case 0:
                return 1;
            case 2:
                return 2;
            default:
                if (x%2 == 0) {
                    memo[x] = calculate(x-1) + calculate(x-2) + calculate(x-3) + calculate(x-4);
                } else {
                    memo[x] = askServerService.request(x);
                }
                return memo[x];
        }
    }
}
