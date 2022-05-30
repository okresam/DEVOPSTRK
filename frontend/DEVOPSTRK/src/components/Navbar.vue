<template>
    <div class="flex flex-col bg-cyan-900 h-auto sm:h-screen justify-between w-64 shadow flex-shrink-0">
        <div class="flex items-center text-3x1 px-5 p-5 bg-cyan-800 shadow">
            <img src="devops.png" class="w-10 h-10">
            <p class="mx-3 text-2xl font-bold">DevOpsTrk</p>
        </div>

        <div class="flex flex-col flex-auto">
            <div v-if="$store.state.user">
                <div class="p-2 mx-5 mt-5">
                    <div class="flex flex-row bg-cyan-700 rounded-lg">
                        <p class="font-bold px-3 py-3">Korisnik: {{ $store.state.user.ime }} {{ $store.state.user.prezime }}</p>
                    </div>
                </div>
                <div class="p-2 mx-5">
                    <div class="flex flex-row">
                        <router-link to="/Projekti" class="hover:text-gray-800">Projekti</router-link>
                    </div>
                </div>
                <div class="p-2 mx-5">
                    <div class="flex flex-row">
                        <router-link to="/Uloge" class="hover:text-gray-800">Uloge</router-link>
                    </div>
                </div>
                <div v-if="$store.state.trenutniProjekt">
                    <div class="p-2 mx-5 mt-5">
                        <div class="flex flex-row bg-cyan-700 rounded-lg">
                            <p class="font-bold px-3 py-3">Projekt: {{ $store.state.trenutniProjekt.nazivProjekta }}</p>
                        </div>
                    </div>
                    <div class="p-2 mx-5">
                        <div class="flex flex-row">
                            <p @click="$store.state.projektInfoPage = 1; storeInSession(1)" class="hover:text-gray-800 hover:cursor-pointer">O projektu</p>
                        </div>
                    </div>
                    <div class="p-2 mx-5">
                        <div class="flex flex-row">
                            <p @click="$store.state.projektInfoPage = 2; storeInSession(2)" class="hover:text-gray-800 hover:cursor-pointer">Sudionici</p>
                        </div>
                    </div>
                    <div class="p-2 mx-5">
                        <div class="flex flex-row">
                            <p @click="$store.state.projektInfoPage = 3; storeInSession(3)" class="hover:text-gray-800 hover:cursor-pointer">Zahtjevi</p>
                        </div>
                    </div>
                    <div class="p-2 mx-5">
                        <div class="flex flex-row">
                            <p @click="$store.state.projektInfoPage = 4; storeInSession(4)" class="hover:text-gray-800 hover:cursor-pointer">Zadaci</p>
                        </div>
                    </div>
                    <div class="p-2 mx-5">
                        <div class="flex flex-row">
                            <p @click="$store.state.projektInfoPage = 5; storeInSession(5)" class="hover:text-gray-800 hover:cursor-pointer">Moji zadaci</p>
                        </div>
                    </div>
                </div>
                <div class="p-2 mx-5">
                    <div class="flex flex-row">
                        <button class="px-6 py-2 mt-4 text-white bg-red-600 rounded-lg hover:bg-red-700"
                            @click="logout">Odjavi se</button>
                    </div>
                </div>
            </div>

            <div v-else>
                <div class="p-2 mx-5">
                    <div class="flex flex-row">
                        Molimo prijavite se u sustav.
                    </div>
                </div>
            </div>

        </div>

    </div>

</template>

<script>
export default {
    data() {
        return {

        }
    },
    methods: {
        async logout() {
            if (confirm("Odjava iz sustava?")) {
                this.$store.state.user = undefined
                sessionStorage.clear()
                this.$router.push("/Login")
            }
        },
        storeInSession(value) {
            sessionStorage.setItem("projektInfoPage", value)
        }
    }
}
</script>
