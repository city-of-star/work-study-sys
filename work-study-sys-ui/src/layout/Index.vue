<template>
  <div class="app">
    <Sidebar />
    <TopBar />
    <TabBar />

    <div class="main">
      <div class="content">
        <router-view />
      </div>
    </div>
  </div>
</template>

<script setup>
import Sidebar from '@/components/sidebar/Index.vue'
import TopBar from '@/components/topBar/Index.vue'
import TabBar from  '@/components/tabBar/Index.vue'

</script>

<style scoped>
.app {
  display: flex;
}

.main {
  margin-top: 72px;
  margin-left: 192px;
  background-color: crimson;
}

.content {
  margin-left: 30px;
  margin-top: 30px;
  background-color: #c5e3f8;
}
</style>