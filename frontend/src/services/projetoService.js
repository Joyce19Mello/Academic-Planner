import ApiService from '@/services/api/apiService.js'

const ProjetoService = {
  listAll: (resource, params) => ApiService.get(resource, params),
  save: (resource, params) => ApiService.post(resource, params)
//   getConvites: (resource, params) => ApiService.get(resource, params),
//   aceitar: (resource, params) => ApiService.get(resource, params),
}
export default ProjetoService