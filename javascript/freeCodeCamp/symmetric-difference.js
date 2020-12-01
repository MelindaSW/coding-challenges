//https://www.freecodecamp.org/learn/coding-interview-prep/algorithms/find-the-symmetric-difference

// function sym(args) {
//   let arg = arguments
//   let res

//   for (let i = 0; i < arg.length - 1; i += 1) {
//     let removeDupl = new Set(arg[i])
//     res = [...removeDupl]
//     let next = arg[i + 1]
//     // let next = [...new Set(arg[i + 1])]
//     console.log({ res, next })

//     res.forEach((value) => {
//       if (next.includes(value)) {
//         res = res.filter((nr) => nr != value)
//         next = next.filter((nr) => nr != value)
//       }
//     })

//     res = res.concat(next)
//   }

//   return res.sort()
// }
// let result = sym([1, 2, 5], [2, 3, 5], [3, 4, 5])
// console.log(result)
// should be [3, 4, 5]
// sym([3, 3, 3, 2, 5], [2, 1, 5, 7], [3, 4, 6, 6], [1, 2, 3], [5, 3, 9, 8], [1]) should return [1, 2, 4, 5, 6, 7, 8, 9]
// My try -- WRONG!

// function sym() {
//   // Convert the argument object into a proper array
//   var args = Array.prototype.slice.call(arguments)

//   // Return the symmetric difference of 2 arrays
//   var getDiff = function (arr1, arr2) {
//     // Returns items in arr1 that don't exist in arr2
//     function filterFunction(arr1, arr2) {
//       return arr1.filter(function (item) {
//         return arr2.indexOf(item) === -1
//       })
//     }

//     // Run filter function on each array against the other
//     return filterFunction(arr1, arr2).concat(filterFunction(arr2, arr1))
//   }

//   // Reduce all arguments getting the difference of them
//   var summary = args.reduce(getDiff, [])

//   // Run filter function to get the unique values
//   var unique = summary.filter(function (elem, index, self) {
//     return index === self.indexOf(elem)
//   })
//   return unique
// }

// Another solution:
const diff = (arr1, arr2) => [
  ...arr1.filter((e) => !arr2.includes(e)),
  ...arr2.filter((e) => !arr1.includes(e))
]

const sym = (...args) => [...new Set(args.reduce(diff))]

// test here
let res = sym(
  [3, 3, 3, 2, 5],
  [2, 1, 5, 7],
  [3, 4, 6, 6],
  [1, 2, 3],
  [5, 3, 9, 8],
  [1]
)
console.log(res.sort())
