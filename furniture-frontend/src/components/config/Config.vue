<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h3>config</h3>
  </div>
</template>

<script>
export default {
  name: "Config",
  props: {
    msg: String
  }
};
</script>

<style scoped lang="scss">
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
