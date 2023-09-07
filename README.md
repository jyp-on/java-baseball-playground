# 숫자야구게임 ToDoList
- 1~9의 숫자중에 랜덤으로 3개의 숫자를 구한다.
- 사용자로부터 입력받는 3개의 숫자 예외처리
  - 1~9사이의 숫자인지
  - 중복이 있는지
  - 3자리인지
- 위치와 값이 같은 경우 - 스트라이크
- 위치는 다른데 값이 있는 경우 - 볼
- 위치, 값 모두 다른경우 - 낫싱
- 사용자가 입력한 값에 대한 실행 결과를 구한다.



PlayResult result = BaseBall.play(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));

com / user
123 / 1 4 - > nothing
123 / 1 2 - > ball
123 / 1 1 - > strike

123 / 3 1 - > ball