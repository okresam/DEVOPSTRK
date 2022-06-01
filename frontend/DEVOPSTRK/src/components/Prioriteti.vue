<template>
    <div>
        <div class="flex flex-row text-3xl py-5 px-5 font-bold">
            <h3>Prioriteti</h3>
        </div>
        <hr />
        <div class="ml-96">
            <form @submit.prevent="">
                <input v-model="noviPrioritet" type="text" required placeholder="Novi prioritet..."
                    oninvalid="this.setCustomValidity('Ovo polje je obavezno!')" oninput="this.setCustomValidity('')"
                    class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                <button @click="" class="px-6 py-2 my-4 mx-5 text-white bg-blue-600 rounded-lg hover:bg-blue-900">Dodaj
                    prioritet</button>
            </form>
        </div>

        <table class="table-auto w-full text-2xl text-center text-gray-600 mx-20 my-5">
            <thead class="text-lg text-gray-700 uppercase bg-gray-50">
                <tr>
                    <th>Id prioriteta</th>
                    <th>Naziv prioriteta</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="p in prioriteti" class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                    <td>{{ p.idPrioriteta }}</td>
                    <td>{{ p.nazivPrioriteta }}</td>
                    <td @click="" class="hover:text-gray-400 cursor-pointer w-16 px-1 py-1 bg-blue-200 rounded-lg">
                        Uredi
                    </td>
                    <td @click="" class="hover:text-gray-400 cursor-pointer w-16 px-1 py-1 bg-red-200 rounded-lg">
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
            noviPrioritet: ''
        }
    },
    async mounted() {
        this.prioriteti = await RequestHandler.getRequest(SPRING_URL.concat("/prioritet/all"))
    },
    methods: {

    }
}
</script>