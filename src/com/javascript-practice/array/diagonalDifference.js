/**
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.

For example, the square matrix  is shown below:

1 2 3
4 5 6
9 8 9  
The left-to-right diagonal = . The right to left diagonal = . Their absolute difference is .

Function description

Complete the  function in the editor below.

diagonalDifference takes the following parameter:

int arr[n][m]: an array of integers
Return

int: the absolute diagonal difference
 */

const diagonalDifference = (arr) => {

    for (let i=0; i<arr.length; i++) {

        for(let j = 0; j < arr[0].length; j ++)
        {
            console.log(arr[i][j]);
          //  console.log(arr[j]);
        }
    }
    

}
let arr = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
];

console.log(diagonalDifference(arr));