<template lnag="pug">
  <div id="app">
    <HelloWorld/>
    <Dashboard/>  
  </div>
</template>

<script>
  import HelloWorld from './components/HelloWorld.vue'
  import Dashboard from './components/Dashboard.vue'

  export default {
    name: 'app',
    components: {
      HelloWorld,
      Dashboard
    }
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
