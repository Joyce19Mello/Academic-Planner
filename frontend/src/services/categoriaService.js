import ApiService from '@/services/api/apiService.js'

const CategoriaService = {
  listAll: (resource, params) => ApiService.get(resource, params)
}
export default CategoriaService