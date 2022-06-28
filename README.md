#  🏃‍♂️ PT Schedule

> ## 1. 기획 의도
>> 
![image](https://user-images.githubusercontent.com/58438267/176190265-b85cec18-8da0-4852-87f3-f982a508443b.png)
<br>&nbsp; - 시간이 지날수록 사람들의 여가시간이 증가하고 있다. 서울시, '서울시민의 여가생활과 휴식'에 관한 빅데이터 분석 결과를
발표했다. 서울 시민이 주중 여가 생활은 TV/인터넷/게임이 1 위를 차지하고 2 위가 운동으로
17.5% 였다. PTS 는 여가시간에 운동을 하는 비율이 증가하는 추세인 흐름에 따라 사용자가
직접 PTS 를 자기 시간에 맞게 설정함으로써 편리성과 간편성을 제공한다. 더 나아가 관리자
가 사용자의 PT 에만 신경 쓸 수 있도록 간편하고 편리한 기능을 제공한다. 단순한 Schedule 
System 이 아닌 종합적인 플랫폼으로 확장 가능성을 지닌 시스템이다.

> ## 2. 함수
>>
```
2.1 로그인 및 회원가입
- 사용자는 회원가입을 하고 핸드폰 번호로 로그인을 한다. 관리자는 주어진 이
 름과 번호로 회원가입 후 로그인한다. 휴대폰 번호는 중복이 안된다.
2.2 PT 구매 및 사용
- 사용자는 로그인 후 PT 를 구매 후 사용한다. PT 사용시 현재 날짜를 기준으로
 이전 날짜에는 사용이 불가하고 PT 수가 0 이면 사용이 불가능하다.
2.3 PT 조회
- 사용자와 관리자는 해당 날짜를 기준으로 이번주와 다음주의 Schedule을 조회
 가 가능하다. 해당 날짜의 이전 날짜는 사라진다.
2.4 회원 정보 조회 및 수정
- 회원 정보를 조회하면 이름과 번호가 표시된다. 회원 정보 중 이름 변경 시
 자동으로 Schedule 에 이름이 변경된다. 번호 변경 시 로그인 할 때 변경된
 번호로 로그인을 해야 성공한다.
2.5 로그아웃 및 종료
- 관리자 및 사용자는 로그아웃을 하면 첫 화면인 [회원가입,로그인,종료] 창으
 로 돌아간다. 종료는 프로그램을 종료시킨다.
2.6 현재 매출 출력 및 PT 수정
- 관리자는 사용자가 Pt 구매 횟수를 누적하여 총 매출을 확인 가능하다. Pt 수정
 을 통해 사용자의 스케줄을 추가, 변경, 삭제가 가능하다
```

> ## 3. Use case Diagram & class Diagram
>>
&nbsp;&nbsp;3-1. Use Case Diagram
<br>![image](https://user-images.githubusercontent.com/58438267/176191139-71640b89-879d-4b00-94a6-1443790594a1.png)
<br> &nbsp;&nbsp;3-2. class Diagram
<br> ![image](https://user-images.githubusercontent.com/58438267/176191288-f0008515-58e6-46a5-bc88-0b83128f830f.png)

> ## 4. User Interface Overview
>>
![image](https://user-images.githubusercontent.com/58438267/176191704-1e145bfe-54af-4160-8a57-663c91d6ac26.png)
 - 사용자는 회원가입 후 로그인하여 메인 페이지로 넘어간다.<br>
 - 메인 페이지에서 사용자가 원하는 기능을 제공한다.
