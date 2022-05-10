import { createRouter, createWebHistory } from 'vue-router'
import Home from './components/Home.vue'
import Login from './components/Login.vue'
import Projekti from './components/Projekti.vue'
import Register from './components/Register.vue'
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
        path: '/:catchAll(.*)',
        redirect: '/Projekti'
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

router.beforeEach(async (to, from) => { 
    if (!store.state.user && to.name !== 'Login' && to.name !== 'Register') {
        return { name: 'Login' }
    }

    if (store.state.user && (to.name === 'Login' || to.name === 'Register')) {
        return { name: 'Projekti' }
    }
})

export default router