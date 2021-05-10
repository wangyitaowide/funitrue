<template>
  <div>
    <el-divider></el-divider>
    <h1>图片</h1>
    <el-row style="margin-top: 24px">
      <el-col :span="8" style="text-align: center">
        <span>图片</span>
      </el-col>
      <el-col :span="8">
        <el-input v-model="weight" placeholder="请选择图片"></el-input>
      </el-col>
    </el-row>
    <el-divider></el-divider>
    <h1>钉架部</h1>
    <el-divider></el-divider>
    <el-row style="margin-top: 24px">
      <el-col :span="3" style="text-align: center">
        <span>净重</span>
      </el-col>
      <el-col :span="4">
        <el-input v-model="weight" placeholder="请输入净重"></el-input>
      </el-col>
      <el-col :span="3" style="text-align: center">
        <span>材积</span>
      </el-col>
      <el-col :span="4">
        <el-input v-model="volume" placeholder="请输入材积"></el-input>
      </el-col>
      <el-col :span="3" style="text-align: center">
        <span>装柜量</span>
      </el-col>
      <el-col :span="4">
        <el-input v-model="number" placeholder="请输入装柜量"></el-input>
      </el-col>
    </el-row>
    <el-divider></el-divider>
    <h1>打底造棉</h1>
    <el-divider></el-divider>
    <el-row style="margin-top: 24px">
      <el-col :span="3" style="text-align: center">
        <span>净重</span>
      </el-col>
      <el-col :span="4">
        <el-input v-model="weight" placeholder="请输入净重"></el-input>
      </el-col>
      <el-col :span="3" style="text-align: center">
        <span>材积</span>
      </el-col>
      <el-col :span="4">
        <el-input v-model="volume" placeholder="请输入材积"></el-input>
      </el-col>
      <el-col :span="3" style="text-align: center">
        <span>装柜量</span>
      </el-col>
      <el-col :span="4">
        <el-input v-model="number" placeholder="请输入装柜量"></el-input>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "ProductDetail",
  props: {
    
  },
  components:{
    
  },
  mounted: function(){
    
  },
  methods: {
      
    },
  data() {
    return {
        
      }
  }
};
</script>

<style scoped lang="scss">

</style>