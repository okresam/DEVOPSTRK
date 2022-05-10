<template>
    <div class="flex flex-auto items-center justify-center min-h-screen bg-gray-300">
        <div class="px-8 py-6 mt-4 text-left bg-white shadow-lg">
            <div class="flex justify-center">
                <img src="devops.png" class="w-12 h-12" />
            </div>
            <h3 class="text-2xl text-center">Prijavite se!</h3>
            <p class="text-red-500 text-center">{{ message }}</p>
            <form @submit.prevent="submit">
                <div class="mt-4">
                    <div>
                        <label class="block" for="email">Email</label>
                        <input v-model="user.email" type="email" required placeholder="primjer@test.com"
                            oninvalid="this.setCustomValidity('Ovo polje je obavezno!')" oninput="this.setCustomValidity('')"
                            class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                    </div>
                    <div class="mt-4">
                        <label class="block">Lozinka</label>
                        <input v-model="user.lozinka" type="password" required placeholder="********"
                            oninvalid="this.setCustomValidity('Ovo polje je obavezno!')" oninput="this.setCustomValidity('')"
                            class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                    </div>
                    <div class="flex items-baseline justify-between">
                        <button
                            class="px-6 py-2 mt-4 text-white bg-cyan-600 rounded-lg hover:bg-cyan-900">Login</button>
                        <router-link to="/Register">Nemate korisnički račun?</router-link>
                    </div>
                </div>
            </form>
        </div>
    </div>
</template>

<script>
import axios from 'axios'
import { SPRING_URL } from './../constants.js'

export default {
    data() {
        return {
            user: {
                email: '',
                lozinka: ''
            },
            message: ''
        }
    },
    methods: {
        async submit() {
            await axios.post(SPRING_URL.concat('/korisnik/login'), this.user)
            .then(response => {
                this.$store.state.user = JSON.stringify(response.data);
                sessionStorage.setItem("user", JSON.stringify(response.data));
                this.$router.push("/")
            })
            .catch(e => {
                this.message = "Uneseni krivi email ili lozinka!"
            })
        }
    }
}
</script>