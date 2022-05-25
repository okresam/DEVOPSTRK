<template>
    <div class="flex-auto">
        <div class="flex flex-col">

            <div v-if="zahtjeviPage === 1">
                <div class="flex flex-row text-3xl py-5 px-5 font-bold">
                    <h3>Zahtjevi</h3>
                </div>
                <hr />
                <div>
                    <button 
                        class="my-5 px-6 py-2 ml-5 text-white bg-blue-600 rounded-lg hover:bg-blue-900"
                        type="button" @click="zahtjeviPage = 2">
                        Dodaj zahtjev
                    </button>
                </div>

                <div>
                    <table class="table-auto w-5/6 text-lg text-left text-gray-600 mx-20 my-20">
                        <thead class="text-lg text-gray-700 uppercase bg-gray-50">
                            <tr>
                                <th class="px-6 py-3">Naziv</th>
                                <th class="px-6 py-3">Vrsta</th>
                                <th class="px-6 py-3 text-center w-4">Otvoreni zadaci</th>
                                <th class="px-6 py-3 text-center w-4">Zatvoreni zadaci</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr v-for="(z, index) in zahtjevi"
                                class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <td>{{ z.nazivZahtjeva }}</td>
                                <td>{{ z.nazivVrsteZahtjeva }}</td>
                                <td class="text-center">{{ brojNezavrsenihZad[index] }}</td>
                                <td class="text-center">{{ brojZavrsenihZad[index] }}</td>
                                <td @click="zahtjevDetail(index)"
                                    class="hover:text-gray-400 cursor-pointer w-16 px-1 py-1 bg-cyan-200 rounded-lg">
                                    Detalji
                                </td>
                                <td @click="zahtjevUredi(index)"
                                    class="hover:text-gray-400 cursor-pointer w-16 px-1 py-1 bg-blue-200 rounded-lg">
                                    Uredi</td>
                                <td @click="deleteZahtjev(index)"
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
                        <h3 class="text-2xl text-center">Zahtjev</h3>
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

            <div v-else-if="zahtjeviPage === 3">

                <div v-if="!noviZadatakForm" class="mx-10 my-10">
                    <button
                        class="px-6 py-2 mt-4 mb-8 text-white bg-gray-600 rounded-lg hover:bg-gray-900 hover:cursor-pointer"
                        @click="zahtjeviPage = 1; zahtjevDetails = undefined; this.$router.go()">
                        Natrag
                    </button>

                    <div class="flex flex-col">
                        <div>
                            <div class="flex flex-row">
                                <h3 class="font-bold">Zahtjev:</h3>
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
                            <button v-if="$store.state.user.idKorisnika === $store.state.trenutniProjekt.idVoditelja"
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

                <div v-else class="flex flex-auto items-center justify-center min-h-screen bg-gray-300">
                    <div class="px-8 py-6 mt-4 text-left bg-white shadow-lg">
                        <h3 class="text-2xl text-center">Dodaj novi zadatak!</h3>
                        <h3 class="text-xl text-center text-gray-500">Za zahtjev: {{ zahtjevDetails.nazivZahtjeva }}
                        </h3>
                        <form @submit.prevent="dodajZadatak">
                            <div class="mt-4">
                                <div>
                                    <label class="block" for="nazivZadatka">Naziv zadatka</label>
                                    <input v-model="noviZadatak.nazivZadatka" type="text" required
                                        placeholder="Zadatak 12..."
                                        oninvalid="this.setCustomValidity('Ovo polje je obavezno!')"
                                        oninput="this.setCustomValidity('')"
                                        class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                                </div>
                                <div class="mt-4">
                                    <label class="block" for="opisZadatka">Opis zadatka</label>
                                    <input v-model="noviZadatak.opisZadatka" type="text" required
                                        placeholder="Zadatak za dodavanje ..."
                                        oninvalid="this.setCustomValidity('Ovo polje je obavezno!')"
                                        oninput="this.setCustomValidity('')"
                                        class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                                </div>
                                <div class="mt-4">
                                    <label class="block" for="rokIzvrsavanja">Rok izvršavanja</label>
                                    <input v-model="noviZadatak.rokIzvrsavanja" type="date" required
                                        oninvalid="this.setCustomValidity('Ovo polje je obavezno!')"
                                        oninput="this.setCustomValidity('')"
                                        class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                                </div>
                                <div class="mt-4 text-center">
                                    <label class="block" for="vrstaZadatka">Vrsta zadatka</label>
                                    <select v-model="noviZadatak.idVrsteZadatka">
                                        <option v-for="v in vrsteZadataka" :value="v.idVrsteZadatka">{{ v.nazivVrsteZadatka }}
                                        </option>
                                    </select>
                                </div>
                                <div class="mt-4 text-center">
                                    <label class="block" for="prioritet">Prioritet</label>
                                    <select v-model="noviZadatak.idPrioriteta">
                                        <option v-for="p in prioriteti" :value="p.idPrioriteta">{{ p.nazivPrioriteta }}
                                        </option>
                                    </select>
                                </div>
                                <div class="mt-4 text-center">
                                    <label class="block" for="izvrsitelj">Izvršitelj</label>
                                    <select v-model="noviZadatak.emailIzvrsitelja">
                                        <option v-for="mi in moguciIzvrsitelji" :value="mi.email">
                                            {{ mi.ime }} {{ mi.prezime }} ({{ mi.ulogaSudionika.nazivUloge }})
                                        </option>
                                    </select>
                                </div>
                                <div class="flex items-baseline justify-between">
                                    <p class="px-6 py-2 mt-4 text-white bg-gray-600 rounded-lg hover:bg-gray-900 hover:cursor-pointer"
                                        @click="noviZadatakForm = 0">
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
                nazivZadatka: '',
                opisZadatka: '',
                rokIzvrsavanja: '',
                idZahtjeva: '',
                idProjekta: '',
                idVrsteZadatka: '',
                idPrioriteta: '',
                emailIzvrsitelja: ''
            },
            noviZadatakForm: 0,
            vrsteZadataka: [],
            prioriteti: [],
            moguciIzvrsitelji: [],
            brojZavrsenihZad: [],
            brojNezavrsenihZad: []
        }
    },
    async mounted() {
        this.zahtjevi = await RequestHandler.postRequest(SPRING_URL.concat("/zahtjev/getProjektZahtjevi"), { "id": this.$store.state.trenutniProjekt.idProjekta.toString() })
        this.zahtjevi.sort((a, b) => (a.nazivZahtjeva > b.nazivZahtjeva) ? 1 : -1)
        
        this.vrsteZahtjeva = await RequestHandler.getRequest(SPRING_URL.concat("/vrstazahtjeva/all"))
        this.vrsteZadataka = await RequestHandler.getRequest(SPRING_URL.concat("/vrstazadatka/all"))
        this.moguciIzvrsitelji = await RequestHandler.postRequest(SPRING_URL.concat('/projekt/sudionici'), { id: this.$store.state.trenutniProjekt.idProjekta.toString() })
        this.prioriteti = await RequestHandler.getRequest(SPRING_URL.concat("/prioritet/all"))

        for(let z of this.zahtjevi) {
            let numbC = await RequestHandler.postRequest(SPRING_URL.concat("/zadatak/completedNumber"), { id: z.idZahtjeva })
            let numI = await RequestHandler.postRequest(SPRING_URL.concat("/zadatak/incompletedNumber"), { id: z.idZahtjeva })
            this.brojZavrsenihZad.push(numbC)
            this.brojNezavrsenihZad.push(numI)
        }
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
        },
        async dodajZadatak() {
            this.noviZadatak.idZahtjeva = this.zahtjevDetails.idZahtjeva.toString()
            this.noviZadatak.idProjekta = this.$store.state.trenutniProjekt.idProjekta.toString()
            this.noviZadatak.idPrioriteta = this.noviZadatak.idPrioriteta.toString()
            this.noviZadatak.idVrsteZadatka = this.noviZadatak.idVrsteZadatka.toString()
            
            await RequestHandler.postRequest(SPRING_URL.concat("/zadatak/add"), this.noviZadatak)
            this.noviZadatak = {
                nazivZadatka: '',
                opisZadatka: '',
                rokIzvrsavanja: '',
                idZahtjeva: '',
                idProjekta: '',
                idVrsteZadatka: '',
                idPrioriteta: '',
                emailIzvrsitelja: ''
            }

            this.zahtjevZadaci = await RequestHandler.postRequest(SPRING_URL.concat("/zadatak/getZahtjevZadaci"), { "id": this.zahtjevDetails.idZahtjeva })
            this.noviZadatakForm = 0
        },
        async deleteZahtjev(i) {
            if (confirm("Jeste li sigurni?")) {
                await RequestHandler.postRequest(SPRING_URL.concat("/zahtjev/delete"), { "id": this.zahtjevi[i].idZahtjeva })
                this.$router.go()
            }
        }
    }
}
</script>