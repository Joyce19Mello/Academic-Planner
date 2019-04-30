<template lang="pug">
  .hello
    h1 {{ msg }}
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return{
      msg: "PROJETOOOO MAIS TOP"
    }
  }
}
</script>

<style scoped lang="sass">
h1
  margin: 40px 0 0

ul
  list-style-type: none
  padding: 0

li
  display: inline-block
  margin: 0 10px

a
  color: #42b983
</style>
