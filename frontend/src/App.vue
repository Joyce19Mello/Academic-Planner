<template lnag="pug">
  <div id="app">
    <HelloWorld/>
<Login/> 
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import Login from './components/Login.vue'

export default {
  name: 'app',
  components: {
    HelloWorld,
    Login
  }
</script>

<style lang="sass">
#app 
  font-family: 'Avenir', Helvetica, Arial, sans-serif
  -webkit-font-smoothing: antialiased
  -moz-osx-font-smoothing: grayscale
  text-align: center
  color: #2c3e50
  margin-top: 60px

</style>
