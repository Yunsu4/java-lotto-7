# 로또

## 로또에 대한 간단한 설명
로또 구입 금액, 로또의 당첨 번호가 될 숫자를 입력하면
구매한 로또가 당첨된 금액과 수익률을 알려줍니다.

## 입력 규칙

### 로또 구입 금액을 입력할 때 규칙
- 1000원 단위로 입력 가능합니다.
    - 1000원 이상 100000이하로 입력 가능합니다.

- (예외 상황) 
  - 1000원 단위로 나누어 떨어지지 않는 숫자는 입력 불가능 합니다.
  - 0원은 로또를 구입하지 않은 것으로 보아 입력 불가능 합니다.
  - 돈에 쉼표(,)가 포함된 경우는 입력 불가능 합니다. 숫자만 입력해 주세요.
  - 숫자 앞 뒤에 공백을 포함할 경우 입력 불가능 합니다.   
-> 예외 상황의 경우 에러 메시지 출력 후 다시 입력 받습니다.


> **예시**   
> ⭕ 가능한 구입 금액: `1000`, `20000`, `55000`   
> ❌ 불가능한 구입 금액: `800`,`이천원`,`1000+4000`,`0`, `2,000`,` 1000 `

<br>

### 로또 당첨 번호를 입력할 때 규칙
- 당첨 번호 6개를 입력합니다.
  - 이때 숫자는 1부터 45 이내의 중복되지 않는 정수를 입력할 수 있습니다.
  - 숫자는 쉼표(,)를 구분자로 입력합니다.
  - 쉼표 앞 뒤의 공백은 제거됩니다.
  - 숫자 앞 뒤의 공백은 제거됩니다.
   
- (예외 상황) 쉼표 사이의 숫자가 없거나 쉼표로 시작하거나 끝내는 것은 입력 불가능 합니다.
- (예외 상황) 중복되지 않는 1~45 범위의 정수 중 6개를 입력하지 않은 경우   
-> 예외 상황의 경우 에러 메시지 출력 후 다시 입력 받습니다.

> **예시**   
> ⭕ 가능한 당첨 번호: '1,2,3,4,5', `45, 44, 43, 42, 40, 39`, ` 45, 44, 43, 42, 40, 39 `   
> ❌ 불가능한 당첨 번호: `1,, 3, 8, 9, 10, 6`, `, 3, 8, 9, 10, 6`, `1, 3, 8, 9, 10,`   
> `1.2, 3.4, 8, 9, 10, 6`, `1,2,2,4,5,6`, `0,1,2,3,4,47`

<br>

### 보너스 번호를 입력할 때 규칙
- 1개의 보너스 번호를 입력합니다.
  - 이때 보너스 번호는 당첨 번호와 중복되지 않으며, 1부터 45 이내의 정수를 입력할 수 있습니다.

- 당첨 번호와 보너스 번호는 오름차순 혹은 내림차순으로 입력하지 않아도 됩니다.
> ⭕ 가능한 입력: 당첨 번호: `45, 1, 3, 12, 40, 39`, 보너스 번호: `2`

- (예외 상황) 당첨 번호와 중복되지 않는 1~45 범위의 정수 중 1개를 입력하지 않은 경우  
- (예외 상황) 숫자 앞 뒤에 공백을 포함할 경우 입력 불가능 합니다.   
-> 예외 상황의 경우 에러 메시지 출력 후 다시 입력 받습니다.


> **예시**  
> ⭕ 가능한 입력: 당첨 번호: `1,2,3,4,5,6`, 보너스 번호: `45`   
> ⭕ 가능한 입력: 당첨 번호: `45,44,43,42,40,39`, 보너스 번호: `2`   
> ⭕ 가능한 입력: 당첨 번호: `45, 44, 43, 42, 40, 39`, 보너스 번호: `12`   
> ❌ 불가능한 입력: 당첨 번호: `1,2,3,4,5,6`, 보너스 번호: `6`   
> ❌ 불가능한 입력: 당첨 번호: `1,3,2,4,5,6`, 보너스 번호: `47`   
> ❌ 불가능한 입력: 당첨 번호: `1.2, 3.4, 8, 9, 10, 6`, 보너스 번호: `4.7`
> ❌ 불가능한 보너스 번호: `0`, ``, `2-1`, `2,000`

<br>

### 로또 결과 확인
- 발행한 로또 수량 및 번호를 출력합니다. 로또 번호는 오름차순으로 정렬하여 보여줍니다.

>  8개를 구매했습니다.   
[8, 21, 23, 41, 42, 43]    
[3, 5, 11, 16, 32, 38]    
[7, 11, 16, 35, 36, 44]    
[1, 8, 11, 31, 41, 42]    
[13, 14, 16, 38, 42, 45]    
[7, 11, 30, 40, 42, 43]    
[2, 13, 22, 32, 38, 45]    
[1, 3, 5, 14, 22, 45]   

- 당첨 내역을 보여줍니다.
> 3개 일치 (5,000원) - 1개   
4개 일치 (50,000원) - 0개   
5개 일치 (1,500,000원) - 0개   
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개   
6개 일치 (2,000,000,000원) - 0개   

