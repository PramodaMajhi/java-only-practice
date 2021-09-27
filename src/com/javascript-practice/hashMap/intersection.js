const intersection = (a, b) => {
    const mySet = new Set(a);
    let result = [];
    //  for(let num of a) {
    //    mySet.add(num);
    //  }
    for(let num of b) {
      if(mySet.has(num))
        {
          result.push(num);
        }
    }
    return result;
  };
  console.log(intersection([4,2,1,6], [3,6,9,2,10])); // -> [2,6]);