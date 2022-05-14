<template>
    <div class="flex flex-col bg-cyan-900 h-screen justify-between w-64 shadow">
        <div class="flex items-center text-3x1 px-5 p-5 bg-cyan-800 shadow">
            <img src="devops.png" class="w-10 h-10">
            <p class="mx-3 text-2xl font-bold">DevOpsTrk</p>
        </div>

        <div class="flex flex-col flex-auto">
            <div v-if="$store.state.user">
                <div class="p-2 mx-5">
                    <div class="flex flex-row">
                        <p class="font-bold">Korisnik: {{ $store.state.user.ime }} {{ $store.state.user.prezime }}</p>
                    </div>
                </div>
                <div class="p-2 mx-5">
                    <div class="flex flex-row">
                        Moji projekti
                    </div>
                </div>
                <div class="p-2 mx-5">
                    <div class="flex flex-row">
                        Svi projekti
                    </div>
                </div>
                <div class="p-2 mx-5">
                    <div class="flex flex-row">
                        <button class="bg-red-900" @click="logout">Odjavi se</button>
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
            this.$store.state.user = undefined
            sessionStorage.clear()
            this.$router.push("/Login")
        }
    }
}
</script>
