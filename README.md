- 안녕하세요 2주차 과제 공유드립니다 저의 코드에 대한 설명은 아래에 작성 하겠습니다 한번 읽어봐 주세요

- 공통

readLine으로 입력을 받을까 했었지만 BufferedReader가 조금 더 빠르다고 얘기를 들어서 BufferedReader를 import 하여 구현하였습니다

추상 클래스를 사용하여 상속을 받았기는 했는데 이게 interface와 어떤 차이가 있는지 잘 몰라서 해당 부분의 차이와 어떤 방법으로 활용해야 잘 활용 할 수 있는지 문의드립니다

- 이 부분은 제가 어떤 부분이 더 빨라진 건지 잘 몰라서 한번 피드백 해주시면 감사하겠습니다

- lv1, lv2
  
사실상 같은 내용이고 나머지 연산자를 잘 활용하냐 안 활용하냐의 차이로 인지했습니다

따라서 해당 부분은 when문을 적절히 사용하여서 간단하게 계산기 구현했습니다

자세한 내용은 Lv1AndLv2.kt 참고 부탁드립니다

- Lv3, Lv4

Lv4 구현을 위해서 일단 추상 클래스로 바꿨지만 Lv3을 구현할 때 드는 생각이 차라리 interface를 사용해서 계산기의 구현을 안내를 하자 여서

abstract class Calculator가 원래 interface Calculator 이었던 점 참고 부탁드립니다

(당연히 abstract fun result(num1:Int, num2:Int):Int -> 이부분도 abstract는 안썼고 인터페이스를 받았기 때문에 상속을 받는 클래스들도 Calculator() 이게 아닌 Calculator이걸로 받았습니다)

Lv3과 Lv4에서는 각각의 계산을 수행할 수 있는 클래스와 이걸 전체적으로 안내하는 추상 클래스를 하나 만들어서 추상 클래스를 연산을 수행하는 클래스에 상속을 받을 수 있도록 하였습니다

- 기타

계산이 끝나도 =을 넣기 전까지 추가적으로 연산이 가능한 부분

입력자가 잘못 입력하는 부분을 간단하게 식별하는 코드도 구현하였습니다

+ 추가
  
Validation 기능 함수로 구현한 Validator.kt 파일을 추가했습니다

코드 가독성을 개선 시켰습니다
