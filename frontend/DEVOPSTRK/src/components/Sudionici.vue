<template>
    <h3 class="text-2xl">Sudionici:</h3>
    <p v-for="s in sudionici"> {{ s.ime }} {{ s.prezime }} ({{ s.ulogaSudionika.nazivUloge }})</p>
</template>

<script>
import RequestHandler from "./../RequestHandler.js"
import { SPRING_URL } from './../constants.js'

export default {
    data() {
        return {
            sudionici: []
        }
    },
    async mounted() {
        this.sudionici = await RequestHandler.postRequest(SPRING_URL.concat('/projekt/sudionici'), { id: this.$store.state.trenutniProjekt.idProjekta.toString() })
    }
}
</script>