<template>
  <div>
    <el-container>
      <el-header>Header</el-header>
      <el-container>
        <el-aside>
          <Aside style="width:100%;"/>
        </el-aside>
        <el-main>
          <!-- <h1>{{ msg }}</h1> -->
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Aside from "./Aside.vue";
export default {
  name: "Home",
  props: {
    msg: String
  },
  components: {
    Aside
  }
};
</script>

<style scoped lang="scss">
  .el-container{
    height: 100%;
  }

 .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    width: 20% !important;
    line-height: 200px;
  }
  
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    width: 80% !important;
    text-align: center;
    line-height: 160px;
  }
</style>