- 수익률을 보여줍니다.
  - 수익률은 당첨 금액/로또 구입 금액 *100 으로 계산합니다.
  - 수익률은 소수점 둘째 자리에서 반올림합니다.
> 총 수익률은 62.5%입니다.

> 총 수익률은 1,000,000.0% 입니다.

<br><br><br><br>

## 기능 목록

### 구매 금액 입력 받기
- 1000원 단위의 구매 금액을 입력 받기
- 유효성 검사(구매 금액)
  - 1000으로 나누어 떨어지는 숫자만 허용
  - 0 입력 제한
  - 빈 입력 제한
  - 현재 최대 구매 금액은 임의로 100000으로 한다.   
  -> 통합 테스트를 통해 구매 금액이 높아짐에 따라 성능의 차이를 확인하고 제한하도록 추가

<br>

### 당첨 번호 6자리 입력 받기
- 1~45 범위 내의 중복되지 않는 정수 입력 받기
- 각 숫자는 쉼표(,)를 구분자로 입력 받기
- 유효성 검사(당첨 번호)
  - 1~45 범위 내의 정수만 허용
  - 중복이 없는 숫자 입력만 허용
  - 빈 입력 제한 (구분자 사이의 숫자가 없는 경우도 빈 입력으로 취급)
  - 구분자는 숫자와 숫자 사이에만 허용

<br>

### 보너스 번호 입력 받기
- 당첨 번호와 중복되지 않는 1~45 범위 내의 정수 한 개 입력 받기
- 유효성 검사
  - 1~45 범위 내의 정수만 허용
  - 당첨 번호와 중복이 없는 숫자 입력만 허용
  - 숫자 한 개만 입력 허용
  - 빈 입력 제한

<br>

### 구매 금액, 당첨 번호, 보너스 번호에 제한된 입력이 들어온 경우
`[ERROR]`로 시작하는 에러 메시지를 출력 후 그 부분부터 다시 입력 받기

<br>

### 구매 금액에 맞게 로또 생성
- `로또 개수: 구매 금액/1000` 로 지정
- 로또 개수 만큼 로또 생성
- 로또 한 개당 1~45 범위 내의 정수 6개를 무작위로 생성하여 번호 부여

<br>

### 당첨 번호와 구매한 로또 번호 비교하여 당첨 내역 생성
- 구매한 로또 한 개씩 로또 번호와 당첨 번호를 비교
- 로또 번호와 당첨 번호가 6개 일치할 경우: 1등, 2,000,000,000원
- 로또 번호와 당첨 번호가 5개 일치할 경우:
  - 일치하지 않는 한 개의 로또 번호가 보너스 번호와 일치할 경우: 2등, 30,000,000원
  - 일치하지 않는 한 개의 로또 번호가 보너스 번호와 일치하지 않을 경우: 3등, 1,500,000원
- 로또 번호와 당첨 번호가 4개 일치할 경우: 4등, 50,000원
- 로또 번호와 당첨 번호가 3개 일치할 경우: 5등, 5,000원

<br>

### 수익률 계산
- 수익률은 당첨 금액/로또 구입 금액 *100 으로 계산
- 수익률은 소수점 둘째 자리에서 반올림

<br><br>

## 실행 결과 예시
```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```
<br><br>

## 예외 목록

- `구매 금액 입력할 때`
  - 1000으로 나누어 떨어지지 않는 숫자를 입력한 경우
  - 1000미만의 수를 입력한 경우
  - 최대 입력 금액을 초과하는 수를 입력한 경우(최대 입력 금액은 임의로 100000으로 한다.)
  - 숫자만 입력되지 않은 경우
  - 빈 입력인 경우


- `당첨 번호 입력할 때`
  - 6개의 숫자를 입력하지 않은 경우
  - 증복되는 숫자를 입력한 경우
  - 1~45 범위 외의 숫자를 입력한 경우
  - 정수가 아닌 수를 입력한 경우
  - 쉼표 이외의 구분자를 사용한 경우
  - 구분자가 숫자와 숫자 사이에 위치하지 않은 경우
  - 구분자와 숫자만 입력되지 않은 경우
  - 빈 입력인 경우 (구분자 사이의 숫자가 없는 경우도 빈 입력으로 취급)


- `보너스 번호 입력할 때`
  - 1개의 숫자를 입력하지 않은 경우
  - 1~45 범위 외의 숫자를 입력한 경우
  - 당첨 번호와 중복되는 숫자를 입력한 경우
  - 빈 입력인 경우


<br><br><br><br>




# 프로그래밍 요구 사항

## 프로그래밍 요구 사항 1

- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 Java Style Guide를 원칙으로 한다.

## 프로그래밍 요구 사항 2

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
  - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
    - JUnit 5 User Guide
    - AssertJ User Guide
    - AssertJ Exception Assertions
    - Guide to JUnit 5 Parameterized Tests 

## 프로그래밍 요구 사항 3
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- Java Enum을 적용하여 프로그램을 구현한다.
- 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  - 단위 테스트 작성이 익숙하지 않다면 LottoTest를 참고하여 학습한 후 테스트를 작성한다.
