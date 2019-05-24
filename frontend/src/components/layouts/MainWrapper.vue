<template lang='pug'>
#main-wrapper
  el-container

    el-header(height="70px")
      cabecalho

    el-main
      router-view

    //   .elFooter
    //     | © 2019 - Academic Planner

</template>

<script>
import Cabecalho from './Cabecalho'
// import Navegacao from './Navegacao'
export default {
  name: 'MainWrapper',
  components: { Cabecalho },

  methods: {
  }
}
</script>

<style lang='sass' scoped>

  #main-wrapper, .el-container
    height: 100vh

  .elFooter
    text-align: center
    justify-content: center
    padding: 35px
    padding-bottom: 0px

  /deep/ .el-header
    padding: 0
    z-index: 1000
    overflow-x: auto
    overflow-y: hidden

  .el-header
    box-shadow: 0 5px 11px rgba(88, 88, 88, 0.1)
    background-color: #fff

</style>
