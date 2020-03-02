# APIコール再帰関数

ask APIの実行に使用するランダムな文字列(seed)を生成するAPIです。
実装が要求されている再帰関数の入力値に対する最終的な解答も合わせて返されます。

- Endpoint: `/api/recursive/generate`
- HTTP Method: GET
- Parameters(Query)
  - n: 解を求める入力の数値。必須。
- Response: JSON。フォーマットは下記
  - APIの実行に成功した場合は、`200 OK`でJSONが返ります。
  - APIの実行に失敗した場合(nパラメータが指定されなかった場合)は、`400 BadRequest`が返ります。

レスポンスのJSONには以下のキーが含まれます。

- seed: 生成されたランダムな文字列
- n: 入力された`n`パラメータ
- result: seedとnに対応する再帰関数の解答


例
```
$ curl https://codecheck-challenge-api.herokuapp.com/api/recursive/generate?n=40
{"seed":"bf7bcfb9-8c17-4db4-99b4-27c0fd8c1860","n":40,"result":3539558}
```

ask

再帰関数の定義中に現れるaskServerに相当。
実行のためにパラメータとしてseed文字列と数値が必要であり、同じ入力に対しては必ず同じ値を返します。

返り値はseedとnから計算したハッシュ値を元に、1-300の範囲内の数字が計算されて返ります。

ただし、この関数は同じseed文字列に対しては１時間に50回までしか実行することはできません。

- Endpoint: `/api/recursive/ask`
- HTTP Method: GET
- Parameters(Query)
  - seed: 解を求める入力のseed文字列。必須。
  - n: 解を求める入力の数値。必須。
- Response: JSON。フォーマットは下記
  - APIの実行に成功した場合は、`200 OK`でJSONが返ります。
  - APIの実行に失敗した場合(nパラメータが指定されなかった場合)は、`400 BadRequest`が返ります。
  - APIが１時間以内に51回以上実行された場合は、`503 Service Unavailable`が返ります。
  - 1時間経つとサーバー側のカウンタがリセットされるので再び同じseedでもAPIを実行できるようになります。

レスポンスのJSONには以下のキーが含まれます。

- seed: 生成されたランダムな文字列
- n: 入力された`n`パラメータ
- result: seedとnに対応する再帰関数の解答


例
```
$ curl https://codecheck-challenge-api.herokuapp.com/api/recursive/ask?n=3&seed=bf7bcfb9-8c17-4db4-99b4-27c0fd8c1860
{"seed":"bf7bcfb9-8c17-4db4-99b4-27c0fd8c1860","n":3,"result":151}
```

#### 実装する再帰関数の要件
以下の要件を満たす関数f(x)を実装しなさい。

- f(0) = 1
- f(2) = 2
- それ以外の場合は `f(x) = if x mod 2 = 0 then f(x − 1) + f(x − 2) + f(x − 3) + f(x − 4) else askServer(x)`
  - askServerは上記のask APIを固定のseedで実行した場合の返り値

#### 入力ルール
- 作成するCLIアプリケーションは引数を二つ取ります。
- 第一引数: API実行に使用するseed文字列
- 第二引数: 再帰関数で結果を計算する入力値

#### 処理ルール
- 上記、再帰関数の要件を満たす関数を実装し、入力値に対して計算を行ってください。
- APIの実行回数に制限があるので最適化を行わないと計算不能になります。

#### 出力ルール
- 最終的な計算結果のみを標準出力に出力。
- 入力パラメータが与えられなかったケースは標準エラー出力にエラーメッセージを出力。