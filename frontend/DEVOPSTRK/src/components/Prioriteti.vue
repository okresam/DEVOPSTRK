<template>
    <div>
        <div class="flex flex-row text-3xl py-5 px-5 font-bold">
            <h3>Prioriteti</h3>
        </div>
        <hr />
        <div class="ml-96">
            <form @submit.prevent="addPrioritet">
                <input v-model="noviPrioritet" type="text" required placeholder="Novi prioritet..."
                    oninvalid="this.setCustomValidity('Ovo polje je obavezno!')" oninput="this.setCustomValidity('')"
                    class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                <button @click="" class="px-6 py-2 my-4 mx-5 text-white bg-blue-600 rounded-lg hover:bg-blue-900">Dodaj
                    prioritet</button>
            </form>
        </div>
         <div>
            <p class="text-red-500 text-center">{{ errorMessage }}</p>
        </div>
        <table class="table-auto w-full text-2xl text-center text-gray-600 mx-20 my-5">
            <thead class="text-lg text-gray-700 uppercase bg-gray-50">
                <tr>
                    <th>Id prioriteta</th>
                    <th>Naziv prioriteta</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(p, index) in prioriteti" class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                    <td>{{ p.idPrioriteta }}</td>
                    <td v-if="editIndex == index">
                        <form @submit.prevent="podnesiPromjenu" class="flex flex-row text-center">
                            <input v-model="prioritetZaEdit.nazivPrioriteta" type="text" required
                                oninvalid="this.setCustomValidity('Ovo polje je obavezno!')"
                                oninput="this.setCustomValidity('')"
                                class="w-1/2 px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600" />
                            <button @click=""
                                class="px-6 py-2 my-4 mx-5 text-white bg-blue-600 rounded-lg hover:bg-blue-900">Spremi</button>
                        </form>
                    </td>
                    <td v-else>{{ p.nazivPrioriteta }}</td>
                    <td @click="urediPrioritet(index)" class="hover:text-gray-400 cursor-pointer w-16 px-1 py-1 bg-blue-200 rounded-lg">
                        Uredi
                    </td>
                    <td @click="obrisiPrioritet(p.idPrioriteta)" class="hover:text-gray-400 cursor-pointer w-16 px-1 py-1 bg-red-200 rounded-lg">
                        Obriši
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import RequestHandler from "./../RequestHandler.js"
import { SPRING_URL } from './../constants.js'

export default {
    data() {
        return {
            prioriteti: [],
            noviPrioritet: '',
            errorMessage: '',
            editIndex: undefined,
            prioritetZaEdit: {
                idPrioriteta: '',
                nazivPrioriteta: ''
            }
        }
    },
    async mounted() {
        this.prioriteti = await RequestHandler.getRequest(SPRING_URL.concat("/prioritet/all"))
        this.prioriteti.sort((a, b) => (a.idPrioriteta > b.idPrioriteta) ? 1 : -1)
    },
    methods: {
        async obrisiPrioritet(i) {
            if (confirm("Jeste li sigurni da želite obrisati prioritet?")) {
                let odgovor = await RequestHandler.postRequest(SPRING_URL.concat("/prioritet/delete"), { "id": i.toString() })
                if (odgovor) {
                    this.$router.go()
                } else {
                    this.errorMessage = "Prioritet nije moguće obrisati jer se koristi!"
                }
            }
        },
        async addPrioritet() {
            await RequestHandler.postRequest(SPRING_URL.concat("/prioritet/add"), { "id": this.noviPrioritet })
            this.$router.go()
        },
        async urediPrioritet(i) {
            this.editIndex = i
            this.prioritetZaEdit.idPrioriteta = this.prioriteti[i].idPrioriteta
            this.prioritetZaEdit.nazivPrioriteta = this.prioriteti[i].nazivPrioriteta
            this.prioriteti = await RequestHandler.getRequest(SPRING_URL.concat("/prioritet/all"))
            this.prioriteti.sort((a, b) => (a.idPrioriteta > b.idPrioriteta) ? 1 : -1)
        },
        async podnesiPromjenu() {
            await RequestHandler.postRequest(SPRING_URL.concat("/prioritet/edit"), { "id": this.prioritetZaEdit.idPrioriteta, "search": this.prioritetZaEdit.nazivPrioriteta })
            this.$router.go()
        }
    }
}
</script>