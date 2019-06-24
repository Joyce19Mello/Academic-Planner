import { Notificator } from '../helpers/notificator'

/**
 * Modelo base de Exceções
 *
 * Ex.: options = {
 *      title: "Erro padrão",
 *      message: "Contate o adiministrador",
 *      type: "error",
 *      duration: 1 (opcional),
 *      show: false (opcional)
 * }
 *
 * @param options - Argumentos da exceção
 * @return {{message: (*|string)}}
 * @constructor
 */
export function Exception (options = null) {
  const MENSAGEM_PADRAO =
    'Erro não identificado. Contate o adiministrador do sistema.'
  const TITLE_PADRAO = 'Erro do sistema'

  // Caso exista no argumento de opções
  // a variavel booleana show, e a mesma seja positiva,
  // exibirá na tela a exceção
  if (options && options.show) {
    Notificator.show({
      title: options && options.title ? options.title : TITLE_PADRAO,
      massage: options && options.message ? options.message : MENSAGEM_PADRAO,
      type: options && options.type ? options.type : 'error'
    })
  }
  return {
    message: options && options.message ? options.message : MENSAGEM_PADRAO
  }
}
