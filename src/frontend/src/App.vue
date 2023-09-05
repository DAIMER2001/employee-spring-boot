

<template>
  <div>

    <Navbar  />
    <RouterView />

  </div>
</template>
<script setup lang="ts">
import Navbar from './components/Navbar.vue'

</script>
<style scoped>
.nav-item {
  margin-right: 15px;
}

.cover-container {
  padding-top: 30px;
  margin: auto;
  max-width: 42em;
}


</style>
