## Strings, Numbers, and Math

1. Counting duplicate characters 문자별로 나온 횟수 카운팅
```java
// String.charAt(i)  i(int)에 해당하는 번호의 문자 리턴
// map.compute(key, (key, value) =>  {로직: 리턴값을 value에 설정})
```
2.
3.
4. 
7. 문자열을 int, long, float 또는 double로 변환
```java
// valueOf 객체로 캐스팅
// parseInt int로 캐스팅
```
8. 문자열에서 공백 제거
```java
str.replaceAll("\\s", "");   // \s 로 보이지 않는 모든 공백 지정(\t, \n, \r)
```
JDK 11부터는 String.isBlank()이 문자열이 비어 있는지 또는 공백 코드 포인트 만 포함하는 지 확인합니다.

99.
```java
int[] integers = new int[] {1,2,3,6,5};
Arrays.sort(integers);  //퀵정렬
```
