<template lang="pug">
  div(id="app")
    main-wrapper
</template>

<script>
import MainWrapper from './components/layouts/MainWrapper.vue'

export default {
  name: 'app',
  components: {
    MainWrapper
  }
}
</script>

<style lang="sass">
body
  margin: 0
  
  #app 
    font-family: 'Avenir', Helvetica, Arial, sans-serif
    -webkit-font-smoothing: antialiased
    -moz-osx-font-smoothing: grayscale
    text-align: center
    color: #2c3e50

</style>
