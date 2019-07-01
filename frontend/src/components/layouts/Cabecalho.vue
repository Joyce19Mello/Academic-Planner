<template lang="pug">
#cabecalho
    .menu-cabecalho
        .left
            .logo(@click="inicioClick")

            .itens-menu(v-if='!usuarioLogado')
                menu-item(titulo="Início" icone="lnr-home" :active="activeRouter('dashboard')" @click="inicioClick")
                menu-item(titulo="Professores" icone="lnr-briefcase" :active="activeRouter('professores')" @click="professoresClick")
                menu-item(titulo="Contato" icone="lnr-envelope" :active="activeRouter('contato')" @click="contatoClick")
                
            .itens-menu(v-if='usuarioLogado')
                //- menu-item(titulo="Início" icone="lnr-home" :active="activeRouter('dashboard')" @click="inicioClick")
                menu-item(titulo="Projetos" icone="lnr-briefcase" :active="activeRouter('projetos')" @click="projetosClick")
                menu-item(titulo="Publicações" icone="lnr-cog" :active="activeRouter('publicacoes')" @click="publicacoesClick")
                menu-item(titulo="Grupos" icone="lnr-envelope" :active="activeRouter('grupos')" @click="gruposClick")
                menu-item(titulo="Alunos" icone="lnr-checkmark-circle" :active="activeRouter('alunos')" @click="alunosClick")
                menu-item(titulo="Aulas" icone="lnr-star" :active="activeRouter('aulas')" @click="aulasClick")

        .right(v-if='usuarioLogado')
            .user
                .icon-user.lnr.lnr-user
                .data
                    h4 Rafael Durelli
            .login(@click="logout")
                .icon-login.lnr.lnr-exit

        .right(@click="loginClick" v-if='!usuarioLogado')
            .login(@click="loginClick")
                .icon-login.lnr.lnr-enter
</template>

<script>
import MenuItem from '@/components/element/MenuItem'
import RouterMixin from '@/utils/mixins/RouterMixin'
// import {
//   USUARIO_LOGOUT
// } from '@/store/actions.type.js'
// import { mapGetters } from 'vuex'
// import { telaInicio } from '@/utils/helpers/permissoes/inicio/inicio.js'
// import { consultarProcesso } from '@/utils/helpers/permissoes/consultar/consultar.js'
// import { telaCaixaDeEntrada } from '@/utils/helpers/permissoes/caixa/caixa.js'
// import { telaAnalise } from '@/utils/helpers/permissoes/analise/analise.js'
// import { telaFavoritos } from '@/utils/helpers/permissoes/favoritos/favorito.js'
// import { configurador } from '@/utils/helpers/permissoes/configurador/configurador.js'

export default {
  name: 'Cabecalho',
  components: { MenuItem },
  mixins: [RouterMixin],

  data () {
    return {
      usuarioLogado: false
    }
  },

  mounted() {
    this.$bus.$on('logar', () => this.logar())
    this.$bus.$on('logout', () => this.logout())
  },

  methods: {
    inicioClick () {
        if(!this.usuarioLogado) {
            this.goToDashboard()
        } else {
            this.goTo('projetos')
        }
    },
    professoresClick () {
      this.goTo('professores')
    },
    contatoClick () {
      this.goTo('contato')
    },
    projetosClick () {
      this.goTo('projetos')
    },
    publicacoesClick () {
        this.goTo('publicacoes')
    },
    gruposClick () {
        this.goTo('grupos')
    },
    alunosClick () {
        this.goTo('alunos')
    },
    aulasClick () {
        this.goTo('aulas')
    },
    loginClick () {
      this.goTo('login')
    },
    logoutClick () {
      // this.$store.dispatch(USUARIO_LOGOUT)
      // this.logout()
    },
    logar () {
        this.usuarioLogado = true
        this.$bus.$emit('loga')
    },
    logout () {
        this.usuarioLogado = false
        this.$bus.$emit('logou')
        this.goToDashboard()
    }

  }
}
</script>

<style lang="sass" scoped>
#cabecalho
    width: 100%
    height: 100%
    border-bottom: 1px #000
    font-color: #424242
    background-color: #fff

    .menu-cabecalho
        display: flex
        align-items: center
        width: 100%
        height: 103%
        justify-content: space-between
        box-sizing: content-box

        .left
            display: flex
            align-items: center

            .logo
                color: white
                height: 80px
                width: 200px
                margin-top: 10px
                background: url("../../assets/logo-academic.png") no-repeat center
                background-size: contain

                &:hover
                    cursor: pointer

            .itens-menu
                display: flex

        .right
            height: 100%
            display: flex

            .login
                cursor: pointer
                color: white
                width: 50px
                display: flex
                justify-content: center
                align-items: center
                padding: 15px 15px

                .icon-login
                    height: 26px
                    font-size: 22px
                    padding: 10px
                    color: #57BC90

            .logout
                cursor: pointer
                color: white
                width: 50px
                display: flex
                justify-content: center
                align-items: center
                padding: 15px 15px

                .icon-logout
                    height: 26px
                    font-size: 22px
                    padding: 10px
                    color: #57BC90

                &:hover
                    background-color: rgba(0, 0, 0, 0.1)
                    cursor: pointer

            .user
                padding: 0 30px
                display: flex
                align-items: center
                border: solid 1px
                border-bottom: 0
                border-top: 0
                border-color: #E0E0E0

                &:hover
                    background-color: rgba(0, 0, 0, 0.1)
                    cursor: pointer

                .icon-user
                    height: 26px
                    font-size: 22px
                    padding-right: 10px
                    color: #57BC90

                .data

                    h4
                        font-size: 15px
                        font-weight: normal
                        margin-bottom: 3px
                        margin-top: 0

                    h5
                        font-size: 13px
                        font-weight: normal
                        color: #BDBDBD
                        margin-top: 3px
                        margin-bottom: 0

</style>
