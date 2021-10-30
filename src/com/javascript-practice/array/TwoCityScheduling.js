const minimumCitySheduling  = (costs) => {
    let result = 0;
    for(let cost of costs) {

        const [first, last] = cost;
        let min =  Math.min(first, last);
        console.log(min);
    //    if(first > last) 
    //    {
    //        max = last;
    //    } else {
    //        max = first;
    //    }
       result = result + min;
     }
     return result;


}

// let costs = [[10,20],[30,200],[400,50],[30,20]]; // 110
let costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]] //1859
// let costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]] // 3086

console.log(minimumCitySheduling(costs));