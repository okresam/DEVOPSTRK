import { createRouter, createWebHistory } from 'vue-router'
import Home from './components/Home.vue'
import Login from './components/Login.vue'
import Projekti from './components/Projekti.vue'
import Register from './components/Register.vue'
import ProjektInfo from './components/ProjektInfo.vue'
import store from "./store.js"

const routes = [
    {
        path: '/',
        redirect: '/Projekti'
    },
    {
        path: '/Projekti',
        name: 'Projekti',
        component: Projekti
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/register',
        name: 'Register',
        component: Register
    },
    {
        path: '/ProjektInfo',
        name: 'ProjektInfo',
        component: ProjektInfo
    },
    {
        path: '/:catchAll(.*)',
        redirect: '/Projekti'
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

router.beforeEach(async (to, from) => {
    
    if (to.name === 'Projekti') {
        sessionStorage.removeItem('trenutniProjekt')
        store.state.trenutniProjekt = undefined
    }

    if (!store.state.user && to.name !== 'Login' && to.name !== 'Register') {
        return { name: 'Login' }
    }

    if (store.state.user && (to.name === 'Login' || to.name === 'Register')) {
        return { name: 'Projekti' }
    }
})

export default router