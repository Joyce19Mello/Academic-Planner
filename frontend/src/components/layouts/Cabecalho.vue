<template lang="pug">
#cabecalho
    .menu-cabecalho
        .left
            .logo(@click="inicioClick")

            .itens-menu
                menu-item(v-if='verificarInicio' titulo="Início" icone="lnr-home" :active="activeRouter('dashboard')" @click="inicioClick")
                menu-item(v-if='verificarConsulta' titulo="Consulta" icone="lnr-magnifier" :active="activeRouter('consulta')" @click="consultaClick")
                menu-item(v-if='verificarCaixa' titulo="Caixa de Entrada" icone="lnr-inbox" :active="activeRouter('caixa-de-entrada')" @click="inboxClick")
                menu-item(v-if='verificarAnalise' titulo="Análise" icone="lnr-checkmark-circle" :active="activeRouter('analise')" @click="analiseClick")
                menu-item(v-if='verificarFavoritos' titulo="Favoritos" icone="lnr-star" :active="activeRouter('favoritos')" @click="favoritosClick")
                menu-item(v-if='verificarConfigurador' titulo="Configurador" icone="lnr-cog" :active="activeRouter('configurador')" @click="configuradorClick")

        .right
            .user
                .icon-user.lnr.lnr-user
                .data
                    h4 {{ usuarioLogado.nome | placeholder("Erro de autenticação") | truncate(20) }}
                    h5 {{ usuarioLogado.perfilSelecionado.nome | placeholder("") | truncate(20) }}
            .logout(@click="logoutClick")
                .icon-logout.lnr.lnr-exit
</template>

<script>
import MenuItem from '@/components/element/MenuItem'
import RouterMixin from '@/utils/mixins/RouterMixin'
import {
  USUARIO_LOGOUT
} from '@/store/actions.type.js'
import { mapGetters } from 'vuex'
import { telaInicio } from '@/utils/helpers/permissoes/inicio/inicio.js'
import { consultarProcesso } from '@/utils/helpers/permissoes/consultar/consultar.js'
import { telaCaixaDeEntrada } from '@/utils/helpers/permissoes/caixa/caixa.js'
import { telaAnalise } from '@/utils/helpers/permissoes/analise/analise.js'
import { telaFavoritos } from '@/utils/helpers/permissoes/favoritos/favorito.js'
import { configurador } from '@/utils/helpers/permissoes/configurador/configurador.js'

export default {
  name: 'Cabecalho',
  components: { MenuItem },
  mixins: [RouterMixin],

  data () {
    return {
      consultarProcesso: consultarProcesso,
      telaInicio: telaInicio,
      telaCaixaDeEntrada: telaCaixaDeEntrada,
      telaAnalise: telaAnalise,
      telaFavoritos: telaFavoritos,
      configurador: configurador
    }
  },

  computed: {
    ...mapGetters([
      'usuarioLogado'
    ]),
    verificarInicio () {
      return this.verificarPermissao(this.telaInicio)
    },
    verificarConsulta () {
      return this.verificarPermissao(this.consultarProcesso)
    },
    verificarCaixa () {
      return this.verificarPermissao(this.telaCaixaDeEntrada)
    },
    verificarAnalise () {
      return this.verificarPermissao(this.telaAnalise)
    },
    verificarFavoritos () {
      return this.verificarPermissao(this.telaFavoritos)
    },
    verificarConfigurador () {
      return this.verificarPermissao(this.configurador)
    }
  },

  methods: {
    inicioClick () {
      this.goToDashboard()
    },
    consultaClick () {
      this.goToConsulta('pastaTecnica')
    },
    inboxClick () {
      this.goToInbox()
    },
    analiseClick () {
      this.goToAnalise()
    },
    favoritosClick () {
      this.goToFavoritos()
    },
    configuradorClick () {
      this.goToConfigurador()
    },
    logoutClick () {
      this.$store.dispatch(USUARIO_LOGOUT)
      this.logout()
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
                height: 50px
                width: 200px
                margin-left: -18px
                background: url("../../assets/logo-branco.svg") no-repeat center
                background-size: contain

                &:hover
                    cursor: pointer

            .itens-menu
                display: flex

        .right
            height: 100%
            display: flex

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
                    color: #FF8C00

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
                    color: #FF8C00

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
