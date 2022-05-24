<template>
    <div v-if="$store.state.trenutniProjekt" class="flex-auto">
        <div class="flex flex-col">
            <OProjektu v-if="$store.state.projektInfoPage === 1" />
            <Sudionici v-if="$store.state.projektInfoPage === 2" />
            <Zahtjevi v-if="$store.state.projektInfoPage === 3" />
            <Zadaci v-if="$store.state.projektInfoPage === 4" />
            <MojiZadaci v-if="$store.state.projektInfoPage === 5" />
        </div>
    </div>
</template>

<script>
import OProjektu from './OProjektu.vue'
import Sudionici from './Sudionici.vue'
import Zahtjevi from './Zahtjevi.vue'
import Zadaci from './Zadaci.vue'
import MojiZadaci from './MojiZadaci.vue'

export default {
  components: {
    OProjektu,
    Sudionici,
    Zahtjevi,
    Zadaci,
    MojiZadaci
  }
}
</script>