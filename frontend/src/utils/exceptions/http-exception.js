import { Exception } from './exception'
import { HttpError } from '../helpers/http-error'
import * as _ from 'lodash'

/**
 * Excessão de erros HTTP
 */
export const HttpException = {
  /**
   * Retorna um obj erro dado a response
   *
   * @param response - Response HTTP
   * @param show - Flag que dita se o erro será ou não exportado ao usuário
   * @return {Exception}
   */
  init (response, show = false) {
    return this.handleError(response, show)
  },

  /**
   * Retorna um objeto erro com o devido status e
   * mensagem
   *
   * @param response
   * @param show - Flag que dita se o erro será ou não exportado ao usuário
   * @return {{message: (*|string)}}
   */
  handleError (response, show) {
    if (this.valid(response)) {
      return this.generateMessage(response) !== null
        ? Exception({ message: this.generateMessage(response), show })
        : Exception({ show })
    } else {
      return new Error('Argumentos inválidos de Exceção.')
    }
  },

  /**
   * Confere se o status é previsto no helper de erros
   * comparando se a mensagem entregue por parâmetro
   * é null ou undefined e retornando falso pra caso seja
   *
   * @param statusMsg
   * @return {boolean}
   */
  handledHttpError (statusMsg) {
    return !_.isNil(HttpError[statusMsg])
  },

  /**
   * Dado o erro HTTP, retorna a mensagem correta
   * de acordo com seu status, guardado em HttpError ou
   * disponibilizado pelo backend
   *
   * @param error
   * @return {String | null}
   */
  generateMessage (error) {
    let status = error.response.status

    if (this.handledHttpError(status)) {
      return HttpError[status]
    } else if (!_.isNil(error.message)) {
      return error.message
    } else {
      return null
    }
  },

  /**
   * Checa se os argumentos do HttpException são
   * válidos
   *
   * @param response
   * @return {*|AxiosResponse|AxiosInterceptorManager<AxiosResponse>|response404.response|{status}|number}
   */
  valid (response) {
    return response && response.response && response.response.status
  }
}
