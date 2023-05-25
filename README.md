![Start.png](/Images/Start.png)

<br/>

# 🚩 프로젝트 소개

## ✔ 프로젝트 명

![Title.png](/Images/Title.png)

<br/>

## ✔ 프로젝트 개요

SSAFY 8기 2학기 특화 프로젝트

6인 제작, 23.02.20 ~ 23.04.07 (총 7주)

<br/>

## ✔ 프로젝트 특징

- 4:1 비대칭 서바이벌 술래잡기 게임
- 유저간 실시간 소통이 가능한 메타버스 로비
- 다양한 업적 및 보상시스템

<br/>
<br/>

# 🏆 프로젝트 성과

![Metaverse.png](/Images/Metaverse.png)

- **SSAFY 특화 프로젝트 경진대회 1등**

- photon의 Remote Procedure Calls으로 메타버스 및 인게임에서 유저간 실시간 동기화 원활하게 제공
- Occlusion Culling 및 카메라 렌더링 거리 조절로 최적화
- 직접 제작 및 편집한 애니메이션, 모델링, 리깅, GUI 다수

<br/>

# 🔧 주요 기능

### 쿡스 아일랜드 - 메타버스

- 사용자끼리 실시간으로 채팅으로 소통하고 상호작용 할 수 있는 메타버스 월드입니다.
- 월드 입장 전, 원하는 캐릭터(재료)를 선택할 수 있습니다.
- 탑승할 수 있는 다양한 놀이기구, 멋있는 풍경으로 재미를 더했습니다.

### 주방 대소동 - 1:4 비대칭 술래잡기

- 요리책(게임참가 메뉴)을 열어 현재 생성된 방 리스트에서 입장하거나, 새로운 방을 만들어 입장합니다.
- 원하는 역할을 선택합니다. (요리사, 식재료)
- 요리사 1명, 식재료 4명이 모이면 자동으로 게임이 시작됩니다.

### 게임 설명

[![Howto](https://img.youtube.com/vi/7ttuP_85A0A/0.jpg)](https://youtu.be/7ttuP_85A0A)

<br/>

## 🕹️조작법🕹️

![Metaverse.png](/Images/Key.png)
<br/>

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

## 기타

지도 : m

감정표현 : 1, 2, 3, 4

<br/>

## 📋규칙📋

### 🍅식재료

- `식재료`는 맵에 존재하는 `밸브`를 상호작용으로 잠굴 수 있습니다.
- `밸브`를 잠군다면 같은 색의 `냄비`를 상호작용으로 밀어 넘어뜨릴 수 있습니다.
- 넘어뜨린 `냄비`가 4개가 된다면 맵에 랜덤으로 `탈출구`가 생성됩니다.
- 1분내에 `탈출구`를 찾아 탈출하게 된다면 승리!

![Howto1.png](/Images/Howto1.png)

### 👨🏻‍🍳요리사

- `요리사`는 **마우스 왼쪽 클릭**을 통하여 **공격**을 할 수 있습니다.
- 공격에 맞은 `식재료`는 일정시간 스턴에 걸립니다.
- `요리사`는 스턴에 걸린 `식재료`를 상호작용을 통해 포획할 수 있습니다.
- 포획한 `식재료`를 맵에 존재하는 큰 `싱크대`에 상호작용을 통해 `식재료`를 가둘 수 있습니다.
- 모든 `식재료`를 `싱크대`에 가둔다면 승리!

### 🍬아이템🍬

- 아이템은 맵 상에 랜덤으로 스폰됩니다.

- 아이템을 소지하게 된다면 아이템에 따라 이동속도 감소가 있습니다.

**나무젓가락**

- `싱크대`에 갇힌 `식재료`를 구출해 줄 수 있습니다.

- 다만 구출한다면 가지고 있던 `나무젓가락`은 사라집니다.

**키친타월**

- `나무젓가락`을 통해 구출된 `식재료`는 물에 젖어 몸이 무겁습니다.

- 물에 젖어 있는 동안 이동속도 감소와 발자국이 남습니다.

- `키친타월`을 사용하여 몸을 닦아 디버프를 제거할 수 있습니다.

<br/>
<br/>

# 📺 서비스 화면

### 트레일러

[![Trailer](https://img.youtube.com/vi/QVzdH992D64/0.jpg)](https://youtu.be/QVzdH992D64)

<br/>
<br/>
여기에 화면 녹화 / gif 들어가야함
<br/>

# 기술 스택

- Game Client
  - Unity Client
- Game Server
  - Photon Server
- FE
  - React.js

<br/>

# 설계

### 아키텍처

![Architecture](/Images/Architecture.png)

### ERD

![ERD.png](/Images/Erd.png)

### 와이어프레임

https://www.figma.com/embed?embed_host=notion&url=https%3A%2F%2Fwww.figma.com%2Ffile%2FCHy5mHE2huckKXflhWVSMf%2FMETA%3Ftype%3Ddesign%26node-id%3D55-2%26t%3D7nTJoahnqLdkddPn-0

<br/>

# 협업 툴 및 환경

- Git
- GitLab
- Jira
- Notion
- Mattermost
