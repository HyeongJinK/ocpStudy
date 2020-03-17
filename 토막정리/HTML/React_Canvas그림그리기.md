# React에서 Canvas로 그림 그리기

## Canvas와 값을 저장할 변수 선언

```javascript
let canvas;                     // 캔버스
let canvasRef = createRef();    // Ref를 사용해 캔버스의 Dom값을 가져온다.

let pos = {                     // 그림이 그려질 때 사용될 좌표 값
    drawable: false,
    X: -1,
    Y: -1
};
let ctx;                        // 컨텍스트
// 캔버스 설정
return (
    <>
        <canvas ref={canvasRef} width="400" height={"300"}/>
    </>
);
```

## 초기화

useEffect(()=> {}, []): 두번째 값으로 '[]'을 주면 componentdidmount을 사용하는 것과 같다.

컴포넌트가 로딩이 완료되면 캔버스의 값을 가져와 컨텍스트를 설정하고 이벤트들 설정한다.

```javascript
useEffect(() => {
    canvas = canvasRef.current;
    ctx = canvas.getContext("2d");
    canvas.addEventListener("mousedown", initDraw);
    canvas.addEventListener("mousemove", draw);
    canvas.addEventListener("mouseup", finishDraw);
    canvas.addEventListener("mouseout", finishDraw);
}, []);
```

## 유틸 함수

### getPosition

이벤트가 발생하는 좌표를 리턴한다.

```javascript
function getPosition(event) {
    return {X: event.offsetX
        , Y:  event.offsetY};
}
```

## 이벤트

### initDraw(event)

* 마우스를 처음 클릭했을 때 호출된다.
* ctx.bdginPath() 함수를 호출해 선그리기를 시작한다.
* 좌표를 설정하고 drawable를 true로 설정하여 그리기를 시작한다는 것을 알려준다.
```javascript
function initDraw(event) {
    ctx.beginPath();
    pos = {drawable: true, ...getPosition(event)};
    ctx.moveTo(pos.X, pos.Y);
}
```

### draw(event)

* 마우스가 움직일 때 일어나는 이벤트
* drawable가 true일 때 위치정보를 가져와 그리기를 한다.
```javascript
function draw(event) {
    if (pos.drawable) {
        pos = {...pos, ...getPosition(event)};
        ctx.lineTo(pos.X, pos.Y);
        ctx.stroke();
    }
}
```

### finishDraw()

* 마우스를 떼거나 캔버스를 벗어놨을 대 일어난 이벤트
* 좌표값을 초기화한다.
```javascript
function finishDraw() {
    pos = {drawable: false, X: -1, Y: -1};
}
```

```javascript
import React, {createRef, useEffect} from "react";



## 전체 소스 코드
function Draw(props) {
    let canvas;
    let canvasRef = createRef();

    let pos = {
        drawable: false,
        X: -1,
        Y: -1
    };
    let ctx;

    useEffect(() => {
        canvas = canvasRef.current;
        ctx = canvas.getContext("2d");
        canvas.addEventListener("mousedown", initDraw);
        canvas.addEventListener("mousemove", draw);
        canvas.addEventListener("mouseup", finishDraw);
        canvas.addEventListener("mouseout", finishDraw);
    }, []);

    function initDraw(event) {
        ctx.beginPath();
        pos = {drawable: true, ...getPosition(event)};
        ctx.moveTo(pos.X, pos.Y);
    }

    function draw(event) {
        if (pos.drawable) {
            pos = {...pos, ...getPosition(event)};
            ctx.lineTo(pos.X, pos.Y);
            ctx.stroke();
        }
    }

    function finishDraw() {
        pos = {drawable: false, X: -1, Y: -1};
    }

    function getPosition(event) {
        return {X: event.offsetX
            , Y:  event.offsetY};
    }

    return (
        <>
            <canvas ref={canvasRef} width="400" height={"300"}/>
        </>
    );
}

export default Draw;
```