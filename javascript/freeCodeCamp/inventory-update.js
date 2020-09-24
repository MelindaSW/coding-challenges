//https://www.freecodecamp.org/learn/coding-interview-prep/algorithms/inventory-update
function updateInventory(curInv, newInv) {
  let inv = curInv.concat(newInv)
  inv.sort(sortItemsByName)
  let length = inv.length - 1
  let i = 0
  while (i < length) {
      let curItm = inv[i][1]
      let nextItm = inv[i + 1][1]
    if (curItm === nextItm) {
        let curAmnt = inv[i][0]
        let newAmnt = inv[i + 1][0]
      inv.push([curAmnt + newAmnt, curItm)
      inv.splice(i, 2)
    } else {
      i += 1
      length = inv.length - 1
    }
  }

  return inv.sort(sortItemsByName)
}

function sortItemsByName(a, b) {
  return a[1] > b[1] ? 1 : -1
}

// Example inventory lists
var curInv = [
  [21, 'Bowling Ball'],
  [2, 'Dirty Sock'],
  [1, 'Air Pin'],
  [5, 'Microphone']
]

var newInv = [
  [2, 'Air Pin'],
  [3, 'Half-Eaten Apple'],
  [67, 'Bowling Ball'],
  [7, 'Toothpaste']
]

console.log(updateInventory(curInv, newInv))
