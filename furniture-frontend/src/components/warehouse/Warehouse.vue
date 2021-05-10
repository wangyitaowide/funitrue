<template>
  <div class="hello">
    <!-- <h1>{{ msg }}</h1> 
    <input type="button" value="Add" class="btn btn-primary"/>-->
    <el-tabs v-model="activeName">
      <el-tab-pane label="查询/增加" name="first">
        <Detail></Detail>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import Detail from './Detail.vue'
export default {
  name: "Warehouse",
  props: {
    msg: String,
  },
  components:{
    Detail
  },
  data() {
    return {
      activeName: "first",
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.hello {
  background: #ffffff;
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
