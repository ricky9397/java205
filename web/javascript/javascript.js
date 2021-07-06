/* 블럭 안이든 밖이든 사용가능 한번만쓰는게좋음 */
let globalName = 'global name';

{
    /* var를 쓰기도 하지만 let을 쓰는게 좋다 */
    let name = 'ricky';
    console.log(name);
    name = 'hello';
    console.log(name);
    console.log(globalName);
}

/* 자바스태틱과 비슷 값을 한번선언하면 변경이 불가능 */
const daysInWeek = 7;
const maxNumber = 5;

/* number은 크기와 상관없으 사용가능! 짱! */