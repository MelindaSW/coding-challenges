// https://www.freecodecamp.org/learn/coding-interview-prep/algorithms/implement-selection-sort

function selectionSort(array) {
  for (let i = 0; i < array.length - 1; i++) {
    let remaining = array.slice(i, array.length)
    let minValue = Math.min(...remaining)
    let minIndex = remaining.indexOf(minValue)

    let c = array[i]
    array[i] = remaining[minIndex]
    array[i + minIndex] = c
  }

  return array
}

let result = selectionSort([
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
