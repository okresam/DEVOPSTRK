<template>
    <div class="flex-auto">
        <div class="flex flex-col">

            <div>
                <div class="flex flex-row text-3xl py-5 px-5 font-bold">
                    <h3>Moji zadaci na projektu</h3>
                </div>
                <hr />
                <button class="my-10 px-6 py-2 ml-10 text-white bg-blue-600 rounded-lg hover:bg-blue-900" type="button"
                    @click="otvoreniPrikaz">
                    Otvoreni zadaci
                </button>
                <button class="px-6 py-2 ml-3 text-white bg-blue-600 rounded-lg hover:bg-blue-900" type="button"
                    @click="zatvoreniPrikaz">
                    Zatvoreni zadaci
                </button>
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
                            </tr>
                        </thead>

                        <tbody>
                            <tr v-for="(z, index) in mojiZadaci"
                                class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <td class="text-left" @click="opisZadatka(index)">{{ z.nazivZadatka }}</td>
                                <td>{{ z.nazivZahtjeva }}</td>
                                <td>{{ z.datumStvaranjaZadatka }}</td>
                                <td>{{ z.rokIzvrsavanja }}</td>
                                <td>{{ z.datumStvarnogIzvrsavanja }}</td>
                                <td>{{ z.prioritet.nazivPrioriteta }}</td>
                                <td>{{ z.stanje.nazivStanja }}</td>
                                <td v-if="z.stanje.idStanja === 1" @click="promjeniStanje(index)"
                                    class="hover:text-gray-400 cursor-pointer w-16 h-12 px-1 py-1 bg-blue-200 rounded-lg">
                                    Preuzmi
                                </td>
                                <td v-if="z.stanje.idStanja === 2" @click="promjeniStanje(index)"
                                    class="hover:text-gray-400 cursor-pointer w-16 h-12 px-1 py-1 bg-green-200 rounded-lg">
                                    Završi
                                </td>
                            </tr>
                        </tbody>
                    </table>
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
            mojiZadaci: [],
            sviZadaci: []
        }
    },
    async mounted() {
        this.sviZadaci = await RequestHandler.postRequest(SPRING_URL.concat("/zadatak/getMojiZadaciNaProjektu"), { id: this.$store.state.trenutniProjekt.idProjekta, search: this.$store.state.user.idKorisnika })
        this.otvoreniPrikaz()
    },
    methods: {
        opisZadatka(i) {
            alert(this.mojiZadaci[i].opisZadatka)
        },
        otvoreniPrikaz() {
            this.mojiZadaci = []
            for (let z of this.sviZadaci) {
                if (z.stanje.idStanja === 1 || z.stanje.idStanja === 2) {
                    this.mojiZadaci.push(z)
                }
            }
        },
        zatvoreniPrikaz() {
            this.mojiZadaci = []
            for (let z of this.sviZadaci) {
                if (z.stanje.idStanja === 3) {
                    this.mojiZadaci.push(z)
                }
            }
        },
        async promjeniStanje(i) {
            if (confirm("Jeste li sigurni?")) {
                await RequestHandler.postRequest(SPRING_URL.concat("/zadatak/stanjeChange"), { id: this.mojiZadaci[i].idZadatka.toString() })
                this.$router.go()
            }
        }
    }
}
</script>