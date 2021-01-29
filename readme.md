Spring
======

Spring Repository

# 데이터 요청/응답 방식
기본적으로 요청/응답은
응답 측에서 도메인을 열어놓고 요청은 해당 도메인에 요청을 하여 그에 맞는 Response를 얻습니다.

|요청측|응답측|
|------|------|
|도메인존재X|도메인존재|
|요청 시 응답측 도메인에 접근|요청 방식, 리턴 값 설정해두고 도메인 오픈|

***즉, 우리가 요청을 받는 쪽이면 RequestMapping을 통해 URL을 열어두면 되는 것이고,***

***우리가 요청을 하는 쪽이면 제시된 URL에 RestTemplate로 요청하여 응답을 받아오면 됩니다.***

모든 요청에 대한 데이터 반환은 Json으로 이루어집니다.


## Json 데이터 전송 형식

### 문제 리스트 요청/응답
	{
		Problems : [
		{
			Pnum : [1001]        //문제 번호
			Pname : [A+B]         //문제 이름
			Solved : T            //T, F, Null 3가지 종류만 존재 String type
		},
		{
			Pnum : [1002]
			Pname : [A-B] 
			Solved : Null
		},
		… 총 5문제]
	}

### 문제 내용 요청
	{
  		Pnum : [문제 번호]
	}

### 문제 내용 요청에 대한 응답
	{
		Pnum : [문제 번호]
		Pname : [문제 이름]
		Solved : [풀이 여부(T, F, Null)]
		Pcond : [시간 제한, 메모리]
		Pdetail : [내용, input 조건, output 조건]
		Pinout : [예시 input, 예시 output]
	}

### 제출 시에 오고 가는 Request
React -> Spring

	{
		UserID : [ID]
		Pnum : [문제 번호]
		Pcode : [제출 코드]
	}

Spring -> Engine

	{
		SubNum : [제출 번호]
		Pnum : [문제 번호]
		Pcode : [제출 코드]
	}
Spring -> Flask

	{
		SubNum : [제출 번호]
		Pnum : [문제 번호]
		UserID : [ID]
	}

### 채점 결과 요청에 따른 Response

Engine -> Spring

	{
		SubNum : [제출 번호]
		Result : [채점 결과]
	}

Spring -> Flask

	{
		SubNum : [제출 번호]
		Result : [채점 결과]
	}

Spring -> React

	{
		SubNum : [제출 번호]
		Result : [채점 결과]
	}
## 1/14 ~ 1/20 1주차 목표
~~문제 리스트 보관 방법 논의~~

~~문제 화면 구성 데이터 받아오기~~

~~코드 제출 시퀀스~~

## 1/20 ~ 1/27 2주차 목표
~~채점 큐 구현~~

~~코드 refactoring~~

~~코드 파싱 issue~~

