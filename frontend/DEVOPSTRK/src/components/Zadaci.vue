<template>
    <div class="flex-auto">
        <div class="flex flex-col">

            <div>
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
                                <th class="px-6 py-3">Opis</th>
                                <th class="px-6 py-3">Zahtjev</th>
                                <th class="px-6 py-3">Datum stvaranja</th>
                                <th class="px-6 py-3">Rok izvršavanja</th>
                                <th class="px-6 py-3">Datum izvršavanja</th>
                                <th class="px-6 py-3">Izvršitelj</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr v-for="z in zadaci" class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <td>{{ z.nazivZadatka }}</td>
                                <td>{{ z.opisZadatka }}</td>
                                <td>{{ z.nazivZahtjeva }}</td>
                                <td>{{ z.datumStvaranjaZadatka }}</td>
                                <td>{{ z.rokIzvrsavanja }}</td>
                                <td>{{ z.datumStvarnogIzvrsavanja }}</td>
                                <td>{{ z.imeIzvrsitelja }} {{ z.prezimeIzvrsitelja }} ({{ z.ulogaIzvrsitelja }})</td>
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
            zadaci: [],
            pretraziValue: ''
        }
    },
    async mounted() {
        this.zadaci = await RequestHandler.postRequest(SPRING_URL.concat("/zadatak/getProjektZadaci"), { "id": this.$store.state.trenutniProjekt.idProjekta.toString() })
    },
    methods: {
        async pretrazi() {
            this.zadaci = await RequestHandler.postRequest(SPRING_URL.concat("/zadatak/getProjektZadaciTrazi"), { "id": this.$store.state.trenutniProjekt.idProjekta.toString(), "search": this.pretraziValue })
        }
    }
}
</script>