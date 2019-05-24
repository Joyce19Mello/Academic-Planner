import Vue from 'vue'
import Router from 'vue-router'
import Dashboard from '@/components/views/Dashboard'
import Professores from '@/components/views/Professores'
import Contato from '@/components/views/Contato'
import Login from '@/components/views/Login'
import NovaConta from '@/components/views/NovaConta'
import Projetos from '@/components/views/Projetos'
import Publicacoes from '@/components/views/Publicacoes'
import Grupos from '@/components/views/Grupos'
import Alunos from '@/components/views/Alunos'
import Aulas from '@/components/views/Aulas'
// import Index from '@/store/index.js'

Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/',
      name: 'dashboard',
      component: Dashboard,
      meta: {
        title: 'Academic Planner'
      }
    },
    {
      path: '/professores/',
      name: 'professores',
      component: Professores,
      meta: {
        title: 'Academic Planner'
      }
    },
    {
      path: '/contato',
      name: 'contato',
      component: Contato,
      meta: {
        title: 'Academic Planner'
      }
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
      meta: {
        title: 'Academic Planner'
      }
    },
    {
      path: '/nova-conta',
      name: 'nova-conta',
      component: NovaConta,
      meta: {
        title: 'Academic Planner'
      }
    },
    {
      path: '/projetos',
      name: 'projetos',
      component: Projetos,
      meta: {
        title: 'Academic Planner'
      }
    },
    {
      path: '/publicacoes',
      name: 'publicacoes',
      component: Publicacoes,
      meta: {
        title: 'Academic Planner'
      }
    },
    {
      path: '/grupos',
      name: 'grupos',
      component: Grupos,
      meta: {
        title: 'Academic Planner'
      }
    },
    {
      path: '/alunos',
      name: 'alunos',
      component: Alunos,
      meta: {
        title: 'Academic Planner'
      }
    },
    {
      path: '/aulas',
      name: 'aulas',
      component: Aulas,
      meta: {
        title: 'Academic Planner'
      }
    }
  ]
})

// router.beforeEach((to, from, next) => {
//   if (!Index.getters.usuarioLogado) {
//     next(false)
//     window.location.href = `${process.env.VUE_APP_HOME_ENTRADA_UNICA}`
//   } else {
//     next()
//   }
// })

export default router
