import ApiService from '@/services/api/apiService.js'

const AlunoService = {
  listAll: (resource, params) => ApiService.get(resource, params),
  save: (resource, params) => ApiService.post(resource, params)
}
export default AlunoService