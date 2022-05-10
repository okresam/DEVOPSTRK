import { createRouter, createWebHistory } from 'vue-router'
import Home from './components/Home.vue'
import Login from './components/Login.vue'
import Register from './components/Register.vue'
import store from "./store.js"

const routes = [
    {
        path: '/',
        redirect: '/Home'
    },
    {
        path: '/Home',
        name: 'Home',
        component: Home
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
        redirect: '/Home'
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
        return { name: 'Home' }
    }
})

export default router