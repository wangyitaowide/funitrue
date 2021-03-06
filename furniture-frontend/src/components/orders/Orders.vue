<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h3>orders</h3>
    <el-button @click="getData()">获取数据</el-button>
  </div>
</template>

<script>
// import { OrdersService } from "../services/OrdersService";
import {environment} from "../../environments/environment"
export default {
  name: "Orders",
  props: {
    msg: String
  },
  methods:{
    getData(){
      // OrdersService.getData();
      this.$http.get(environment.API_URL + '/hello').then((response) =>{
        console.log(response);
      })
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
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
