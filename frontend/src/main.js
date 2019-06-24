import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/pt-br'
import router from '@/router'
import ApiService from '@/services/api/apiService.js'

import '@/assets/linearicons/style.css'

Vue.config.productionTip = false
Vue.prototype.$bus = new Vue()
Vue.use(ElementUI, { locale })

ApiService.init()

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
