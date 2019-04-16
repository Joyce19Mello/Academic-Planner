<template lang="pug">
  .container-login
    p.titulo-login Autenticação
    .campos-login  
      p E-mail
      el-input(placeholder='Please input user', v-model='inputUser')
  
      p Senha
      el-input(placeholder='Please input password', v-model='inputPassword', show-password='')
      
      .campo-recuperar-senha
        <a href="Login">Recuperar Senha</a>
      
      el-button.botao-login(plain='') Enviar

      .campo-criar-conta
        <a href="Login">Criar Conta</a>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return{
        inputUser: '',
        inputPassword: ''
    }
  }
}
</script>

<style scoped lang="sass">
  p
    margin-right: 130px;

    margin-bottom: 2px;

  .botao-login
    margin: 15px;

  .container-login
    background-color: white;
    text-align: center;
    border: 2px solid;
    border-color: black;
    max-width: 300px;
    margin: auto;

  .campos-login
    background-color: white;
    text-align: center;
    border-top: 2px solid;
    border-color: black;
    max-width: 300px;
    margin: auto;

  .campo-recuperar-senha
    margin-top: 15px;
    font-size: 10px;
    margin-right: 100px;
  
  .campo-criar-conta
    margin-bottom: 15px;
    font-size: 10px;

</style>
