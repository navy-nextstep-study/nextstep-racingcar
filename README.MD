## 기능 예시

```bash
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.
```

## 요구사항

- [X] 자동차는 이름을 가지고 있다.
    - [X] 자동차 이름을 5자를 초과 할 수 없다. `Name#validNameLength`
- [X] 자동차 출력 시 자동차 이름을 같이 출력한다. `Getter` 사용하기.
- [X] 자동차 입력은 쉼표로 구분한다.
    - [X] 자동차 이름 입력 InputView#inputCarName()
    - [X] 입력을 받을 때 split(",")를 이용한다.
    - [X] 게임 플레이 횟수 입력 InputView#inputPlayCount()
- [X] 출력은 출력에 대한 안내사항과 시도 횟수가 있다.
    - [X] 자동차 게임 시작 결과 출력을 시작하는 메시지 출력하기 OutputView#displayStartMsg()
    - [X] 자동차 게임의 회차 당 실행 결과를 출력 OutputView#displayPerPlayResult(Cars cars)
    - [X] 자동차 이름 입력 안내사항 출력하기 OutputView#displayPromptCarName()
    - [X] 시도할 횟수는 몇 회 인지 입력하기 OutputView#printPlayCountRequestMsg()
    - [X] 자동차 게임의 우승자 출력하기 OutputView#displayResult(List<Car> winners)
- [X] 자동차는 random 값은 0 ~ 9 사이여야 한다 4 이상일 경우에만 전진 할 수 있다.
    - [X] 자동차의 이동을 수행한다. Car#move()
- [X] 생성 된 자동차는 일급 컬렉션으로 관리 된다. Cars
    - [X] Cars 일급 컬렉션은 리스트를 전달 받아서 생성된다. Cars(List<Car> car)
    - [X] Cars 일급 컬렉션에서 계산 결과를 반환한다. Cars#calculateWinner()
    - [X] 경기에 참여하는 자동차들은 동시에 연산이 된다. Cars#move()
    - [X] 자동차 게임이 일급 컬렉션인 Cars 갖는다. CarGame
        - [X] 자동차 게임이 실질적인 게임 진행을 관리한다. CarGame#play()
        - [X] 자동차는 정해진 횟수 동안 이동한다.