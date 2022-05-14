<template>
    <div class="flex-auto">
        <div class="flex flex-col">

            <div v-if="!isDodajVisible" class="divide-y-[2px] divide-gray-900">
                <div class="flex flex-row text-3xl py-5 px-5 font-bold">
                    Moji projekti
                </div>
                <div class="px-5 py-5">
                    <button class="px-6 py-2 text-white bg-cyan-600 rounded-lg hover:bg-cyan-900" 
                    type="button" @click="showDodaj">Dodaj projekt</button>
                </div>
                <div>
                    <div v-for="p in projekti">{{ p.nazivProjekta }}</div>
                </div>
            </div>

            <div v-else class="flex flex-auto items-center justify-center min-h-screen bg-gray-300">
                <div class="px-8 py-6 mt-4 text-left bg-white shadow-lg">
                    <h3 class="text-2xl text-center">Dodaj novi projekt!</h3>
                    <form @submit.prevent="dodajProjekt">
                        <div class="mt-4">
                            <div>
                                <label class="block" for="nazivProjekta">Naziv projekta</label>
                                <input v-model="projekt.nazivProjekta" type="text" required placeholder="Projekt 225"
                                    oninvalid="this.setCustomValidity('Ovo polje je obavezno!')"
                                    oninput="this.setCustomValidity('')"
                                    class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                            </div>
                            <div class="mt-4">
                                <label class="block" for="opisProjekta">Opis projekta</label>
                                <textarea v-model="projekt.opisProjekta" type="text" required placeholder="Projekt za izradu programske podrške..."
                                    oninvalid="this.setCustomValidity('Ovo polje je obavezno!')"
                                    oninput="this.setCustomValidity('')"
                                    class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600"></textarea>
                            </div>
                            <div class="mt-4">
                                <label class="block" for="datumPocetka">Datum početka</label>
                                <input v-model="projekt.datumPocetka" type="date" required
                                    oninvalid="this.setCustomValidity('Ovo polje je obavezno!')"
                                    oninput="this.setCustomValidity('')"
                                    class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                            </div>
                            <div class="mt-4">
                                <label class="block" for="datumZavrsetka">Datum završetka</label>
                                <input v-model="projekt.datumZavrsetka" type="date" required
                                    oninvalid="this.setCustomValidity('Ovo polje je obavezno!')"
                                    oninput="this.setCustomValidity('')"
                                    class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                            </div>
                            <div class="flex items-baseline justify-between">
                                <p class="px-6 py-2 mt-4 text-white bg-gray-600 rounded-lg hover:bg-gray-900 hover:cursor-pointer"
                                    @click="closeDodaj">
                                    Natrag
                                </p>
                                <button class="px-6 py-2 mt-4 text-white bg-cyan-600 rounded-lg hover:bg-cyan-900">
                                    Dodaj
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </div>

</template>

<script>
import { useRoute } from "vue-router";
import RequestHandler from "./../RequestHandler.js"
import { SPRING_URL } from './../constants.js'

export default {
    components: {

    },
    data() {
        return {
            isDodajVisible: false,
            projekt: {
                nazivProjekta: '',
                opisProjekta: '',
                datumPocetka: '',
                datumZavrsetka: '',
                emailVoditelja: ''
            },
            projekti: []
        };
    },
    async mounted() {
        this.projekti = await RequestHandler.postRequest(SPRING_URL.concat('/korisnik/mojiProjekti'), {id: this.$store.state.user.email})
    },
    methods: {
        showDodaj() {
            this.isDodajVisible = true;
        },
        closeDodaj() {
            this.isDodajVisible = false;
        },
        async dodajProjekt() {
            this.projekt.emailVoditelja = this.$store.state.user.email
            await RequestHandler.postRequest(SPRING_URL.concat('/projekt/add'), this.projekt)
            this.$router.go()
        }
    }
}
</script>