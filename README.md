![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f1566dec-587f-43db-85b7-c2acebf02ff7/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/58cf7b16-7bc9-4d64-a50e-f7e44b93121e/Untitled.png)

## 프로젝트 개요

---

SSAFY 8기 2학기 특화 프로젝트

6인 제작, 23.02.20 ~ 23.04.07 (총 7주)

## 프로젝트 특징

---

- 4:1 비대칭 서바이벌 술래잡기 게임
- 유저간 실시간 소통이 가능한 메타버스 로비
- 다양한 업적 및 보상시스템

## 서비스 대상

---

- 여러 사람들과 함께 긴장감 넘치는 술래잡기 게임을 하고 싶은 사람
- 아기자기한 마을에서 친구들과 추억을 만들고 싶은 사람

## 주요 기능

---

1. 대기 단계에서 유저 간 실시간 소통, 이벤트, 상호작용으로 재미있는 사용자 경험 제공
    - 다수의 어트랙션 탑승 가능
    - 유저끼리 채팅으로 소통 가능
2. 특색있는 컨셉과 직관적인 규칙으로 재치있는 긴장감 유도
3. 귀여운 플레이어 캐릭터로 진입장벽 완화
    - 메타버스에서 즐길 수 있는 다양한 캐릭터와 착용 가능한 모자(아바타) 제공

## 주요 기술

---

- photon의 Remote Procedure Calls으로 메타버스 및 인게임에서 유저간 실시간 동기화 원활하게 제공
- Occlusion Culling 및 카메라 렌더링 거리 조절로 최적화
- 직접 제작 및 편집한 애니메이션, 모델링, 리깅, GUI 다수

## 기술 스택

---

- Game Client
    - Unity Client
- Game Server
    - Photon Server
- FE
    - React.js

## 설계

---

### 아키텍처

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/950ba729-1f62-4cc5-9a5b-4938a18fa979/Untitled.png)

### ERD

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/efe83460-4a3b-4a21-952d-953d4ac13cea/Untitled.png)

### 와이어프레임

https://www.figma.com/embed?embed_host=notion&url=https%3A%2F%2Fwww.figma.com%2Ffile%2FCHy5mHE2huckKXflhWVSMf%2FMETA%3Ftype%3Ddesign%26node-id%3D55-2%26t%3D7nTJoahnqLdkddPn-0

## **프로젝트 상세 설명**

---

![Image Pasted at 2023-4-13 10-54.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/dcd9e48d-f455-4825-a92d-a91867bc4ab9/Image_Pasted_at_2023-4-13_10-54.png)

### 트레일러

https://youtu.be/QVzdH992D64

### **게임 설명/주요 기능**

https://youtu.be/7ttuP_85A0A

## 🕹️조작법🕹️

### 제어

캐릭터 이동 : wasd

달리기 : shift

점프 : space

웅크리기 : ctrl

카메라 회전 : alt

관전 카메라 전환 : tab

요리사 공격 : 왼쪽 마우스 클릭

### 상호작용

아이템 줍기 / 버리기 / 교환 : f

아이템 사용 q

오브젝트 상호작용 : e

### 기타

지도 : m

감정표현 : 1, 2 ,3 ,4

## 📋규칙📋

### 🍅식재료

- `식재료`는 맵에 존재하는 `밸브`를 상호작용으로 잠굴 수 있습니다.
- `밸브`를 잠군다면 같은 색의 `냄비`를 상호작용으로 밀어 넘어뜨릴 수 있습니다.
- 넘어뜨린 `냄비`가 4개가 된다면 맵에 랜덤으로 `탈출구`가 생성됩니다.
- 1분내에 `탈출구`를 찾아 탈출하게 된다면 승리!

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d324d53a-3dcc-44a0-bec3-484ca0efd6bb/Untitled.png)

### 👨🏻‍🍳요리사

- `요리사`는 **마우스 왼쪽 클릭**을 통하여 **공격**을 할 수 있습니다.
- 공격에 맞은 `식재료`는 일정시간 스턴에 걸립니다.
- `요리사`는 스턴에 걸린 `식재료`를 상호작용을 통해 포획할 수 있습니다.
- 포획한 `식재료`를 맵에 존재하는 큰 `싱크대`에 상호작용을 통해 `식재료`를 가둘 수 있습니다.
- 모든 `식재료`를 `싱크대`에 가둔다면 승리!

## 🍬아이템🍬

아이템은 맵 상에 랜덤으로 스폰됩니다.

아이템을 소지하게 된다면 아이템에 따라 이동속도 감소가 있습니다.

### 나무젓가락

`싱크대`에 갇힌 `식재료`를 구출해 줄 수 있습니다.

다만 구출한다면 가지고 있던 `나무젓가락`은 사라집니다.

### 키친타월

`나무젓가락`을 통해 구출된 `식재료`는 물에 젖어 몸이 무겁습니다.

물에 젖어 있는 동안 이동속도 감소와 발자국이 남습니다.

`키친타월`을 사용하여 몸을 닦아 디버프를 제거할 수 있습니다.

## 협업 툴 및 환경

---

- Git
- GitLab
- Jira
- Notion
- Mattermost
