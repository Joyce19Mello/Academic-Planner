<template lang="pug">
  .login
    h1 {{titulo}}
    p E-mail
    el-input(placeholder='Please input', v-model='inputUser')
    p Senha
    el-input(placeholder='Please input password', v-model='inputPassword', show-password='')
    el-button(plain='') Plain
</template>

<script>
export default {
  name: 'Login',
  data() {
    return{
        titulo: "Autenticação",
        inputUser: '',
        inputPassword: ''
    }
  }
}
</script>

<style scoped lang="sass">
h3
  margin: 40px 0 0

ul
  list-style-type: none
  padding: 0

li
  display: inline-block
  margin: 0 10px

a
  color: #42b983

p
    margin-right: 35%
</style>
