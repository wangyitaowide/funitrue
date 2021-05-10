<template>
  <div class="hello">
    <el-divider></el-divider>
    <el-row>
      <el-col :span="3" style="text-align: center">
        <span>产品型号</span>
      </el-col>
      <el-col :span="4">
        <el-input v-model="model" placeholder="请输输入型号"></el-input>
      </el-col>
      <el-col :span="3" style="text-align: center">
        <span>产品尺寸</span>
      </el-col>
      <el-col :span="4">
        <el-input v-model="size" placeholder="请输入尺寸"></el-input>
      </el-col>
      <el-col :span="3" style="text-align: center">
        <span>日期</span>
      </el-col>
      <el-col :span="4">
        <el-input v-model="date" placeholder="请输入日期"></el-input>
      </el-col>
    </el-row>
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
    <el-row style="margin-top: 24px">
      <el-col :span="3" style="text-align: center">
        <span>货柜运费</span>
      </el-col>
      <el-col :span="4">
        <el-input v-model="cost" placeholder="请输入运费"></el-input>
      </el-col>
      <!-- <el-col :span="3" style="text-align: center">
        <span>图片</span>
      </el-col>
      <el-col :span="4">
        <el-input v-model="picture" placeholder="请输入图片"></el-input>
      </el-col> -->
    </el-row>
    <el-divider></el-divider>
    <el-row style="text-align: right">
      <el-button type="primary" @click="toAddDetail">新增</el-button>
      <el-button type="primary">查询</el-button>
    </el-row>
    <el-divider></el-divider>
    <el-row>
      <el-col :span="5" v-for="(o, index) in 8" :key="o" :offset="index%4 != 0 > 0 ? 1 : 0" style="margin-top:24px;">
        <el-card :body-style="{ padding: '0px' }">
          <div style="text-align:center;">
            <img src="../../assets/hamburger.png" class="image">
          </div>
          <div style="padding: 14px;text-align:center;">
            <span>9010</span>
            <div class="bottom clearfix">
              <time class="time"></time>
              <el-button type="text" class="button" @click="toDetail">查看详情</el-button>
              <!-- <router-link to="/product/detail">查看详情</router-link> -->
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Product",
  props: {
    msg: String,
  },
  data() {
    return {
      model: "",
      size: "",
      date: "",
      weight: "",
      volume: "",
      number: "",
      cost: "",
      picture: ""
    };
  },
  methods: {
    toDetail(){
      this.$router.push("/product/productDetail")
    },
    toAddDetail(){
      this.$router.push("/product/productAddDetail")
    }
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
