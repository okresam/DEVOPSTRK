<template>
  <div class="flex flex-row">
    <Navbar />
    <router-view />

  </div>
</template>

<script>
import Navbar from './components/Navbar.vue'

export default {
  components: {
    Navbar
  },
  created() {
    if (sessionStorage.getItem("user") ) {
      this.$store.state.user = JSON.parse(sessionStorage.getItem("user"))
    }

    if (sessionStorage.getItem("trenutniProjekt") ) {
      this.$store.state.trenutniProjekt = JSON.parse(sessionStorage.getItem("trenutniProjekt"))
    }
  }
}

</script>
