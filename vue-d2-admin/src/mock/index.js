import d2Mock from './d2-mock'

const req = context => context.keys().map(context)
const options = req(require.context('./api/', true, /\.js$/))
  .filter(e => e.default)
  .map(e => e.default)

options.forEach(option => {
  // 关闭搞死人的mock
  // d2Mock.load(option)
})
