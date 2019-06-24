import * as _ from 'lodash'
import Vue from 'vue'

// Definido pelo element, os tipos aceitos de notificação
// https://element.eleme.io/#/en-US/component/notification
const NOTIFICATION_TYPES = ['error', 'warning', 'info', 'success']

export const Notificator = {
  /**
   * Mostra a notificação de interface se os argumentos forem válidos
   *
   * Ex.:
   * opt = {
   *      title: "Erro padrão",
   *      message: "Contate o adiministrador",
   *      type: "error",
   *      duration: 1 (opcional)
   * }
   *
   * @param {Object} opt Argumentos da notificação
   */
  show (opt) {
    // Valida argumentos
    if (this.valid(opt)) {
      // Chama a devida função de exibir na interface, conforme exista duration
      this.show_duration(opt)
        ? this.display_duration_on(
          opt.title,
          opt.message,
          opt.type,
          opt.duration
        )
        : this.display_duration_off(opt.title, opt.message, opt.type)
    } else {
      // Lança erro para o navegador, já que é um erro de dev e
      // não de usuário
      return new Error('Argumentos de notificação inválidos.')
    }
  },

  /**
   * Checa se os argumentos são válidos,
   * ou seja, passam nas próprias checagens
   *
   * @param {Object} opt Argumentos da notificação
   * @return {boolean}
   */
  valid (opt) {
    return (
      this.valid_type(opt.type) &&
      this.valid_title(opt.title) &&
      this.valid_message(opt.message)
    )
  },

  /**
   * Checa se o argumento possui a variavel duration
   *
   * @param {Object} opt Argumentos da notificação
   * @returns {boolean}
   */
  show_duration (opt) {
    return !_.isNil(opt.duration) && _.isNumber(opt.duration)
  },

  /**
   * Mostra na tela a notificação caso possua duração: duration > 0
   * ou duration == 0, o que fará com que a notificação só suma
   * ao apertar o 'x' da mesma
   *
   * @param {String} title Titulo da notificacao
   * @param {String} message Mensagem da notificacao
   * @param {String} type Tipo da notificacao
   * @param {Number} duration Duração na tela, no qual 0 é pra sempre
   */
  display_duration_on (title, message, type, duration) {
    // Ativa componente de Notificação do element
    // https://element.eleme.io/#/en-US/component/notification
    Vue.$notify({
      title: title,
      message: message,
      type: type,
      duration: duration
    })
  },

  /**
   * Mostra na tela a notificação caso não possua duração:
   * Notificação sumirá automaticamente
   *
   * @param {String} title Titulo da notificacao
   * @param {String} message Mensagem da notificacao
   * @param {String} type Tipo da notificacao
   */
  display_duration_off (title, message, type) {
    // Ativa componente de Notificação do element
    // https://element.eleme.io/#/en-US/component/notification
    Vue.$notify({
      title: title,
      message: message,
      type: type
    })
  },

  /**
   * Checa se o type da notificação é valido
   *
   * @param {String} type
   * @return {boolean}
   */
  valid_type (type) {
    return NOTIFICATION_TYPES.includes(type)
  },

  /**
   * Checa se o titulo da notificação é valido, ou seja,
   * se ele existe
   *
   * @param {String} title
   * @return {boolean}
   */
  valid_title (title) {
    return !_.isEmpty(title)
  },

  /**
   * Checa se a mensagem da notificação é valida, ou seja,
   * se ela existe
   *
   * @param {String} message
   * @return {boolean}
   */
  valid_message (message) {
    return !_.isEmpty(message)
  }
}
