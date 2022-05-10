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
      this.$store.state.user = sessionStorage.getItem("user")
    }
  }
}

</script>
