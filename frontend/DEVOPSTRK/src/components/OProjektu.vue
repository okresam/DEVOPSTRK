<template>
    <div class="flex flex-auto items-center justify-center min-h-screen bg-gray-300">
        <div class="px-8 py-6 mt-4 text-left bg-white shadow-lg">
            <div class="flex flex-row text-3xl py-5 px-5 font-bold">
                <h3>O projektu</h3>
            </div>
            <hr />
            <div class="mt-4 text-2xl px-16 py-6">
                <div class="flex flex-row">
                    <h3 class="font-bold">Naziv:</h3>
                    <p class="px-2">{{ $store.state.trenutniProjekt.nazivProjekta }}</p>
                </div>

                <div class="flex flex-row">
                    <h3 class="font-bold">Opis:</h3>
                    <p class="px-2">{{ $store.state.trenutniProjekt.opisProjekta }}</p>
                </div>

                <div class="flex flex-row">
                    <h3 class="font-bold">Datum početka:</h3>
                    <p class="px-2">{{ $store.state.trenutniProjekt.datumPocetka }}</p>
                </div>

                <div class="flex flex-row">
                    <h3 class="font-bold">Datum završetka:</h3>
                    <p class="px-2">{{ $store.state.trenutniProjekt.datumZavrsetka }}</p>
                </div>

                <div class="flex flex-row">
                    <h3 class="font-bold">Stanje:</h3>
                    <p class="px-2">{{ $store.state.trenutniProjekt.stanje.nazivStanja }}</p>
                </div>


            </div>
        </div>
    </div>
</template>

<script>

</script>