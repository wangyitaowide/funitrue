<template>
  <div id="app">
    <!-- <HelloWorld msg="Welcome to Your Vue.js App" /> -->
    <Home style="height:100%"/>
  </div>
</template>

<script>
// import HelloWorld from "./components/HelloWorld.vue";
import Home from "./components/Home.vue";

export default {
  name: "app",
  components: {
    // HelloWorld,
    Home
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /*text-align: center;*/
  color: #2c3e50;
  height: 100%;
  /* margin-top: 60px; */
}
</style>
