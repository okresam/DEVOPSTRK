<template>
    <div class="flex-auto">
        <div class="flex flex-col">

            <div v-if="zahtjeviPage === 1">
                <div class="flex flex-row text-3xl py-5 px-5 font-bold">
                    <h3>Zahtjevi</h3>
                </div>
                <hr />
                <div>
                    <button class="my-5 px-6 py-2 ml-5 text-white bg-blue-600 rounded-lg hover:bg-blue-900"
                        type="button" @click="zahtjeviPage = 2">
                        Dodaj zahtjev
                    </button>
                </div>

                <div>
                    <table class="table-auto w-4/6 text-lg text-left text-gray-600 mx-20 my-20">
                        <thead class="text-lg text-gray-700 uppercase bg-gray-50">
                            <tr>
                                <th class="px-6 py-3">Naziv</th>
                                <th class="px-6 py-3">Vrsta</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr v-for="(z, index) in zahtjevi"
                                class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <td>{{ z.nazivZahtjeva }}</td>
                                <td>{{ z.nazivVrsteZahtjeva }}</td>
                                <td @click="zahtjevDetail(index)"
                                    class="hover:text-gray-400 cursor-pointer w-16 px-1 py-1 bg-cyan-200 rounded-lg">
                                    Detalji
                                </td>
                                <td @click="zahtjevUredi(index)"
                                    class="hover:text-gray-400 cursor-pointer w-16 px-1 py-1 bg-blue-200 rounded-lg">
                                    Uredi</td>
                                <td @click=""
                                    class="hover:text-gray-400 cursor-pointer w-16 px-1 py-1 bg-red-200 rounded-lg">
                                    Obriši</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div v-else-if="zahtjeviPage === 2">
                <div class="flex flex-auto items-center justify-center min-h-screen bg-gray-300">
                    <div class="px-8 py-6 mt-4 text-left bg-white shadow-lg">
                        <h3 class="text-2xl text-center">Dodaj novi zahtjev!</h3>
                        <form @submit.prevent="dodajZahtjev">
                            <div class="mt-4">
                                <div>
                                    <label class="block" for="nazivZahtjeva">Naziv zahtjeva</label>
                                    <input v-model="zahtjev.nazivZahtjeva" type="text" required
                                        placeholder="Zahtjev za ..."
                                        oninvalid="this.setCustomValidity('Ovo polje je obavezno!')"
                                        oninput="this.setCustomValidity('')"
                                        class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                                </div>
                                <div class="mt-4">
                                    <label class="block" for="opisZahtjeva">Opis zahtjeva</label>
                                    <textarea v-model="zahtjev.opisZahtjeva" type="text" required
                                        placeholder="Opis zahtjeva..."
                                        oninvalid="this.setCustomValidity('Ovo polje je obavezno!')"
                                        oninput="this.setCustomValidity('')"
                                        class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600"></textarea>
                                </div>
                                <div class="mt-4 text-center">
                                    <label class="block" for="vrstaZahtjeva">Vrsta zahtjeva</label>
                                    <select v-model="zahtjev.idVrsteZahtjeva">
                                        <option v-for="v in vrsteZahtjeva" :value="v.idVrsteZahtjeva"
                                            :selected="v.idVrsteZahtjeva === this.zahtjev.idVrsteZahtjeva">
                                            {{ v.nazivVrsteZahtjeva }}
                                        </option>
                                    </select>
                                </div>

                                <div class="flex items-baseline justify-between">
                                    <p class="px-6 py-2 mt-4 text-white bg-gray-600 rounded-lg hover:bg-gray-900 hover:cursor-pointer"
                                        @click="natrag">
                                        Natrag
                                    </p>
                                    <button v-if="!zahtjev.idZahtjeva"
                                        class="px-6 py-2 mt-4 text-white bg-cyan-600 rounded-lg hover:bg-cyan-900">
                                        Dodaj
                                    </button>
                                    <button v-else
                                        class="px-6 py-2 mt-4 text-white bg-cyan-600 rounded-lg hover:bg-cyan-900">
                                        Promjeni
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div v-else-if="zahtjeviPage === 3" class="mx-10 my-10">

                <div v-if="!noviZadatakForm">
                    <button
                        class="px-6 py-2 mt-4 text-white bg-gray-600 rounded-lg hover:bg-gray-900 hover:cursor-pointer"
                        @click="zahtjeviPage = 1; zahtjevDetails = undefined">
                        Natrag
                    </button>
                    <h3 class="text-2xl mt-10">Detalji:</h3>

                    <div class="flex flex-col">
                        <div>
                            <div class="flex flex-row">
                                <h3 class="font-bold">Naziv:</h3>
                                <p class="px-3">{{ zahtjevDetails.nazivZahtjeva }}</p>
                            </div>
                            <div class="flex flex-row">
                                <h3 class="font-bold">Opis:</h3>
                                <p class="px-3">{{ zahtjevDetails.opisZahtjeva }}</p>
                            </div>
                            <div class="flex flex-row">
                                <h3 class="font-bold">Vrsta:</h3>
                                <p class="px-3">{{ zahtjevDetails.nazivVrsteZahtjeva }}</p>
                            </div>
                            <div class="flex flex-row">
                                <h3 class="font-bold">Izvor:</h3>
                                <p class="px-3">{{ zahtjevDetails.imeIzvora }} {{ zahtjevDetails.prezimeIzvora }} ({{
                                        zahtjevDetails.ulogaIzvora
                                }})</p>
                            </div>
                            <button
                                class="px-6 py-2 mt-10 text-white bg-blue-600 rounded-lg hover:bg-blue-900 hover:cursor-pointer"
                                @click="noviZadatakForm = 1">
                                Novi zadatak
                            </button>
                        </div>

                        <div>
                            <div class="flex flex-row">
                                <div class="mx-20 my-16">
                                    <h3 class="font-bold">Zadaci:</h3>
                                    <table class="table-auto w-full text-sm text-left text-gray-600 border-4">
                                        <thead class="text-xs text-gray-700 uppercase bg-gray-50">
                                            <tr>
                                                <th class="px-6 py-3">Naziv zadatka</th>
                                                <th class="px-6 py-3">Datum stvaranja</th>
                                                <th class="px-6 py-3">Datum izvršavanja</th>
                                                <th class="px-6 py-3">Izvršitelj</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <tr v-for="z in zahtjevZadaci"
                                                class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                                <td>{{ z.nazivZadatka }}</td>
                                                <td>{{ z.datumStvaranjaZadatka }}</td>
                                                <td>{{ z.datumStvarnogIzvrsavanja }}</td>
                                                <td>{{ z.imeIzvrsitelja }} {{ z.prezimeIzvrsitelja }} ({{
                                                        z.ulogaIzvrsitelja
                                                }})</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>

                                <div class="mx-20 my-16">
                                    <h3 class="font-bold">Povijest promjena:</h3>
                                    <table class="table-auto w-full text-sm text-left text-gray-600 border-4">
                                        <thead class="text-xs text-gray-700 uppercase bg-gray-50">
                                            <tr>
                                                <th class="px-6 py-3">Datum promjene</th>
                                                <th class="px-6 py-3">Naziv</th>
                                                <th class="px-6 py-3">Opis</th>
                                                <th class="px-6 py-3">Vrsta</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <tr v-for="z in zahtjevHistory"
                                                class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                                <td>{{ z.ulogaIzvora }}</td>
                                                <td>{{ z.nazivZahtjeva }}</td>
                                                <td>{{ z.opisZahtjeva }}</td>
                                                <td>{{ z.nazivVrsteZahtjeva }}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>

                <div v-else>
                    Novi zadatak form
                </div>


            </div>

        </div>
    </div>
