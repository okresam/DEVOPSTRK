<template>
    <div class="flex-auto">
        <div class="flex flex-col">
            
            <div>
                <table class="table-auto w-full text-sm text-left text-gray-500 mx-20 my-20">
                    <thead class="text-xs text-gray-700 uppercase bg-gray-50">
                        <tr>
                            <th class="px-6 py-3">Naziv</th>
                            <th class="px-6 py-3">Opis</th>
                            <th class="px-6 py-3">Vrsta</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr v-for="z in zahtjevi" class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                            <td>{{ z.nazivZahtjeva }}</td>
                            <td>{{ z.opisZahtjeva }}</td>
                            <td>{{ z.nazivVrsteZahtjeva }}</td>
                        </tr>
                    </tbody>
                </table>
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
            zahtjevi: []
        }
    },
    async mounted() {
        this.zahtjevi = await RequestHandler.postRequest(SPRING_URL.concat("/zahtjev/getProjektZahtjevi"), { "id": this.$store.state.trenutniProjekt.idProjekta.toString() })
    },
    methods: {
        
    }
}
</script>