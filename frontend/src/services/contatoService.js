import ApiService from '@/services/api/apiService.js'

const ContatoService = {
  contact: (resource, params) => ApiService.post(resource, params),
//   verificarStatus: (resource, params) => ApiService.get(resource, params),
//   getConvites: (resource, params) => ApiService.get(resource, params),
//   aceitar: (resource, params) => ApiService.get(resource, params),
}
export default ContatoService