<template>
    <div v-if="showDodaj" class="flex flex-auto items-center justify-center min-h-screen bg-gray-300">
        <div class="px-8 py-6 mt-4 text-left bg-white shadow-lg">
            <h3 v-if="$store.state.user.idKorisnika === $store.state.trenutniProjekt.idVoditelja"
                class="text-2xl text-center font-bold">Dodaj sudionika</h3>
            <p class="text-red-500 text-center">{{ message }}</p>

            <form @submit.prevent="dodajSudionika">
                <div class="mt-4">

                    <div>
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
                            <p class="px-6 py-2 mt-4 mr-5 text-white bg-gray-600 rounded-lg hover:bg-gray-900 hover:cursor-pointer"
                                @click="showDodaj = false">
                                Natrag
                            </p>
                            <button
                                class="px-6 py-2 mt-4 ml-5 text-white bg-cyan-600 rounded-lg hover:bg-cyan-900">Dodaj</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div v-else>
        <div>
            <div class="flex flex-row text-3xl py-5 px-5 font-bold">
                    <h3>Sudionici</h3>
                </div>
            <hr />
            <button v-if="$store.state.user.idKorisnika === $store.state.trenutniProjekt.idVoditelja" @click="showDodaj = true"
                class="px-6 py-2 my-4 mx-5 text-white bg-blue-600 rounded-lg hover:bg-blue-900">Dodaj sudionika</button>
            <table class="table-auto w-1/3 text-lg text-left text-gray-600 mx-20 my-5">
                <thead class="text-lg text-gray-700 uppercase bg-gray-50">
                    <tr>
                        <th>Sudionik</th>
                        <th>Uloga</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="s in sudionici" class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                        <td>{{ s.ime }} {{ s.prezime }}</td>
                        <td>{{ s.ulogaSudionika.nazivUloge }}</td>
                    </tr>
                </tbody>
            </table>
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
            uloge: [],
            showDodaj: false
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