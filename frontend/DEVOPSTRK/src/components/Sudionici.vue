<template>
    <div class="flex flex-auto items-center justify-center min-h-screen bg-gray-300">
        <div class="px-8 py-6 mt-4 text-left bg-white shadow-lg">
            <h3 v-if="$store.state.user.idKorisnika === $store.state.trenutniProjekt.idVoditelja" class="text-2xl text-center font-bold">Dodaj sudionika</h3>
            <p class="text-red-500 text-center">{{ message }}</p>
            <form @submit.prevent="dodajSudionika">
                <div class="mt-4">

                    <div v-if="$store.state.user.idKorisnika === $store.state.trenutniProjekt.idVoditelja" class="mb-10">
                        <div>
                            <label class="block" for="emailSudionika">Email sudionika</label>
                            <input v-model="noviSudionik.emailSudionika" type="text" required
                                placeholder="pero@gmail.com"
                                oninvalid="this.setCustomValidity('Ovo polje je obavezno!')"
                                oninput="this.setCustomValidity('')"
                                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                        </div>
                        <div class="mt-4 text-center">
                            <label class="block" for="ulogaSudionika">Uloga</label>
                            <select v-model="noviSudionik.idUlogeSudionika" required
                                oninvalid="this.setCustomValidity('Ovo polje je obavezno!')"
                                oninput="this.setCustomValidity('')">
                                <option v-for="u in uloge" :value="u.idUloge">
                                    {{ u.nazivUloge }}
                                </option>
                            </select>
                        </div>
                        <div class="flex items-baseline justify-center">
                            <button
                                class="px-6 py-2 mt-4 text-white bg-cyan-600 rounded-lg hover:bg-cyan-900">Dodaj</button>
                        </div>
                    </div>

                    <div>
                        <h3 class="text-4xl mb-5 font-bold">Sudionici:</h3>
                        <p v-for="s in sudionici" class="text-2xl"> {{ s.ime }} {{ s.prezime }} ({{ s.ulogaSudionika.nazivUloge }})</p>
                    </div>
                </div>
            </form>
        </div>
    </div>
</template>

<script>
import RequestHandler from "./../RequestHandler.js"
import { SPRING_URL } from './../constants.js'

export default {
    data() {
        return {
            sudionici: [],
            message: '',
            noviSudionik: {
                emailSudionika: '',
                idUlogeSudionika: ''
            },
            uloge: []
        }
    },
    async mounted() {
        this.sudionici = await RequestHandler.postRequest(SPRING_URL.concat('/projekt/sudionici'), { id: this.$store.state.trenutniProjekt.idProjekta.toString() })
        this.uloge = await RequestHandler.getRequest(SPRING_URL.concat('/uloga/all'))
    },
    methods: {
        async dodajSudionika() {
            let odgovor = await RequestHandler.postRequest(SPRING_URL.concat('/projekt/dodajSudionika'), {
                "emailSudionika": this.noviSudionik.emailSudionika,
                "idUlogeSudionika": this.noviSudionik.idUlogeSudionika.toString(),
                "idProjekta": this.$store.state.trenutniProjekt.idProjekta.toString()
            })

            if (odgovor) {
                this.$router.go()
            } else {
                this.message = 'Korisnik nije pronađen!'
            }


        }
    }
}
</script>