Spring
======

Spring Repository

# 데이터 요청/응답 방식
모든 요청에 대한 데이터 반환은 Json으로 이루어집니다.


## 1/14 ~ 1/20 1주차 Json 데이터 전송 형식

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
		Pcond : [조건]
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

