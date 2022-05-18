<template>
    <div class="flex-auto">
        <div class="flex flex-col">

            <div>
                <div class="flex flex-row text-3xl py-5 px-5 font-bold">
                    <h3>Zadaci</h3>
                </div>
                <hr />
                <div>
                    <table class="table-auto w-4/6 text-lg text-left text-gray-600 mx-20 my-20">
                        <thead class="text-lg text-gray-700 uppercase bg-gray-50">
                            <tr>
                                <th class="px-6 py-3">Naziv</th>
                                <th class="px-6 py-3">Opis</th>
                                <th class="px-6 py-3">Datum stvaranja</th>
                                <th class="px-6 py-3">Datum izvrsavanja</th>
                                <th class="px-6 py-3">Izvršitelj</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr v-for="z in zadaci" class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <td>{{ z.nazivZadatka }}</td>
                                <td>{{ z.opisZadatka }}</td>
                                <td>{{ z.datumStvaranjaZadatka }}</td>
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
            zadaci: []
        }
    },
    async mounted() {
        this.zadaci = await RequestHandler.postRequest(SPRING_URL.concat("/zadatak/getProjektZadaci"), { "id": this.$store.state.trenutniProjekt.idProjekta.toString() })
    },
    methods: {

    }
}
</script>