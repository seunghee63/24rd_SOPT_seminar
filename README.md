# 24rd_SOPT_seminar

# 1주차

#### 1. 안드로이드
##### 1.1 프로젝트 구조
Menifest : 앱에 대한 정보 ex) 앱 이름
Activity : 화면 전체를 채우는 하나의 뷰
Drawable : 앱에서 사용할 리소스를 모아둠 ex) 이미지 자료
Values : 앱에서 사용하는 값(대명사) 정의 ex) color, string, styles,,
Build : 외부라이브러리, sdk정보

##### 1.2 외부 라이브러리
###### 외부라이브러리 등록 방법
gradle>dependency
1) Project Structure>app>dependency>library dependency
2) 직접입력

#### 2. Activity와 intent
##### 2.1 Activity란
##### 2.2 Activity 생명주기
##### 2.3 Activity 전환
		var intent = Intent(this, LoginActivity::class.java)
		intent.putExtra("id",1)
		startActivity(intent)
line 1)  intent의 매개변수(현재 액티비티, 전환 액티비티)
line 2)  보낼때는 자료형에 상관 없이 **putExtra** (단, 받을때는 자료형에 맞는 메소드를 사용해야 함.)

#### 3. Layout UI 구성하기
##### 3.1 View와 ViewGroup
##### 3.2 Attribute
###### padding vs margin
padding : 내부 컨텐츠와의 간격
margin : 다른 뷰와의 간격
##### 3.3 기타
###### TitleBar 가 없는 Activity
menifest => application태그의 theme 속성 => AppCompat.Light.NoActionBar
###### 둥근 모서리 스타일
res/drawable/new_style.xml

속성
solid : 배경 채우기 속성
stroke : 테두리 속성
corners : 모서리 속성

###### 앱에서 사용할 값 정의
*자주 사용하는 색 지정
res/color.xml
color태그의 name속성에는 값(대명사), 태그 안에는 색상 코드값

*TitleBar를 없애는 다른방법
res/style.xml
style태그의 parent속성을 "Theme.AppCompat.Light.NoActionBar"

#### 4. 이벤트 핸들링
##### 4.1 OnFocusChangeListener
View에 Focus가 잡혔을때 이벤트 처리

        edt_login_id.setOnFocusChangeListener { v, hasfocus ->
            if(hasfocus == true)
                v.setBackgroundResource(R.drawable.primary_border_gray)
            else
                v.setBackgroundResource(R.drawable.primary_border)
        }
line 1) **setOnFocusChangeListener**의 인자(바뀌는 뷰, 활성화가 되었는가(Boolean) ) ->
line 2)  활성화가 되면 테두리가 primary_border_gray style로, 
line 4)  그렇지 않으면 primary_border style로
