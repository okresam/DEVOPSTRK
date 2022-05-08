import { createRouter, createWebHistory } from 'vue-router'
import Home from './components/Home.vue'
import Login from './components/Login.vue'
import Register from './components/Register.vue'
import store from "./store.js"

const routes = [
    {
        path: '/',
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
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

router.beforeEach(async (to, from) => {
    if (!store.state.isLoggedIn && to.name !== 'Login' && to.name !== 'Register') {
        return { name: 'Login' }
    }
})

export default router