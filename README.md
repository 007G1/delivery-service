# delivery-service
# 예제 - 음식배달

# 서비스 시나리오

기능적 요구사항
1. 고객이 메뉴를 선택하여 주문한다
2. 고객이 선택한 메뉴에 대해 결제한다
3. 주문이 되면 주문 내역이 입점상점주인에게 주문정보가 전달된다
4. 상점주는 주문을 수락하거나 거절할 수 있다
5. 상점주는 요리시작때와 완료 시점에 시스템에 상태를 입력한다
6. 고객은 아직 요리가 시작되지 않은 주문은 취소할 수 있다
7. 요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다
8. 라이더가 해당 요리를 pick 한 후, pick 했다고 앱을 통해 통보한다
9. 고객이 주문상태를 중간중간 조회한다
10. 주문상태가 바뀔 때 마다 카톡으로 알림을 보낸다
11. 고객이 요리를 배달 받으면 배송확인 버튼을 탭하여, 모든 거래가 완료된다.

비기능적 요구사항
1. 장애격리
    1. 상점관리 기능이 수행되지 않더라도 주문은 365일 24시간 받을 수 있어야 한다  Async (event-driven), Eventual Consistency
    1. 결제시스템이 과중되면 사용자를 잠시동안 받지 않고 결제를 잠시후에 하도록 유도한다  Circuit breaker, fallback
1. 성능
    1. 고객이 자주 상점관리에서 확인할 수 있는 배달상태를 주문시스템(프론트엔드)에서 확인할 수 있어야 한다  CQRS
    1. 배달상태가 바뀔때마다 카톡 등으로 알림을 줄 수 있어야 한다  Event driven


## Event Storming 결과
* MSAEz 로 모델링한 이벤트스토밍 결과:  
![image](https://user-images.githubusercontent.com/100417759/203254344-8771c9e3-6bfb-4f7a-bc6d-9819a902d568.png)




### 비기능 요구사항에 대한 검증
- Saga(pub/sub)
=> order, food에 대한 state, pay, delivery 소스 코드 수정


- CQRS
=> order에realmodel 적용(create, update, delete)
![image](https://user-images.githubusercontent.com/100417759/203252792-24ef4d47-1a8d-4698-a65c-fa41864e64db.png)


- Compensation / Correlation
=> 상점관리 수행되지 않을 때 주문 받을 수 있도록 store.java의 소스코드 수정
![image](https://user-images.githubusercontent.com/100417759/203234366-e090257d-eb73-476d-99c6-fd51c6267424.png)

- Request / Response
=> order-> pay후 manager check
![image](https://user-images.githubusercontent.com/100417759/203256180-b66f08a6-f841-4809-b7b9-fc9f1a43d6b8.png)

- Circuit breaker
=> pay의 리소스의 application.yml에서 임계치 바꾸고 payment.java의 소스코드 수정해서 delay 발생 유도
![image](https://user-images.githubusercontent.com/100417759/203233269-0004a085-955b-4fb0-949e-e77114693fc2.png)
![image](https://user-images.githubusercontent.com/100417759/203233325-bb6968b3-2f9e-4fab-a058-866bdf74b511.png)
=> 확인
=> ![image](https://user-images.githubusercontent.com/100417759/203255017-fdd435a4-117d-4a04-8a68-6160757c631d.png)

- Gateway
=> gateway에 각 api 엔드포인트 설정(customer, front, rider, store)
=> ![image](https://user-images.githubusercontent.com/100417759/203249962-075435fd-62ac-4847-bd6c-4495fb76dc8b.png)


