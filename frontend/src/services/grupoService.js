import ApiService from '@/services/api/apiService.js'

const GrupoService = {
  listAll: (resource, params) => ApiService.get(resource, params),
  save: (resource, params) => ApiService.post(resource, params),
  edit: (resource, params) => ApiService.post(resource, params)
}
export default GrupoService