module.exports = {
    devServer: {
      proxy: 'http://localhost:9000'
    },
    publicPath: '/public/',
    outputDir: '../backend/public/',
    assetsDir: '.',
    indexPath: 'index.html'
  }