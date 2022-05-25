<template>
    <div class="flex-auto">
        <div class="flex flex-col">

            <div v-if="!showUredi">
                <div class="flex flex-row text-3xl py-5 px-5 font-bold">
                    <h3>Zadaci</h3>
                </div>
                <hr />
                <div class="text-center mt-5">
                    <input type="text" placeholder="Pretraži..." v-model="pretraziValue" v-on:input="pretrazi"
                        class="w-1/2 px-4 py-2 mt-2 bg-gray-200 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600" />
                </div>
                <div>
                    <table class="table-auto w-5/6 text-sm text-center text-gray-600 mx-20 my-16">
                        <thead class="text-lg text-gray-700 uppercase bg-gray-50">
                            <tr>
                                <th class="px-6 py-3">Naziv</th>
                                <th class="px-6 py-3">Zahtjev</th>
                                <th class="px-6 py-3">Datum stvaranja</th>
                                <th class="px-6 py-3">Rok izvršavanja</th>
                                <th class="px-6 py-3">Datum izvršavanja</th>
                                <th class="px-6 py-3">Prioritet</th>
                                <th class="px-6 py-3">Stanje</th>
                                <th class="px-6 py-3">Izvršitelj</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr v-for="(z, index) in zadaci" class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <td class="text-left">{{ z.nazivZadatka }}</td>
                                <td>{{ z.nazivZahtjeva }}</td>
                                <td>{{ z.datumStvaranjaZadatka }}</td>
                                <td>{{ z.rokIzvrsavanja }}</td>
                                <td>{{ z.datumStvarnogIzvrsavanja }}</td>
                                <td>{{ z.prioritet.nazivPrioriteta }}</td>
                                <td>{{ z.stanje.nazivStanja }}</td>
                                <td>{{ z.imeIzvrsitelja }} {{ z.prezimeIzvrsitelja }} ({{ z.ulogaIzvrsitelja }})</td>
                                <td v-if="$store.state.user.idKorisnika === $store.state.trenutniProjekt.idVoditelja"
                                    @click="urediZadatak(index)"
                                    class="hover:text-gray-400 cursor-pointer w-16 px-1 py-1 bg-blue-200 rounded-lg">
                                        Uredi
                                </td>
                                <td v-if="$store.state.user.idKorisnika === $store.state.trenutniProjekt.idVoditelja"
                                    @click="obrisiZadatak(index)"
                                    class="hover:text-gray-400 cursor-pointer w-16 px-1 py-1 bg-red-200 rounded-lg">
                                        Obriši
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div v-else>
                <div class="flex flex-auto items-center justify-center min-h-screen bg-gray-300">
                    <div class="px-8 py-6 mt-4 text-left bg-white shadow-lg">
                        <h3 class="text-2xl text-center">Promjeni zadatak!</h3>
                        <form @submit.prevent="posaljiPromjenu">
                            <div class="mt-4">
                                <div>
                                    <label class="block" for="nazivZadatka">Naziv zadatka</label>
                                    <input v-model="editZadatak.nazivZadatka" type="text" required
                                        oninvalid="this.setCustomValidity('Ovo polje je obavezno!')"
                                        oninput="this.setCustomValidity('')"
                                        class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                                </div>
                                <div class="mt-4">
                                    <label class="block" for="opisZadatka">Opis zadatka</label>
                                    <input v-model="editZadatak.opisZadatka" type="text" required
                                        oninvalid="this.setCustomValidity('Ovo polje je obavezno!')"
                                        oninput="this.setCustomValidity('')"
                                        class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                                </div>
                                <div class="mt-4">
                                    <label class="block" for="rokIzvrsavanja">Rok izvršavanja</label>
                                    <input v-model="editZadatak.rokIzvrsavanja" type="date" required
                                        oninvalid="this.setCustomValidity('Ovo polje je obavezno!')"
                                        oninput="this.setCustomValidity('')"
                                        class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                                </div>
                                <div class="mt-4 text-center">
                                    <label class="block" for="vrstaZadatka">Vrsta zadatka</label>
                                    <select v-model="editZadatak.idVrsteZadatka">
                                        <option v-for="v in vrsteZadataka" :value="v.idVrsteZadatka"
                                         :selected="v.idVrsteZadatka === this.editZadatak.idVrsteZadatka">{{ v.nazivVrsteZadatka }}
                                        </option>
                                    </select>
                                </div>
                                <div class="mt-4 text-center">
                                    <label class="block" for="prioritet">Prioritet</label>
                                    <select v-model="editZadatak.idPrioriteta">
                                        <option v-for="p in prioriteti" :value="p.idPrioriteta"
                                         :selected="p.idPrioriteta === this.editZadatak.idPrioriteta">{{ p.nazivPrioriteta }}
                                        </option>
                                    </select>
                                </div>
                                <div class="flex items-baseline justify-between">
                                    <p class="px-6 py-2 mt-4 text-white bg-gray-600 rounded-lg hover:bg-gray-900 hover:cursor-pointer"
                                        @click="showUredi = false">
                                        Natrag
                                    </p>
                                    <button class="px-6 py-2 mt-4 text-white bg-cyan-600 rounded-lg hover:bg-cyan-900">
                                        Promjeni
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
            zadaci: [],
            pretraziValue: '',
            editZadatak: {
                nazivZadatka: '',
                opisZadatka: '',
                rokIzvrsavanja: '',
                idVrsteZadatka: '',
                idPrioriteta: ''
            },
            showUredi: false,
            vrsteZadataka: [],
            prioriteti: []
        }
    },
    async mounted() {
        this.zadaci = await RequestHandler.postRequest(SPRING_URL.concat("/zadatak/getProjektZadaci"), { "id": this.$store.state.trenutniProjekt.idProjekta.toString() })
        this.vrsteZadataka = await RequestHandler.getRequest(SPRING_URL.concat("/vrstazadatka/all"))
        this.prioriteti = await RequestHandler.getRequest(SPRING_URL.concat("/prioritet/all"))
    },
    methods: {
        async pretrazi() {
            this.zadaci = await RequestHandler.postRequest(SPRING_URL.concat("/zadatak/getProjektZadaciTrazi"), { "id": this.$store.state.trenutniProjekt.idProjekta.toString(), "search": this.pretraziValue })
        },
        async obrisiZadatak(i) {
            if (confirm("Jeste li sigurni?")) {
                await RequestHandler.postRequest(SPRING_URL.concat("/zadatak/delete"), { "id": this.zadaci[i].idZadatka.toString() })
                this.$router.go()
            }
        },
        async urediZadatak(i) {
            this.editZadatak.idZadatka = this.zadaci[i].idZadatka.toString()
            this.editZadatak.nazivZadatka = this.zadaci[i].nazivZadatka
            this.editZadatak.opisZadatka = this.zadaci[i].opisZadatka
            this.editZadatak.rokIzvrsavanja = this.zadaci[i].rokIzvrsavanja
            this.editZadatak.idVrsteZadatka = this.zadaci[i].vrstaZadatka.idVrsteZadatka.toString()
            this.editZadatak.idPrioriteta = this.zadaci[i].prioritet.idPrioriteta.toString()
            
            this.showUredi = true
        },
        async posaljiPromjenu() {
            await RequestHandler.postRequest(SPRING_URL.concat("/zadatak/edit"), this.editZadatak)
            this.$router.go()
        }
    }
}
</script>