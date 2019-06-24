/* eslint-disable */
/**
 * Pega o primeiro item da lista passada como
 * primeiro argumento que atende o requisito do callback
 * do segundo argumento da função
 *
 * @param {Array} list
 * @param {Function} f
 * @return {*}
 */
export function find(list, f) {
    return list.filter(f)[0]
  }
  
  /**
   * Copia em cascata um objeto considerando sua estrutura circular.
   * Esta função cria o cache para todos os objetos filhos e suas cópias.
   * Se for encontrado uma estrutura circular, usa o cache para evitar um loop infinito
   *
   * @param {*} obj
   * @param {Array<Object>} cache
   * @return {*}
   */
  export function deepCopy(obj, cache = []) {
    // apenas retorna se o objeto for um valor imutável
    if (obj === null || typeof obj !== 'object') {
      return obj
    }
  
    // se o objeto for atingido, ele é uma estrutura circular
    const hit = find(cache, c => c.original === obj)
    if (hit) {
      return hit.copy
    }
  
    const copy = Array.isArray(obj) ? [] : {}
  
    cache.push({
      original: obj,
      copy
    })
  
    Object.keys(obj).forEach(key => {
      copy[key] = deepCopy(obj[key], cache)
    })
  
    return copy
  }
  
  /**
   * forEach para um objeto
   *
   * @param obj
   * @param fn
   */
  export function forEachValue (obj, fn) {
    Object.keys(obj).forEach(key => fn(obj[key], key))
  }
  
  /**
   * Retorna verdadeiro se o obj for um objeto
   *
   * @param obj
   * @return {boolean}
   */
  export function isObject (obj) {
    return obj !== null && typeof obj === 'object'
  }
  
  /**
   * Retorna verdadeiro de o parâmetro val for uma promessa
   *
   * @param val
   * @return {*|boolean}
   */
  export function isPromise(val) {
    return val && typeof val.then === 'function'
  }
  
  /**
   * Valida se uma condição é verdadeira e retorna erro caso não seja
   *
   * @param condition
   * @param msg
   */
  export function assert(condition, msg) {
    if (!condition) throw new Error(`[vuex] ${msg}`)
  }
  