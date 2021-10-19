const findAllCharacter = (src, target) => {

    const map  = new Map();

    for(let s = 0; s < src.length; s ++) {
        map.set(src[s], s);
    }

    console.log(map);
   
    for(let i =0; i < target.length; i++) {
        if(!map.has(target.charAt(i))) return false
    }
 return true;
}

console.log(findAllCharacter("floor", "for"));