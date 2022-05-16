<template>
    <div class="flex-auto">
        <div class="flex flex-col">

            <div v-if="!isDodajVisible" class="divide-y-[2px] divide-gray-900">
                <div class="flex flex-row text-3xl py-5 px-5 font-bold">
                    <h3 v-if="!ostaliProjekti">Moji projekti</h3>
                    <h3 v-else>Ostali projekti</h3>
                </div>

                <div class="px-5 py-5">
                    <button class="px-6 py-2 ml-3 text-white bg-blue-600 rounded-lg hover:bg-blue-900" type="button"
                        @click="showMojiProjekti">
                        Moji projekti
                    </button>
                    <button class="px-6 py-2 ml-3 text-white bg-blue-600 rounded-lg hover:bg-blue-900" type="button"
                        @click="showOstaliProjekti">
                        Ostali projekti
                    </button>
                    <button v-if="!ostaliProjekti"
                        class="px-6 py-2 ml-3 text-white bg-cyan-600 rounded-lg hover:bg-cyan-900" type="button"
                        @click="showDodaj">Dodaj projekt</button>
                </div>

                <div class="grid grid-flow-col auto-cols-max auto-rows-max">
                    <div v-if="!projekti.length" class="text-gray-500 mx-5 my-5">
                        Nema projekata za prikaz...
                    </div>
                    <div v-for="p in projekti" class="px-5 py-5 md:max-w-96 md:min-w-32">
                        <div class="block p-6 max-w-sm bg-gray-300 rounded-lg border border-gray-200 shadow-md">
                            <h5 class="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
                                {{ p.nazivProjekta }}
                            </h5>
                            <p class="font-normal text-gray-700 dark:text-gray-400 mb-3">
                                {{ p.opisProjekta }}
                            </p>
                            <div class="flex flex-row">
                                <h5 class="mr-1">
                                    Početak:
                                </h5>
                                <p>
                                    {{ p.datumPocetka }}
                                </p>
                            </div>
                            <div class="flex flex-row">
                                <h5 class="mr-1">
                                    Završetak:
                                </h5>
                                <p>
                                    {{ p.datumZavrsetka }}
                                </p>
                            </div>
                            <div class="flex flex-row">
                                <h5 class="mr-1">
                                    Stanje:
                                </h5>
                                <p>
                                    {{ p.stanje.nazivStanja }}
                                </p>
                            </div>
                            <div class="flex flex-row">
                                <button v-if="!ostaliProjekti" @click="obrisiProjekt(p.idProjekta)"
                                    class="px-6 py-2 mt-4 mr-4 text-white bg-red-600 rounded-lg hover:bg-red-900">
                                    Obriši
                                </button>
                                <button v-if="!ostaliProjekti" @click="editProjekt(p)"
                                    class="px-6 py-2 mt-4 mr-4 text-white bg-blue-600 rounded-lg hover:bg-blue-900">
                                    Uredi
                                </button>
                                <button @click="odaberiProjekt(p)"
                                    class="px-6 py-2 mt-4 text-white bg-cyan-600 rounded-lg hover:bg-cyan-900">
                                    Odaberi
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div v-else class="flex flex-auto items-center justify-center min-h-screen bg-gray-300">
                <div class="px-8 py-6 mt-4 text-left bg-white shadow-lg">
                    <h3 v-if="!projekt.idProjekta" class="text-2xl text-center">Dodaj novi projekt!</h3>
                    <h3 v-else class="text-2xl text-center">Promjeni informacije o projektu!</h3>
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
                                <textarea v-model="projekt.opisProjekta" type="text" required
                                    placeholder="Projekt za izradu programske podrške..."
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
                            <div v-if="projekt.idProjekta" class="mt-4 text-center">
                                <label class="block" for="stanjeProjekta">Stanje projekta</label>
                                <select v-model="stanjeProjekta">
                                    <option v-for="s in stanja" :value="s.idStanja"
                                        :selected="s.idStanja === this.projekt.stanje.idStanja">{{ s.nazivStanja }}
                                    </option>
                                </select>
                            </div>
                            <div class="flex items-baseline justify-between">
                                <p class="px-6 py-2 mt-4 text-white bg-gray-600 rounded-lg hover:bg-gray-900 hover:cursor-pointer"
                                    @click="closeDodaj">
                                    Natrag
                                </p>
                                <button v-if="projekt.idProjekta"
                                    class="px-6 py-2 mt-4 text-white bg-cyan-600 rounded-lg hover:bg-cyan-900">
                                    Promjeni
                                </button>
                                <button v-else
                                    class="px-6 py-2 mt-4 text-white bg-cyan-600 rounded-lg hover:bg-cyan-900">
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
            ostaliProjekti: false,
            projekt: {
                nazivProjekta: '',
                opisProjekta: '',
                datumPocetka: '',
                datumZavrsetka: '',
                emailVoditelja: ''
            },
            stanjeProjekta: '',
            projekti: [],
            stanja: []
        };
    },
    async mounted() {
        this.projekti = await RequestHandler.postRequest(SPRING_URL.concat('/korisnik/mojiProjekti'), { id: this.$store.state.user.email })
    },
    methods: {
        showDodaj() {
            this.isDodajVisible = true;
        },
        closeDodaj() {
            this.isDodajVisible = false;
            this.projekt = {
                nazivProjekta: '',
                opisProjekta: '',
                datumPocetka: '',
                datumZavrsetka: '',
                emailVoditelja: ''
            }
        },
        async showOstaliProjekti() {
            this.ostaliProjekti = true
            this.projekti = await RequestHandler.postRequest(SPRING_URL.concat('/korisnik/otherProjekti'), { id: this.$store.state.user.email })
        },
        async showMojiProjekti() {
            this.ostaliProjekti = false
            this.projekti = await RequestHandler.postRequest(SPRING_URL.concat('/korisnik/mojiProjekti'), { id: this.$store.state.user.email })
        },
        async dodajProjekt() {
            if (this.projekt.idProjekta) {
                await RequestHandler.postRequest(SPRING_URL.concat('/projekt/edit'), {
                    idProjekta: this.projekt.idProjekta.toString(),
                    nazivProjekta: this.projekt.nazivProjekta,
                    opisProjekta: this.projekt.opisProjekta,
                    datumPocetka: this.projekt.datumPocetka,
                    datumZavrsetka: this.projekt.datumZavrsetka,
                    idStanja: this.stanjeProjekta
                })
                this.$router.go()
            } else {
                this.projekt.emailVoditelja = this.$store.state.user.email
                await RequestHandler.postRequest(SPRING_URL.concat('/projekt/add'), this.projekt)
                this.$router.go()
            }
        },
        async obrisiProjekt(projektID) {
            if (confirm("Obriši projekt?")) {
                await RequestHandler.postRequest(SPRING_URL.concat('/projekt/delete'), { "id": projektID.toString() })
                this.$router.go()
            }
        },
        async editProjekt(projektInfo) {
            this.projekt = projektInfo
            this.isDodajVisible = true;
            this.stanja = await RequestHandler.getRequest(SPRING_URL.concat('/stanje/all'))
            this.stanjeProjekta = projektInfo.stanje.idStanja
        },
        odaberiProjekt(projektInfo) {
            sessionStorage.setItem('trenutniProjekt', JSON.stringify(projektInfo))
            this.$store.state.trenutniProjekt = projektInfo
            this.$store.state.projektInfoPage = 1
            this.$router.push('/ProjektInfo')
        }
    }
}
</script>