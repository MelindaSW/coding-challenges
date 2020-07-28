// https://open.kattis.com/problems/pot

const readline = require('readline')
const rl = readline.createInterface({
  input: process.stdin,
  ouput: process.stdout
})

let nrOfValues
rl.on('line', (line) => {
  nrOfValues = line
})
rl.close()

let result = 0

for (let i = 0; i < nrOfValues; i++) {
  rl.on('line', (line) => {
    result += Math.pow(line.slice(0, line.length - 1), line.charAt(line.length))
  })
}

console.log(result)
