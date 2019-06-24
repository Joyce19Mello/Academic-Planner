import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
// import Cors from 'cors'

// import { HttpException } from '../../utils/exceptions/http-exception'


const ApiService = {
	init () {
		Vue.use(VueAxios, axios)
		// Vue.use(Cors)
		axios.defaults.baseURL ='http://localhost:9000/'
		// this.setHeader()
	},

	// setHeader () {
	// 	Vue.axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'
	// 	Vue.axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*'
	// 	Vue.axios.defaults.headers.post['Accept'] = 'application/json'
	// },

	async get (resource, slug = '') {
		try {
			if (slug === '') {
				return await Vue.axios.get(`${resource}`)
			} else {
				return await Vue.axios.get(`${resource}/${slug}`)
			}
		} catch (error) {
			// return Promise.reject(new HttpException(error))
		}
	},

	async post (resource, params) {
		try {
			return await Vue.axios.post(`${resource}`, params)
		} catch (error) {
			// return Promise.reject(new HttpException(error))
		}
	}	
}

export default ApiService
	