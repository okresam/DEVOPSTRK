<template>
    <div>
        <div class="flex flex-row text-3xl py-5 px-5 font-bold">
            <h3>Uloge</h3>
        </div>
        <hr />

        <div class="ml-96">
            <form @submit.prevent="addUloga">
                <input v-model="novaUloga" type="text" required placeholder="Nova uloga..."
                    oninvalid="this.setCustomValidity('Ovo polje je obavezno!')" oninput="this.setCustomValidity('')"
                    class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                <button @click="" class="px-6 py-2 my-4 mx-5 text-white bg-blue-600 rounded-lg hover:bg-blue-900">Dodaj
                    ulogu</button>
            </form>
        </div>
        <div>
            <p class="text-red-500 text-center">{{ errorMessage }}</p>
        </div>
        <table class="table-auto w-full text-2xl text-center text-gray-600 mx-20 my-5">
            <thead class="text-lg text-gray-700 uppercase bg-gray-50">
                <tr>
                    <th>Id uloge</th>
                    <th>Naziv uloge</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(u, index) in uloge" class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                    <td>{{ u.idUloge }}</td>
                    <td v-if="editIndex == index">
                        <form @submit.prevent="podnesiPromjenu" class="flex flex-row text-center">
                            <input v-model="ulogaZaEdit.nazivUloge" type="text" required
                                oninvalid="this.setCustomValidity('Ovo polje je obavezno!')"
                                oninput="this.setCustomValidity('')"
                                class="w-1/2 px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600" />
                            <button @click=""
                                class="px-6 py-2 my-4 mx-5 text-white bg-blue-600 rounded-lg hover:bg-blue-900">Spremi</button>
                        </form>
                    </td>
                    <td v-else>{{ u.nazivUloge }}</td>
                    <td @click="urediUlogu(index)"
                        class="hover:text-gray-400 cursor-pointer w-16 px-1 py-1 bg-blue-200 rounded-lg">
                        Uredi
                    </td>
                    <td @click="obrisiUlogu(u.idUloge)"
                        class="hover:text-gray-400 cursor-pointer w-16 px-1 py-1 bg-red-200 rounded-lg">
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
            uloge: [],
            novaUloga: '',
            errorMessage: '',
            editIndex: undefined,
            ulogaZaEdit: {
                idUloge: '',
                nazivUloge: ''
            }
        }
    },
    async mounted() {
        this.uloge = await RequestHandler.getRequest(SPRING_URL.concat("/uloga/all"))
        this.uloge.sort((a, b) => (a.idUloge > b.idUloge) ? 1 : -1)
    },
    methods: {
        async obrisiUlogu(i) {
            if (confirm("Jeste li sigurni da želite obrisati ulogu?")) {
                let odgovor = await RequestHandler.postRequest(SPRING_URL.concat("/uloga/delete"), { "id": i.toString() })
                if (odgovor) {
                    this.$router.go()
                } else {
                    this.errorMessage = "Ulogu nije moguće obrisati jer se koristi!"
                }
            }
        },
        async addUloga() {
            await RequestHandler.postRequest(SPRING_URL.concat("/uloga/add"), { "id": this.novaUloga })
            this.$router.go()
        },
        async urediUlogu(i) {
            this.editIndex = i
            this.ulogaZaEdit.idUloge = this.uloge[i].idUloge
            this.ulogaZaEdit.nazivUloge = this.uloge[i].nazivUloge
            this.uloge = await RequestHandler.getRequest(SPRING_URL.concat("/uloga/all"))
            this.uloge.sort((a, b) => (a.idUloge > b.idUloge) ? 1 : -1)
        },
        async podnesiPromjenu() {
            await RequestHandler.postRequest(SPRING_URL.concat("/uloga/edit"), { "id": this.ulogaZaEdit.idUloge, "search": this.ulogaZaEdit.nazivUloge })
            this.$router.go()
        }
    }
}
</script>