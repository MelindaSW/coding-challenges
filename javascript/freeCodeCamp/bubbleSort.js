//https://www.freecodecamp.org/learn/coding-interview-prep/algorithms/implement-bubble-sort
function bubbleSort(array) {
  let swaps = false
  for (let i = 0; i < array.length; i++) {
    if (array[i] > array[i + 1]) {
      let x = array[i]
      array[i] = array[i + 1]
      array[i + 1] = x
      swaps = true
    }
  }
  if (swaps) {
    bubbleSort(array)
  }
  return array
}

let result = bubbleSort([
  1,
  4,
  2,
  8,
  345,
  123,
  43,
  32,
  5643,
  63,
  123,
  43,
  2,
  55,
  1,
  234,
  92
])

console.log(result)
