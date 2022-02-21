

const romanToInt = (s) => {

   /**
   IDEA: Create a Map to store all keys and their values
   Store the last value in a variable called total,
   run a loop starting from second last(s.length() -2)
   Compare the last element and second last element from
   if its less then substract from  total else add into total.
   if you are writing in java, don't forget to declare a character map with Integer
   **/
    let len = s.length - 1 ;
    let map = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000,
    }
    let result  = map[s.charAt(len)];
    for(let i = s.length - 2 ; i >=0; i --) {
      if(map[s.charAt(i)] < map[s.charAt(i +1)]) {
          result-= map[s.charAt(i)];
      } else {
          result+=map[s.charAt(i)];
      }
    }
    return result;
}
 let s   = "MCMXCIV";
console.log(romanToInt(s))