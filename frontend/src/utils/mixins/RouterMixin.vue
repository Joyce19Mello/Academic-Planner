<script>
/**
 * Mixin para gerenciar e organizar
 * métodos de rotas
 */

import { mapGetters } from 'vuex'

export default {
  data () {
    return {
      usuario: ''
    }
  },
  name: 'RouterMixin',
  methods: {
    /**
     * Método para voltar à rota anterior
     */
    goBack () {
      this.$router.back()
    },

    /**
     * Método para ir à página Dashboard
     */
    goToDashboard () {
      this.$router.push('/')
    },

    /**
     * Método para navegar para a página '/produtividade/regiao-analise'
     */
    // goToConsulta (nomeAba) {
    //   this.$router.push({ name: 'consulta', params: { 'nomeAba': nomeAba } })
    // },

    /**
     * Método para navegar para a página '/caixa-de-entrada'
     */
    // goToInbox () {
    //   this.$router.push({ name: 'caixa-de-entrada' })
    // },

    /**
     * Método para deslogar do sistema
     */
    // logout () {
    //   window.location.href = `${process.env.VUE_APP_HOME_ENTRADA_UNICA}`
    // },

    /**
     * Retorna se a rota passada esta ativa
     *
     * @param rota - nome da rota a se checar
     * @returns {Boolean}
     */
    activeRouter (rota) {
      return rota === this.$route.name
    },
    /**
     * Retorna se ao menos uma das rotas enviadas está ativa
     *
     * @param rotas - Lista de  nome de rotas
     * @returns {Boolean} - Verdadeiro se uma das rotas enviadas estiver ativa
     */
    activeRoutes (rotas) {
      let active = false
      rotas.forEach(rota => {
        active = active || this.activeRouter(rota)
      })
      return active
    },

    /**
     * Método que recebe o nome da rota,
     * e redireciona para mesma
     *
     * @param route
     */
    goTo (route) {
      this.$router.push({ name: route })
    }
  }
}
</script>
