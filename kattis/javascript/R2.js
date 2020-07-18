const readline = require('readline')

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
})

rl.on('line', (line) => {
  var nums = line.split(' ')
  const R1 = nums[0]
  const S = nums[1]
  const R2 = S * 2 - R1
  console.log(R2)
})