</template>

<script>
import RequestHandler from "./../RequestHandler.js"
import { SPRING_URL } from './../constants.js'

export default {
    data() {
        return {
            zahtjevi: [],
            zahtjeviPage: 1,
            zahtjev: {
                nazivZahtjeva: '',
                opisZahtjeva: '',
                idVrsteZahtjeva: '',
                emailIzvora: '',
                idProjekta: ''
            },
            vrsteZahtjeva: [],
            zahtjevDetails: undefined,
            zahtjevZadaci: [],
            zahtjevHistory: [],
            noviZadatak: {

            },
            noviZadatakForm: 0
        }
    },
    async mounted() {
        this.zahtjevi = await RequestHandler.postRequest(SPRING_URL.concat("/zahtjev/getProjektZahtjevi"), { "id": this.$store.state.trenutniProjekt.idProjekta.toString() })
        this.vrsteZahtjeva = await RequestHandler.getRequest(SPRING_URL.concat("/vrstazahtjeva/all"))
    },
    methods: {
        async dodajZahtjev() {
            this.zahtjev.emailIzvora = this.$store.state.user.email.toString()
            this.zahtjev.idProjekta = this.$store.state.trenutniProjekt.idProjekta.toString()

            await RequestHandler.postRequest(SPRING_URL.concat("/zahtjev/add"), this.zahtjev)
            this.$router.go()
        },
        async zahtjevDetail(i) {
            this.zahtjevDetails = this.zahtjevi[i]
            this.zahtjevZadaci = await RequestHandler.postRequest(SPRING_URL.concat("/zadatak/getZahtjevZadaci"), { "id": this.zahtjevi[i].idZahtjeva })
            this.zahtjevHistory = await RequestHandler.postRequest(SPRING_URL.concat("/zahtjev/getChangeHistory"), { "id": this.zahtjevi[i].idZahtjeva })
            this.zahtjevHistory.reverse()
            this.zahtjeviPage = 3
        },
        async zahtjevUredi(i) {
            this.zahtjev.idZahtjeva = this.zahtjevi[i].idZahtjeva
            this.zahtjev.nazivZahtjeva = this.zahtjevi[i].nazivZahtjeva
            this.zahtjev.opisZahtjeva = this.zahtjevi[i].opisZahtjeva
            this.zahtjev.idVrsteZahtjeva = this.zahtjevi[i].idVrsteZahtjeva
            this.zahtjev.emailIzvora = this.zahtjevi[i].emailIzvora
            this.zahtjev.idProjekta = this.$store.state.trenutniProjekt.idProjekta

            this.zahtjeviPage = 2
        },
        natrag() {
            this.zahtjev.idZahtjeva = undefined
            this.zahtjev.idZahtjeva = ''
            this.zahtjev.nazivZahtjeva = ''
            this.zahtjev.opisZahtjeva = ''
            this.zahtjev.idVrsteZahtjeva = ''
            this.zahtjev.emailIzvora = ''
            this.zahtjev.idProjekta = ''

            this.zahtjeviPage = 1
        }
    }
}
</script>