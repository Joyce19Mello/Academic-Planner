import ApiService from '@/services/api/apiService.js'

const AulaService = {
  listAll: (resource, params) => ApiService.get(resource, params),
  save: (resource, params) => ApiService.post(resource, params)
}
export default AulaService