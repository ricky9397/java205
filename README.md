# java205

# HTMLCSS
HTMLCSS

1. 제목(글머리) 작성 

# H1, 제목                                  
## H2, 부제목                            
### H3, 소제목
#### H4, 제목4
##### H5, 제목5
###### H6, 제목6
 

2. 번호 없는 리스트 작성

* 리스트 1
- 리스트 2
+ 리스트 3
 

3. 번호 있는 리스트 작성

1. 리스트 1
2. 리스트 2
3. 리스트 3 
 

4. 이텔릭체(기울어진 글씨) 작성

*텍스트* 혹은 _텍스트_
 

5. 굵은 글씨 작성

**텍스트** 혹은 __텍스트__
 

6. 인용

> 텍스트

> > 텍스트 ( > 기호 하나 더 추가할 경우 인용문 안에 또 인용문 추가)
 

7. 수평선 넣기

하단의 기호 3개 이상 나열
***   
---
___ 
 

8. 링크 달기 

(1) 인라인 링크
[텍스트](링크 주소)

(2) 참조 링크
[텍스트][참조명]
[참조명]: 링크 주소
 

![image](https://user-images.githubusercontent.com/84554175/123606499-e911f080-d837-11eb-95bc-d2674e5d5c2e.png)
 

10. 코드 블록 추가하기

```
코드
코드
코드
```
(주의! 작은따옴표 아닙니다. 악센트 기호에요. 맥의 경우, option 키 + ~키(₩키) 를 같이 눌러주시면 악센트 기호를 넣을 수 있습니다.)
 

etc. 

[문자열 개행]
방법1. 문장 마지막에 스페이스 두 번 이상 입력
방법2. html <br> 태그를 사용

[글씨 취소선 넣기]
~~텍스트~~

[체크박스 넣기]
* [x] 체크박스
* [ ] 빈 체크박스

[이모지 넣기]
맥 기준: control + command + space bar 
윈도우 기준: window key + . (윈도우 로고 키 + 마침표)

[표 넣기]
|왼쪽 정렬|가운데 정렬|오른쪽 정렬|
|:---|:---:|---:|      // :의 위치가 정렬을 결정
|내용1|내용2|내용3|
|내용1|내용2|내용3|
 

Github README.md에 이미지 추가하는 방법
![image](https://user-images.githubusercontent.com/84554175/123601241-66d2fd80-d832-11eb-8326-a5b1bda6cdd5.png)
![image](https://user-images.githubusercontent.com/84554175/123601276-718d9280-d832-11eb-83d0-93890cdb6c6d.png)
![image](https://user-images.githubusercontent.com/84554175/123601411-9bdf5000-d832-11eb-9f09-910c43c51e27.png)
![image](https://user-images.githubusercontent.com/84554175/123601442-a568b800-d832-11eb-8bb1-1162e91445b3.png)
![image](https://user-images.githubusercontent.com/84554175/123601463-ad285c80-d832-11eb-81ce-9dcddc75c015.png)
위에 정리한 내용을 바탕으로 README.md를 작성해보면 다음과 같은 결과가 나옵니다.

# MARKDOWN
MARKDOWN 정리, 실습 for README.md

# 1. 제목(글머리) 작성
# H1 제목  
## H2 부제목
### H3 소제목
#### H4 제목4
##### H5 제목5
###### H6 제목6


# 2. 번호 없는 리스트 작성
* 리스트1
  - 리스트2
    + 리스트3
    
# 3. 번호 있는 리스트 작성
1. 리스트1
2. 리스트2
3. 리스트3 

# 4. 이텔릭체(기울어진 글씨) 작성
*텍스트*

# 5. 굵은 글씨 작성
**텍스트**

# 6. 인용
> 인용1

> 인용2
>> 인용안의 인용

# 7. 수평선 넣기

---
  
# 8. 링크 달기
(1) 인라인 링크  

[블로그 주소](https://lsh424.tistory.com/)

(2) 참조 링크  

[블로그 주소][blog]

[blog]: https://lsh424.tistory.com/

# 9. 이미지 추가하기
![이탈리아 포지타노](https://user-images.githubusercontent.com/31477658/85016059-f962aa80-b1a3-11ea-8c91-dacba2666b78.jpeg)

### 이미지 사이즈 조절
<img src="https://user-images.githubusercontent.com/31477658/85016059-f962aa80-b1a3-11ea-8c91-dacba2666b78.jpeg"  width="700" height="370">

### 이미지 파일로 추가하기
<img src="Capri_Island.jpeg" width="700">

# 10. 코드블럭 추가하기

```swift
public struct CGSize {
  public var width: CGFloat
  public var heigth: CGFloat
  ...
}
```

# etc

**텍스트 굵게**  
~~텍스트 취소선~~

### [개행]  

스페이스바를 통한 문장개행  
스페이스바를 통한 문장개행  

br태그를 사용한 문장개행
<br>
<br>
br태그를 사용한 문장개행


### [체크박스]

다음과 같이 체크박스를 표현 할 수 있습니다. 
* [x] 체크박스
* [ ] 빈 체크박스
* [ ] 빈 체크박스

### [이모지 넣기]
❤️💜💙🤍

### [표 넣기]
|왼쪽 정렬|가운데 정렬|오른쪽 정렬| 
|:---|:---:|---:| 
|내용1|내용2|내용3| 
|내용1|내용2|내용3| 

<br>

### 정리내용
[정리 내용 보기](https://lsh424.tistory.com/37)
