# 미션 - 로또

--- 

## 🚀 기능 요구 사항

로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다.

```
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
```

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

---

## 🔧 기능 목록

- [ ] 로또 구입 금액을 입력받는다.
    - 최소 구입 금액인 1,000원 미만 입력시 예외 발생
    - 최대 구입 금액인 10만원 초과 입력시 예외 발생
    - 구입 금액은 1,000원 단위이며 1,000원으로 나누어 떨어지지 않으면 예외 발생
    - 숫자 이외의 다른 문자나 특수문자가 입력되면 예외 발생
- [ ] 구입 금액에 해당하는 만큼 로또를 발행한다. (로또 1장당 1000원)
- [ ] 로또 번호를 생성한다.
    - 생성된 숫자의 개수가 6개가 아니면 예외 발생
    - 생성된 숫자가 1 ~ 45 내의 숫자가 아니면 예외 발생
    - 중복된 숫자가 있는 경우 예외 발생
- [ ] 발행된 로또를 출력한다.
- [ ] 당첨 번호 6개와 보너스 번호 1개를 입력받는다.
    - 당첨 번호와 보너스 번호는 1 ~ 45 사이의 숫자 이외의 값을 입력받으면 예외 발생
    - 중복된 번호를 입력하면 예외 발생
- [ ] 당첨 번호와 사용자가 구매한 로또 번호를 비교하여 당첨 내역을 생성한다.
- [ ] 수익률을 계산한다. (소수점 둘째 자리에서 반올림)
- [ ] 당첨 내역 및 수익률을 출력한다.

---

## 🗃️ 디렉토리 구조

### Controller

- LottoGame : 로또 게임 기능의 흐름을 담당한다.

### Domain

- LottoTicketMaker : 로또를 발행하고 당첨내역 및 수익률을 생성하는 역할을 한다.
- LottoNumberGenerator : 로또 번호를 생성하는 역할을 한다.
- PrizeNumbers : 당첨번호와 보너스 번호를 담는 값 객체
- LottoRank : 로또 등수 정보를 가진다.
- LottoPrizeDetails : 당첨 내역과 당첨 금액을 담는 값 객체
- Lotto : 로또의 6개 숫자를 가지는 일급컬렉션
- Money : 금액의 값 객체
- YieldRate : 수익률 값 객체

### Util

- LottoGuideMessage : 로또 게임 안내 메시지
- ErrorMessage : 예외 상황 관련 메시지

### View

- InputView : 사용자로부터 입력을 받는다.
- OutputView : 사용자에게 출력을 한다.

---