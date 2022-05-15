<template>
    <div class="flex-auto">
        <div class="flex flex-col">
            <OProjektu v-if="$store.state.projektInfoPage === 1" />
            <Sudionici v-if="$store.state.projektInfoPage === 2" />
        </div>
    </div>
</template>

<script>
import OProjektu from './OProjektu.vue'
import Sudionici from './Sudionici.vue'

export default {
  components: {
    OProjektu,
    Sudionici
  }
}
</script>